package com.example.nerme.alabdallah;

public class Client {
    String id;
    String name;
    String phone ;
    String discribtion;

    public Client() {
    }

    public Client(String id, String name, String phone, String discribtion) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.discribtion = discribtion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDiscribtion() {
        return discribtion;
    }

    public void setDiscribtion(String discribtion) {
        this.discribtion = discribtion;
    }
}
