package com.crudgames.todoservice.controller;

import com.crudgames.todoservice.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TaskController {
    //    List<Task> taskList = new ArrayList<>();
    LinkedHashMap<String, Task> taskList = new LinkedHashMap<>() {{
        put("1", new Task("1", "tarefa 1", "01/01/01", false));
        put("2", new Task("2", "tarefa 2", "02/02/02", true));
    }};

    // Lista todas as tasks
    @GetMapping("/tasks")
    public String listTasks() {
        StringBuilder allTasks = new StringBuilder();
        for (Map.Entry<String, Task> task : taskList.entrySet()) {
            allTasks.append(String.format("%s\n\n", task.getValue()));
        }
        return allTasks.toString();
    }


    // Adiciona tarefa
    @PostMapping("/tasks/add")
    public String addTask(@RequestBody Task task) {
        if (!taskList.containsKey(task.getId())) {
            taskList.put(task.getId(), task);
            return "Tarefa adicionada!";
        }
        return String.format("Já existe uma tarefa com ID: %s", task.getId());
    }

    // Edita uma tarefa
    @PostMapping("/task/edit/{id}")
    public String editTask(@PathVariable String id,
                           @RequestBody Task taskEdited) {
        if (taskList.containsKey(id)) {
            taskList.put(id, taskEdited);
            return "Tarefa editada!";
        }
        return "Tarefa não existe!";
    }
}
