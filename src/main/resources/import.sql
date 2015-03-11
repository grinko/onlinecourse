set schema public;

--locations
insert into location(location_id, location_name) values (1,'Berlin');
insert into location(location_id, location_name) values (2,'Paris');
insert into location(location_id, location_name) values (3, 'Riga');
insert into location(location_id, location_name) values (4, 'Vilnius');

--persons
insert into person(person_id, first_name, last_name, age) values (1, 'Mikalai', 'Grinko', 30);
insert into person(person_id, first_name, last_name, age) values (2, 'Mike', 'Ross', 32);
insert into person(person_id, first_name, last_name, age) values (3, 'Barbara', 'Brylska', 20);
insert into person(person_id, first_name, last_name, age) values (4, 'Kriss', 'Rurk', 22);
insert into person(person_id, first_name, last_name, age) values (5, 'Indiana', 'Jones', 35);
insert into person(person_id, first_name, last_name, age) values (6, 'Franka', 'Potente', 32);
insert into person(person_id, first_name, last_name, age) values (7, 'Ivan', 'Urgant', 37);
insert into person(person_id, first_name, last_name, age) values (8, 'Leonard', 'Hofstadter', 32);
insert into person(person_id, first_name, last_name, age) values (9, 'Sheldon', 'Cooper', 30);
insert into person(person_id, first_name, last_name, age) values (10, 'Linus', 'Torvalds', 46);

--courses
insert into course(course_id, course_name, start_date, end_date, location_locationId) values (1, 'Scala', DATE '2015-3-10', DATE '2015-4-10', 1);
insert into course(course_id, course_name, start_date, end_date, location_locationId) values (2, 'Java', DATE '2015-3-17', DATE '2015-4-17', 2);
insert into course(course_id, course_name, start_date, end_date, location_locationId) values (3, 'JavaScript', DATE '2015-3-24', DATE '2015-5-1', 3);
insert into course(course_id, course_name, start_date, end_date, location_locationId) values (4, 'SQL', DATE '2015-5-8', DATE '2015-5-15', 4);
insert into course(course_id, course_name, start_date, end_date, location_locationId) values (5, 'Haskel', DATE '2015-5-22', DATE '2015-5-29', 4);
insert into course(course_id, course_name, start_date, end_date, location_locationId) values (6, 'Erlang', DATE '2015-6-5', DATE '2015-6-12', 4);

insert into person_course(person_id, course_id) values (1, 1);
insert into person_course(person_id, course_id) values (2, 1);
insert into person_course(person_id, course_id) values (3, 1);
insert into person_course(person_id, course_id) values (4, 1);
insert into person_course(person_id, course_id) values (5, 2);
insert into person_course(person_id, course_id) values (6, 2);
insert into person_course(person_id, course_id) values (7, 2);
insert into person_course(person_id, course_id) values (8, 2);
insert into person_course(person_id, course_id) values (9, 3);
insert into person_course(person_id, course_id) values (10, 1);
insert into person_course(person_id, course_id) values (10, 2);
insert into person_course(person_id, course_id) values (10, 3);
insert into person_course(person_id, course_id) values (10, 4);
insert into person_course(person_id, course_id) values (2, 2);
insert into person_course(person_id, course_id) values (3, 3);
insert into person_course(person_id, course_id) values (4, 4);