package com.swodd.backend.repository;

import com.swodd.backend.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitleContaining(String keyword);
}
