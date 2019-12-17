#!/bin/bash

docker stack deploy --compose-file docker-compose.yml amq

#To remove: docker stack rm amq
