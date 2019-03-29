
ARG ELK_VERSION

# https://github.com/elastic/elasticsearch-docker
FROM docker.elastic.co/elasticsearch/elasticsearch:${ELK_VERSION}
RUN rm /opt/jdk-11.0.1/conf/security/java.policy
COPY java.policy /opt/jdk-11.0.1/conf/security

COPY ./plugin ./plugin
# Add your elasticsearch plugins setup here
# Example: RUN elasticsearch-plugin install analysis-icu
RUN bin/elasticsearch-plugin install file:////usr/share/elasticsearch/plugin/plugin-elastic-0.0.1.zip
