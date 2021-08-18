package com.example.lib.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;

    @ManyToOne(fetch=FetchType.LAZY)
    private Writer writer;

//    @ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "book_student",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name = "book_id"))
    @Transient
    private List<Student> borrowingHistory;
    private boolean taken = false;

    public Book() { super(); }

    public Book(String title, Writer writer, List<Student> borrowingHistory, boolean taken) {
        super();
        this.title = title;
        this.writer = writer;
        this.borrowingHistory = borrowingHistory;
        this.taken = taken;
    }

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

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public List<Student> getBorrowingHistory() {
        return borrowingHistory;
    }

    public void setBorrowingHistory(List<Student> borrowingHistory) {
        this.borrowingHistory = borrowingHistory;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

}
