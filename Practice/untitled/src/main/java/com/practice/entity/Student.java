package com.practice.entity;

import java.sql.Date;
import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private Date dob;
    private String address;
    private int classId;

    public Student() {
    }

    public Student(int id, String name, Date dob, String address, int classId) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.classId = classId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
