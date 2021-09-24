package com.teamRed.app.User.Model;

public class UserDTO {

    private final String email;
    private final int level;
    private final int experiencePoints;

    public UserDTO(User user) {
        this.email = user.getEmail();
        this.level = user.getLevel();
        this.experiencePoints = user.getExperiencePoints();
    }

}
