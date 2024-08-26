package com.fajlay.todo.repositories;

import com.fajlay.todo.entities.TodoEntities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<TodoEntities, Long> {
}
