package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeNumber_short_cfg_path_4_Test {

    private JsonGenerator mockJsonGenerator;
    private TokenFilter mockTokenFilter;
    private TokenFilterContext mockTokenFilterContext;
    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
        
        // Set up the _filterContext to return a valid TokenFilter
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withValidShortValue() {
        short validShortValue = 100; // A valid short value

        try {
            when(mockTokenFilter.includeNumber(validShortValue)).thenReturn(true);
            filteringGeneratorDelegate.writeNumber(validShortValue);
            verify(mockJsonGenerator).writeNumber(validShortValue);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withNullItemFilter() {
        filteringGeneratorDelegate._itemFilter = null; // Simulate null _itemFilter

        try {
            filteringGeneratorDelegate.writeNumber((short) 100);
            verify(mockJsonGenerator, never()).writeNumber(anyShort());
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withIncludeAllItemFilter() {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL; // Set _itemFilter to INCLUDE_ALL

        short validShortValue = 100; // A valid short value

        try {
            filteringGeneratorDelegate.writeNumber(validShortValue);
            verify(mockJsonGenerator).writeNumber(validShortValue);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withNonIncludedNumber() {
        short validShortValue = 100; // A valid short value

        try {
            when(mockTokenFilter.includeNumber(validShortValue)).thenReturn(false);
            filteringGeneratorDelegate.writeNumber(validShortValue);
            verify(mockJsonGenerator, never()).writeNumber(anyShort());
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}