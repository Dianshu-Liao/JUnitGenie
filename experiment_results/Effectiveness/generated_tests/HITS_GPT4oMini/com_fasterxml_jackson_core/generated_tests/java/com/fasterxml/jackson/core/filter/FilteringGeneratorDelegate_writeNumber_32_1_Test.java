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

public class FilteringGeneratorDelegate_writeNumber_32_1_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private TokenFilterContext mockTokenFilterContext;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        // Use mockTokenFilter directly instead of Inclusion.INCLUDE_ALL
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true);
    }

    @Test
    public void testWriteNumber_ItemFilterNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = null;
        filteringGeneratorDelegate.writeNumber((short) 5);
        verify(mockJsonGenerator, never()).writeNumber(anyShort());
    }

    @Test
    public void testWriteNumber_ItemFilterIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate.writeNumber((short) 5);
        verify(mockJsonGenerator).writeNumber((short) 5);
    }

    @Test
    public void testWriteNumber_ItemFilterNotIncludeAllAndStateNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(filteringGeneratorDelegate._itemFilter)).thenReturn(null);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeNumber((short) 5);
        verify(mockJsonGenerator, never()).writeNumber(anyShort());
    }

    @Test
    public void testWriteNumber_ItemFilterNotIncludeAllAndNotIncluded() throws IOException {
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(filteringGeneratorDelegate._itemFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(anyInt())).thenReturn(false);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeNumber((short) 5);
        verify(mockJsonGenerator, never()).writeNumber(anyShort());
    }

    @Test
    public void testWriteNumber_ItemFilterNotIncludeAllAndIncluded() throws IOException {
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(filteringGeneratorDelegate._itemFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(anyInt())).thenReturn(true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeNumber((short) 5);
        verify(mockJsonGenerator).writeNumber((short) 5);
    }
}
