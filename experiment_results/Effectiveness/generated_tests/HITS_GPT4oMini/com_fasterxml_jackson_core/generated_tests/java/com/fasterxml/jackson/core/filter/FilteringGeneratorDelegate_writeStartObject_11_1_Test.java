package com.fasterxml.jackson.core.filter;

import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;

public class FilteringGeneratorDelegate_writeStartObject_11_1_Test {

    private JsonGenerator mockGenerator;

    private TokenFilter mockFilter;

    private FilteringGeneratorDelegate delegate;

    @BeforeEach
    public void setUp() {
        mockGenerator = mock(JsonGenerator.class);
        mockFilter = mock(TokenFilter.class);
        // Fix the constructor call to use TokenFilter.INCLUDE_ALL
        delegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true);
    }

    @Test
    public void testWriteStartObject_WithNullItemFilter() throws IOException {
        // Simulate null item filter
        delegate._itemFilter = null;
        delegate.writeStartObject(new Object(), 0);
        // Check that filter context is created
        assertNotNull(delegate._filterContext);
    }

    @Test
    public void testWriteStartObject_WithIncludeAll() throws IOException {
        // Simulate INCLUDE_ALL filter
        delegate._itemFilter = TokenFilter.INCLUDE_ALL;
        delegate.writeStartObject(new Object(), 0);
        // Verify generator method called
        verify(mockGenerator).writeStartObject(any(), anyInt());
    }

    @Test
    public void testWriteStartObject_WithFilteredValue() throws IOException {
        when(mockFilter.filterStartObject()).thenReturn(TokenFilter.INCLUDE_ALL);
        // Simulate a filter
        delegate._itemFilter = mockFilter;
        delegate.writeStartObject(new Object(), 0);
        // Verify generator method called
        verify(mockGenerator).writeStartObject(any(), anyInt());
    }

    @Test
    public void testWriteStartObject_WithNoMatch() throws IOException {
        when(mockFilter.filterStartObject()).thenReturn(null);
        // Simulate a filter with no match
        delegate._itemFilter = mockFilter;
        delegate.writeStartObject(new Object(), 0);
        // Check that filter context is still valid
        assertNotNull(delegate._filterContext);
    }
}
