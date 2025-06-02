package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
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

class FilteringGeneratorDelegate_writeString_16_3_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private TokenFilterContext mockTokenFilterContext;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    void setUp() {
        mockJsonGenerator = Mockito.mock(JsonGenerator.class);
        mockTokenFilter = Mockito.mock(TokenFilter.class);
        mockTokenFilterContext = Mockito.mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
    }

    @Test
    void testWriteString_ItemFilterIsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = null;
        filteringGeneratorDelegate.writeString("test");
        verify(mockJsonGenerator, never()).writeString(anyString());
    }

    @Test
    void testWriteString_ItemFilterIsIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate.writeString("test");
        verify(mockJsonGenerator).writeString("test");
    }

    @Test
    void testWriteString_ItemFilterCheckValueReturnsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeString("test");
        verify(mockJsonGenerator, never()).writeString(anyString());
    }

    @Test
    void testWriteString_ItemFilterCheckValueReturnsIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(TokenFilter.INCLUDE_ALL);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeString("test");
        verify(mockJsonGenerator).writeString("test");
    }

    @Test
    void testWriteString_ItemFilterCheckValueReturnsNotIncludeAllAndDoesNotIncludeString() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeString("test")).thenReturn(false);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeString("test");
        verify(mockJsonGenerator, never()).writeString(anyString());
    }

    @Test
    void testWriteString_ItemFilterCheckValueReturnsNotIncludeAllAndIncludesString() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeString("test")).thenReturn(true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeString("test");
        verify(mockJsonGenerator).writeString("test");
    }

    @Test
    void testWriteString_CheckParentPathCalled() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeString("test")).thenReturn(true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeString("test");
        verify(mockJsonGenerator).writeString("test");
        verify(filteringGeneratorDelegate, times(1))._checkParentPath();
    }
}
