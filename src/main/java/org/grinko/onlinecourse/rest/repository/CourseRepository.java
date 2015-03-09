package org.grinko.onlinecourse.rest.repository;

import org.grinko.onlinecourse.rest.DO.Course;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by grinko on 8.3.15.
 */
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {

    @Query("SELECT c FROM Course c WHERE c.startDate < ?2 AND c.endDate > ?1")
    public List<Course> findByTime(Date from, Date to, Pageable page);
}
