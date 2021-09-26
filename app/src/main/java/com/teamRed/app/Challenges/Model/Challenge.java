package com.teamRed.app.Challenges.Model;

import com.teamRed.app.Products.Model.Product;
import com.teamRed.app.Task.Model.Task;
import com.teamRed.app.Task.Model.TaskType;
import com.teamRed.app.Task.Service.TaskGenerator;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.PersistenceConstructor;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Challenge implements Comparable<Challenge>{

    private final String challengeId;
    private final String title;
    private final String description;
    private List<Task> taskList;
    private final int experiencePoints;
    private LocalDateTime challengeFinishDate;
    private final LocalDateTime challengeStartDate;
    private final ChallengeDuration challengeDuration;

    @PersistenceConstructor
    public Challenge(String challengeId, String title, String description, List<Task> taskList, int experiencePoints, LocalDateTime challengeFinishDate, LocalDateTime challengeStartDate, ChallengeDuration challengeDuration) {
        this.challengeId = challengeId;
        this.title = title;
        this.description = description;
        this.taskList = taskList;
        this.experiencePoints = experiencePoints;
        this.challengeFinishDate = challengeFinishDate;
        this.challengeStartDate = challengeStartDate;
        this.challengeDuration = challengeDuration;
    }

    public Challenge(String challengeId, String title, String description, Map<TaskType, Integer> taskTypeIntegerMap, int experiencePoints, ChallengeDuration duration, LocalDateTime challengeStartDate) {
        this.challengeId = challengeId;
        this.title = title;
        this.description = description;
        this.experiencePoints = experiencePoints;
        this.challengeStartDate = challengeStartDate;
        this.challengeDuration = duration;
        taskTypeIntegerMap.forEach((key, value) -> {
            for (int i = 0; i < value; i++) {
                taskList.add(TaskGenerator.taskReturner(key, "", duration));
            }
        });
        this.challengeFinishDate = taskList.get(new SecureRandom().nextInt(taskList.size())).getFinishDate();
    }

    public Challenge(String challengeId, String title, String description, Map<TaskType, Integer> taskTypeIntegerMap, int experiencePoints, ChallengeDuration duration, LocalDateTime challengeStartDate, boolean isScanner) {
        this.challengeId = challengeId;
        this.title = title;
        this.description = description;
        this.experiencePoints = experiencePoints;
        this.challengeStartDate = challengeStartDate;
        this.challengeDuration = duration;
        taskTypeIntegerMap.forEach((key, value) -> {
            for (int i = 0; i < value; i++) {
                taskList.add(TaskGenerator.taskReturner(key, "", duration));
            }
        });
        this.challengeFinishDate = taskList.get(new SecureRandom().nextInt(taskList.size())).getFinishDate();
    }

    public boolean hasExpired() {
        return challengeFinishDate.isBefore(LocalDateTime.now());
    }

    public boolean hasBeenCompleted() {
        return taskList.stream().filter(Task::isCompleted).count() == taskList.size();
    }

    public boolean updateProgress() {
        if (!hasBeenCompleted()) {
            taskList.forEach(task -> {
                if (!task.isCompleted()) {
                    task.setCompleted(true);
                }
            });
            return true;
        }
        return false;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public LocalDateTime getChallengeStartDate() {
        return challengeStartDate;
    }

    public String getChallengeId() {
        return challengeId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ChallengeDuration getChallengeDuration() {
        return challengeDuration;
    }

    @Override
    public int compareTo(@NotNull Challenge o) {
        return this.getChallengeDuration().compareTo(o.getChallengeDuration());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Challenge)) return false;
        Challenge challenge = (Challenge) o;
        return getChallengeId().equals(challenge.getChallengeId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChallengeId());
    }
}
