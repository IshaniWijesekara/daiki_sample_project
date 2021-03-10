package com.daiki.demo.service.impl;

import com.daiki.demo.dto.PublisherDTO;
import com.daiki.demo.entity.Publisher;
import com.daiki.demo.repository.PublisherRepository;
import com.daiki.demo.service.PublisherService;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Slf4j
@Transactional
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public Publisher savePublisher(PublisherDTO publisherDTO) throws Exception {
        /** Check publisherDTO is null and save data **/
        if (publisherDTO != null) {
            Publisher publisher = new Publisher();
            publisher.setAddress(publisherDTO.getAddress());
            publisher.setName(publisherDTO.getName());

            /** Save Publisher instance **/
            return publisherRepository.save(publisher);
        }else{
            return  null;
        }
    }

    @Override
    public Publisher updatePublisher(PublisherDTO publisherDTO) throws Exception {
        /** Check publisherDTO is null and save data **/
        if (publisherDTO != null) {
            /** Get the Current Publisher Object **/
            Publisher publisher = publisherRepository.findByPublisherId(publisherDTO.getPublisherId());
            publisher.setAddress(publisherDTO.getAddress());
            publisher.setName(publisherDTO.getName());

            /** Save Publisher instance **/
            return publisherRepository.save(publisher);
        }else{
            return  null;
        }
    }

    @Override
    public boolean deletePublisher(Integer id) throws Exception {
        /** Get the Current Publisher Object **/
        Publisher publisher = publisherRepository.findByPublisherId(id);
        publisherRepository.delete(publisher);
        return true;
    }

    @Override
    public PublisherDTO findByName(String name) throws Exception {
        /** Get the Current Publisher Object By Name **/
        Publisher publisher = publisherRepository.findByName(name);

        if (publisher != null) {
            PublisherDTO publisherDTO = new PublisherDTO();
            publisherDTO.setName(publisher.getName());
            publisherDTO.setAddress(publisher.getAddress());
            return publisherDTO;
        }else {
            return null;
        }
    }

    @Override
    public PublisherDTO findByAddress(String address) throws Exception {
        /** Get the Current Publisher Object By Address **/
        Publisher publisher = publisherRepository.findByAddress(address);

        if (publisher != null) {
            PublisherDTO publisherDTO = new PublisherDTO();
            publisherDTO.setName(publisher.getName());
            publisherDTO.setAddress(publisher.getAddress());
            return publisherDTO;
        }else {
            return null;
        }
    }

    @Override
    public PublisherDTO findById(Integer id) throws Exception {
        /** Get the Current Publisher Object By Id **/
        Publisher publisher = publisherRepository.findByPublisherId(id);

        if (publisher != null) {
            PublisherDTO publisherDTO = new PublisherDTO();
            publisherDTO.setName(publisher.getName());
            publisherDTO.setAddress(publisher.getAddress());
            return publisherDTO;
        }else {
            return null;
        }
    }
}
