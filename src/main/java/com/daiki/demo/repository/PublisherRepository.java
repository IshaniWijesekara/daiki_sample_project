package com.daiki.demo.repository;

import com.daiki.demo.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Integer> {
    public Publisher findByPublisherId(Integer id);
}
