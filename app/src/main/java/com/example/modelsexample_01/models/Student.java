package com.example.modelsexample_01.models;

public class Student {

    protected int cod;
    protected String name;
    protected String phone;
    protected String address;

    public Student(int cod, String name, String phone, String address) {
        this.cod = cod;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public int getCod() {
        return cod;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
