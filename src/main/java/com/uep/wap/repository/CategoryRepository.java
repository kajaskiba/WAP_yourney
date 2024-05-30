package com.uep.wap.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.uep.wap.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

    Category findByName(String name);
}
