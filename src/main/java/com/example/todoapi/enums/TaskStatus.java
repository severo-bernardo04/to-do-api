package com.example.todoapi.enums;

public enum TaskStatus {
    PENDING("PENDING"),
    CANCELED("Cancelled"),
    ACTIVE("Active"),
    COMPLETED("Completed");

    private final String description;
    TaskStatus(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
