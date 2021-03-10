package com.daiki.demo.service;

import com.daiki.demo.dto.BookDTO;
import com.daiki.demo.entity.Book;

import java.util.List;

public interface BookService {
    public Book saveBook(BookDTO bookDTO)throws Exception;

    public Book updateBook(BookDTO bookDTO)throws Exception;

    public boolean deleteBook(Integer id)throws Exception;

    public BookDTO findByName(String name)throws Exception;

    public BookDTO findById(Integer id)throws Exception;

    public List<BookDTO> findAllByAuthor(String authorName)throws Exception;

    public List<BookDTO> findAllByAuthorId(Integer id)throws Exception;

    public List<BookDTO> findAllByPublisherName(String name)throws Exception;

    public List<BookDTO> findAllByPublisherId(Integer id)throws Exception;
}
