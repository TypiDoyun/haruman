package com.project.haruman;

public class User {
    private String name;
    private int age;
    private Gender gender;
    private long phoneNumber;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }
}

