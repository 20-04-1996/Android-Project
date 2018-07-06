package com.dholakiya.pankaj.databasepractice;

public class TableDetail {

    String name;
    String email;
    String address;
    String gender;

    public TableDetail(){}


    public TableDetail(String name, String email, String address, String gender) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
