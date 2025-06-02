package com.fasterxml.jackson.core.filter;

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

class FilteringGeneratorDelegate_writeStartObject_9_1_Test {

    private JsonGenerator mockGenerator;

    private TokenFilter mockFilter;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    void setUp() {
        mockGenerator = mock(JsonGenerator.class);
        mockFilter = mock(TokenFilter.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, TokenFilter.Inclusion.INCLUDE_NON_NULL, true);
    }

    @Test
    void testWriteStartObjectWithNullItemFilter() throws IOException {
        // Simulate null item filter
        filteringGeneratorDelegate._itemFilter = null;
        filteringGeneratorDelegate.writeStartObject();
        // Check that context is created
        assertNotNull(filteringGeneratorDelegate.getFilterContext());
    }

    @Test
    void testWriteStartObjectWithIncludeAll() throws IOException {
        // Set item filter to INCLUDE_ALL
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate.writeStartObject();
        // Verify that writeStartObject was called on the generator
        verify(mockGenerator).writeStartObject();
    }

    @Test
    void testWriteStartObjectWithFilteredItem() throws IOException {
        // Use mock filter
        filteringGeneratorDelegate._itemFilter = mockFilter;
        // Mock filter behavior
        when(mockFilter.filterStartObject()).thenReturn(TokenFilter.INCLUDE_ALL);
        filteringGeneratorDelegate.writeStartObject();
        // Verify that writeStartObject was called on the generator
        verify(mockGenerator).writeStartObject();
    }

    @Test
    void testWriteStartObjectWithFilteredOutItem() throws IOException {
        // Use mock filter
        filteringGeneratorDelegate._itemFilter = mockFilter;
        // Mock filter behavior to filter out
        when(mockFilter.filterStartObject()).thenReturn(null);
        filteringGeneratorDelegate.writeStartObject();
        // Check that context is not updated
        assertNull(filteringGeneratorDelegate.getFilterContext().getCurrentName());
    }
}
