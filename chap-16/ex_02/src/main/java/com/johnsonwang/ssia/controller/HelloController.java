package com.johnsonwang.ssia.controller;

import com.johnsonwang.ssia.services.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private NameService nameService;

    @GetMapping("/secret/names/{name}")
    public List<String> hello(@PathVariable String name) {
        return this.nameService.getSecretNames(name);
    }
}
