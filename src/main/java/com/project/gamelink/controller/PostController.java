package com.project.gamelink.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;

import com.mysql.cj.util.StringUtils;
import com.project.gamelink.model.*;
import com.project.gamelink.repository.*;

@Controller
@RestController
public class PostController {

    @Autowired
    private UserRepository uRepo;
    @Autowired
    private GenderRepository gRepo;

    @PostMapping("/registerGender")
    public Gender registerGender(
        @RequestParam("gender_id") String genderId,
        @RequestParam("gender_title") String genderTitle
    ) {
        Gender gender = new Gender();
        gender.setGenderId(genderId);
        gender.setGenderTitle(genderTitle);
        gRepo.save(gender);
        return gender;
    }


    @PostMapping("/registerUser")
    public Object registerUser(
            @RequestParam("first_name") String name,
            @RequestParam("last_name") String lastName,
            @RequestParam("nickname") String nickName,
            @RequestParam("birthday") String birthday,
            @RequestParam("profile_pic") MultipartFile image,
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
                System.out.println(birthday);
        User user = new User();
        user.setFirstName(name);
        user.setLastName(lastName);
        user.setNickName(nickName);
        user.setEmail(email);
        user.setPassword(password);
        user.setAccountStatus("ATIVO");

        String genderId = "M";
        Gender gender = gRepo.findById(genderId).orElse(null);
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

        String fileName = StringUtils.cl(image.getOriginalFilename());
        user.setProfilePic(fileName);
         
        User savedUser = uRepo.save(user);
 
        String uploadDir = "user-photos/" + savedUser.getId();
 
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);


        uRepo.save(user);
        return user;
    }
}
