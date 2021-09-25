package com.teamRed.app.Task.Model;

import com.teamRed.app.Challenges.Model.ChallengeDuration;
import org.springframework.data.annotation.PersistenceConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Locale;

public class ScanningTask implements Task {


    private final String description;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;
    private boolean isCompleted;

    @PersistenceConstructor
    public ScanningTask(String description,LocalDateTime startDate, LocalDateTime finishDate, boolean isCompleted) {
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.isCompleted = isCompleted;
    }

    public ScanningTask(String description, ChallengeDuration challengeDuration) {
        this.description = description;
        this.startDate = LocalDateTime.now();
        switch (challengeDuration) {
            case DAILY:
                this.finishDate = LocalDate.now().plusDays(1).atStartOfDay();
                break;
            case WEEKLY:
                var firstDayOfWeek = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek();
                var startOfCurrentWeek = LocalDate.now().with(TemporalAdjusters.previousOrSame(firstDayOfWeek)).atStartOfDay();
                var lastDayOfWeek = firstDayOfWeek.plus(6);
                this.finishDate = LocalDate.now().with(TemporalAdjusters.nextOrSame(lastDayOfWeek)).atStartOfDay().plusDays(1);
                break;
            case MONTHLY:
                this.finishDate = LocalDate.now().withDayOfMonth(1).atStartOfDay().plusMonths(1);
                break;
            case THREE_MONTHS:
                this.finishDate = LocalDate.now().withDayOfMonth(1).plusMonths(3).atStartOfDay();
                break;
            default:
                throw new IllegalArgumentException("The enum doesn't exist for Challenge Duration");
        }
        this.isCompleted = false;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
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

}
