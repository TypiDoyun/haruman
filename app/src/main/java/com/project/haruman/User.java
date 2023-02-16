package com.project.haruman;

import lombok.Getter;

@Getter
public class User {
    private String name;
    private int age;
    private Gender gender;
    private long phoneNumber;

    public User(String name) {
        this.name = name;
    }

}

