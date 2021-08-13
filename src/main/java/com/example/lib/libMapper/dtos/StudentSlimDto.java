package com.example.lib.libMapper.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentSlimDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("lastname")
    private String lastname;

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
}
