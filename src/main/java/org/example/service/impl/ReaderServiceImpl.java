package org.example.service.impl;

import org.example.model.Reader;
import org.example.repository.ReaderRepo;
import org.example.repository.impl.ReaderRepoImpl;
import org.example.service.ReaderService;

public class ReaderServiceImpl implements ReaderService {

    ReaderRepo readerRepo=new ReaderRepoImpl();

    @Override
    public String saveReader(Reader reader) {
        return readerRepo.saveReader(reader);
    }

    @Override
    public Reader updateReader(Long readerId, Reader newReader) {
        return readerRepo.updateReader(readerId, newReader);
    }

    @Override
    public Reader getReaderByBookId(Long bookId) {
        return readerRepo.getReaderByBookId(bookId);
    }

    @Override
    public String deleteReaderById(Long readerId) {
        return readerRepo.deleteReaderById(readerId);
    }

    @Override
    public Reader getReadersByAuthorId(Long authorId) {
        return readerRepo.getReadersByAuthorId(authorId);
    }
}
