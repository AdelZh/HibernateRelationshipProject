package org.example.repository;

import org.example.model.Reader;

public interface ReaderRepo {
    String saveReader(Reader reader);

    Reader updateReader(Long readerId, Reader newReader);
    Reader getReaderByBookId(Long bookId);
    String deleteReaderById(Long readerId);
    Reader getReadersByAuthorId(Long authorId);
}

