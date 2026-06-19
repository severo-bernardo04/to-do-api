package com.example.todoapi.service;

import com.example.todoapi.dto.TaskRequestDto;
import com.example.todoapi.dto.TaskResponseDto;
import com.example.todoapi.enums.TaskStatus;
import com.example.todoapi.model.Task;
import com.example.todoapi.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class TaskService {

    private final TaskRepository taskRepository;
    
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private TaskResponseDto toResponseDto(Task task) {
        TaskResponseDto taskResponseDto = new TaskResponseDto();
        taskResponseDto.setTitle(task.getTitle());
        taskResponseDto.setId(task.getId());
        taskResponseDto.setDescription(task.getDescription());
        taskResponseDto.setStatus(task.getStatus().getDescription());
        taskResponseDto.setCreatedAt(task.getCreatedAt());
        return taskResponseDto;
    }

    public TaskResponseDto create(TaskRequestDto taskRequestDto) {
        Task task = new Task();
        task.setTitle(taskRequestDto.getTitle());
        task.setDescription(taskRequestDto.getDescription());
        task.setCreatedAt(LocalDateTime.now());
        task.setStatus(TaskStatus.PENDING);

        Task savedTask = taskRepository.save(task);
        return toResponseDto(savedTask);
    }

    public TaskResponseDto findById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrado"));

        return toResponseDto(task);
    }

    public List<TaskResponseDto> findAll() {
        return taskRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    @Transactional
    public TaskResponseDto update(Long id, TaskRequestDto taskRequestDto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Registro Não encontrado com ID " + id));

        task.setTitle(taskRequestDto.getTitle());
        task.setDescription(taskRequestDto.getDescription());

        return toResponseDto(taskRepository.save(task));
    }

    public void delete(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa Não Encontrada"));

        taskRepository.delete(task);
    }
}
