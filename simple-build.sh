#!/bin/bash

# set necessary environment varibles
cd docker/
source ./export-env.sh

# build spring application
cd ../workshop-organizer/
mvn clean package

# build docker image and start container via
# docker-compose (-d for detached mode)
cd ../docker/
docker-compose down
docker-compose up --build -d 

