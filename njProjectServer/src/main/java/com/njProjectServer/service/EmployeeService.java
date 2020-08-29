package com.njProjectServer.service;

import com.njProjectServer.exception.ResourceNotFoundException;
import com.njProjectServer.model.*;
import com.njProjectServer.model.dto.InsertEmployeeDto;
import com.njProjectServer.model.dto.InsertTeacherDto;
import com.njProjectServer.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TeacherRepository teachersRepository;

    @Autowired
    private AssistantRepository assistantRepository;

    @Autowired
    private RankRepository rankRepository;

    @Autowired
    private TitleRepository titleRepository;

    public List<Employee> getAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public List<Teacher> getAllTeachers() {
         return  (List<Teacher>) teachersRepository.findAll();
    }

    public List<Assistant> getAllAssistants() {
        return  (List<Assistant>) assistantRepository.findAll();
    }

    public Employee insert(InsertEmployeeDto employee) {
        Employee emp = new Employee(employee.getName(), employee.getSurname(), employee.getEmploymentDate());
        return employeeRepository.save(emp);
    }

    public Teacher insertTeacher(InsertTeacherDto teacher) {
        Optional<Rank> r = rankRepository.findById(teacher.getRankID());

        if(r.isEmpty())
            throw new ResourceNotFoundException("Rank with given id not found!");

        Optional<Title> t = titleRepository.findById(teacher.getTitleID());

        if(t.isEmpty())
            throw new ResourceNotFoundException("Title with given id not found!");

        Teacher tech = new Teacher(teacher.getName(), teacher.getSurname(), teacher.getEmploymentDate(), t.get(), r.get());
        return teachersRepository.save(tech);
    }

    public Assistant insertAssistant(Assistant assistant) {
        return assistantRepository.save(assistant);
    }

    public void delete(int id){
        employeeRepository.deleteById(id);
    }


    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Assistant updateAssistant(Assistant assistant) {
        return assistantRepository.save(assistant);
    }

    public Teacher updateTeacher(Teacher teacher) {
        return teachersRepository.save(teacher);
    }

    public ResponseEntity<Employee> findById(int id) {
        Optional<Employee> e =  employeeRepository.findById(id);

        if (e.isEmpty()){
            throw new ResourceNotFoundException("User with id: "+id+ " not found");
        }

        return new ResponseEntity(e, HttpStatus.OK);
    }
}
