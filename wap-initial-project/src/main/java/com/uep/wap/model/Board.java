package com.uep.wap.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "board_id")
    private int board_id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "owner_id")
    private int owner_id;

    @ManyToMany
    @JoinTable(name = "board_category", joinColumns = @JoinColumn(name = "board_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @ManyToMany(mappedBy = "boards")
    private List<Photo> photos;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;

    public int getBoard_id() {
        return board_id;
    }

    public Board(){

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }
}
