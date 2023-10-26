package com.crudgames.todoservice;

import lombok.Data;

@Data
public class Task {
    public String id;
    public String description;
    public String expiringDate;
    public boolean done;

    public Task(String id, String description, String expiringDate, boolean done) {
        this.id = id;
        this.description = description;
        this.expiringDate = expiringDate;
        this.done = done;
    }

    @Override
    public String toString() {
        return String.format("ID: %s - Até %s - Concluída: %s\n" +
                        "\tDescrição: %s",
                this.id, this.expiringDate, (this.done ? "Sim" : "Não"), this.description);
    }
}
