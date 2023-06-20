package com.project.gamelink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.project.gamelink.model.User;
import com.project.gamelink.repository.*;

@Controller
@RequestMapping
public class NavegationController {

    @Autowired
    private UserRepository uRepo;
    @Autowired
    private ConvocationRepository cRepo;
    @Autowired
    private GameRepository gameRepo;

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        User user = uRepo.Login(email, password);

        if (user != null) {
            if (password.equals(user.getPassword()) && email.equals(user.getEmail())) {
                model.addAttribute("convocations", cRepo.findLastFive());
                model.addAttribute("convocations", cRepo.findLastFive());
                return "index";
            }
        }
        return "erro-não-preenchido";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("convocations", cRepo.findLastFive());
        model.addAttribute("convocations", cRepo.findLastFive());
        return "index";

    }

    @GetMapping("/games")
    private String getGameInfo(Model model) {
        model.addAttribute("jogos", gameRepo.getAll());
        return "games";
    }

    @GetMapping("/convocations")
    public String convocation(Model model) {
        model.addAttribute("games", gameRepo.getAll());
        model.addAttribute("convocations", cRepo.findAll());
        return "convocations";
    }

    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}