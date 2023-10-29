package org.example.repository.impl;

import jakarta.persistence.TypedQuery;
import org.example.config.Config;
import org.example.model.Author;
import org.example.model.Book;
import org.example.model.Publisher;
import org.example.repository.PublisherRepo;
import org.hibernate.Session;

import java.util.List;

public class PublisherRepoImpl implements PublisherRepo {



    @Override
    public String savePublisher(List<Publisher> publishers) {
        try (Session session1 = Config.getSession().openSession()) {
            session1.beginTransaction();
            for (Publisher p : publishers) {
                session1.persist(p);
            }
            session1.getTransaction().commit();
            return "saved";
        }
    }


    @Override
    public Publisher getPublisherById(Long id) {
        try(Session session1=Config.getSession().openSession()){
            session1.beginTransaction();
            Publisher publisher=session1.get(Publisher.class, id);
            session1.getTransaction().commit();
            return publisher;
        }

    }

    @Override
    public List<Publisher> getAllPublishers(String ascDesc) {
        try (Session session1 = Config.getSession().openSession()) {
            session1.beginTransaction();
            String jpql = "select p from Publisher p";
            if (ascDesc != null && ascDesc.equalsIgnoreCase("asc")) {
                jpql += " order by name asc";
            } else if (ascDesc != null && ascDesc.equalsIgnoreCase("desc")) {
                jpql += " order by name desc";
            }

            TypedQuery<Publisher> query = session1.createQuery(jpql, Publisher.class);
            List<Publisher> publishers = query.getResultList();

            session1.getTransaction().commit();
            return publishers;
        }
    }


    @Override
    public Publisher updatePublisher(Long id, Publisher newPublisher) {
        try (Session session1 = Config.getSession().openSession()) {
            session1.beginTransaction();
            Publisher publisher = session1.get(Publisher.class, id);
            publisher.setName(newPublisher.getName());
            publisher.setAddress(newPublisher.getAddress());
            session1.getTransaction().commit();
            return publisher;
        }
    }


    @Override
    public String deletePublisherByName(Long id) {
        try(Session session1=Config.getSession().openSession()){
            session1.beginTransaction();
            Publisher publisher=session1.get(Publisher.class, id);
            for (Book book:publisher.getBooks()){
                book.setPublishers(null);
            }
            for (Author author:publisher.getAuthors()){
                author.getPublishers().remove(publisher);
            }
            session1.remove(publisher);
            session1.getTransaction().commit();
            return "deleted";
        }
    }

}
