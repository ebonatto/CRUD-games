package com.crudgames.todoservice.controller;

import com.crudgames.todoservice.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {
    List<Task> taskList = new ArrayList<>();

    // Lista todas as tasks
    @GetMapping("/tasks")
    public String listTasks() {
        StringBuilder allTasks = new StringBuilder();
        for (Task task : taskList) {
            allTasks.append(String.format("%s\n", task));
        }
        return allTasks.toString();
    }

}
