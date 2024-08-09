package io.voidengine.api.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends SolrCrudRepository<SearchResultDocument, String> {

    @Query("url:?0 OR title:?0 OR keywords:?0 OR description:?0")
    Page<SearchResultDocument> searchUrlTitleKeywordsDescriptionForWords(String keywords, Pageable pager);
}
