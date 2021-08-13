package io.voidengine.api.search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@SolrDocument(collection = "nutch")
public class SearchResultDocument {
    @Id
    @Indexed(name = "id", type = "string")
    private String id;
    @Indexed(name = "title", type = "string")
    private String title;
    @Indexed(name = "url", type = "string")
    private String url;
    @Indexed(name = "description", type = "string")
    private List<String> description;
}
