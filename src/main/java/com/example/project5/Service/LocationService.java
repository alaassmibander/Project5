package com.example.project5.Service;

import com.example.project5.DTO.LocationDTO;
import com.example.project5.Exception.APIException;
import com.example.project5.Model.Location;
import com.example.project5.Model.Store;
import com.example.project5.Repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {


    private LocationRepository locationRepository;
    private StoreService storeService;

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationBy(Integer locationId) {
        Location location = locationRepository.findById(locationId).orElse(null);
        if (location == null) throw new APIException("Location not found");
        return location;
    }

    public void addLocation(LocationDTO locationDTO) {
        Store store = storeService.getStoreBy(locationDTO.getStoreId());

        Location location = new Location(locationDTO, store);
        locationRepository.save(location);
    }

    public void updateLocation(Integer locationId, LocationDTO locationDTO) {
        getLocationBy(locationId);
        Store store = storeService.getStoreBy(locationDTO.getStoreId());

        Location updatedLocation = new Location(locationDTO, store);
        updatedLocation.setId(locationId);

        locationRepository.save(updatedLocation);
    }

    public void deleteLocation(Integer locationId) {
        getLocationBy(locationId);
        locationRepository.deleteById(locationId);
    }
}
