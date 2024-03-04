package com.lekkss.database.repositories;

import com.lekkss.database.TestDataUtil;
import com.lekkss.database.domain.entities.AuthorEntity;
import com.lekkss.database.domain.entities.BookEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookEntityRepositoryImplementationTests {

    private final AuthorRepository authorDao;
    private final BookRepository underTest;

    @Autowired
    public BookEntityRepositoryImplementationTests(AuthorRepository authorDao, BookRepository underTest) {
        this.authorDao = authorDao;
        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        AuthorEntity authorEntity = TestDataUtil.createTestAuthorEntityA();
        authorDao.save(authorEntity);
        BookEntity bookEntity = TestDataUtil.createTestBookEntityA(authorEntity);
        underTest.save(bookEntity);
        Optional<BookEntity> results = underTest.findById(bookEntity.getIsbn());
        Assertions.assertThat(results).isPresent();
        Assertions.assertThat(results.get()).isEqualTo(bookEntity);
    }

     @Test
     public void testThatMultipleBooksCanBeCreatedAndRecalled(){
     AuthorEntity authorEntity = TestDataUtil.createTestAuthorEntityA();
     authorDao.save(authorEntity);

     BookEntity bookEntityA = TestDataUtil.createTestBookEntityA(authorEntity);
     underTest.save(bookEntityA);
     BookEntity bookEntityB = TestDataUtil.createTestBookB(authorEntity);
     underTest.save(bookEntityB);
     BookEntity bookEntityC = TestDataUtil.createTestBookC(authorEntity);
     underTest.save(bookEntityC);
     Iterable<BookEntity> results = underTest.findAll();
     Assertions.assertThat(results)
     .hasSize(3)
     .containsExactly(bookEntityA, bookEntityB, bookEntityC);
     }

     @Test
     public void testThatBookCanBeUpdated(){
     AuthorEntity authorEntity = TestDataUtil.createTestAuthorEntityA();
     authorDao.save(authorEntity);

     BookEntity bookEntityA = TestDataUtil.createTestBookEntityA(authorEntity);
     underTest.save(bookEntityA);

     bookEntityA.setTitle("Updated");

     underTest.save(bookEntityA);
     Optional<BookEntity> result = underTest.findById(bookEntityA.getIsbn());
     Assertions.assertThat(result).isPresent();
     Assertions.assertThat(result.get()).isEqualTo(bookEntityA);
     }

     @Test
     public void testThatBookCanBeDeleted(){
     AuthorEntity authorEntity = TestDataUtil.createTestAuthorEntityA();
     authorDao.save(authorEntity);

     BookEntity bookEntityA = TestDataUtil.createTestBookEntityA(authorEntity);
     underTest.save(bookEntityA);

     underTest.deleteById(bookEntityA.getIsbn());

     Optional<BookEntity> result = underTest.findById(bookEntityA.getIsbn());
     Assertions.assertThat(result).isEmpty();
     }
}
