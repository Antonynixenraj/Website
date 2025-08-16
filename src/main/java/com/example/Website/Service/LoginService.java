package com.example.Website.Service;

import com.example.Website.Database.UserDetails;
import com.example.Website.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserRepo repo;  //Object for Repository

    public boolean loginCheck(String username,String password){
        username=username.trim();  // To remove spaces

        // Check it is Phone Number or email
        try{
            Long phNumber=Long.parseLong(username);
            return repo.findByPhoneNumberAndPassword(phNumber,password).isPresent();
        }
        // If conversion of long throw exception it is email
        catch (NumberFormatException e) {
            return repo.findByEmailAndPassword(username, password).isPresent();
        }
    }

    // Use to add users to Database
    public void addUser(String firstname,
                         String lastname,
                         String email,
                         String dob,
                         Long phoneNumber,
                         String gender,
                         String password){
        repo.save(new UserDetails(firstname,lastname,email,dob,phoneNumber,gender,password)); // Save method inside UserRepo interface convert object to it's respective value for it's value
    }
}
