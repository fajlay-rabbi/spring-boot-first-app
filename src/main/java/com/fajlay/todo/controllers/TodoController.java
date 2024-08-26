package com.fajlay.todo.controllers;

import com.fajlay.todo.dto.PersonDTO;
import com.fajlay.todo.dto.TodoDTO;
import com.fajlay.todo.entities.PersonEntities;
import com.fajlay.todo.entities.TodoEntities;
import com.fajlay.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/todo")
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllTodo(){
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public List<TodoDTO> getTodoByUser(@PathVariable Long id){
        return todoService.getAllTodosForUser(id);
    }

    @PostMapping("/register")
    public ResponseEntity<PersonEntities> addUser(@RequestBody PersonDTO personDTO){
        PersonEntities newUser = todoService.addAUser(personDTO.getName(), personDTO.getEmail(), personDTO.getAddress());

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/new-todo")
    public ResponseEntity<TodoEntities> addNewTodo(@RequestBody TodoDTO todoDTO){
        TodoEntities newTodo = todoService.addTodo(todoDTO.getPersonId(), todoDTO.getTodo(), todoDTO.getCategory());

        return new ResponseEntity<>(HttpStatus.OK);
    }





}
