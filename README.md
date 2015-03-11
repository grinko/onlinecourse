# onlinecourse
Spring Boot REST app with in memory DB HSQLDB.


1) chekout <div />
2) build <div />
3) deploy >div />

Project includes initial DB data and you can make sure that it's working without additional moves.

/locations/,methods=[GET] - get All locations <div />
http://localhost:8090/locations/ <div />

/locations/{1},methods=[GET] - get location {1} <div />
http://localhost:8090/locations/ <div />

/locations/{id},methods=[PUT] -update location {id} <div />

/locations/{id},methods=[DELETE] - delete location {id} <div />

/locations/,methods=[POST] - add new location <div />

/persons/csv,methods=[GET] - get csv file of all persons <div />
localhost:8090/persons/csv <div />

/persons/,methods=[GET] - get All persons <div />
http://localhost:8090/courses/ <div />

/persons/{id},methods=[PUT] - update person {id} <div />

/persons/{id},methods=[DELETE] - delete person {id} <div />

/persons/,methods=[POST] - add person <div />

/courses/{id},methods=[GET] - get course {id} <div />
http://localhost:8090/courses/

/courses/,methods=[POST] - add new course <div />

/courses/{id},methods=[DELETE] - delete course {id} <div />

/courses/,methods=[GET] - get All courses <div />
http://localhost:8090/courses/

/courses/page,methods=[GET] - get courses with pagination, sorting and time conditions <div />
http://localhost:8090/courses/page?order=courseName.desc&page=0&size=3 - get 3 first courses ordered by courseName descending
http://localhost:8090/courses/page?order=courseName.desc&page=1&size=3 - get 2nd page with 3 courses ordered by courseName descending
http://localhost:8090/courses/page?order=courseName.desc&page=0&size=10&fromDate=1426539590000&toDate=1431637200001 - get ordered and paged list of courses from time interval


/courses/{id},methods=[PUT] - update course {id} <div />
