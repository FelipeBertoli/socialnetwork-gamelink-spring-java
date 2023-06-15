package com.project.gamelink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.gamelink.model.GameGenre;

public interface GenreRepository extends JpaRepository<GameGenre, Integer>{
    <Entity extends GameGenre> Entity save(Entity entity);
}
