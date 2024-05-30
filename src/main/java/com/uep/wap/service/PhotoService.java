package com.uep.wap.service;

import com.uep.wap.model.Photo;
import com.uep.wap.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public List<Photo> getAllPhotos() {
        return photoRepository.findAll();
    }

    public Photo getPhotoByID(int photoID) {
        return photoRepository.findByPhotoID(photoID);
    }

    public List<Photo> getPhotosByUser(int userID) {
        return photoRepository.findByUserID(userID);
    }

    public Photo savePhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    public void deletePhoto(int photoID) {
        photoRepository.deleteById((long) photoID);
    }

    public Photo postPhoto(Photo photo) {
        // Assuming 'postPhoto' means the same as 'savePhoto' in this context
        return photoRepository.save(photo);
    }
}


