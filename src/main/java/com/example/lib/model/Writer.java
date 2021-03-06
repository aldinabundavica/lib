package com.example.lib.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String lastname;
    @Basic
    private java.util.Date date;
    @OneToMany(mappedBy="writer")
    private List<Book> books;

    public Writer() {
        super();
    }

    public Writer(String name, String lastname, Date date) {
        super();
        this.name = name;
        this.lastname = lastname;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
