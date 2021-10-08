package com.todojava.todolist.services;


import com.todojava.todolist.exceptions.ObjectNotFoundException;
import com.todojava.todolist.model.TodoItem;
import com.todojava.todolist.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepo repo;

    public TodoItem findById(Long id){
        Optional<TodoItem> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + TodoItem.class.getName()));
    }

    public List<TodoItem> findAllOpen() {
        List<TodoItem> list = repo.findAllOpen();
        return list;
    }

    public List<TodoItem> findAllClose() {
        List<TodoItem> list = repo.findAllClose();
        return list;
    }

    public List<TodoItem> findAll() {
        List<TodoItem> list = repo.findAll();
        return list;
    }

    public TodoItem create(TodoItem obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
