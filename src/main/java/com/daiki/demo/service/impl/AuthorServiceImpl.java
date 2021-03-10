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
        /** Check authorDTO is null and save data **/
        if (authorDTO != null) {
            Author author = new Author();
            author.setName(authorDTO.getName());
            author.setAddress(authorDTO.getAddress());

            /** Save Author instance **/
            return authorRepository.save(author);
        }else{
            return  null;
        }
    }

    @Override
    public Author updateAuthor(AuthorDTO authorDTO) throws Exception {
        /** Check authorDTO is null and update data **/
        if (authorDTO != null) {
            /** Get the current author by Id**/
            Author author = authorRepository.findByAuthorId(authorDTO.getAuthorId());
            author.setName(authorDTO.getName());
            author.setAddress(authorDTO.getAddress());

            /** Save Author instance **/
            return authorRepository.save(author);
        }else {
            return null;
        }
    }

    @Override
    public boolean deleteAuthor(Integer id) throws Exception {
        /** Get the current author by Id**/
        Author byAuthorId = authorRepository.findByAuthorId(id);
        authorRepository.delete(byAuthorId);
        return true;
    }

    @Override
    public AuthorDTO findByName(String name) throws Exception {
        /** Get the current author by Name**/
        Author byName = authorRepository.findByName(name);
        if (byName != null) {
            /** If author present return data **/
            AuthorDTO authorDTO = new AuthorDTO();
            authorDTO.setName(byName.getName());
            authorDTO.setAddress(byName.getAddress());
            return authorDTO;
        }else{
            return null;
        }
    }

    @Override
    public AuthorDTO findByAddress(String address) throws Exception {
        /** Get the current author by Address**/
        Author byAddress = authorRepository.findByAddress(address);
        if (byAddress != null) {
            /** If author present return data **/
            AuthorDTO authorDTO = new AuthorDTO();
            authorDTO.setAddress(byAddress.getAddress());
            authorDTO.setName(byAddress.getName());
            return authorDTO;
        }else{
            return null;
        }
    }

    @Override
    public AuthorDTO findById(Integer id) throws Exception {
        /** Get the current author by Id**/
        Author author = authorRepository.findByAuthorId(id);
        if (author != null) {
            /** If author present return data **/
            AuthorDTO authorDTO = new AuthorDTO();
            authorDTO.setAddress(author.getAddress());
            authorDTO.setName(author.getName());
            return authorDTO;
        }else{
            return null;
        }
    }
}
