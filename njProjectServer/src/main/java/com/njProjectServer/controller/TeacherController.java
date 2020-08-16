package com.njProjectServer.controller;

import com.njProjectServer.model.Teacher;
import com.njProjectServer.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping
    public List<Teacher> getAll(){
        return (List<Teacher>) teacherRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Teacher> getOne(@PathVariable int id){
        return  teacherRepository.findById(id);
    }
}
