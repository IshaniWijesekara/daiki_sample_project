package com.daiki.demo.repository;

import com.daiki.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    public Book findByBookId(Integer id);

    public Book findByName(String name);

    public List<Book> findAllByAuthorIdAuthorId(Integer id);

    public List<Book> findAllByPublisherIdPublisherId(Integer id);

    public List<Book> findAllByAuthorIdName(String name);

    public List<Book> findAllByPublisherIdName(String name);
}
