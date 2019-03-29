package org.elasticsearch.plugin.ingest.search;

import org.elasticsearch.ingest.AbstractProcessor;
import org.elasticsearch.ingest.IngestDocument;

public final class EnrichProcessor extends AbstractProcessor {

    public static final String TYPE = "enrich";

    EnrichProcessor(String tag) {
        super(tag);
    }

    @Override
    public IngestDocument execute(IngestDocument document) {
        document.setFieldValue("enrich", true);
        return document;
    }

    @Override
    public String getType() {
        return TYPE;
    }

}


