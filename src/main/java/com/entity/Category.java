package com.entity;

import lombok.Data;

@Data
public class Category {


    private Long id;
    private String name;


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
