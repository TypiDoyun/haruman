package com.project.haruman;

import lombok.Getter;

@Getter
public class User {
    private String name;
    private int age;
    private Gender gender;
    private String phoneNumber;

    public User(String name, int age, Gender gender, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

}

