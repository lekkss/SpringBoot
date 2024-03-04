package com.lekkss.database.dao.impl;

import com.lekkss.database.TestDataUtil;
import com.lekkss.database.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
   private AuthorDaoImpl underTest;

    @Test
    public  void testThatCreateAuthorGeneratesCorrectSql(){
        Author author = TestDataUtil.createTestAuthorA();

        underTest.create(author);
        Mockito.verify(jdbcTemplate).update(
                ArgumentMatchers.eq("INSERT INTO authors (id, name, age) VALUES (?,?,?)"),
                ArgumentMatchers.eq(1L),
                ArgumentMatchers.eq("Afolabi Segun"),
                ArgumentMatchers.eq(18)
        );
    }

    @Test
    public void testThatFindsOneGeneratesTheCorrectSql(){
        underTest.findOne(1L);
        Mockito.verify(jdbcTemplate).query(
                ArgumentMatchers.eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
                ArgumentMatchers.eq(1L)
        );
    }

    @Test
    public void testThatFindManyGeneratesCorrectSql(){
        underTest.find();
        Mockito.verify(jdbcTemplate).query(
                ArgumentMatchers.eq("SELECT id, name, age FROM authors"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any()
        );
    }

    @Test
    public  void testThatUpdatesGeneratesCorrectSql(){
        Author author = TestDataUtil.createTestAuthorA();
        underTest.update(author.getId(), author);
        Mockito.verify(jdbcTemplate).update("UPDATE authors SET id = ?, name = ?, age = ? WHERE id = ?",
                        1L, "Afolabi Segun", 18, 1L
        );
    }

    @Test
    public void testThatDeletesGeneratesCorrectSql(){
        underTest.delete(1L);
        jdbcTemplate.update("DELETE FROM authors WHERE id = ?",
                1L);
    }
}
