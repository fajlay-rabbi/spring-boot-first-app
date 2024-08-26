package com.fajlay.todo.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "todo")
public class TodoEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long todoId;
    private String Todo;

    @ManyToOne
    @JoinColumn(name = "personId")
    private PersonEntities personEntities;

    @ManyToMany
    @JoinTable(
            name = "todo_categories",
            joinColumns = @JoinColumn(name = "todoId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId")
    )
    private Set<CategoryEntities> categories  = new HashSet<>();


    public TodoEntities() {
        super();
    }
    public TodoEntities(Long todoId, String todo) {
        this.todoId = todoId;
        Todo = todo;
    }
    public Long getTodoId() {
        return todoId;
    }
    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }
    public String getTodo() {
        return Todo;
    }
    public void setTodo(String todo) {
        Todo = todo;
    }
    public PersonEntities getPersonEntities() {
        return personEntities;
    }
    public void setPersonEntities(PersonEntities personEntities) {
        this.personEntities = personEntities;
    }
    public Set<CategoryEntities> getCategories() {
        return categories;
    }
    public void setCategories(Set<CategoryEntities> categories) {
        this.categories = categories;
    }
}
