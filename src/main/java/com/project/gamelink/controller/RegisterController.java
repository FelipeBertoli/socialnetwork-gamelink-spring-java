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
@RestController
public class RegisterController {

    @Autowired
    private UserRepository uRepo;
    @Autowired
    private GenderRepository genderRepo;
    @Autowired
    private GenreRepository genreRepo;
    @Autowired
    private BucketService service;


    @PostMapping("/registerGender")
    public Gender registerGender(
        @RequestParam("gender_id") String genderId,
        @RequestParam("gender_title") String genderTitle
    ) {
        Gender gender = new Gender();
        gender.setGenderId(genderId);
        gender.setGenderTitle(genderTitle);
        genderRepo.save(gender);
        return gender;
    }

    
    @PostMapping("/registerGameGenre")
    public GameGenre registerGameGenre(
        @RequestParam("genre_title") String genreTitle
    ) {
        GameGenre genre = new GameGenre();
        genre.setGenreTitle(genreTitle);
        genreRepo.save(genre);
        return genre;
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

        String genderId = "M";
        Gender gender = genderRepo.findById(genderId).orElse(null);
        user.setGender(gender);

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
        redirectView.setUrl("/");
        return redirectView;
    }

}
