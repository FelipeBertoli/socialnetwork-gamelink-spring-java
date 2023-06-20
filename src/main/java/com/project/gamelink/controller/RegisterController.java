package com.project.gamelink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import java.io.IOException;
import java.text.SimpleDateFormat;
import com.project.gamelink.model.*;
import com.project.gamelink.repository.*;
import com.project.gamelink.service.BucketService;


@Controller
public class RegisterController {

    @Autowired
    private UserRepository uRepo;
    @Autowired
    private GenreRepository genreRepo;
    @Autowired
    private GameRepository gameRepo;
    @Autowired
    private ConvocationRepository cRepo;
    @Autowired
    private BucketService service;
    
    @PostMapping("/registerGameGenre")
    public GameGenre registerGameGenre(
        @RequestParam("genre_title") String genreTitle
    ) {
        GameGenre genre = new GameGenre();
        genre.setGenreTitle(genreTitle);
        genreRepo.save(genre);
        return genre;
    }

    @PostMapping("/registerGame")
    public Game registerGame(
        @RequestParam("game_title") String gameTitle,
        @RequestParam("description") String description,
        @RequestParam("game_image") String gameImage,
        @RequestParam("game_icon") String gameIcon,
        @RequestParam("genre_id") int genreId,
        @RequestParam("genre_id_optional") int genreIdOpt
    ) {
        Game game = new Game();
        
        game.setGameTitle(gameTitle);
        game.setDescription(description);
        game.setGameImage(gameImage);
        game.setGameIcon(gameIcon);
        GameGenre genre = genreRepo.findById(genreId).orElse(null);
        game.setGenre(genre);
        GameGenre genreOpt = genreRepo.findById(genreIdOpt).orElse(null);
        game.setGenreOp(genreOpt);
        game.setGameImage(gameImage);

        gameRepo.save(game);
        return game;
    }

    @PostMapping("/registerConvocation")
    public RedirectView RegisterConvocation(
            @RequestParam("convocation_title") String title,
            @RequestParam("convocation_type") String type,
            @RequestParam("description") String description,
            // @RequestParam("author_id") Long authorId,
            @RequestParam("game_id") int gameId
    ){
        Convocation convocation = new Convocation();
        // User user = uRepo.findById(authorId).orElse(null);
        Game game = gameRepo.findById(gameId).orElse(null);
        convocation.setConvocationTitle(title);
        convocation.setConvocationType(type);
        convocation.setDescription(description);
        // convocation.setUser(user);
        convocation.setGame(game);
        cRepo.save(convocation);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("convocations");
        return redirectView;
    }

    @PostMapping("/registerUser")
    public RedirectView registerUser(
            @RequestParam("first_name") String name,
            @RequestParam("last_name") String lastName,
            @RequestParam("nickname") String nickName,
            @RequestParam("birthday") String birthday,
            @RequestParam("profile_pic") MultipartFile file,
            @RequestParam("email") String email,
            @RequestParam("password") String password) throws IOException {
                System.out.println(birthday);
        User user = new User();
        user.setFirstName(name);
        user.setLastName(lastName);
        user.setNickName(nickName);
        user.setEmail(email);
        user.setPassword(password);
        user.setAccountStatus("ATIVO");

        SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
        java.util.Date dataUtil;
        try {
            dataUtil = format.parse(birthday);
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
            user.setBirthday(dataSql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String path = service.getUrl(file, nickName, birthday);
        user.setProfilePic(path);
        service.saveFile(file, nickName, birthday);
        uRepo.save(user);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("success");
        return redirectView;
    }
}
