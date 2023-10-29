package org.example.service.impl;

import org.example.model.Author;
import org.example.model.Book;
import org.example.model.Publisher;
import org.example.model.Reader;
import org.example.repository.BookRepo;
import org.example.repository.impl.BookRepoImpl;
import org.example.service.BookService;

import java.util.Map;

public class BookServiceImpl implements BookService {

    BookRepo bookRepo=new BookRepoImpl();

    @Override
    public String saveBook(Book book) {
        return bookRepo.saveBook(book);
    }

    @Override
    public void updateBookTable(Long bookID, Reader newReader) {
        bookRepo.updateBookTable(bookID, newReader);
    }

    @Override
    public Author updateBookAuthor(Long bookID, Long authorId, Author newAuthor) {
        return bookRepo.updateBookAuthor(bookID, authorId, newAuthor);
    }

    @Override
    public Map<Book, Publisher> getBookAndPublisherByBookId(Long bookID) {
        return bookRepo.getBookAndPublisherByBookId(bookID);
    }

    @Override
    public String deleteBookByAuthorId(Long authorID, Long bookId) {
        return bookRepo.deleteBookByAuthorId(authorID, bookId);
    }
}
