package com.daiki.demo.service;

import com.daiki.demo.dto.AuthorDTO;
import com.daiki.demo.entity.Author;

public interface AuthorService {
    public Author saveAuthor(AuthorDTO authorDTO)throws Exception;

    public Author updateAuthor(AuthorDTO authorDTO)throws Exception;

    public boolean deleteAuthor(Integer id)throws Exception;
}
