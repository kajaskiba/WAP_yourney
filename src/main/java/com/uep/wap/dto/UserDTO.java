package com.uep.wap.dto;

import java.util.List;

public class UserDTO {

    private int userID;
    private String username;
    private List<BoardDTO> boards;
    private List<PhotoDTO> photos;

    // Getters and Setters
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<BoardDTO> getBoards() {
        return boards;
    }

    public void setBoards(List<BoardDTO> boards) {
        this.boards = boards;
    }

    public List<PhotoDTO> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoDTO> photos) {
        this.photos = photos;
    }
}
