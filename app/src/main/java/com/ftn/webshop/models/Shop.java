package com.ftn.webshop.models;

public class Shop {

    private Long id;
    private String name;
    private String location;
    private String contact;
    private User manager;

    public Shop() {
    }

    public Shop(Long id, String name, String location, String contact, User manager) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.contact = contact;
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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


    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", contact='" + contact + '\'' +
                ", manager=" + manager +
                '}';
    }
}
