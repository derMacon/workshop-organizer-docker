#!/bin/bash

echo set necessary environment variables
cd workshop-organizer/
#source ./export-env.sh
source workshop-organizer/variables.env

echo build spring application
cd spring-project/
mvn clean package

echo build docker image and start container via \
docker-compose, -d for detached mode
cd ../
docker-compose down
docker-compose up --build -d 

