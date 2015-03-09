package org.grinko.onlinecourse.rest.repository;

import org.grinko.onlinecourse.rest.DO.Location;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by grinko on 8.3.15.
 */
public interface LocationRepository extends PagingAndSortingRepository<Location, Long> {

}
