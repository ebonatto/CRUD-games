package com.crudgames.todoservice.controller;

import com.crudgames.todoservice.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {
//    List<Task> taskList = new ArrayList<>();
    List<Task> taskList = new ArrayList<>() {{
        add(new Task("1", "tarefa 1", "01/01/01", false));
        add(new Task("2", "tarefa 2", "02/02/02", true));
}};

    // Lista todas as tasks
    @GetMapping("/tasks")
    public String listTasks() {
        StringBuilder allTasks = new StringBuilder();
        for (Task task : taskList) {
            allTasks.append(String.format("%s\n\n", task));
        }
        return allTasks.toString();
    }


    // Adiciona tarefa
    @GetMapping("/tasks/add")
    public String addTask(
            @RequestParam(value = "id") String id,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "expiringDate") String expiringDate,
            @RequestParam(value = "status") boolean status
    ) {
        taskList.add(new Task(id,description,expiringDate,status));
        return "Tarefa adicionada!";
    }
}
