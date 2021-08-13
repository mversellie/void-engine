package io.voidengine.api.search;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class SearchControllerTest {
    private final String ANEXAMPLE_ID = "anexampleID";
    private final String EXAMPLE_DESCRIPTION = "description";
    private final String EXAMPLE_URL = "http://aurl.com";
    private final String EXAMPLE_TITLE = "Example Title";
    private SearchController controller;

    @Mock
    private SearchService service;

    @Before
    public void setUp() throws Exception {
        controller = new SearchController(service);
        makeMocks();
    }

    @Test
    public void search_doesNotReturnNull() {
        var actual = controller.search("");

        Assertions.assertThat(actual).isNotNull();
    }

    @Test
    public void search_ReturnsResponseWithASearchResultFromService() {
        var actual = controller.search("");

        Assertions.assertThat(actual.getResultCount()).isEqualTo(1);
        Assertions.assertThat(actual.getResults().size()).isEqualTo(1);
        Assertions.assertThat(actual.getResults().get(0)).isEqualTo(mockResultDoc());
    }

    private void makeMocks() {
        Mockito.when(service.search(anyString())).thenReturn(Arrays.asList(mockResultDoc()));
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