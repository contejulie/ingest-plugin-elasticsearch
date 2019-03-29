package org.elasticsearch.plugin.ingest.search;

import org.elasticsearch.ingest.Processor;

import java.util.Map;

public final class Factory implements Processor.Factory {

    @Override
    public EnrichProcessor create(Map<String, Processor.Factory> registry,
                                  String processorTag,
                                  Map<String, Object> config) {

        return new EnrichProcessor(processorTag);
    }
}
