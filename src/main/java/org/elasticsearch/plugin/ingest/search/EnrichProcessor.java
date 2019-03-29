package org.elasticsearch.plugin.ingest.search;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.ingest.AbstractProcessor;
import org.elasticsearch.ingest.IngestDocument;

import java.util.Arrays;

public final class EnrichProcessor extends AbstractProcessor {

    public static final String TYPE = "enrich";

    private final TransportClient client;

    /**
     * @param tag
     * @param client
     */
    EnrichProcessor(String tag, TransportClient client) {
        super(tag);
        this.client = client;
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


