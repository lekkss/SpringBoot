package com.lekkss.database.dao.impl;

import com.lekkss.database.TestDataUtil;
import com.lekkss.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTest {

    @Mock
   private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public  void testThatCreateBookGeneratesCorrectSql(){
        Book book = TestDataUtil.createTestBookA();
        underTest.create(book);
        Mockito.verify(jdbcTemplate).update(
                ArgumentMatchers.eq("INSERT INTO books (isbn, title, author_id) VALUES (?,?,?)"),
                ArgumentMatchers.eq("3456-6543-8763-8"),
                ArgumentMatchers.eq("Learn Spring"),
                ArgumentMatchers.eq(1L)
        );
    }

    @Test
    public void testThatFindsOneBookGeneratesTheCorrectSal(){
        underTest.findOne("456-6543-8763-8");
        Mockito.verify(jdbcTemplate).query(
                ArgumentMatchers.eq("SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                ArgumentMatchers.eq("456-6543-8763-8")
        );
    }

    @Test
    public void testThatFindsBookGeneratesCorrectSql(){
        underTest.find();
        jdbcTemplate.query(
                ArgumentMatchers.eq("SELECT isbn, title, author_id FROM books"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any()
        );
    }

    @Test
    public void testThatUpdatesBookGeneratesCorrectSql(){
        Book book = TestDataUtil.createTestBookA();
        underTest.update(book.getIsbn(), book);
        Mockito.verify(jdbcTemplate).update(
                "UPDATE books SET isbn = ?, title = ?, author_id = ? WHERE isbn = ?",
                "3456-6543-8763-8", "Learn Spring", 1L, "3456-6543-8763-8"

        );
    }

    @Test
    public  void testThatDeletesGenerateCorrectSql(){
        underTest.delete("3456-6543-8763-8");
        Mockito.verify(jdbcTemplate).update("DELETE FROM books WHERE isbn = ?", "3456-6543-8763-8");
    }
}
