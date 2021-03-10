package com.daiki.demo.controller;

import com.daiki.demo.dto.PublisherDTO;
import com.daiki.demo.service.PublisherService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("${app.endpoint.api}/publisher")
public class PublisherController {
    final org.slf4j.Logger logger = LoggerFactory.getLogger(PublisherController.class);

    @Autowired
    private PublisherService publisherService;

    @PostMapping("/save")
    public ResponseEntity savePublisher(@RequestBody PublisherDTO publisherDTO) {
        try {
            publisherService.savePublisher(publisherDTO);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in save Publisher: "+publisherDTO.getName(), e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity updatePublisher(@RequestBody PublisherDTO publisherDTO) {
        try {
            publisherService.updatePublisher(publisherDTO);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in Update Publisher: "+publisherDTO.getName(), e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/delete/{id}")
    public boolean deletePublisher(@PathVariable Integer id) {
        try {
            return publisherService.deletePublisher(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in delete Publisher: "+id, e);
            return false;
        }
    }

    @PostMapping("/searchByName/{name}")
    public PublisherDTO searchPublisherByName(@PathVariable String name ) {
        try {
            return publisherService.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in Searching Publisher By Name: ", e);
            return null;
        }
    }

    @PostMapping("/searchByAddress/{address}")
    public PublisherDTO searchPublisherByAddress(@PathVariable String address ) {
        try {
            return publisherService.findByAddress(address);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in Searching Publisher By Address: ", e);
            return null;
        }
    }

    @PostMapping("/searchById/{id}")
    public PublisherDTO searchPublisherById(@PathVariable Integer id ) {
        try {
            return publisherService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in Searching Publisher By Id: ", e);
            return null;
        }
    }



}
