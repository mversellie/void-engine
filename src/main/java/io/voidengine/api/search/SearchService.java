package io.voidengine.api.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SearchService {

   private SearchRepository searchRepository;

    public SearchService(SearchRepository repo){
        searchRepository = repo;
    }

    public Page<SearchResultDocument> search(String query, int pageNo, int pageSize){
        String queryCheck = spaceToAnd(query);
        return searchRepository.searchUrlTitleKeywordsDescriptionForWords(spaceToAnd(queryCheck),
                PageRequest.of(pageNo, pageSize));
    }

    private String spaceToAnd(String in){
        String[] terms = in.trim().split(" ");
        if(terms.length < 2){
            return terms[0].trim();
        }

        StringBuilder ret = new StringBuilder("(\"" + terms[0].trim());
        for (String term : Arrays.asList(terms).subList(1,terms.length)) {
            String trimmed = term.trim();
            if(!trimmed.isEmpty()) {
                ret.append("\" AND \"");
                ret.append(term.trim());
            }
        }
        return ret.append("\")").toString();
    }
}
