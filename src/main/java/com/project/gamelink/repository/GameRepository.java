package com.project.gamelink.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.project.gamelink.model.Game;

public interface GameRepository extends JpaRepository<Game, Integer>{
    @Query(value="select * from games order by game_title", nativeQuery = true)
    List<Game> getAll();

    @Query(value="select game_id, game_title from games order by game_title", nativeQuery = true)
    List<Game> getGameNames();
    
    <Entity extends Game> Entity save(Entity entity);
}
