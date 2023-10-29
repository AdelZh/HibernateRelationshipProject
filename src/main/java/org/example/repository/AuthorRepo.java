package org.example.repository;

import org.example.model.Author;

import java.util.List;

public interface AuthorRepo {

    String saveAuthor(Author authors);

    Author updateAuthor(Long id, Author newAuthor);
    List<Author> getAuthorById(Long id);
    List<Author> getAuthorsByPublisherId(Long publisherID);

    String deleteAuthorById(Long id);
}


