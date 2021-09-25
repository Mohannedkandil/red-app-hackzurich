package com.teamRed.app.Task.Service;


import com.teamRed.app.Challenges.Model.ChallengeDuration;
import com.teamRed.app.Task.Model.ScanningTask;
import com.teamRed.app.Task.Model.StampTask;
import com.teamRed.app.Task.Model.Task;
import com.teamRed.app.Task.Model.TaskType;

import java.util.EnumMap;
import java.util.Map;

public abstract class TaskGenerator {

    public TaskGenerator() {
        throw new IllegalStateException("Utility Class");
    }

    public static Map<TaskType, Integer> parameterTaskTypeStamp() {
        EnumMap<TaskType, Integer> stampTask = new EnumMap<>(TaskType.class);
        stampTask.put(TaskType.STAMP, 8);
        return stampTask;
    }

    public static Map<TaskType, Integer> parameterTaskTypeProductScanningTen() {
        EnumMap<TaskType, Integer> productScanningTask = new EnumMap<>(TaskType.class);
        productScanningTask.put(TaskType.PRODUCT_SCANNING, 10);
        return productScanningTask;
    }

    public static Map<TaskType, Integer> parameterTaskTypeProductScanningHundred() {
        EnumMap<TaskType, Integer> productScanningTask = new EnumMap<>(TaskType.class);
        productScanningTask.put(TaskType.PRODUCT_SCANNING, 100);
        return productScanningTask;
    }

    public static Task taskReturner(TaskType taskType, String productName, ChallengeDuration duration) {
        switch (taskType) {
            case PRODUCT_SCANNING:
                return new ScanningTask("Scan " + productName + ".", duration);
            case STAMP:
                return new StampTask("Visit Migros to collect More stamps");
            default:
                throw new IllegalArgumentException("Not a valid Task-Type");
        }
    }


}
