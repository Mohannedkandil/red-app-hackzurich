package com.teamRed.app.Challenges.Controller;

import com.teamRed.app.Challenges.Model.Challenge;
import com.teamRed.app.Task.Model.Task;

import java.util.stream.Collectors;

public class ChallengeDTO {

    private final String challengeTitle;
    private final String challengeDescription;
    private final int challengeProgress;
    private final int challengeRequirement;
    public ChallengeDTO(Challenge challenge) {
        this.challengeDescription = challenge.getDescription();
        this.challengeTitle = challenge.getTitle();
        this.challengeProgress = challenge.getTaskList().stream().filter(Task::isCompleted).collect(Collectors.toList()).size();
        this.challengeRequirement = challenge.getTaskList().size();
    }

    public String getChallengeTitle() {
        return challengeTitle;
    }

    public String getChallengeDescription() {
        return challengeDescription;
    }

    public int getChallengeProgress() {
        return challengeProgress;
    }

    public int getChallengeRequirement() {
        return challengeRequirement;
    }
}
