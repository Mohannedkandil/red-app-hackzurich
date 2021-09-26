package com.teamRed.app.User.Model;

public class UserDTO {

    private final String email;
    private final int level;
    private final int experiencePoints;
    private final String avatarUrl;

    public UserDTO(User user) {
        this.email = user.getEmail();
        this.level = user.getLevel();
        this.experiencePoints = user.getExperiencePoints();
        this.avatarUrl = user.getUserAvatar();
    }

    public String getEmail() {
        return email;
    }

    public int getLevel() {
        return level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
