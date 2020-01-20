#!/bin/bash

export REGISTRY_URL=localhost:5000
export MSG_CONSUMER_VERSION=0.0.1-SNAPSHOT
export AMQ_BROKER_HOST=activemq:61616

docker stack deploy --compose-file docker-compose.yml amq

#To remove: docker stack rm amq
