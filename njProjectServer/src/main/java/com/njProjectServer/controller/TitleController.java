package com.njProjectServer.controller;

import com.njProjectServer.model.Employee;
import com.njProjectServer.model.Title;
import com.njProjectServer.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/titles")
public class TitleController {
    @Autowired
    TitleRepository titleRepository;

    @GetMapping
    public List<Title> getAll(){
        return this.titleRepository.findAll();
    }
}
