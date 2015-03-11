package org.grinko.onlinecourse.rest.controller;

import org.grinko.onlinecourse.rest.DO.Course;
import org.grinko.onlinecourse.rest.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by grinko on 8.3.15.
 */
@RestController
@RequestMapping("/courses")
public class CourseRESTController {

    @Autowired
    CourseRepository courseRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Course getCourse(@PathVariable Long id) {
        return courseRepository.findOne(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteCourse(@PathVariable Long id) {
        courseRepository.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Course update(@PathVariable Long id, @RequestBody Course course) {
        Course oldCourse = courseRepository.findOne(id);
        oldCourse.setCourseName(course.getCourseName());
        oldCourse.setStartDate(course.getStartDate());
        oldCourse.setEndDate(course.getEndDate());
        return courseRepository.save(oldCourse);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public List<Course> getAll(HttpServletRequest request) {
        Map<String, String[]> parameters = request.getParameterMap();

        Pageable pageable;
        Date toDate;
        Date fromDate;
        //TODO move to separate method
        try {
            String pageStr = parameters.get("page")[0];
            int pageNumber = StringUtils.isNotBlank(pageStr) ? Integer.valueOf(pageStr) : 0;

            String sizeStr = parameters.get("size")[0];
            int size = StringUtils.isNotBlank(sizeStr) ? Integer.valueOf(sizeStr) : 100;

            String[] sortProperties = parameters.get("order")[0].split("\\.");
            String sortProperty = sortProperties[0];
            String sortOrder = sortProperties[1];

            pageable = new PageRequest(pageNumber, size, Sort.Direction.fromString(sortOrder), sortProperty);
        }catch (Exception ex) {
            return new ArrayList<>();
        }
        try {
            String fromStr = parameters.get("fromDate")[0];
            fromDate = new Date(Long.valueOf(fromStr));

            String toStr = parameters.get("toDate")[0];
            toDate = new Date(Long.valueOf(toStr));
        }catch (Exception ex) {
            return courseRepository.findAll(pageable).getContent();
        }
        return  courseRepository.findByTime(fromDate, toDate, pageable);

    }
}
