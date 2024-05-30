package com.uep.wap.repository;

import com.uep.wap.model.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InteractionRepository extends JpaRepository<Interaction, Long> {
    Optional<Interaction> findByUserId(Long userId);
    Optional<Interaction> findByPhotoId(Long photoId);
}


