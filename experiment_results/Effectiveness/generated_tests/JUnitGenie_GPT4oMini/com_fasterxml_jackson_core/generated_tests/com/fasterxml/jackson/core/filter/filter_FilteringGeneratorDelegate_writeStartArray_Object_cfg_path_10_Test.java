package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeStartArray_Object_cfg_path_10_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private TokenFilterContext mockTokenFilterContext;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;

        filteringGeneratorDelegate.writeStartArray(new Object());

        verify(mockTokenFilterContext).createChildArrayContext(TokenFilter.INCLUDE_ALL, true);
        verify(mockJsonGenerator).writeStartArray(any());
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withNonNullInclusion() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL; // Simulating the filter check
        when(mockTokenFilterContext.checkValue(any(TokenFilter.class))).thenReturn(mockTokenFilter);
        when(mockTokenFilter.filterStartArray()).thenReturn(mockTokenFilter);

        filteringGeneratorDelegate.writeStartArray(new Object());

        verify(mockTokenFilterContext).createChildArrayContext(mockTokenFilter, true);
        verify(mockJsonGenerator).writeStartArray(any());
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withNullItemFilter() throws IOException {
        filteringGeneratorDelegate._itemFilter = null;

        filteringGeneratorDelegate.writeStartArray(new Object());

        verify(mockTokenFilterContext).createChildArrayContext(null, false);
        verify(mockJsonGenerator, never()).writeStartArray(any());
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withNonIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(any(TokenFilter.class))).thenReturn(mockTokenFilter);
        when(mockTokenFilter.filterStartArray()).thenReturn(mockTokenFilter);
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL; // Simulating the filter check

        filteringGeneratorDelegate.writeStartArray(new Object());

        verify(mockTokenFilterContext).createChildArrayContext(mockTokenFilter, true);
        verify(mockJsonGenerator).writeStartArray(any());
    }

    @Test(timeout = 4000)
    public void testWriteStartArray_withInvalidJsonGeneratorState() throws IOException {
        // Simulate an invalid state for the JsonGenerator
        doThrow(new IOException("Invalid state")).when(mockJsonGenerator).writeStartArray(any());

        try {
            filteringGeneratorDelegate.writeStartArray(new Object());
        } catch (IOException e) {
            // Expected exception
        }

        verify(mockJsonGenerator).writeStartArray(any());
    }

}