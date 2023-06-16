package com.project.gamelink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.project.gamelink.model.User;
import com.project.gamelink.repository.UserRepository;

@Controller
@RequestMapping
public class NavegationController {

    @Autowired
    private UserRepository uRepo;
    
    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

     @RequestMapping("/success")
    public String success() {
        return "success";
    }


    @RequestMapping("/profile")
    public String profile(){
        return "profile";
    }

    @RequestMapping("/community")
    public String community(){
        return "community";
    }

    @RequestMapping("/favorites")
    public String favorites(){
        return "favorites";
    }

    @RequestMapping("/settings")
    public String settings(){
        return "setting";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        User user = uRepo.Login(email, password);
        
        if(user != null) {
            if(password.equals(user.getPassword()) && email.equals(user.getEmail())) {
                return "index";
            }

        }
        return "erro-não-preenchido";
    }
    
}