package com.project.gamelink.controller;

import com.project.gamelink.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis")
public class GetController {

    @Autowired
    private UserRepository uRepo;
    @Autowired 
    private ConvocationRepository cRepo;
    @Autowired
    private GameRepository gameRepo;
    @Autowired
    private GenreRepository genreRepo;
    
    @GetMapping("/getUsers")
    public Object getUsers(){
        return uRepo.findAll();
    }

    @GetMapping("/getGames")
    public Object getGames(){
        return gameRepo.findAll();
    }

    @GetMapping("/getGameGenres")
    public Object getGameGenres(){
        return genreRepo.findAll();
    }

    @GetMapping("/getConvocations")
    public Object getConvocations(){
        return cRepo.findAll();
    }

}
