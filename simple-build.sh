#!/bin/bash

# set necessary environment varibles
cd workshop-organizer/
source ./export-env.sh

# build spring application
cd spring-project/
mvn clean package

# build docker image and start container via
# docker-compose (-d for detached mode)
cd ../
docker-compose down
docker-compose up --build -d 

