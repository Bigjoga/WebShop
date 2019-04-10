package com.ftn.webshop.models;

import android.database.Cursor;

public class Item {

    private Long id;
    private String name;
    private String description;
    private int price;
    private String imageLocation;
    private Long shop_id;


    public Item() {
    }

    public Item(Long id, String name, String description, int price, String imageLocation, Long shop_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageLocation = imageLocation;
        this.shop_id = shop_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public Long getShop_id() {
        return shop_id;
    }

    public void setShop_id(Long shop_id) {
        this.shop_id = shop_id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageLocation='" + imageLocation + '\'' +
                ", shop_id='" + shop_id + '\'' +
                '}';
    }

    public void getShopFromCursor(Cursor cursor) {
        this.id= cursor.getLong(cursor.getColumnIndexOrThrow("id"));
        this.name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        this.price = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow("price")));
        this.description = cursor.getString(cursor.getColumnIndexOrThrow("description"));
        this.imageLocation = cursor.getString(cursor.getColumnIndexOrThrow("imageLocation"));
        this.shop_id = cursor.getLong(cursor.getColumnIndexOrThrow("shop_id"));

    }
}
