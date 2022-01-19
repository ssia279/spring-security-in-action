package com.johnsonwang.ssia.controller;

import com.johnsonwang.ssia.model.Employee;
import com.johnsonwang.ssia.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book/details/{name}")
    public Employee getDetails(@PathVariable String name) {
        return this.bookService.getBookDetails(name);
    }
}
