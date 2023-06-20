package com.project.gamelink.model;

import jakarta.persistence.*;

@Entity
@Table(name = "convocation")
public class Convocation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "convocation_id", nullable = false)
    private int convocationId;

    @Column(name = "convocation_title", nullable = false)
    private String convocationTitle;

    @Column(name = "convocation_type", nullable = false)
    private String convocationType;

    @Column(name = "description", nullable = false, columnDefinition = "LONGTEXT")
    private String description;

    // @ManyToOne
    // @JoinColumn(name = "author_id", referencedColumnName = "user_id")
    // private User user;

    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "game_id")
    private Game game;

    public int getConvocationId() {
        return convocationId;
    }

    public void setConvocationId(int genreId) {
        this.convocationId = genreId;
    }

    public String getConvocationTitle() {
        return convocationTitle;
    }

    public void setConvocationTitle(String convocationTitle) {
        this.convocationTitle = convocationTitle;
    }

    public String getConvocationType() {
        return convocationType;
    }

    public void setConvocationType(String convocationType) {
        this.convocationType = convocationType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // public User getUser() {
    //     return user;
    // }

    // public void setUser(User user) {
    //     this.user = user;
    // }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }


}
