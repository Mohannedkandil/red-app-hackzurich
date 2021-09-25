package com.teamRed.app.Challenges.Model;

import com.teamRed.app.Task.Model.TaskType;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "challenges")
public final class ChallengeTemplate {

    @Id
    private final String challengeId;
    // Challenge description
    private String description;

    private String title;

    // Challenge type
    private final ChallengeDuration duration;

    // challenge task
    private final Map<TaskType, Integer> taskTypes;

    // Challenge points awarded on completion
    private final int experiencePoints;

    @PersistenceConstructor
    public ChallengeTemplate(String challengeId, String description, String title, ChallengeDuration duration, Map<TaskType, Integer> taskTypes, int experiencePoints) {
        this.challengeId = challengeId;
        this.description = description;
        this.title = title;
        this.duration = duration;
        this.taskTypes = taskTypes;
        this.experiencePoints = experiencePoints;
    }
}
