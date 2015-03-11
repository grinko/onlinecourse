package org.grinko.onlinecourse.rest.DO;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by grinko on 8.3.15.
 */

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long courseId;
    private String courseName;
    private Date startDate;
    private Date endDate;
    @OneToOne
    private Location location;
    @ManyToMany(mappedBy = "courses")
    @JsonManagedReference
    private Set<Person> persons = new HashSet<>();


    public Course() {
    }

    public Course(String courseName, Date startDate, Date endDate, Location location, Set<Person> persons) {
        this.courseName = courseName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.persons = persons;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

}
