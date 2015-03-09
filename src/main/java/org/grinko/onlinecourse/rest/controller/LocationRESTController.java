package org.grinko.onlinecourse.rest.controller;

import org.grinko.onlinecourse.rest.DO.Location;
import org.grinko.onlinecourse.rest.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by grinko on 8.3.15.
 */
@RestController
@RequestMapping("/locations")
public class LocationRESTController {

    @Autowired
    LocationRepository locationRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Location> getAll() {
        return (List<Location>) locationRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Location create(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestBody Long id) {
        locationRepository.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public Location update(@RequestBody Long id, @RequestBody Location location) {
        Location oldLocation = locationRepository.findOne(id);
        oldLocation.setLocationName(location.getLocationName());
        return locationRepository.save(oldLocation);
    }
}
