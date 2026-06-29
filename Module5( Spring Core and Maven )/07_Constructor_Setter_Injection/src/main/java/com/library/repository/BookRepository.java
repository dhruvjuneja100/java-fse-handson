package com.library.repository;

public class BookRepository {

    private String dataSource;

    public BookRepository(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getBook(String title) {
        return "[" + dataSource + "] Book: " + title;
    }
}
