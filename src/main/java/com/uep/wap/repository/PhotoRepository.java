package com.uep.wap.repository;
import com.uep.wap.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
    Photo findByPhotoID(int photoID);
    List<Photo> findByUserID(int userID);
}

