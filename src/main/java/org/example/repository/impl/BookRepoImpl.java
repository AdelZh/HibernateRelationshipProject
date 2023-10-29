package org.example.repository.impl;

import org.example.config.Config;
import org.example.model.Author;
import org.example.model.Book;
import org.example.model.Publisher;
import org.example.model.Reader;
import org.example.repository.BookRepo;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.Map;

public class BookRepoImpl implements BookRepo {



    @Override
    public String saveBook(Book book) {
        try (Session session1 = Config.getSession().openSession()) {
            session1.beginTransaction();
            session1.persist(book);
            session1.getTransaction().commit();
            return book.getName() + "saved";
        }
    }


    @Override
    public Author updateBookAuthor(Long bookID, Long authorId, Author newAuthor) {
        try (Session session1 = Config.getSession().openSession()) {
            session1.beginTransaction();
            Book book = session1.get(Book.class, bookID);
            for (Author author : book.getPublishers().getAuthors()) {
                if (author.getId().equals(authorId)) {
                    author.setFirst_name(newAuthor.getFirst_name());
                    author.setLast_name(newAuthor.getLast_name());
                    session1.getTransaction().commit();

                }
            }
            return book.getAuthors();
        }
    }


    @Override
    public void updateBookTable(Long bookID, Reader newReader) {
        try (Session session1=Config.getSession().openSession()){
            session1.beginTransaction();
            Book book=session1.get(Book.class, bookID);
            session1.persist(newReader);
            book.setReaders(newReader);
            session1.merge(book);
            session1.getTransaction().commit();

        }

    }

    @Override
    public Map<Book, Publisher> getBookAndPublisherByBookId(Long bookID) {
        try (Session session1 = Config.getSession().openSession()) {
            session1.beginTransaction();
            Map<Book, Publisher> map = new HashMap<>();
            Book book = session1.get(Book.class, bookID);
            Publisher publisher = book.getPublishers();
            map.put(book, publisher);
            session1.getTransaction().commit();
            return map;


        }

    }

    @Override
    public String deleteBookByAuthorId(Long authorID, Long bookId) {
        try(Session session1=Config.getSession().openSession()){
            session1.beginTransaction();
            Book book=session1.get(Book.class, bookId);
            for (Author author:book.getPublishers().getAuthors()){
                if (author.getId().equals(authorID)){
                    author.getBooks().clear();
                }
            }
            session1.remove(book);
            session1.getTransaction().commit();
            return "deleted";
        }
    }

}
