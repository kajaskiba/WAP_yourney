package com.uep.wap.controller;

import com.uep.wap.dto.PhotoDTO;
import com.uep.wap.model.Photo;
import com.uep.wap.service.PhotoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping(path = "/photos")
    public String addPhoto(@RequestBody PhotoDTO photoDTO) {
        Photo photo = new Photo();
        photo.setPhotoID(photoDTO.getPhotoID());
        photo.setImageURL(photoDTO.getImageURL());
        photo.setDescription(photoDTO.getDescription());
        // Add other fields if needed

        photoService.savePhoto(photo);
        return "Photo added!";
    }

    @GetMapping(path = "/photos")
    public Iterable<Photo> getAllPhotos() {
        return photoService.getAllPhotos();
    }

    @GetMapping(path = "/photos/{photoID}")
    public Photo findPhotoByID(@PathVariable int photoID) {
        return photoService.getPhotoByID(photoID);
    }

    @GetMapping(path = "/photos/user/{userID}")
    public List<Photo> getPhotosByUser(@PathVariable int userID) {
        return photoService.getPhotosByUser(userID);
    }

    @DeleteMapping(path = "/photos/{photoID}")
    public void deletePhotoById(@PathVariable int photoID) {
        photoService.deletePhoto(photoID);
    }
}
