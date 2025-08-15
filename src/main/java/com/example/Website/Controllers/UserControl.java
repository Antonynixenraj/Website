package com.example.Website.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserControl {

    @PostMapping("/login")
    public String validateCredential(
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String email,
            @RequestParam String dob,
            @RequestParam Long phoneNumber,
            @RequestParam String gender,
            @RequestParam String password,
            @RequestParam String remember
    ) {
        if (
                firstname!=null
                && lastname!=null
                && email!=null
                && dob!=null
                && phoneNumber!=null
                && gender!=null
                && password!=null
        )
            return "login"; // loads login.html from templates/
        else
            return "register";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register"; // loads login.html from templates/
    }
}
