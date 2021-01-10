package io.voidengine.api;

import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.server.SolrClientFactory;
import org.springframework.data.solr.server.support.HttpSolrClientFactory;

@Configuration
public class SolrConfig {

    @Value("${solr.user}")
    private String solrUser;

    @Value("${solr.password}")
    private String solrPassword;

    @Bean
    public SolrClientFactory solrClientFactory(final SolrClient solrClient){
        Credentials credentials = new UsernamePasswordCredentials(solrUser, solrPassword);
        return new HttpSolrClientFactory(solrClient, credentials,"BASIC");
    }

}
