package com.daiki.demo.service;

import com.daiki.demo.dto.PublisherDTO;
import com.daiki.demo.entity.Publisher;

public interface PublisherService {
    public Publisher savePublisher(PublisherDTO publisherDTO)throws Exception;

    public Publisher updatePublisher(PublisherDTO publisherDTO)throws Exception;

    public boolean deletePublisher(Integer id)throws Exception;

    public PublisherDTO findByName(String name)throws Exception;

    public PublisherDTO findByAddress(String address)throws Exception;

    public PublisherDTO findById(Integer id)throws Exception;
}
