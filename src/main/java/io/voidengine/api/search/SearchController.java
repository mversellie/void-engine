package io.voidengine.api.search;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping()
    public ResponseEntity<SearchResponse> search(@RequestParam String query){
        Page<SearchResultDocument> searchResults = searchService.search(query,0,10);
        SearchResponse res = SearchResponse.builder().results(searchResults.toList())
                .resultsCount(searchResults.getTotalElements()).build();
        return ResponseEntity.ok(res);
    }
}
