package com.daiki.demo.repository;

import com.daiki.demo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    public Author findByAuthorId(Integer id);

    public Author findByName(String name);

    public Author findByAddress(String address);
}
