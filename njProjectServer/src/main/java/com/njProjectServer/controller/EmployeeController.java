package com.njProjectServer.controller;

import com.njProjectServer.exception.ResourceNotFoundException;
import com.njProjectServer.model.Assistant;
import com.njProjectServer.model.Employee;
import com.njProjectServer.model.Teacher;
import com.njProjectServer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/assistants")
    @ResponseBody
    public List<Assistant> getAllAssistants(){
        return service.getAllAssistants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable int id){

        return  service.findById(id);
//                orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+ id));

    }

    @PostMapping
    public Employee insert(@RequestBody Employee employee){
        return service.insert(employee);
    }

    @PostMapping("/teachers")
    public Teacher insertTeacher(@RequestBody Teacher teacher){
        return service.insertTeacher(teacher);
    }

    @PostMapping("/assistants")
    public Assistant insertAssistant(@RequestBody Assistant assistant){
        return service.insertAssistant(assistant);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

    @PutMapping()
    public Employee update(@RequestBody Employee employee){
        return service.update(employee);
    }

    @PutMapping("/teachers")
    public Teacher updateTeacher(@RequestBody Teacher teacher){
        return service.updateTeacher(teacher);
    }

    @PutMapping("/assistants")
    public Assistant update(@RequestBody Assistant assistant){
        return service.updateAssistant(assistant);
    }

}
