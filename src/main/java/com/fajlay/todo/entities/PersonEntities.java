package com.fajlay.todo.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class PersonEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personId;
    private String name;
    @Column(nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntities addressEntities;

    @OneToMany(mappedBy = "personEntities", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TodoEntities> todoEntities = new ArrayList<>();


    public PersonEntities() {
        super();
    }
    public PersonEntities(Long personId, String name, String email) {
        this.personId = personId;
        this.name = name;
        this.email = email;
    }
    public Long getPersonId() {
        return personId;
    }
    public void setPersonId(Long personId) {
        this.personId = personId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<TodoEntities> getTodoEntities() {
        return todoEntities;
    }

    public void setTodoEntities(List<TodoEntities> todoEntities) {
        this.todoEntities = todoEntities;
    }

    public AddressEntities getAddressEntities() {
        return addressEntities;
    }

    public void setAddressEntities(AddressEntities addressEntities) {
        this.addressEntities = addressEntities;
    }
}
