package com.todojava.todolist.services;


import com.todojava.todolist.model.TodoItem;
import com.todojava.todolist.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepo repo;

    public TodoItem findById(Long id){
        Optional<TodoItem> obj = repo.findById(id);
        return obj.orElse(null);
    }
}
