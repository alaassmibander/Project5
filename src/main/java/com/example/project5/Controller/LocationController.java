package com.example.project5.Controller;

import com.example.project5.DTO.LocationDTO;
import com.example.project5.Service.LocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/location")
public class LocationController {


    private LocationService locationService;

    @GetMapping("/get")
    public ResponseEntity getLocation() {
        return ResponseEntity.status(200).body(locationService.getAllLocations());
    }

    @PostMapping("/add")
    public ResponseEntity addLocation(@RequestBody LocationDTO locationDTO) {
        locationService.addLocation(locationDTO);
        return ResponseEntity.status(200).body("Location was added.");
    }

    @PutMapping("/update/{locationId}")
    public ResponseEntity updateLocation(@RequestBody @Valid LocationDTO locationDTO, @PathVariable Integer locationId) {
        locationService.updateLocation(locationId, locationDTO);
        return ResponseEntity.status(200).body("Location updates");
    }

    @DeleteMapping("/delete/{locationId}")
    public ResponseEntity deleteLocation(@PathVariable Integer locationId) {
        locationService.deleteLocation(locationId);
        return ResponseEntity.status(200).body("Location deleted");
    }
}
