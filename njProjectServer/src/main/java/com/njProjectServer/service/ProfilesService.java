package com.njProjectServer.service;

import com.njProjectServer.config.EmailConfiguration;
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
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.websocket.Session;
import java.sql.SQLClientInfoException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Service
public class ProfilesService {

    @Autowired
    private EmailConfiguration emailConfiguration;

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

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailConfiguration.getHost());
        mailSender.setPort(this.emailConfiguration.getPort());
        mailSender.setUsername(this.emailConfiguration.getUsername());
        mailSender.setPassword(this.emailConfiguration.getPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(this.emailConfiguration.getUsername());
        mailMessage.setTo(profile.getEmail());
        mailMessage.setSubject("Confirmation email");
        mailMessage.setText("Please confirm that you sign up to our site: " +
                "Click to link: ");


        mailSender.send(mailMessage);

        try {
            return profilesRepository.save(up);
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

        return profilesRepository.save(p.get());

    }

    public UserProfile login(LoginUserDto user) {
        Optional <UserProfile> profile =  profilesRepository.findByUsername(user.getUsername());
        if (profile.isEmpty())
            throw  new LoginException("Profile with given username doesent exist");

        if(!profile.get().getPassword().equals(user.getPassword())){
            throw new LoginException("Wrong password, try again!");
        }

        try {
            return  profile.get();
        }
        catch (Exception e){
            throw new SqlConstraintException("Profile with given username already exists!");
        }

    }


}
