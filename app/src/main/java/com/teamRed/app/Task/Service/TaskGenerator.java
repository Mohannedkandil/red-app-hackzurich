package com.teamRed.app.Task.Service;


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

}
