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
import org.springframework.data.domain.Page;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class SearchServiceTest {

    @Mock
    private SearchRepository mockRepo;

    private SearchService searchService;


    @Mock
    private Page mockPage;

    @Before
    public void setUp() throws Exception {
        searchService = new SearchService(mockRepo);

        Mockito.when(mockPage.getTotalPages()).thenReturn(0);
        Mockito.when(mockPage.getTotalElements()).thenReturn(0L);
        Mockito.when(mockPage.getContent()).thenReturn(new ArrayList());
        Mockito.when(mockRepo.searchUrlTitleKeywordsDescriptionForWords(Mockito.anyString(),any())).thenReturn(mockPage);
    }

    @Test
    public void search_ReturnsNotNUll(){
        var actual = searchService.search("",0,0);

        assertThat(actual).isNotNull();
    }
}