package com.lekkss.database;

import com.lekkss.database.domain.Author;
import com.lekkss.database.domain.Book;

public class TestDataUtil {
    private TestDataUtil(){
    }

    public static Author createTestAuthorA() {
        return Author.builder()
                .id(1L)
                .name("Afolabi Segun")
                .age(18)
                .build();
    }
    public static Author createTestAuthorB() {
        return Author.builder()
                .id(2L)
                .name("John Doe")
                .age(30)
                .build();
    }
    public static Author createTestAuthorC() {
        return Author.builder()
                .id(3L)
                .name("Adenike Adeoye")
                .age(12)
                .build();
    }

    public static Book createTestBookA() {
        return Book.builder()
                .isbn("3456-6543-8763-8")
                .title("Learn Spring")
                .authorId(1L)
                .build();
    }
    public static Book createTestBookB() {
        return Book.builder()
                .isbn("3456-6543-afa4-4")
                .title("Intro to React")
                .authorId(1L)
                .build();
    } public static Book createTestBookC() {
        return Book.builder()
                .isbn("3456-654j-755-5")
                .title("Learn Wordpress")
                .authorId(1L)
                .build();
    }
}
