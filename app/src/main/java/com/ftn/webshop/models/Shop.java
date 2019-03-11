package com.ftn.webshop.models;

public class Shop {

    private Long id;
    private String name;
    private String location;
    private String contact;

    public Shop() {
    }

    public Shop(Long id, String name, String location, String contact) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.contact = contact;
    }

    public Long getPib() {
        return id;
    }

    public void setPib(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "pib='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
