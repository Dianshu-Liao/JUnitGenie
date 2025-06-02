package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeStartArray_Object_cfg_path_6_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private TokenFilterContext mockFilterContext;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
        filteringGeneratorDelegate._filterContext = mockFilterContext;
    }

    @Test(timeout = 4000)
    public void testWriteStartArrayWithIncludeAll() {
        try {
            filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
            when(mockFilterContext.createChildArrayContext(TokenFilter.INCLUDE_ALL, true)).thenReturn(mockFilterContext);
            filteringGeneratorDelegate.writeStartArray(new Object());
            verify(mockJsonGenerator).writeStartArray(any());
        } catch (IOException e) {
            // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartArrayWithNonNullInclusion() {
        try {
            filteringGeneratorDelegate._itemFilter = mockTokenFilter;
            when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
            when(mockTokenFilter.filterStartArray()).thenReturn(mockTokenFilter);
            when(mockFilterContext.createChildArrayContext(mockTokenFilter, true)).thenReturn(mockFilterContext);
            filteringGeneratorDelegate.writeStartArray(new Object());
            verify(mockJsonGenerator).writeStartArray(any());
        } catch (IOException e) {
            // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartArrayWithNullItemFilter() {
        try {
            filteringGeneratorDelegate._itemFilter = null;
            when(mockFilterContext.createChildArrayContext(null, false)).thenReturn(mockFilterContext);
            filteringGeneratorDelegate.writeStartArray(new Object());
            verify(mockFilterContext).createChildArrayContext(null, false);
        } catch (IOException e) {
            // Handle exception
        }
    }

}