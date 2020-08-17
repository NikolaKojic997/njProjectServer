package com.njProjectServer.service;

import com.njProjectServer.model.Employee;
import com.njProjectServer.model.Teacher;
import com.njProjectServer.repository.EmployeeRepository;
import com.njProjectServer.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private TeacherRepository teachersRepository;

    public List<Employee> getAll() {
        return (List<Employee>) repository.findAll();
    }

    public List<Teacher> getAllTeachers() {
         List<Teacher> teachers = (List<Teacher>) teachersRepository.findAll();
         return teachers;
    }
}
