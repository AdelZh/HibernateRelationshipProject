package org.example.repository.impl;

import org.example.config.Config;
import org.example.model.Author;
import org.example.model.Publisher;
import org.example.repository.AuthorRepo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepoImpl implements AuthorRepo {



    @Override
    public String saveAuthor(Author authors) {
        try (Session session1=Config.getSession().openSession()){
            session1.beginTransaction();
            session1.persist(authors);
            session1.getTransaction().commit();

            return authors.getFirst_name()+"saved";
        }

    }

    @Override
    public Author updateAuthor(Long id, Author newAuthor) {
        try (Session session1 = Config.getSession().openSession()) {
            session1.beginTransaction();
            Author author = session1.get(Author.class, id);
            author.setFirst_name(newAuthor.getFirst_name());
            author.setCountry(newAuthor.getCountry());
            session1.merge(author);
            session1.getTransaction().commit();

        }
        return newAuthor;
    }
    @Override
    public List<Author> getAuthorById(Long id) {
        try (Session session1 = Config.getSession().openSession()) {
            List<Author> authors = new ArrayList<>();
            session1.beginTransaction();
            Author author = session1.get(Author.class, id);
            authors.add(author);
            session1.getTransaction().commit();
            return authors;
        }
    }



    @Override
    public List<Author> getAuthorsByPublisherId(Long publisherID) {
        List<Author> authors;
        try (Session session1 = Config.getSession().openSession()) {
            session1.beginTransaction();
            Publisher publisher = session1.get(Publisher.class, publisherID);
            authors = new ArrayList<>(publisher.getAuthors());
            session1.getTransaction().commit();

        } catch (HibernateException e) {
            throw new RuntimeException(e.getMessage());

        }
       return authors;
    }


    @Override
    public String deleteAuthorById(Long id) {
        try (Session session1=Config.getSession().openSession()){
            session1.beginTransaction();
            Author author=session1.get(Author.class, id);
            session1.remove(author);
            session1.getTransaction().commit();
            return "deleted";
        }
    }
}

