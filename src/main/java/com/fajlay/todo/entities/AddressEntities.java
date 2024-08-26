package com.fajlay.todo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class AddressEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;



    public AddressEntities() {
        super();
    }
    public AddressEntities(Long id, String address) {
        this.id = id;
        this.address = address;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
