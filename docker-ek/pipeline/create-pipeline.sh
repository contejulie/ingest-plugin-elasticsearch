#!/usr/bin/env bash
curl -H 'Content-Type: application/json' -XPUT 'localhost:9200/_ingest/pipeline/enrich-pipeline' --data-binary @create-pipeline.json;
echo
