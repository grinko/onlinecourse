package org.grinko.onlinecourse.rest.DO;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by grinko on 8.3.15.
 */

@Entity
@ToString(exclude="id")
@EqualsAndHashCode(exclude="id")
public @Data class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String courseName;
    private Date startDate;
    private Date endDate;
    @OneToOne
    private Location location;
}
