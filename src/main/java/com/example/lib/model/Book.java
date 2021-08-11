package com.example.lib.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    private long id;
    private String title;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //, mappedBy = "book")
    private List<Writer> writer;
    @ManyToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "borrowedBooks")
    private List<Student> borrowingHistory;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Writer> getWriter() {
        return writer;
    }

    public void setWriter(List<Writer> writer) {
        this.writer = writer;
    }

    public List<Student> getBorrowingHistory() {
        return borrowingHistory;
    }

    public void setBorrowingHistory(List<Student> borrowingHistory) {
        this.borrowingHistory = borrowingHistory;
    }
}
