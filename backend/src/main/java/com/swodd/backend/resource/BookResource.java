package com.swodd.backend.resource;

import com.swodd.backend.domain.Book;
import com.swodd.backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookResource {

    @Autowired
    private BookService bookService;

    @RequestMapping (value="/add", method= RequestMethod.POST)
    public Book addBookPost(@RequestBody Book book){
        return bookService.save(book);
    }

    @RequestMapping(value = "/add/image", method = RequestMethod.POST)
    public ResponseEntity upload(@RequestParam("id") Long id, HttpServletResponse response, HttpServletRequest request){
        try{
            Book book = bookService.findOne(id);
            MultipartHttpServletRequest multiparRequest = (MultipartHttpServletRequest) request;
            Iterator<String> it = multiparRequest.getFileNames();
            MultipartFile multipartFile = multiparRequest.getFile(it.next());
            String fileName = id + ".png";

            byte[] bytes = multipartFile.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/book/" + fileName)));
            stream.write(bytes);
            stream.close();

            return new ResponseEntity("Upload Success!", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity("Upload failed!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/bookList")
    public List<Book> getBookList(){
            return bookService.findAll();
    }

    @RequestMapping("/{id}")
    public Book getBook(@PathVariable("id") Long id){
        Book book = bookService.findOne(id);
        return book;
    }
}
