package com.lekkss.database;

import com.lekkss.database.domain.dto.AuthorDto;
import com.lekkss.database.domain.dto.BookDto;
import com.lekkss.database.domain.entities.AuthorEntity;
import com.lekkss.database.domain.entities.BookEntity;

public class TestDataUtil {
    private TestDataUtil(){
    }

    public static AuthorEntity createTestAuthorEntityA() {
        return AuthorEntity.builder()
                .id(1L)
                .name("Afolabi Segun")
                .age(18)
                .build();
    }

    public static AuthorDto createTestAuthorDtoA() {
        return AuthorDto.builder()
                .id(1L)
                .name("Afolabi Segun")
                .age(18)
                .build();
    }

    public static AuthorEntity createTestAuthorB() {
        return AuthorEntity.builder()
                .id(2L)
                .name("John Doe")
                .age(30)
                .build();
    }
    public static AuthorEntity createTestAuthorC() {
        return AuthorEntity.builder()
                .id(3L)
                .name("Adenike Adeoye")
                .age(12)
                .build();
    }

    public static BookEntity createTestBookEntityA(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("3456-6543-8763-8")
                .title("Learn Spring")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookDto createTestBookDtoA(final AuthorDto authorDto) {
        return BookDto.builder()
                .isbn("3456-6543-8763-8")
                .title("Learn Spring")
                .author(authorDto)
                .build();
    }

    public static BookEntity createTestBookB(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("3456-6543-afa4-4")
                .title("Intro to React")
                .authorEntity(authorEntity)
                .build();
    }
    public static BookEntity createTestBookC(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("3456-654j-755-5")
                .title("Learn Wordpress")
                .authorEntity(authorEntity)
                .build();
    }
}
