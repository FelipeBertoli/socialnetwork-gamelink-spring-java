package com.project.gamelink.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.gamelink.model.Convocation;

@Repository
public interface ConvocationRepository extends JpaRepository<Convocation, Integer>{
    
    @Query(value = "select * from convocation order by convocation_id desc limit 5", nativeQuery = true)
    List<Convocation> findLastFive();


    List<Convocation> findAll();
    <Entity extends Convocation> Entity save(Entity entity);
}
