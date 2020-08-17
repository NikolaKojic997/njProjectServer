package com.njProjectServer.controller;

import com.njProjectServer.model.Employee;
import com.njProjectServer.model.Teacher;
import com.njProjectServer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAll(){
        return service.getAll();
    }

    @GetMapping("/teachers")
    @ResponseBody
    public List<Teacher> getAllTeachers(){
        List<Teacher> teachers = service.getAllTeachers();
        return teachers;
    }


}
