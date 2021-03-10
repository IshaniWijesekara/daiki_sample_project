package com.daiki.demo.service.impl;

import com.daiki.demo.dto.BookDTO;
import com.daiki.demo.entity.Author;
import com.daiki.demo.entity.Book;
import com.daiki.demo.entity.Publisher;
import com.daiki.demo.repository.AuthorRepository;
import com.daiki.demo.repository.BookRepository;
import com.daiki.demo.repository.PublisherRepository;
import com.daiki.demo.service.BookService;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public Book saveBook(BookDTO bookDTO) throws Exception {
        /** Check BookDTO is null and save data **/
        if (bookDTO != null) {
            /** Get Author and Publisher by thier Ids**/
            Author byAuthorId = authorRepository.findByAuthorId(bookDTO.getAuthorId());
            Publisher byPublisherId = publisherRepository.findByPublisherId(bookDTO.getPublisherId());

            Book book = new Book();
            book.setAuthorId(byAuthorId);
            book.setPublisherId(byPublisherId);
            book.setName(bookDTO.getName());
            book.setPrice(bookDTO.getPrice());

            /** Save Book instance **/
            return bookRepository.save(book);
        }else{
            return  null;
        }
    }

    @Override
    public Book updateBook(BookDTO bookDTO) throws Exception {
        /** Check BookDTO is null and save data **/
        if (bookDTO != null) {
            /**Get the Book by its ID**/
            Book book = bookRepository.findByBookId(bookDTO.getBookId());
            /** Get Author and Publisher by thier Ids**/
            Author byAuthorId = authorRepository.findByAuthorId(bookDTO.getAuthorId());
            Publisher byPublisherId = publisherRepository.findByPublisherId(bookDTO.getPublisherId());

            book.setAuthorId(byAuthorId);
            book.setPublisherId(byPublisherId);
            book.setName(bookDTO.getName());
            book.setPrice(bookDTO.getPrice());

            /** Save Book instance **/
            return bookRepository.save(book);
        }else{
            return  null;
        }
    }

    @Override
    public boolean deleteBook(Integer id) throws Exception {
        /**Get the Book by its ID**/
        Book book = bookRepository.findByBookId(id);
        bookRepository.delete(book);
        return true;
    }

    @Override
    public BookDTO findByName(String name) throws Exception {
        /** Get the Book find By Its Name**/
        Book book = bookRepository.findByName(name);

        if (book != null) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setAuthorId(book.getAuthorId().getAuthorId());
            bookDTO.setPublisherId(book.getPublisherId().getPublisherId());
            bookDTO.setName(book.getName());
            bookDTO.setPrice(book.getPrice());
            return bookDTO;
        }else{
            return null;
        }
    }

    @Override
    public BookDTO findById(Integer id) throws Exception {
        /** Get the Book find By Its Name**/
        Book book = bookRepository.findByBookId(id);

        if (book != null) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setAuthorId(book.getAuthorId().getAuthorId());
            bookDTO.setPublisherId(book.getPublisherId().getPublisherId());
            bookDTO.setName(book.getName());
            bookDTO.setPrice(book.getPrice());
            return bookDTO;
        }else{
            return null;
        }
    }

    @Override
    public List<BookDTO> findAllByAuthor(String authorName) throws Exception {
        List<BookDTO> lists= new ArrayList<>();
        /** Get the Book Lists By Author Name**/
        List<Book> allByAuthorIdName = bookRepository.findAllByAuthorIdName(authorName);
        if (allByAuthorIdName.size() >0) {
            for (Book book:allByAuthorIdName) {
                BookDTO bookDTO = new BookDTO();
                bookDTO.setAuthorId(book.getAuthorId().getAuthorId());
                bookDTO.setPublisherId(book.getPublisherId().getPublisherId());
                bookDTO.setName(book.getName());
                bookDTO.setPrice(book.getPrice());

                lists.add(bookDTO);
            }
            return lists;
        }else {
            return null;
        }
    }

    @Override
    public List<BookDTO> findAllByAuthorId(Integer id) throws Exception {
        List<BookDTO> lists= new ArrayList<>();
        /** Get the Book Lists By Author Id**/
        List<Book> list = bookRepository.findAllByAuthorIdAuthorId(id);
        if (list.size() >0) {
            for (Book book:list) {
                BookDTO bookDTO = new BookDTO();
                bookDTO.setAuthorId(book.getAuthorId().getAuthorId());
                bookDTO.setPublisherId(book.getPublisherId().getPublisherId());
                bookDTO.setName(book.getName());
                bookDTO.setPrice(book.getPrice());

                lists.add(bookDTO);
            }
            return lists;
        }else {
            return null;
        }
    }

    @Override
    public List<BookDTO> findAllByPublisherName(String name) throws Exception {
        List<BookDTO> lists= new ArrayList<>();
        /** Get the Book Lists By Publisher Name**/
        List<Book> list = bookRepository.findAllByPublisherIdName(name);
        if (list.size() >0) {
            for (Book book:list) {
                BookDTO bookDTO = new BookDTO();
                bookDTO.setAuthorId(book.getAuthorId().getAuthorId());
                bookDTO.setPublisherId(book.getPublisherId().getPublisherId());
                bookDTO.setName(book.getName());
                bookDTO.setPrice(book.getPrice());

                lists.add(bookDTO);
            }
            return lists;
        }else {
            return null;
        }
    }

    @Override
    public List<BookDTO> findAllByPublisherId(Integer id) throws Exception {
        List<BookDTO> lists= new ArrayList<>();
        /** Get the Book Lists By Publisher Id**/
        List<Book> list = bookRepository.findAllByPublisherIdPublisherId(id);
        if (list.size() >0) {
            for (Book book:list) {
                BookDTO bookDTO = new BookDTO();
                bookDTO.setAuthorId(book.getAuthorId().getAuthorId());
                bookDTO.setPublisherId(book.getPublisherId().getPublisherId());
                bookDTO.setName(book.getName());
                bookDTO.setPrice(book.getPrice());

                lists.add(bookDTO);
            }
            return lists;
        }else {
            return null;
        }
    }
}
