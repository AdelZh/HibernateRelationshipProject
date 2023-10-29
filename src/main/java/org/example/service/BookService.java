package org.example.service;

import org.example.model.Author;
import org.example.model.Book;
import org.example.model.Publisher;
import org.example.model.Reader;

import java.util.Map;

public interface BookService {
    String saveBook(Book book);

    Author updateBookAuthor(Long bookID, Long authorId, Author newAuthor);
    Map<Book, Publisher> getBookAndPublisherByBookId(Long bookID);
    String deleteBookByAuthorId(Long authorID, Long bookId);
    void updateBookTable(Long bookID, Reader newReader);
}

