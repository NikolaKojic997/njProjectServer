package com.njProjectServer.service;

import com.njProjectServer.model.UserProfile;
import com.njProjectServer.repository.ProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfilesService {

    @Autowired
    private ProfilesRepository profilesRepository;

    public List<UserProfile> findAll(){
        return profilesRepository.findAll();
    }

}
