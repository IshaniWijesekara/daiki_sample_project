package com.daiki.demo.dto;

import lombok.Data;

@Data
public class BookDTO {
    public int bookId;
    public String name;
    public double price;
    public int authorId;
    public int publisherId;
}
