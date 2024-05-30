package com.uep.wap.controller;

import com.uep.wap.model.Location;
import com.uep.wap.dto.LocationDTO;
import com.uep.wap.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<List<LocationDTO>> getAllLocations() {
        List<Location> locations = locationService.getAllLocations();
        List<LocationDTO> locationDTOs = locations.stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(locationDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationDTO> getLocationById(@PathVariable Long id) {
        Location location = locationService.getLocationById(id);
        if (location != null) {
            return new ResponseEntity<>(convertToDTO(location), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/byname")
    public ResponseEntity<LocationDTO> getLocationByName(@RequestParam String name) {
        Location location = locationService.findLocationByName(name);
        if (location != null) {
            return new ResponseEntity<>(convertToDTO(location), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<LocationDTO> createLocation(@RequestBody LocationDTO locationDTO) {
        Location location = convertToEntity(locationDTO);
        Location savedLocation = locationService.saveLocation(location);
        return new ResponseEntity<>(convertToDTO(savedLocation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationDTO> updateLocation(@PathVariable Long id, @RequestBody LocationDTO locationDTO) {
        Location location = locationService.getLocationById(id);
        if (location != null) {
            location.setName(locationDTO.getName());
            Location updatedLocation = locationService.saveLocation(location);
            return new ResponseEntity<>(convertToDTO(updatedLocation), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        Location location = locationService.getLocationById(id);
        if (location != null) {
            locationService.deleteLocation(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private LocationDTO convertToDTO(Location location) {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setName(location.getName());
        return locationDTO;
    }

    private Location convertToEntity(LocationDTO locationDTO) {
        Location location = new Location();
        location.setName(locationDTO.getName());
        return location;
    }
}

