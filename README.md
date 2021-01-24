# workshop-organizer-docker

## Functionality
Webapp to manage workshops. Users can enroll and drop out of courses. An admin can promote or create users with admin or manager permissions, only those permissions make it possible for a user to create a new course. A course consists out of an panel containing all relevant information for the course such as the title, content, calender etc.. Also it is possible for the manager of the course to create announcements which will be displayed in the browser and will also be send via email to the specified course members.

![screenshot](./img/screenshot_02.png)

## Build
To build the project just run the `simple-build.sh` script in the projects directory. It is also possible to build it with a jenkins server using the `Jenkinsfile` in the projects directory.

Steps used to build:
* set necessary environmnent variables (database credentials)
* build spring application (`mvn clean package`)
* build docker image using the Dockerimage (`./workshop-organizer/Dockerfile)
* run containers with `docker-compose up`

## Technologies used
* Spring Boot
* Hibernate
* Docker (docker-compose)
* Jenkins
