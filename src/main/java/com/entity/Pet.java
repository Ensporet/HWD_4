package com.entity;

import lombok.Data;

import java.util.List;

@Data
public class Pet {

    private long id;
    private Category category;
    private String name;
    private List photoUrls;
    private List<Tag> tags;
    private PetStatus status;

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status=" + status +
                '}';
    }
}
