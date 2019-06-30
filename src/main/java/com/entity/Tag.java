package com.entity;

import lombok.Data;

@Data
public class Tag {


    private Long id;
    private String name;


    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
