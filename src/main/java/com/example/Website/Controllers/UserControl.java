package com.example.Website.Controllers;


import com.example.Website.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserControl {
    @Autowired
    LoginService login;

    @PostMapping("/register")
    public String validateCredential(
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String email,
            @RequestParam String dob,
            @RequestParam Long phoneNumber,
            @RequestParam String gender,
            @RequestParam String password
    ) {
        try {
            login.addUser(firstname,lastname,email,dob,phoneNumber,gender,password);
            return "Signin/login"; // loads login.html from templates/
        }
        catch (Exception e){
            return "Signin/register";
        }


    }
    @PostMapping("/login")
    public String checkLogin(String username,
                             String password){
        if(login.loginCheck(username,password))
            return "Signin/hello";
        else
            return "Signin/login";

    }

    @GetMapping("/login")
    public String loginPage(){
        return "Signin/login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "Signin/register"; // loads login.html from templates/
    }
}
