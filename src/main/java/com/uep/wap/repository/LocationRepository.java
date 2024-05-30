package com.uep.wap.repository;
import com.uep.wap.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long>{

    Location findLocationByName(String name);
}
