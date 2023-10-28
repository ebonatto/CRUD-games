package com.crudgames.todoservice.controller;

import com.crudgames.todoservice.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/tasks/add")
    public String addTask(@RequestBody Task task) {
        taskList.add(task);
        return "Tarefa adicionada!";
    }

    // Edita uma tarefa
    @PostMapping("/task/edit/{id}")
    public String editTask(@PathVariable String id,
                           @RequestBody Task taskEdited) {
        if (taskList.stream().anyMatch(task -> task.getId().equals(id))) {
            taskList.stream().filter(task -> task.getId().equals(id))
                    .findFirst().ifPresent(task -> {
                        task.setDescription(taskEdited.getDescription());
                        task.setExpiringDate(taskEdited.getExpiringDate());
                        task.setDone(taskEdited.done);
                    });
            return "Tarefa editada!";
        }
        return "Tarefa não existe!";
    }
}
