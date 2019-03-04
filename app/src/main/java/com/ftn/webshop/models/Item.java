package com.ftn.webshop.models;

public class Item {

    private String idNumber;
    private String name;
    private String description;
    private String price;

    public Item() {
    }

    public Item(String idNumber, String name, String description, String price) {
        this.idNumber = idNumber;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "idNumber='" + idNumber + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
