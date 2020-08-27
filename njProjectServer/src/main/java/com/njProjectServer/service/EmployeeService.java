package com.njProjectServer.service;

import com.njProjectServer.exception.ResourceNotFoundException;
import com.njProjectServer.model.Assistant;
import com.njProjectServer.model.Employee;
import com.njProjectServer.model.Teacher;
import com.njProjectServer.repository.AssistantRepository;
import com.njProjectServer.repository.EmployeeRepository;
import com.njProjectServer.repository.TeacherRepository;
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

    public List<Employee> getAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public List<Teacher> getAllTeachers() {
         return  (List<Teacher>) teachersRepository.findAll();
    }

    public List<Assistant> getAllAssistants() {
        return  (List<Assistant>) assistantRepository.findAll();
    }

    public Employee insert(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Teacher insertTeacher(Teacher teacher) {
        return teachersRepository.save(teacher);
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

    public ResponseEntity<Object> findById(int id) {
        Optional<Employee> e =  employeeRepository.findById(id);

        if (e.isEmpty()){
            throw new ResourceNotFoundException("User with id: "+id+ " not found");
        }

        return new ResponseEntity(e, HttpStatus.OK);
    }
}
