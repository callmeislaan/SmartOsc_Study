package com.fitech;

public class Person {
    private String firstName;
    private String lastName;

    public  Person() {

    }

    public Person(String name) {
        String[] spl = name.split(" ");
        this.firstName = spl[0];
        this.lastName = spl[1];
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
