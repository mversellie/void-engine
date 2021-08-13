package io.voidengine.api.search;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class SearchServiceTest {
    private final String ANEXAMPLE_ID = "anexampleID";
    private final String EXAMPLE_DESCRIPTION = "description";
    private final String EXAMPLE_URL = "http://aurl.com";
    private final String EXAMPLE_TITLE = "Example Title";


    @Mock
    private SearchRepository mockRepo;

    private SearchService searchService;

    @Before
    public void setUp() throws Exception {
        searchService = new SearchService(mockRepo);
        Mockito.when(mockRepo.searchUrlTitleKeywordsDescriptionForWords(Mockito.anyString(), any()))
                .thenReturn(Arrays.asList(mockResultDoc()));
    }

    @Test
    public void search_ReturnsNotNUll() {
        var actual = searchService.search("");

        assertThat(actual).isNotNull();
    }

    @Test
    public void search_returnsResultsFromRepoCall() {
        var actual = searchService.search("");

        assertThat(actual.get(0)).isEqualTo(mockResultDoc());
        assertThat(actual.size()).isEqualTo(1);
    }

    private SearchResultDocument mockResultDoc() {
        return SearchResultDocument.builder()
                .id(ANEXAMPLE_ID)
                .url(EXAMPLE_URL)
                .title(EXAMPLE_TITLE)
                .description(Arrays.asList(EXAMPLE_DESCRIPTION))
                .build();
    }
}