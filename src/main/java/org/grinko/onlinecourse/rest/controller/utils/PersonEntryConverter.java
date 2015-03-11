package org.grinko.onlinecourse.rest.controller.utils;

import com.googlecode.jcsv.writer.CSVEntryConverter;
import org.grinko.onlinecourse.rest.DO.Person;

/**
 * Created by grinko on 10.3.15.
 */
public class PersonEntryConverter implements CSVEntryConverter<Person> {
    @Override
    public String[] convertEntry(Person p) {
        String[] columns = new String[3];

        columns[0] = p.getFirstName();
        columns[1] = p.getLastName();
        columns[2] = String.valueOf(p.getAge());

        return columns;
    }
}
