package com.daiki.demo.service.impl;

import com.daiki.demo.dto.AuthorDTO;
import com.daiki.demo.entity.Author;
import com.daiki.demo.repository.AuthorRepository;
import com.daiki.demo.service.AuthorService;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author saveAuthor(AuthorDTO authorDTO) throws Exception {
        return null;
    }

    @Override
    public Author updateAuthor(AuthorDTO authorDTO) throws Exception {
        return null;
    }

    @Override
    public boolean deleteAuthor(Integer id) throws Exception {
        return false;
    }
}
