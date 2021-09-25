package com.teamRed.app.Task.Model;

import org.springframework.data.annotation.PersistenceConstructor;

import java.time.LocalDateTime;

public class StampTask {

    private final String description;
    private final int requirement;
    private int progress;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private boolean isCompleted;
    private long TIME_FOR_STAMP_EXPIRATION = 3;

    @PersistenceConstructor
    public StampTask(String description, int requirement, int progress, LocalDateTime startDate, LocalDateTime finishDate, boolean isCompleted) {
        this.description = description;
        this.requirement = requirement;
        this.progress = progress;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.isCompleted = isCompleted;
    }

    public StampTask(String description, int requirement) {
        this.description = description;
        this.requirement = requirement;
        this.progress = 0;
        this.startDate = LocalDateTime.now();
        this.finishDate = LocalDateTime.now().plusMonths(TIME_FOR_STAMP_EXPIRATION);
        this.isCompleted = false;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDateTime finishDate) {
        this.finishDate = finishDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public void incrementProgress() {
        this.progress += 1;
    }

    public int getRequirement() {
        return requirement;
    }

    public String getDescription() {
        return description;
    }

}
