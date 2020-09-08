package com.njProjectServer.controller;

import com.njProjectServer.model.Rank;
import com.njProjectServer.model.Title;
import com.njProjectServer.repository.RankRepository;
import com.njProjectServer.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/ranks")
public class RankController {
    @Autowired
    RankRepository ranksRepository;

    @GetMapping
    public List<Rank> getAll(){
        return this.ranksRepository.findAll();
    }
}
