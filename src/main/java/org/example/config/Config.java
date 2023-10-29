package org.example.config;

import org.example.model.Author;
import org.example.model.Book;
import org.example.model.Publisher;
import org.example.model.Reader;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class Config {

    public static SessionFactory getSession(){



    Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/maven5");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "zoom");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.HBM2DDL_AUTO, "update");

    Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Author.class);
        configuration.addAnnotatedClass(Publisher.class);
        configuration.addAnnotatedClass(Book.class);
        configuration.addAnnotatedClass(Reader.class);
        return configuration.buildSessionFactory();
}
}

