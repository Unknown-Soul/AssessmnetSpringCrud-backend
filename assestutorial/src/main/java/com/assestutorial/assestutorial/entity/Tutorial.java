package com.assestutorial.assestutorial.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String description;

    private boolean published;

    public Tutorial(){}

    public Tutorial(String title, String description, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }
}
