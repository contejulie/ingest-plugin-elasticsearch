package org.elasticsearch.plugin.ingest.search;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.ingest.Processor;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.Closeable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

public final class Factory implements Closeable, Processor.Factory {

    private TransportClient client;

    @Override
    public EnrichProcessor create(Map<String, Processor.Factory> registry,
                                  String processorTag,
                                  Map<String, Object> config) throws UnknownHostException {

        Settings settings = Settings.builder()
                .put("cluster.name", "docker-cluster").build();
        client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
        return new EnrichProcessor(processorTag, client);
    }

    @Override
    public void close() {
        client.close();
    }
}
