package com.uep.wap.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.uep.wap.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
