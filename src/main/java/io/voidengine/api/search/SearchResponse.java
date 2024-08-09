package io.voidengine.api.search;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class SearchResponse {
    List<SearchResultDocument> results;
    Long resultsCount;
}
