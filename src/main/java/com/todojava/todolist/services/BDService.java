package com.todojava.todolist.services;


import com.todojava.todolist.model.TodoItem;
import com.todojava.todolist.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class BDService {

    @Autowired
    private TodoRepo todoRepo;

    public void instanciaBaseDeDados() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        TodoItem item1 = new TodoItem(null, "Estudar", "Estudar projeto fullstack", LocalDateTime.parse("15/01/2022 10:00", formatter), false);
        TodoItem item2 = new TodoItem(null, "Meditar", "Estudar projeto fullstack", LocalDateTime.parse("15/01/2022 15:00", formatter), false);
        TodoItem item3 = new TodoItem(null, "Academia", "Estudar projeto fullstack", LocalDateTime.parse("15/01/2022 15:00", formatter), true);
        TodoItem item4 = new TodoItem(null, "Trabalhar", "Estudar projeto fullstack", LocalDateTime.parse("15/01/2022 20:00", formatter), false);

        todoRepo.saveAll(Arrays.asList(item1, item2, item3, item4));
    }
}
