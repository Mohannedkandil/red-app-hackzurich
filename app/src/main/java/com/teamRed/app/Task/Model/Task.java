package com.teamRed.app.Task.Model;

import java.time.LocalDateTime;

public interface Task {

    boolean isCompleted();

    String getDescription();

    LocalDateTime getStartDate();

    LocalDateTime getFinishDate();

    void setCompleted(boolean completed);
}
