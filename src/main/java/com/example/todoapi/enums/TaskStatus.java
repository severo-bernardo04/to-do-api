package com.example.todoapi.enums;

public enum TaskStatus {
    WAITING("Waiting Payment"),
    PAID("Paid"),
    SEND("Send"),
    DELIVERED("Delivered");

    private final String description;
    TaskStatus(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
