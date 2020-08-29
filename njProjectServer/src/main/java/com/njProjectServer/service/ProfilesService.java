package com.njProjectServer.service;

import com.njProjectServer.exception.LoginException;
import com.njProjectServer.exception.ResourceNotFoundException;
import com.njProjectServer.model.Employee;
import com.njProjectServer.model.UserProfile;
import com.njProjectServer.model.dto.InsertProfileDto;
import com.njProjectServer.model.dto.LoginUserDto;
import com.njProjectServer.repository.EmployeeRepository;
import com.njProjectServer.repository.ProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.websocket.Session;
import java.util.List;
import java.util.Optional;

@Service
public class ProfilesService {

    @Autowired
    private ProfilesRepository profilesRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<UserProfile> findAll(){
        return profilesRepository.findAll();
    }

    public UserProfile findById(int id) {
       return profilesRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Profile with given id not found"));
    }

    public UserProfile insert(InsertProfileDto profile) {
        Optional<Employee> emp = employeeRepository.findById(profile.getEmployeeID());

        if (emp.isEmpty())
            new ResourceNotFoundException("Employee with given id not found");

        UserProfile up = new UserProfile(profile.getUsername(), profile.getPassword(), profile.getEmail(), emp.get());
        return profilesRepository.save(up);
    }


    public void delete(int id) {
        Optional<UserProfile> profile = profilesRepository.findById(id);
        if (profile.isEmpty())
            new ResourceNotFoundException("Profile with given id not found");
        profilesRepository.deleteById(id);
    }

    public UserProfile update(InsertProfileDto profile, int id) {
        Optional<UserProfile> p = profilesRepository.findById(id);
        if (p.isEmpty())
            new ResourceNotFoundException("Profile with given id not found");

        Optional<Employee> emp = employeeRepository.findById(profile.getEmployeeID());

        if (emp.isEmpty())
            new ResourceNotFoundException("Employee with given id not found");

        p.get().setEmail(profile.getEmail());
        p.get().setPassword(profile.getPassword());
        p.get().setEmployee(emp.get());

        return profilesRepository.save(p.get());

    }

    public UserProfile login(LoginUserDto user) {
        Optional <UserProfile> profile =  profilesRepository.findByUsername(user.getUsername());
        if (profile.isEmpty())
            throw  new LoginException("Profile with given username doesent exist");

        if(!profile.get().getPassword().equals(user.getPassword())){
            throw new LoginException("Wrong password, try again!");
        }

        return  profile.get();

    }


}
