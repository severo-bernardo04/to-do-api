package com.example.todoapi.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskResponseDto {

    private Integer id;
    private String Title;
    private String description;
    private LocalDate dueDate;
    private String status;
}
