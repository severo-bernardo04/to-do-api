package com.example.todoapi.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TaskResponseDto {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private String status;
}
