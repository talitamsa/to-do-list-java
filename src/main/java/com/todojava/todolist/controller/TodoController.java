package com.todojava.todolist.controller;


import com.todojava.todolist.model.TodoItem;
import com.todojava.todolist.repository.TodoRepo;
import com.todojava.todolist.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "todo")
public class TodoController {

    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private TodoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TodoItem> findById(@PathVariable Long id) {
        TodoItem obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public List<TodoItem> findAll() {
        return todoRepo.findAll();
    }

    @PostMapping
    public TodoItem save(@Valid @NotNull @RequestBody TodoItem todoItem){
        return todoRepo.save(todoItem);
    }

    @PutMapping
    public TodoItem update(@Valid @NotNull @RequestBody TodoItem todoItem) {
        return todoRepo.save(todoItem);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        todoRepo.deleteById(id);
    }

}
