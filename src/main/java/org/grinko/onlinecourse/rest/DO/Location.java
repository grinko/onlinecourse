package org.grinko.onlinecourse.rest.DO;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by grinko on 8.3.15.
 */
@Entity
@ToString(exclude="id")
@EqualsAndHashCode(exclude="id")
public @Data class Location {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String locationName;
}
