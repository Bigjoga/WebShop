package com.ftn.webshop.models;
import android.database.Cursor;

import java.io.Serializable;

public class User implements Serializable {

    public enum Type {ADMIN, USER,MANAGER}
    private String email;
    private String name;
    private String surname;
    private String password;
    private Type type;
    private ShoppingCart shoppingCart;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String name,String surname,String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.shoppingCart = new ShoppingCart();
    }

    public User(String email, String name, String surname, String password, Type type) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }



    public void getUserFromCursor(Cursor cursor){

        this.email = cursor.getString(cursor.getColumnIndexOrThrow("email")).toString();
        this.password = cursor.getString(cursor.getColumnIndexOrThrow("password"));
        this.name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        this.surname = cursor.getString(cursor.getColumnIndexOrThrow("surname"));
        String typeString = cursor.getString(cursor.getColumnIndexOrThrow("type"));

        if(Type.USER.toString().equals(typeString)){
            this.type=Type.USER;
        }else if(Type.MANAGER.toString().equals(typeString)){
            this.type=Type.MANAGER;
        }else{
            this.type=Type.ADMIN;
        }

    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}