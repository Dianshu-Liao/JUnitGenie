package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeNumber_short_cfg_path_2_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;
    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private TokenFilterContext mockTokenFilterContext;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withValidTokenFilter() throws IOException {
        short value = 5; // Example value
        when(filteringGeneratorDelegate._itemFilter).thenReturn(TokenFilter.INCLUDE_ALL);
        
        filteringGeneratorDelegate.writeNumber(value);
        verify(mockJsonGenerator).writeNumber(value);
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withNonIncludeAllFilter() throws IOException {
        short value = 5; // Example value
        when(filteringGeneratorDelegate._itemFilter).thenReturn(mockTokenFilter);
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(value)).thenReturn(false); // Simulate includeNumber returning false

        filteringGeneratorDelegate.writeNumber(value);
        verify(mockJsonGenerator, never()).writeNumber(value); // Ensure writeNumber is not called
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withNullItemFilter() throws IOException {
        short value = 5; // Example value
        when(filteringGeneratorDelegate._itemFilter).thenReturn(null);

        filteringGeneratorDelegate.writeNumber(value);
        verify(mockJsonGenerator, never()).writeNumber(value); // Ensure writeNumber is not called
    }

}