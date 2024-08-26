package com.fajlay.todo.services;

import com.fajlay.todo.dto.PersonDTO;
import com.fajlay.todo.dto.TodoDTO;
import com.fajlay.todo.entities.AddressEntities;
import com.fajlay.todo.entities.CategoryEntities;
import com.fajlay.todo.entities.PersonEntities;
import com.fajlay.todo.entities.TodoEntities;
import com.fajlay.todo.repositories.CateRepo;
import com.fajlay.todo.repositories.PersonRepo;
import com.fajlay.todo.repositories.TodoRepo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoService {

    private final TodoRepo todoRepo;
    private final PersonRepo personRepo;
    private final CateRepo cateRepo;

    public TodoService(TodoRepo todoRepo, PersonRepo personRepo, CateRepo cateRepo) {
        this.todoRepo = todoRepo;
        this.personRepo = personRepo;
        this.cateRepo = cateRepo;
    }


    public List<TodoDTO> getAllTodosForUser(Long userID){

        List<TodoDTO> todoDTOList = new ArrayList<>();

        PersonEntities personEntities = personRepo.findById(userID)
                .orElseThrow(()-> new RuntimeException("Person not found!"));

        for (TodoEntities todoEntity  : personEntities.getTodoEntities()){
            TodoDTO todoDTO = new TodoDTO();
            todoDTO.setTodoId(todoEntity.getTodoId());
            todoDTO.setTodo(todoEntity.getTodo());
            todoDTO.setPersonId(personEntities.getPersonId());

            todoDTOList.add(todoDTO);
        }
        return todoDTOList;
    }



    public PersonEntities addAUser(String name, String email, String address){
        PersonEntities newUser = new PersonEntities();
        newUser.setName(name);
        newUser.setEmail(email);

        AddressEntities userAddress = new AddressEntities();
        userAddress.setAddress(address);

        newUser.setAddressEntities(userAddress);

        return personRepo.save(newUser);
    }



    public TodoEntities addTodo(Long personID, String todoText, String category){


        Optional<PersonEntities> personOptional = personRepo.findById(personID);
        if (personOptional.isEmpty()){
            throw new RuntimeException("Person not found");
        }
        CategoryEntities cat = cateRepo.findByCategory(category.trim())
                    .orElseGet(() -> cateRepo.save(new CategoryEntities(category.trim())));

        TodoEntities newTodo = new TodoEntities();
        newTodo.setTodo(todoText);
        newTodo.setPersonEntities(personOptional.get());

        newTodo.getCategories().add(cat);

        return todoRepo.save(newTodo);
    }





}
