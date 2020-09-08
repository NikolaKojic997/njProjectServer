package com.njProjectServer.controller;

import com.njProjectServer.model.Assistant;
import com.njProjectServer.model.Employee;
import com.njProjectServer.model.Teacher;
import com.njProjectServer.model.dto.InsertAssistantDto;
import com.njProjectServer.model.dto.InsertEmployeeDto;
import com.njProjectServer.model.dto.InsertTeacherDto;
import com.njProjectServer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin
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
    public ResponseEntity<Employee> getOne(@PathVariable int id){
        return  service.findById(id);
    }

    @PostMapping
    public Employee insert(@Valid @RequestBody InsertEmployeeDto employee){
        return service.insert(employee);
    }

    @PostMapping("/teachers")
    public Teacher insertTeacher(@Valid @RequestBody InsertTeacherDto teacher){
        return service.insertTeacher(teacher);
    }

    @PostMapping("/assistants")
    public Assistant insertAssistant(@Valid @RequestBody InsertAssistantDto assistant){
        return service.insertAssistant(assistant);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable int id ,@Valid @RequestBody InsertEmployeeDto employee){
        return service.update(employee, id);
    }

    @PutMapping("/teachers/{id}")
    public Teacher updateTeacher(@PathVariable int id,@Valid@RequestBody InsertTeacherDto teacher){
        return service.updateTeacher(id,teacher);
    }

    @PutMapping("/assistants/{id}")
    public Assistant update(@PathVariable int id,@Valid@RequestBody InsertAssistantDto assistant){
        return service.updateAssistant(id,assistant);


}
}
