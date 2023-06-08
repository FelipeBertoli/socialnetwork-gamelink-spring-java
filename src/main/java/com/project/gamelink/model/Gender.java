package com.project.gamelink.model;


import jakarta.persistence.*;

@Entity
@Table(name = "gender")
public class Gender {
    
    @Id
    @Column(name = "gender_id", nullable = false)
    private String genderId;

    @Column(name = "gender_title", nullable = false)
    private String genderTitle;

    public String getGenderId() {
        return genderId;
    }

    public void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    public String getGenderTitle() {
        return genderTitle;
    }

    public void setGenderTitle(String genderTitle) {
        this.genderTitle = genderTitle;
    }

    

}
