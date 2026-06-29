package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public String getBook(String title) {
        return "Book: " + title;
    }
}
