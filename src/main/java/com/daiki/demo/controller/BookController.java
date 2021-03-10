package com.daiki.demo.controller;

import com.daiki.demo.dto.BookDTO;
import com.daiki.demo.service.BookService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("${app.endpoint.api}/book")
public class BookController {
    final org.slf4j.Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public ResponseEntity saveBook(@RequestBody BookDTO bookDTO) {
        try {
            bookService.saveBook(bookDTO);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in save Book: "+bookDTO.getName(), e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity updateBook(@RequestBody BookDTO bookDTO) {
        try {
            bookService.updateBook(bookDTO);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in update Book: "+bookDTO.getName(), e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteBook(@PathVariable Integer id) {
        try {
            return bookService.deleteBook(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in delete Book: "+id, e);
            return false;
        }
    }

    @PostMapping("/searchByName/{name}")
    public BookDTO searchBookByName(@PathVariable String name ) {
        try {
            return bookService.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in Searching Book By Name: ", e);
            return null;
        }
    }

    @PostMapping("/searchById/{id}")
    public BookDTO searchBookById(@PathVariable Integer id ) {
        try {
            return bookService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in Searching Book By Id: ", e);
            return null;
        }
    }

    @PostMapping("/searchByAuthorId/{id}")
    public List<BookDTO> searchBookByAuthorId(@PathVariable Integer id ) {
        try {
            return bookService.findAllByAuthorId(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in Searching Book By Author Id: ", e);
            return null;
        }
    }

    @PostMapping("/searchBookByAuthorName/{name}")
    public List<BookDTO> searchBookByAuthorName(@PathVariable String name ) {
        try {
            return bookService.findAllByAuthor(name);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in Searching Book By Author Name: ", e);
            return null;
        }
    }

    @PostMapping("/searchBookByPublisherId/{id}")
    public List<BookDTO> searchBookByPublisherId(@PathVariable Integer id ) {
        try {
            return bookService.findAllByPublisherId(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in Searching Book By Publisher Id: ", e);
            return null;
        }
    }

    @PostMapping("/searchBookByPublisherName/{name}")
    public List<BookDTO> searchBookByPublisherName(@PathVariable String name ) {
        try {
            return bookService.findAllByPublisherName(name);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error in Searching Book By Publisher Name: ", e);
            return null;
        }
    }


}
