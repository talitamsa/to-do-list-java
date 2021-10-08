package com.todojava.todolist.repository;

import com.todojava.todolist.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepo extends JpaRepository<TodoItem, Long> {

    @Query("SELECT obj FROM TodoItem obj WHERE obj.done = false ORDER BY obj.endDate")
    List<TodoItem> findAllOpen();

    @Query("SELECT obj FROM TodoItem obj WHERE obj.done = true ORDER BY obj.endDate")
    List<TodoItem> findAllClose();
}
