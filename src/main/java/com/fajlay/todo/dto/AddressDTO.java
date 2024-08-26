package com.fajlay.todo.dto;

public class AddressDTO {
    private Long id;
    private String address;

    public AddressDTO() {
        super();
    }
    public AddressDTO(Long id, String address) {
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
    @Override
    public String toString() {
        return "AddressDTO{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
