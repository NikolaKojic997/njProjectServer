package com.njProjectServer.service;

import com.njProjectServer.exception.LoginException;
import com.njProjectServer.exception.ResourceNotFoundException;
import com.njProjectServer.exception.SqlConstraintException;
import com.njProjectServer.model.Employee;
import com.njProjectServer.model.UserProfile;
import com.njProjectServer.model.dto.InsertProfileDto;
import com.njProjectServer.model.dto.LoginUserDto;
import com.njProjectServer.repository.EmployeeRepository;
import com.njProjectServer.repository.ProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ProfilesService {

    @Autowired
    private JavaMailSender mailSender;

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
        Optional<Employee> emp = employeeRepository.findByIdentificationNumber(profile.getIdentificationNumber());

        if (emp.isEmpty())
            throw new ResourceNotFoundException("Employee with given id not found");

        UserProfile up = new UserProfile(profile.getUsername(), profile.getPassword(), profile.getEmail(), emp.get());

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        try {

        UserProfile p =  profilesRepository.save(up);

            String htmlMsg = "<p>Hi "+profile.getUsername()+" </p>" +
                    "<br> <p> Please confirm that you want to activate your account. " +
                    "To activate your account, you need to click " +
                    "the link below</p> <br> http://localhost:3000/confirmation/"+p.getProfileID();


        helper.setText(htmlMsg, true); // Use this or above line.
        helper.setTo(profile.getEmail());
        helper.setSubject("Confirmation email");
        helper.setFrom("planart.test@gmail.com");
        mailSender.send(mimeMessage);

        return p;

        }
        catch (Exception e){
            throw new SqlConstraintException("Profile with given username already exists!");
        }
    }


    public void delete(int id) {
        Optional<UserProfile> profile = profilesRepository.findById(id);
        if (profile.isEmpty())
            throw new ResourceNotFoundException("Profile with given id not found");
        profilesRepository.deleteById(id);
    }

    public UserProfile update(InsertProfileDto profile, int id) {
        Optional<UserProfile> p = profilesRepository.findById(id);
        if (p.isEmpty())
            throw new ResourceNotFoundException("Profile with given id not found");

        Optional<Employee> emp = employeeRepository.findByIdentificationNumber(profile.getIdentificationNumber());

        if (emp.isEmpty())
            throw new ResourceNotFoundException("Employee with given id not found");

        p.get().setEmail(profile.getEmail());
        p.get().setPassword(profile.getPassword());
        p.get().setEmployee(emp.get());
        p.get().setUsername(profile.getUsername());


        try {
            return profilesRepository.save(p.get());
        }
        catch (Exception e){
            throw new SqlConstraintException("Profile with given username already exists!");
        }

    }

    public UserProfile login(LoginUserDto user) {
        Optional <UserProfile> profile =  profilesRepository.findByUsername(user.getUsername());
        if (profile.isEmpty())
            throw  new LoginException("Profile with given username doesent exist");

        if(!profile.get().getPassword().equals(user.getPassword())){
            throw new LoginException("Wrong password, try again!");
        }

        if (profile.get().getStatus() == 0){
            throw new LoginException("Please activate your account!");
        }

        return  profile.get();


    }
    public UserProfile activate(int id) {
        Optional <UserProfile> profile =  profilesRepository.findById(id);
        if (profile.isEmpty())
            throw  new LoginException("Profile with given id doesent exist");
        UserProfile up = profile.get();
        up.setStatus(1);
        return profilesRepository.save(up);
    }
}
