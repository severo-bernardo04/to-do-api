package com.example.todoapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskRequestDto {

    @NotBlank(message = "O Titulo é Obrigatório")
    private String title;

    @NotBlank(message = "Uma descrição é obrigatório para a tarefa")
    private String description;


}
