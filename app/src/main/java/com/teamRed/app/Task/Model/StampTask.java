package com.teamRed.app.Task.Model;

import org.springframework.data.annotation.PersistenceConstructor;

import java.time.LocalDateTime;

public class StampTask implements Task {

    private final String description;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private boolean isCompleted;
    private long TIME_FOR_STAMP_EXPIRATION = 3;

    @PersistenceConstructor
    public StampTask(String description, LocalDateTime startDate, LocalDateTime finishDate, boolean isCompleted) {
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.isCompleted = isCompleted;
    }

    public StampTask(String description) {
        this.description = description;
        this.startDate = LocalDateTime.now();
        this.finishDate = LocalDateTime.now().plusMonths(TIME_FOR_STAMP_EXPIRATION);
        this.isCompleted = false;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    @Override
    public LocalDateTime getStartDate() {
        return startDate;
    }

    @Override
    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDateTime finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public boolean isCompleted() {
        return isCompleted;
    }

    @Override
    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
