package org.example.repository;

import org.example.model.Publisher;

import java.util.List;

public interface PublisherRepo {
    String savePublisher(List<Publisher> publishers);
    Publisher getPublisherById(Long id);
    List<Publisher> getAllPublishers(String ascDesc);
    Publisher updatePublisher(Long id, Publisher newPublisher);

    String deletePublisherByName(Long id);
}

