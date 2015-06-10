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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Location> getAll() {
        return (List<Location>) locationRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Location getById(@PathVariable Long id) {
        try {
            throw new Exception("firts try");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locationRepository.findOne(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Location create(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        locationRepository.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Location update(@PathVariable Long id, @RequestBody Location location) {
        Location oldLocation = locationRepository.findOne(id);
        oldLocation.setLocationName(location.getLocationName());
        return locationRepository.save(oldLocation);
    }
}
