package com.njProjectServer.controller;

import com.njProjectServer.model.Assistant;
import com.njProjectServer.model.Employee;
import com.njProjectServer.model.Teacher;
import com.njProjectServer.model.UserProfile;
import com.njProjectServer.model.dto.InsertAssistantDto;
import com.njProjectServer.model.dto.InsertEmployeeDto;
import com.njProjectServer.model.dto.InsertProfileDto;
import com.njProjectServer.model.dto.InsertTeacherDto;
import com.njProjectServer.service.ProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/profiles")
public class UserProfileController {

    @Autowired
    private ProfilesService profilesService;

    @GetMapping
    public List<UserProfile> findAll(){
        List<UserProfile> profiles =  profilesService.findAll();
        return profiles;
    }

    @GetMapping("/{id}")
    public UserProfile getOne(@PathVariable int id){
        return  profilesService.findById(id);
    }

    @PostMapping
    public UserProfile insert(@Valid @RequestBody InsertProfileDto profile){
        return profilesService.insert(profile);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        profilesService.delete(id);
    }

    @PutMapping("/{id}")
    public UserProfile update(@PathVariable int id ,@Valid @RequestBody InsertProfileDto profile){
        return profilesService.update(profile, id);
    }

}
