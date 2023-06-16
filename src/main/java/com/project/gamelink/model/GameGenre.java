package com.project.gamelink.model;

import jakarta.persistence.*;

@Entity
@Table(name = "game_genre")
public class GameGenre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id", nullable = false)
    private int genreId;

    @Column(name = "genre_title", nullable = false)
    private String genreTitle;

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreTitle() {
        return genreTitle;
    }

    public void setGenreTitle(String genreTitle) {
        this.genreTitle = genreTitle;
    }
}
