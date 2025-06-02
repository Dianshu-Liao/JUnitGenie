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

public class FilteringGeneratorDelegate_writeString_16_0_Test {

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
    public void testWriteStringWithNullItemFilter() throws IOException {
        filteringGeneratorDelegate._itemFilter = null;
        filteringGeneratorDelegate.writeString("test");
        verify(mockJsonGenerator, never()).writeString(anyString());
    }

    @Test
    public void testWriteStringWithIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate.writeString("test");
        verify(mockJsonGenerator).writeString("test");
    }

    @Test
    public void testWriteStringWithExcludedValue() throws IOException {
        when(mockTokenFilter.includeString("test")).thenReturn(false);
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        filteringGeneratorDelegate.writeString("test");
        verify(mockJsonGenerator, never()).writeString(anyString());
    }

    @Test
    public void testWriteStringWithIncludedValue() throws IOException {
        when(mockTokenFilter.includeString("test")).thenReturn(true);
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        filteringGeneratorDelegate.writeString("test");
        verify(mockJsonGenerator).writeString("test");
    }
}
