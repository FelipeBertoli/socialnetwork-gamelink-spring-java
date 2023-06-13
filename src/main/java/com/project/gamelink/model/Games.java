package com.project.gamelink.model;

import jakarta.persistence.*;

@Entity
@Table(name = "games")
public class Games {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id", nullable = false)
    private int gameId;

    @Column(name = "game_title", nullable = false)
    private String gameTitle;

    @Column(name = "description", nullable = false, columnDefinition = "LONGTEXT")
    private String description;

    @Column(name = "game_image", nullable = false)
    private String gameImage;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "genre_id")
    private GameGenre genre;

    @ManyToOne
    @JoinColumn(name = "genre_id_optional", referencedColumnName = "genre_id")
    private GameGenre genreOp;

    public GameGenre getGenreOp() {
        return genreOp;
    }

    public void setGenreOp(GameGenre genreOp) {
        this.genreOp = genreOp;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGameImage() {
        return gameImage;
    }

    public void setGameImage(String gameImage) {
        this.gameImage = gameImage;
    }

    public GameGenre getGenre() {
        return genre;
    }

    public void setGenre(GameGenre genre) {
        this.genre = genre;
    }

    
    
}
