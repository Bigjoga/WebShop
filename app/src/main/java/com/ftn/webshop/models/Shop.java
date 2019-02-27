package com.ftn.webshop.models;

public class Shop {

    private String pib;
    private String name;
    private String location;
    private String contact;

    public Shop() {
    }

    public Shop(String pib, String name, String location, String contact) {
        this.pib = pib;
        this.name = name;
        this.location = location;
        this.contact = contact;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
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
                "pib='" + pib + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
