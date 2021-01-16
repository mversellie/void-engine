package io.voidengine.api.search;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
@SolrDocument(collection = "nutch")
public class SearchResultDocument {
    @Id
    @Indexed(name = "id", type = "string")
    private String id;
    @Indexed(name = "title", type = "string")
    private String title;
    @Indexed(name = "description", type = "string")
    private String description;
}
