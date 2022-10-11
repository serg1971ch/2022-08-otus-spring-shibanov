package ru.otus.spring.domain;

import lombok.Data;

@Data
public class Student {
    String name;
    String surname;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
