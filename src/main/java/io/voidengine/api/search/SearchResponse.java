package io.voidengine.api.search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class SearchResponse {
    private Integer resultCount;
    private List<SearchResultDocument> results;

    public SearchResponse() {
        resultCount = 0;
        results = new ArrayList<>();
    }
}
