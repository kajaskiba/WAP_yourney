package com.uep.wap.service;
import com.uep.wap.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uep.wap.model.Location;
import com.uep.wap.repository.LocationRepository;

import java.util.List;

    @Service
    public class LocationService {
        @Autowired
        private LocationRepository locationRepository;

        public List<Location> getAllLocations() {
            return locationRepository.findAll();
        }

        public Location findLocationByName(String locationName) {
            return  locationRepository.findLocationByName(locationName);
        }

        public Location getLocationById(Long id) {
            return locationRepository.findById(id).orElse(null);
        }

        public Location saveLocation(Location location) {
            return locationRepository.save(location);
        }

        public void deleteLocation(Long id) {
            locationRepository.deleteById(id);
        }}



