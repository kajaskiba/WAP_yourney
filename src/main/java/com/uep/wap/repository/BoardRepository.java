package com.uep.wap.repository;

import com.uep.wap.model.Board;
import com.uep.wap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByTitle(String title);

    Board findByOwnerID(Long ownerId);

    Board findByUsers(User user);

}
