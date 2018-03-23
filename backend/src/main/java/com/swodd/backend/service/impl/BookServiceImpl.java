package com.swodd.backend.service.impl;

import com.swodd.backend.domain.Book;
import com.swodd.backend.repository.BookRepository;
import com.swodd.backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll(){
        List<Book> bookList = (List<Book>) bookRepository.findAll();

        List<Book> activeBookList = new ArrayList<>();

        for (Book book: bookList){
            if(book.isActive()){
                activeBookList.add(book);
            }
        }
        return activeBookList;
    }

    public Book findOne(Long id){
        return bookRepository.findOne(id);
    }

    public Book save(Book book){
        return bookRepository.save(book);
    }

    public List<Book> blurrySearch(String keyword){
        List<Book> bookList = bookRepository.findByTitleContaining(keyword);
        List<Book> activeBookList = new ArrayList<>();

        for (Book book: bookList){
            if(book.isActive()){
                activeBookList.add(book);
            }
        }
        return activeBookList;
    }

    public void removeOne(Long id){
        bookRepository.delete(id);
    }
}
