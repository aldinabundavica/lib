package com.example.lib.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String lastname;
    private Date birthDate;

    public Student() {
        super();
    }

    public Student(String name, String lastname, Date birthDate) {
        super();
        this.name = name;
        this.lastname = lastname;
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
