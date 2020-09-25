package com.fintech.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@XmlRootElement(name = "person")
public class Person {
    private int id;
    private String name;
    private LocalDateTime dateOfBirth = LocalDateTime.now();

    public Person() {
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

    public Date getDateOfBirth() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        return Date.from(this.dateOfBirth.atZone(defaultZoneId).toInstant());
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
