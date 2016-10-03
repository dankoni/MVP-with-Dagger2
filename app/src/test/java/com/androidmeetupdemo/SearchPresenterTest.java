package com.androidmeetupdemo;

import com.androidmeetupdemo.network.apiservice.OmbdServiceApi;
import com.androidmeetupdemo.network.models.Title;
import com.androidmeetupdemo.search.presenter.SearchPresenterImpl;
import com.androidmeetupdemo.search.views.SearchView;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by danko.misic on 10/2/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class SearchPresenterTest extends TestCase{
    @Mock
    private OmbdServiceApi mockService;
    @Mock
    private SearchView mockView;
    @Mock
    private ArrayList<Title> data;
    @Captor
    private ArgumentCaptor<List> dataArgumentCaptor;

    private SearchPresenterImpl classUnderTest;


    @Before
    public void setUp() throws Exception {
        super.setUp();
        classUnderTest = new SearchPresenterImpl(mockView, mockService);
        when(data.size()).thenReturn(10);
    }

    @Test
    public void testUpdateView() throws Exception {
        Title testTitle = new Title();
        testTitle.setTitle("Batman");
        when(data.get(anyInt())).thenReturn(testTitle);
        classUnderTest.updateSearchResult(data);
        verify(mockView).searchComplete((ArrayList<Title>) dataArgumentCaptor.capture());
        assertEquals(10, dataArgumentCaptor.getValue().size());
        assertTrue(dataArgumentCaptor.getValue().get(anyInt()) instanceof  Title);
        Title result = (Title) dataArgumentCaptor.getValue().get(anyInt());
        assertTrue(result.getTitle().contentEquals(testTitle.getTitle()));

    }
}
