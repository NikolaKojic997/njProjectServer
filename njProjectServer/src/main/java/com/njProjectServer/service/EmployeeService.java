package com.njProjectServer.service;

import com.njProjectServer.exception.ResourceNotFoundException;
import com.njProjectServer.model.*;
import com.njProjectServer.model.dto.InsertAssistantDto;
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

    public Assistant insertAssistant(InsertAssistantDto assistant) {
        Optional<Title> t = titleRepository.findById(assistant.getTitleID());

        if(t.isEmpty())
            throw new ResourceNotFoundException("Title with given id not found!");

        Assistant a = new Assistant(assistant.getName(), assistant.getSurname(), assistant.getEmploymentDate(), t.get());

        return assistantRepository.save(a);
    }

    public void delete(int id){
        Optional<Employee> e = employeeRepository.findById(id);
        if(e.isEmpty())
            throw new ResourceNotFoundException("Employee with given id not found");
        employeeRepository.deleteById(id);
    }


    public Employee update(InsertEmployeeDto employee, int id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        if (emp.isEmpty()){
            throw new ResourceNotFoundException("Employee with given id not found");
        }
        emp.get().setEmploymentDate(employee.getEmploymentDate());
        emp.get().setName(employee.getName());
        emp.get().setSurname(employee.getSurname());

        return employeeRepository.save(emp.get());
    }

    public Assistant updateAssistant(int id, InsertAssistantDto assistant) {
        Optional<Assistant> a = assistantRepository.findById(id);
        if (a.isEmpty()){
            throw new ResourceNotFoundException("Assistant with given id not found");
        }
        a.get().setEmploymentDate(assistant.getEmploymentDate());
        a.get().setName(assistant.getName());
        a.get().setSurname(assistant.getSurname());

        Optional<Title> title = titleRepository.findById(assistant.getTitleID());

        if(title.isEmpty())
            throw new ResourceNotFoundException("Title with given id not found!");

        a.get().setTitle(title.get());

        return assistantRepository.save(a.get());
    }

    public Teacher updateTeacher(int id,InsertTeacherDto teacher) {
        Optional<Teacher> t = teachersRepository.findById(id);
        if (t.isEmpty()){
            throw new ResourceNotFoundException("Teacher with given id not found");
        }
        t.get().setEmploymentDate(teacher.getEmploymentDate());
        t.get().setName(teacher.getName());
        t.get().setSurname(teacher.getSurname());

        Optional<Title> title = titleRepository.findById(teacher.getTitleID());

        if(title.isEmpty())
            throw new ResourceNotFoundException("Title with given id not found!");

        t.get().setTitle(title.get());

        Optional<Rank> rank = rankRepository.findById(teacher.getRankID());

        if(rank.isEmpty())
            throw new ResourceNotFoundException("Rank with given id not found!");

        t.get().setRank(rank.get());

        return teachersRepository.save(t.get());
    }

    public ResponseEntity<Employee> findById(int id) {
        Optional<Employee> e =  employeeRepository.findById(id);

        if (e.isEmpty()){
            throw new ResourceNotFoundException("User with id: "+id+ " not found");
        }

        return new ResponseEntity(e, HttpStatus.OK);
    }
}
