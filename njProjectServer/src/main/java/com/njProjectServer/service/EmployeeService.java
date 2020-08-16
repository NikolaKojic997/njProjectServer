package com.njProjectServer.service;

import com.njProjectServer.model.Employee;
import com.njProjectServer.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAll() {
        return (List<Employee>) repository.findAll();
    }
}
