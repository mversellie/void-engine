package io.voidengine.api.Search;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class SearchControllerTest {
    private SearchController controller;

    @Mock
    private SearchService service;

    @Before
    public void setUp() throws Exception {
        controller = new SearchController(service);
        Mockito.when(service.search(anyString())).thenReturn(new ArrayList<>());
    }

    @Test
    public void search_doesNotReturnNull() {
        var actual = controller.search("");

        Assertions.assertThat(actual).isNotNull();
    }
}