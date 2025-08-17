package com.example.Website.Controllers;


import com.example.Website.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserControl {
    @Autowired
    LoginService login;

    @PostMapping("/register")
    public String validateCredential(
            String firstname,
            String lastname,
            String email,
            String dob,
            Long phoneNumber,
            String gender,
            String password
    )
    {
        try {
            login.addUser(firstname,lastname,email,dob,phoneNumber,gender,password);
            return "redirect:/login"; // loads login.html from templates/
        }
        catch (Exception e){
            return "redirect:/register?error=conflict";
        }


    }
    @PostMapping("/login")
    public String checkLogin(String username, String password)
    {
        return login.loginCheck(username,password)?"redirect:/":"redirect:/login?error=notfound";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "Signin/login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "Signin/register"; // loads login.html from templates/
    }

    @GetMapping("")
    public String welcomePage(){
        return  "Signin/hello";
    }
}
