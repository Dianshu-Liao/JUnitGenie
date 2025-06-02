package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeStartArray_Object_cfg_path_9_Test {

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
    public void testWriteStartArray_withValidTokenFilter() {
        try {
            filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
            when(mockFilterContext.createChildArrayContext(any(TokenFilter.class), anyBoolean())).thenReturn(mockFilterContext);
            filteringGeneratorDelegate.writeStartArray(new Object());

            verify(mockFilterContext).createChildArrayContext(TokenFilter.INCLUDE_ALL, true);
            verify(mockJsonGenerator).writeStartArray(any(Object.class));
        } catch (IOException e) {
            // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withNonNullItemFilter() {
        try {
            filteringGeneratorDelegate._itemFilter = mockTokenFilter;
            when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
            when(mockFilterContext.createChildArrayContext(any(TokenFilter.class), anyBoolean())).thenReturn(mockFilterContext);
            when(mockTokenFilter.filterStartArray()).thenReturn(mockTokenFilter);
            filteringGeneratorDelegate.writeStartArray(new Object());

            verify(mockFilterContext).checkValue(mockTokenFilter);
            verify(mockTokenFilter).filterStartArray();
            verify(mockFilterContext).createChildArrayContext(mockTokenFilter, true);
            verify(mockJsonGenerator).writeStartArray(any(Object.class));
        } catch (IOException e) {
            // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withNullItemFilter() {
        try {
            filteringGeneratorDelegate._itemFilter = null;
            when(mockFilterContext.createChildArrayContext(any(TokenFilter.class), anyBoolean())).thenReturn(mockFilterContext);
            filteringGeneratorDelegate.writeStartArray(new Object());

            verify(mockFilterContext).createChildArrayContext(null, false);
        } catch (IOException e) {
            // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withInclusionNonNull() {
        try {
            filteringGeneratorDelegate._itemFilter = mockTokenFilter;
            filteringGeneratorDelegate._inclusion = TokenFilter.Inclusion.INCLUDE_NON_NULL;
            when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
            when(mockFilterContext.createChildArrayContext(any(TokenFilter.class), anyBoolean())).thenReturn(mockFilterContext);
            filteringGeneratorDelegate.writeStartArray(new Object());

            verify(mockFilterContext).checkValue(mockTokenFilter);
            verify(mockFilterContext).createChildArrayContext(mockTokenFilter, true);
            verify(mockJsonGenerator).writeStartArray(any(Object.class));
        } catch (IOException e) {
            // Handle exception
        }
    }

}