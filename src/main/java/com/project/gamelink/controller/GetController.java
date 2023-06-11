package com.project.gamelink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.gamelink.repository.UserRepository;

@Controller
@RestController
public class GetController {

    @Autowired
    private UserRepository uRepo;

    @GetMapping("/getAllUsers")
    public Object getAllUsers(){
        return uRepo.findAll();
    }

}
