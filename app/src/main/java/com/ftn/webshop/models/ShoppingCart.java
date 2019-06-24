package com.ftn.webshop.models;

import java.util.HashMap;
import java.util.List;

public class ShoppingCart {

    private Long id;
    private HashMap<Item, Integer> items;

    public ShoppingCart() {
    }

    public ShoppingCart(HashMap<Item, Integer> items) {
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HashMap<Item, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<Item, Integer> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", items=" + items +
                '}';
    }
}
