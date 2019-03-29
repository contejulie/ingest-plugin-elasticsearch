#!/usr/bin/env bash
curl -H 'Content-Type: application/x-ndjson' -XPOST 'localhost:9200/data-enrich/_doc/_bulk?pretty&pipeline=enrich' --data-binary @data.json;
echo
