package com.crudgames.todoservice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Task {
    public int id;
    public String description;
    public String expiringDate;
    public boolean done;
}
