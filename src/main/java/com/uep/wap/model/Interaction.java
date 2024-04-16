package com.uep.wap.model;

import javax.persistence.*;

@Entity
public class Interaction {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "interaction_id")
    private int interaction_id;

    public int getInteraction_id() {
        return interaction_id;
    }

    public void setInteraction_id(int interaction_id) {
        this.interaction_id = interaction_id;
    }

    public int getTarget_id() {
        return target_id;
    }

    public void setTarget_id(int target_id) {
        this.target_id = target_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    private Interaction(){

    }

    @ManyToOne
    @JoinColumn(name = "photo_id")
    private Photo photos;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;
    @Column(name = "target_id")
    private int target_id;
    @Column(name = "type")
    private String type;
    @Column(name = "timestamp")
    private int timestamp;


}
