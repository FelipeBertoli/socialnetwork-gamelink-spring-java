package com.project.gamelink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.gamelink.model.Gender;


public interface GenderRepository extends JpaRepository<Gender, String>{
    <Entity extends Gender> Entity save(Entity entity);
}
