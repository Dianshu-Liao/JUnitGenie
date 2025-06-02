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

public class FilteringGeneratorDelegate_writeNumber_33_0_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true);
    }

    @Test
    public void testWriteNumber_ItemFilterIsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = null;
        filteringGeneratorDelegate.writeNumber(5);
        verify(mockJsonGenerator, never()).writeNumber(anyInt());
    }

    @Test
    public void testWriteNumber_ItemFilterIsIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate.writeNumber(5);
        verify(mockJsonGenerator).writeNumber(5);
    }

    @Test
    public void testWriteNumber_ItemFilterDoesNotIncludeNumber() throws IOException {
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        when(filteringGeneratorDelegate._itemFilter.includeNumber(5)).thenReturn(false);
        filteringGeneratorDelegate.writeNumber(5);
        verify(mockJsonGenerator, never()).writeNumber(anyInt());
    }

    @Test
    public void testWriteNumber_ItemFilterIncludesNumber() throws IOException {
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        when(filteringGeneratorDelegate._itemFilter.includeNumber(5)).thenReturn(true);
        filteringGeneratorDelegate.writeNumber(5);
        verify(mockJsonGenerator).writeNumber(5);
    }
}
