package org.grinko.onlinecourse.rest.DO;

import javax.persistence.*;

/**
 * Created by grinko on 8.3.15.
 */
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long locationId;
    private String locationName;


    public Location() {
    }

    public Location(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
}
