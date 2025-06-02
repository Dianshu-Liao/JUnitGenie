package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;

class FilteringGeneratorDelegate_writeNumber_36_0_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private TokenFilterContext mockTokenFilterContext;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
    }

    @Test
    void testWriteNumber_ItemFilterIsNull() throws IOException {
        // Set item filter to null
        filteringGeneratorDelegate._itemFilter = null;
        // This should not throw an exception
        filteringGeneratorDelegate.writeNumber(5.0);
        // Verify that writeNumber was never called
        verify(mockJsonGenerator, never()).writeNumber(anyDouble());
    }

    @Test
    void testWriteNumber_ItemFilterIsIncludeAll() throws IOException {
        // Set item filter to INCLUDE_ALL
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        // Should call writeNumber on JsonGenerator
        filteringGeneratorDelegate.writeNumber(5.0);
        // Verify that writeNumber was called
        verify(mockJsonGenerator).writeNumber(5.0);
    }

    @Test
    void testWriteNumber_ItemFilterReturnsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        // Simulate checkValue returning null
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
        // Set the filter context
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        // This should not throw an exception
        filteringGeneratorDelegate.writeNumber(5.0);
        // Verify that writeNumber was never called
        verify(mockJsonGenerator, never()).writeNumber(anyDouble());
    }

    @Test
    void testWriteNumber_ItemFilterDoesNotIncludeNumber() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        // Simulate checkValue returning the item filter
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        // Simulate includeNumber returning false
        when(mockTokenFilter.includeNumber(5.0)).thenReturn(false);
        // Set the filter context
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        // This should not throw an exception
        filteringGeneratorDelegate.writeNumber(5.0);
        // Verify that writeNumber was never called
        verify(mockJsonGenerator, never()).writeNumber(anyDouble());
    }

    @Test
    void testWriteNumber_ItemFilterIncludesNumber() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        // Simulate checkValue returning the item filter
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        // Simulate includeNumber returning true
        when(mockTokenFilter.includeNumber(5.0)).thenReturn(true);
        // Set the filter context
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        // Should call writeNumber on JsonGenerator
        filteringGeneratorDelegate.writeNumber(5.0);
        // Verify that writeNumber was called
        verify(mockJsonGenerator).writeNumber(5.0);
    }
}
