#!/bin/bash

echo rebuild
docker-compose -f docker-compose_devDB.yml down -v
docker-compose -f docker-compose_devDB.yml up -d

