package com.fintech.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "persons")
public class Persons {
    List<Person> personList;

    public Persons() {
    }

    public List<Person> getPersonList() {
        return personList;
    }

    @XmlElement(name = "person")
    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "personList=" + personList +
                '}';
    }
}
