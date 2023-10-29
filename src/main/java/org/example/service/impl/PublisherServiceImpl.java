package org.example.service.impl;

import org.example.model.Publisher;
import org.example.repository.PublisherRepo;
import org.example.repository.impl.PublisherRepoImpl;
import org.example.service.PublisherService;

import java.util.List;

public class PublisherServiceImpl implements PublisherService {

    PublisherRepo publisherRepo=new PublisherRepoImpl();

    @Override
    public String savePublisher(List<Publisher> publishers) {
        return publisherRepo.savePublisher(publishers);
    }

    @Override
    public Publisher getPublisherById(Long id) {
        return publisherRepo.getPublisherById(id);
    }

    @Override
    public List<Publisher> getAllPublishers(String ascDesc) {
        return publisherRepo.getAllPublishers(ascDesc);
    }

    @Override
    public Publisher updatePublisher(Long id, Publisher newPublisher) {
        return publisherRepo.updatePublisher(id,newPublisher);
    }

    @Override
    public String deletePublisherByName(Long id) {
        return publisherRepo.deletePublisherByName(id);
    }
}
