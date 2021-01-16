package io.voidengine.api.search;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class SearchServiceTest {

    @Mock
    private SearchRepository mockRepo;

    private SearchService searchService;

    @Before
    public void setUp() throws Exception {
        searchService = new SearchService(mockRepo);
        Mockito.when(mockRepo.searchUrlTitleKeywordsDescriptionForWords(Mockito.anyString(),any())).thenReturn(new ArrayList<>());
    }

    @Test
    public void search_ReturnsNotNUll(){
        var actual = searchService.search("");

        assertThat(actual).isNotNull();
    }
}