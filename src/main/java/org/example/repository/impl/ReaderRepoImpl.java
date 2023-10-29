package org.example.repository.impl;

import org.example.config.Config;
import org.example.model.Author;
import org.example.model.Book;
import org.example.model.Reader;
import org.example.repository.ReaderRepo;
import org.hibernate.Session;

public class ReaderRepoImpl implements ReaderRepo {


    @Override
    public String saveReader(Reader reader) {
        try (Session session1 = Config.getSession().openSession()) {
            session1.beginTransaction();
            session1.persist(reader);
            session1.getTransaction().commit();
            return reader.getName() + "saved";
        }
    }


    @Override
    public Reader updateReader(Long readerId, Reader newReader) {
        try(Session session1=Config.getSession().openSession()){
            session1.beginTransaction();
            Reader reader = session1.get(Reader.class, readerId);
            reader.setName(newReader.getName());
            session1.getTransaction().commit();
            return reader;
        }

    }

    @Override
    public Reader getReaderByBookId(Long bookId) {
        try(Session session1=Config.getSession().openSession()){
            session1.beginTransaction();
            Book book = session1.get(Book.class, bookId);
            Reader reader = book.getReaders();
            session1.getTransaction().commit();
            return reader;
        }
    }


    @Override
    public String deleteReaderById(Long readerId) {
        try(Session session1=Config.getSession().openSession()){
            session1.beginTransaction();
            Reader reader = session1.get(Reader.class, readerId);
            for (Book book : reader.getBooks()) {
                book.setReaders(null);
            }
            session1.remove(reader);
            session1.getTransaction().commit();
            return "deleted";
        }

    }

    @Override
    public Reader getReadersByAuthorId(Long authorId) {
        try (Session session1 = Config.getSession().openSession()) {
            session1.beginTransaction();
            Author author = session1.get(Author.class, authorId);
            for (Book book : author.getBooks()) {
                return book.getReaders();
            }
            session1.getTransaction().commit();
            return null;

        }
    }
}

