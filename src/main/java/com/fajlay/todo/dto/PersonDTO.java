package com.fajlay.todo.dto;

import jakarta.persistence.Column;

public class PersonDTO {
    private Long personId;
    private String name;
    private String email;
    private String address;

    public PersonDTO() {
        super();
    }
    public PersonDTO(Long personId, String name, String email) {
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
    @Override
    public String toString() {
        return "PersonDTO{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
