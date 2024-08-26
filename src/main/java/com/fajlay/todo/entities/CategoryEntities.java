package com.fajlay.todo.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Category")
public class CategoryEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;
    private String category;

    @ManyToMany(mappedBy = "categories")
    private Set<TodoEntities> todos = new HashSet<>();

    public CategoryEntities() {
        super();
    }

    public CategoryEntities(String category) {
        this.category = category;
    }

    public CategoryEntities(Long categoryId, String category, Set<TodoEntities> todos) {
        this.categoryId = categoryId;
        this.category = category;
        this.todos = todos;
    }


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<TodoEntities> getTodos() {
        return todos;
    }

    public void setTodos(Set<TodoEntities> todos) {
        this.todos = todos;
    }

    @Override
    public String toString() {
        return "CategoryEntities{" +
                "categoryId=" + categoryId +
                ", category='" + category + '\'' +
                ", todos=" + todos +
                '}';
    }
}
