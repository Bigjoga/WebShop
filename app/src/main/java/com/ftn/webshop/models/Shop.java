package com.ftn.webshop.models;

import android.database.Cursor;

public class Shop {

    private Long id;
    private String imageLocation;
    private String name;
    private String location;
    private String description;
    private User manager;

    public Shop() {

    }

    public Shop(Long id, String name, String location, String description,String imageLocation, User manager) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.imageLocation=imageLocation;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public void getShopFromCursor(Cursor cursor){

        this.name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        this.location = cursor.getString(cursor.getColumnIndexOrThrow("location"));
        this.description = cursor.getString(cursor.getColumnIndexOrThrow("description"));
        this.imageLocation = cursor.getString(cursor.getColumnIndexOrThrow("imageLocation"));

    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", imageLocation='" + imageLocation + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", manager=" + manager +
                '}';
    }
}
