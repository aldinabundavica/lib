package com.example.lib.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String lastname;
    @ManyToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "borrowingHistory")
    private List<Book> borrowedBooks;

    public Student() {
        super();
    }

    public Student(String name, String lastname, List<Book> borrowedBooks) {
        super();
        this.name = name;
        this.lastname = lastname;
        this.borrowedBooks = borrowedBooks;
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

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

}
