package com.uep.wap.dto;

public class InteractionDTO {

    public int interactionID;
    public int targetID;
    public String type;
    public int timestamp;

    public int getInteractionID() {
        return interactionID;
    }

    public void setInteractionID(int interactionID) {
        this.interactionID = interactionID;
    }

    public int getTargetID() {
        return targetID;
    }

    public void setTargetID(int targetID) {
        this.targetID = targetID;
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
}
