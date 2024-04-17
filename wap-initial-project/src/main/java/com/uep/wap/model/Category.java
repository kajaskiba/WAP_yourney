package com.uep.wap.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int category_id;
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Board> boards;

    @ManyToMany(mappedBy = "categories")
    private List<Photo> photos;


    public int getCategory_id() {
        return category_id;
    }

    public Category(){

    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}