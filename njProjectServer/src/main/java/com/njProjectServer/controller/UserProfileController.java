package com.njProjectServer.controller;

import com.njProjectServer.model.UserProfile;
import com.njProjectServer.service.ProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class UserProfileController {

    @Autowired
    private ProfilesService profilesService;

    @GetMapping
    public List<UserProfile> findAll(){
        return profilesService.findAll();
    }
}
