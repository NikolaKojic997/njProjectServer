package com.njProjectServer.resource;

import com.njProjectServer.model.User;
import com.njProjectServer.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UserResource {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/all")
    public List<User> GetAll(){
        return usersRepository.findAll();
    }

}
