package com.example.todoapi.controller;

import com.example.todoapi.dto.TaskRequestDto;
import com.example.todoapi.dto.TaskResponseDto;
import com.example.todoapi.model.Task;
import com.example.todoapi.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponseDto> create(@RequestBody @Valid TaskRequestDto  taskRequestDto) {
            TaskResponseDto createdTask = taskService.create(taskRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

}
