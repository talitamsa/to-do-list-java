package com.todojava.todolist.controller;


import com.todojava.todolist.model.TodoItem;
import com.todojava.todolist.repository.TodoRepo;
import com.todojava.todolist.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
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

    @GetMapping(value = "/open")
    public ResponseEntity<List<TodoItem>> listOpen() {
        List<TodoItem> list = service.findAllOpen();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/close")
    public ResponseEntity<List<TodoItem>> listClose() {
        List<TodoItem> list = service.findAllClose();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping
    public ResponseEntity<List<TodoItem>> listAll() {
        List<TodoItem> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<TodoItem> create(@RequestBody TodoItem obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public TodoItem update(@Valid @NotNull @RequestBody TodoItem todoItem) {
        return todoRepo.save(todoItem);
    }

}
