package com.fajlay.todo.repositories;

import com.fajlay.todo.entities.CategoryEntities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CateRepo extends JpaRepository<CategoryEntities, Long> {
    Optional<CategoryEntities> findByCategory(String category);
}
