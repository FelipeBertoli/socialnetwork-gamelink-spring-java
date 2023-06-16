package com.project.gamelink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.project.gamelink.repository.*;

@Controller
@RequestMapping
public class GetController {

    @Autowired
    private UserRepository uRepo;
    @Autowired
    private ConvocationRepository cRepo;
    @Autowired
    private GameRepository gameRepo;

    @GetMapping("/games")
    private String getGameInfo(Model model){
        model.addAttribute("jogos", gameRepo.getAll());
        return "games";
    }

    @GetMapping("/index")
    public String games(Model model){
        model.addAttribute("convocations", cRepo.findLastFive());
         return "index";
    }

    @GetMapping("/convocations")
    public String convocation(Model model){
        model.addAttribute("convocations", cRepo.findAll());
         return "convocations";
    }

    @GetMapping("/getAllUsers")
    public Object getAllUsers(){
        return uRepo.findAll();
    }

}
