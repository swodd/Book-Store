package com.swodd.backend.resource;

import com.swodd.backend.domain.Book;
import com.swodd.backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/book")
public class BookResource {

    @Autowired
    private BookService bookService;

    @RequestMapping (value="/add", method= RequestMethod.POST)
    public Book addBookPost(@RequestBody Book book){
        return bookService.save(book);
    }
}
