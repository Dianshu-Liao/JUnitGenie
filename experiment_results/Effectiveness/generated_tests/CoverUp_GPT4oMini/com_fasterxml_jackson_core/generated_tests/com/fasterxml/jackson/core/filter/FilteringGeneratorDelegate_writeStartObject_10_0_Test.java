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

class FilteringGeneratorDelegate_writeStartObject_10_0_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private TokenFilterContext mockTokenFilterContext;

    @BeforeEach
    void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, TokenFilter.Inclusion.INCLUDE_NON_NULL, true);
        // Set the filter context to a mocked context
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test
    void testWriteStartObject_ItemFilterNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = null;
        filteringGeneratorDelegate.writeStartObject(new Object());
        verify(mockTokenFilterContext).createChildObjectContext(null, false);
    }

    @Test
    void testWriteStartObject_ItemFilterIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate.writeStartObject(new Object());
        verify(mockTokenFilterContext).createChildObjectContext(filteringGeneratorDelegate._itemFilter, true);
        verify(mockJsonGenerator).writeStartObject(any());
    }

    @Test
    void testWriteStartObject_ItemFilterCheckValueReturnsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
        filteringGeneratorDelegate.writeStartObject(new Object());
        verify(mockTokenFilterContext).createChildObjectContext(null, false);
    }

    @Test
    void testWriteStartObject_ItemFilterCheckValueReturnsIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(TokenFilter.INCLUDE_ALL);
        filteringGeneratorDelegate.writeStartObject(new Object());
        verify(mockTokenFilterContext).createChildObjectContext(TokenFilter.INCLUDE_ALL, true);
        verify(mockJsonGenerator).writeStartObject(any());
    }

    @Test
    void testWriteStartObject_ItemFilterCheckValueReturnsNonNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.filterStartObject()).thenReturn(mockTokenFilter);
        filteringGeneratorDelegate.writeStartObject(new Object());
        verify(mockTokenFilterContext).createChildObjectContext(mockTokenFilter, true);
        verify(mockJsonGenerator).writeStartObject(any());
    }

    @Test
    void testWriteStartObject_FilterOut() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.filterStartObject()).thenReturn(null);
        filteringGeneratorDelegate.writeStartObject(new Object());
        verify(mockTokenFilterContext).createChildObjectContext(mockTokenFilter, false);
    }
}
