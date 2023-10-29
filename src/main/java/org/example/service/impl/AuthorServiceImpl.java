package org.example.service.impl;

import org.example.model.Author;
import org.example.repository.AuthorRepo;
import org.example.repository.impl.AuthorRepoImpl;
import org.example.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    AuthorRepo authorRepo=new AuthorRepoImpl();

    @Override
    public String saveAuthor(Author authors) {
        return authorRepo.saveAuthor(authors);
    }

    @Override
    public Author updateAuthor(Long id, Author newAuthor) {
        return authorRepo.updateAuthor(id,newAuthor);
    }

    @Override
    public List<Author> getAuthorById(Long id) {
        return authorRepo.getAuthorById(id);
    }

    @Override
    public List<Author> getAuthorsByPublisherId(Long publisherID) {
        return authorRepo.getAuthorsByPublisherId(publisherID);
    }

    @Override
    public String deleteAuthorById(Long id) {
        return authorRepo.deleteAuthorById(id);
    }
}
