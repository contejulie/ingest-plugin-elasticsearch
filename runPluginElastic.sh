#!/usr/bin/env bash
./reinitAll.sh && \
mvn package && \
cd ./docker-ek/ && \
echo $(pwd) && \
docker-compose down && \
docker container prune -f && \
docker volume prune -f
docker-compose up --build -d
until curl http://localhost:9200/_cluster/health?pretty; do sleep 5; done

curl -X PUT localhost:9200/data-enrich
echo "\nIndex data-enrich  créé"

./pipeline/create-pipeline.sh
./send-data-enrich.sh
