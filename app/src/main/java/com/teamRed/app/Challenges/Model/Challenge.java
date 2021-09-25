package com.teamRed.app.Challenges.Model;

import com.teamRed.app.Task.Model.Task;
import com.teamRed.app.Task.Model.TaskType;
import com.teamRed.app.Task.Service.TaskGenerator;
import org.springframework.data.annotation.PersistenceConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Challenge {

    private String challengeId;
    private String title;
    private String description;
    private List<Task> taskList;
    private int experiencePoints;
    private LocalDateTime challengeFinishDate;
    private LocalDateTime challengeStartDate;

    @PersistenceConstructor
    public Challenge(String challengeId, String title, String description, List<Task> taskList, int experiencePoints, LocalDateTime challengeFinishDate, LocalDateTime challengeStartDate) {
        this.challengeId = challengeId;
        this.title = title;
        this.description = description;
        this.taskList = taskList;
        this.experiencePoints = experiencePoints;
        this.challengeFinishDate = challengeFinishDate;
        this.challengeStartDate = challengeStartDate;
    }

    public Challenge(String challengeId, String title, String description, Map<TaskType, Integer> taskTypeIntegerMap, int experiencePoints, ChallengeDuration duration, LocalDateTime challengeStartDate) {
        this.challengeId = challengeId;
        this.title = title;
        this.description = description;
        this.experiencePoints = experiencePoints;
        this.challengeStartDate = LocalDateTime.now();
        taskTypeIntegerMap.forEach((key, value) -> {
            for (int i = 0; i < value; i++) {
                taskList.add(TaskGenerator.taskReturner(key, "", duration));
            }
        });
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

}
