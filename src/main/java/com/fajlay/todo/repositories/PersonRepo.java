package com.fajlay.todo.repositories;

import com.fajlay.todo.dto.PersonDTO;
import com.fajlay.todo.entities.PersonEntities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<PersonEntities, Long> {
}
