package com.example.Website.Service;

import com.example.Website.Database.UserDetails;
import com.example.Website.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserRepo repo;
    public boolean loginCheck(String email,String password){
        return repo.findByEmailAndPassword(email,password).isPresent();
    }
    public void addUser(String firstname,
                         String lastname,
                         String email,
                         String dob,
                         Long phoneNumber,
                         String gender,
                         String password){
        repo.save(new UserDetails(firstname,lastname,email,dob,phoneNumber,gender,password));
    }
}
