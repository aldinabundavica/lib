package com.example.lib.libMapper.dtos;

import com.example.lib.model.Student;
import com.example.lib.model.Writer;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.util.List;

public class BookSlimDto {
    @JsonProperty("title")
    private String title;

    @JsonProperty("writer")
    private Writer writer;

    @JsonProperty("taken")
    private boolean taken;

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

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

}
