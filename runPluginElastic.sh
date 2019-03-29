#!/usr/bin/env bash
./docker-ek/env.sh $@
set -x
./reinitAll.sh && \
mvn package && \
(cd ./docker-ek/ && \
echo $(pwd) && \
docker-compose down && \
docker container prune -f && \
docker volume prune -f
docker-compose up --build -d)
until curl http://localhost:9200/_cluster/health?pretty; do sleep 5; done

curl -X PUT localhost:9200/data-enrich
echo "\nIndex data-enrich  créé"
curl -H 'Content-Type: application/json' -X PUT 'localhost:9200/_ingest/pipeline/enrich' -d @./docker-ek/pipeline/pipeline.json;
(cd ./docker-ek/fake-data/ && ./send-data.sh)
