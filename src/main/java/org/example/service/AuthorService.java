package org.example.service;

import org.example.model.Author;

import java.util.List;

public interface AuthorService {

    String saveAuthor(Author authors);

    Author updateAuthor(Long id, Author newAuthor);
    public List<Author> getAuthorById(Long id);
    List<Author> getAuthorsByPublisherId(Long publisherID);

    String deleteAuthorById(Long id);
}
