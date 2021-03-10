package com.daiki.demo.service;

import com.daiki.demo.dto.AuthorDTO;
import com.daiki.demo.entity.Author;

public interface AuthorService {
    public Author saveAuthor(AuthorDTO authorDTO)throws Exception;

    public Author updateAuthor(AuthorDTO authorDTO)throws Exception;

    public boolean deleteAuthor(Integer id)throws Exception;

    public AuthorDTO findByName(String name)throws Exception;

    public AuthorDTO findByAddress(String address)throws Exception;

    public AuthorDTO findById(Integer id)throws Exception;
}
