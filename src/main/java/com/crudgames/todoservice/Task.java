package com.crudgames.todoservice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    public String id;
    public String description;
    public String expiringDate;
    public boolean done;

    @Override
    public String toString() {
        return String.format("ID: %s - Até %s - Concluída: %s\n" +
                        "\tDescrição: %s",
                this.id, this.expiringDate, (this.done ? "Sim" : "Não"), this.description);
    }
}
