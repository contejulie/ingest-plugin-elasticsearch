#!/usr/bin/env bash
curl -H 'Content-Type: application/x-ndjson' -XPOST 'localhost:9200/session/product/_bulk?pretty&pipeline=enrich' --data-binary @data.json;
echo
