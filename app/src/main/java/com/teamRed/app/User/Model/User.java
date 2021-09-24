package com.teamRed.app.User.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    @Id
    private final String email;
    private int level;
    private int experiencePoints;


    public User(String email) {
        this.email = email;
        this.level = 1;
        this.experiencePoints = 0;
    }

    public User(String email, int level, int experiencePoints) {
        this.email = email;
        if (level <= 0)
            this.level = 1;
        this.level = level;
        if (experiencePoints <= 0)
            this.experiencePoints = 0;
        this.experiencePoints = experiencePoints;
    }

    @PersistenceConstructor
    public User(int level, String email, int experiencePoints) {
        this.email = email;
        this.level = level;
        this.experiencePoints = experiencePoints;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public String getEmail() {
        return this.email;
    }
}
