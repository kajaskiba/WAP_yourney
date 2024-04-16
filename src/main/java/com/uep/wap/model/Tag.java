package com.uep.wap.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private int tag_id;
    @Column(name = "name")
    private String name;

    private Tag(){

    }
    @ManyToMany(mappedBy = "tags")
    private List<Photo> photos;
    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
