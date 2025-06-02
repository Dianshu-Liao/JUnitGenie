package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeStartArray_Object_cfg_path_7_Test {

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
    public void testWriteStartArray_withIncludeAll() {
        try {
            filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
            filteringGeneratorDelegate.writeStartArray(new Object());
            verify(mockFilterContext).createChildArrayContext(TokenFilter.INCLUDE_ALL, true);
            verify(mockJsonGenerator).writeStartArray(any());
        } catch (IOException e) {
            // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withNonNullInclusion() {
        try {
            filteringGeneratorDelegate._itemFilter = mockTokenFilter;
            when(mockTokenFilter.filterStartArray()).thenReturn(mockTokenFilter);
            filteringGeneratorDelegate._inclusion = TokenFilter.Inclusion.INCLUDE_NON_NULL;

            filteringGeneratorDelegate.writeStartArray(new Object());
            verify(mockFilterContext).createChildArrayContext(mockTokenFilter, true);
            verify(mockJsonGenerator).writeStartArray(any());
        } catch (IOException e) {
            // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withNullItemFilter() {
        try {
            filteringGeneratorDelegate._itemFilter = null;
            filteringGeneratorDelegate.writeStartArray(new Object());
            verify(mockFilterContext).createChildArrayContext(null, false);
        } catch (IOException e) {
            // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withFilteredItem() {
        try {
            filteringGeneratorDelegate._itemFilter = mockTokenFilter;
            when(mockTokenFilter.filterStartArray()).thenReturn(mockTokenFilter);
            when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);

            filteringGeneratorDelegate.writeStartArray(new Object());
            verify(mockFilterContext).createChildArrayContext(mockTokenFilter, true);
            verify(mockJsonGenerator).writeStartArray(any());
        } catch (IOException e) {
            // Handle exception
        }
    }

}