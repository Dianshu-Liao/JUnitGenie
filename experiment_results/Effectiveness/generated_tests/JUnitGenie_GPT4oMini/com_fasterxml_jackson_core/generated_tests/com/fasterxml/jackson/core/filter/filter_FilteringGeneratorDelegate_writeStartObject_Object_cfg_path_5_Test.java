package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeStartObject_Object_cfg_path_5_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private TokenFilterContext mockFilterContext;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, Inclusion.INCLUDE_NON_NULL, false);
        filteringGeneratorDelegate._filterContext = mockFilterContext;
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withNonNullItemFilter() {
        try {
            filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
            filteringGeneratorDelegate.writeStartObject(new Object());
            verify(mockFilterContext).createChildObjectContext(TokenFilter.INCLUDE_ALL, true);
            verify(mockJsonGenerator).writeStartObject(any());
        } catch (IOException e) {
            // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withNullItemFilter() {
        try {
            filteringGeneratorDelegate._itemFilter = null;
            filteringGeneratorDelegate.writeStartObject(new Object());
            verify(mockFilterContext).createChildObjectContext(null, false);
        } catch (IOException e) {
            // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withCheckValueReturningNull() {
        try {
            filteringGeneratorDelegate._itemFilter = mockTokenFilter;
            when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
            filteringGeneratorDelegate.writeStartObject(new Object());
            verify(mockFilterContext).createChildObjectContext(null, false);
        } catch (IOException e) {
            // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withCheckValueReturningIncludeAll() {
        try {
            filteringGeneratorDelegate._itemFilter = mockTokenFilter;
            when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(TokenFilter.INCLUDE_ALL);
            filteringGeneratorDelegate.writeStartObject(new Object());
            verify(mockFilterContext).createChildObjectContext(TokenFilter.INCLUDE_ALL, true);
            verify(mockJsonGenerator).writeStartObject(any());
        } catch (IOException e) {
            // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartObject_withCheckValueReturningNonNull() {
        try {
            filteringGeneratorDelegate._itemFilter = mockTokenFilter;
            TokenFilter nonNullFilter = mock(TokenFilter.class);
            when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(nonNullFilter);
            filteringGeneratorDelegate.writeStartObject(new Object());
            verify(mockFilterContext).createChildObjectContext(nonNullFilter, true);
            verify(mockJsonGenerator).writeStartObject(any());
        } catch (IOException e) {
            // Handle exception
        }
    }

}