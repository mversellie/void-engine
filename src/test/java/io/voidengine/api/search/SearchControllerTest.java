package io.voidengine.api.search;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class SearchControllerTest {
    private SearchController controller;

    @Mock
    private SearchService service;

    @Mock
    private Page mockPage;

    @Before
    public void setUp() throws Exception {
        controller = new SearchController(service);
        Mockito.when(mockPage.getTotalPages()).thenReturn(0);
        Mockito.when(mockPage.getTotalElements()).thenReturn(0L);
        Mockito.when(mockPage.getContent()).thenReturn(new ArrayList());
        Mockito.when(service.search(anyString(),0,1)).thenReturn(mockPage);
    }

    @Test
    public void search_doesNotReturnNull() {
        var actual = controller.search("");

        Assertions.assertThat(actual).isNotNull();
    }
}