package io.voidengine.api.Search;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

   SearchRepository searchRepository;

    public SearchService(SearchRepository repo){
        searchRepository = repo;
    }

    public List<SearchResultDocument> search(String query){
        return searchRepository.searchUrlTitleKeywordsDescriptionForWords(query,PageRequest.of(0, 10));
    }
}
