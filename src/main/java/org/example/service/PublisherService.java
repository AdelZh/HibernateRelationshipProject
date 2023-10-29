package org.example.service;

import org.example.model.Publisher;

import java.util.List;

public interface PublisherService {
    String savePublisher(List<Publisher> publishers);
    Publisher getPublisherById(Long id);
    List<Publisher> getAllPublishers(String ascDesc);
    Publisher updatePublisher(Long id, Publisher newPublisher);

    String deletePublisherByName(Long id);
}


