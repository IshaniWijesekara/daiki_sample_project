package com.daiki.demo.controller;


import com.daiki.demo.dto.AuthorDTO;
import com.daiki.demo.service.AuthorService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("${app.endpoint.api}/author")
public class AuthorController {
    final org.slf4j.Logger logger = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    private AuthorService authorService;

    @PostMapping("/save")
    public ResponseEntity saveAuthor(@RequestBody AuthorDTO authorDTO) {
        try {
            authorService.saveAuthor(authorDTO);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in save Author: "+authorDTO.getName(), e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity updateAuthor(@RequestBody AuthorDTO authorDTO) {
        try {
            authorService.updateAuthor(authorDTO);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in update Author: "+authorDTO.getName(), e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteAuthor(@PathVariable Integer id) {
        try {
            return authorService.deleteAuthor(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in delete Author: "+id, e);
            return false;
        }
    }


    @PostMapping("/searchByName/{name}")
    public AuthorDTO searchAuthorByName(@PathVariable String name ) {
        try {
            return authorService.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in Searching Author By Name: ", e);
            return null;
        }
    }

    @PostMapping("/searchByAddress/{address}")
    public AuthorDTO searchAuthorByAddress(@PathVariable String address ) {
        try {
            return authorService.findByAddress(address);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in Searching Author By Address: ", e);
            return null;
        }
    }

    @PostMapping("/searchAuthorById/{id}")
    public AuthorDTO searchAuthorById(@PathVariable Integer id ) {
        try {
            return authorService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in Searching Author By Id: ", e);
            return null;
        }
    }
}
