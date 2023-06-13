package com.project.gamelink.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.project.gamelink.model.Games;

public interface GameRepository extends JpaRepository<Games, Integer>{
    @Query(value="select * from games order by gameTitle", nativeQuery = true)
    List<Games> getAll();
    
    <Entity extends Games> Entity save(Entity entity);
}
