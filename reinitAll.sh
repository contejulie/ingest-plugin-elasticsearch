#!/usr/bin/env bash
cd ./docker-ek/ && \
docker-compose down && \
docker container prune -f && \
docker volume prune -f
