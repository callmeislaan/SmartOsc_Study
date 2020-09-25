package com.fintech.stackjava.dependency_injection;

public class Person {
    private String name;
    private int age;
    private Address address;
    public Person() {
    }
    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void print() {
        System.out.println("Person: " + this.name + " Age: " + this.age + " Address: " + this.address.toString());
    }
}
