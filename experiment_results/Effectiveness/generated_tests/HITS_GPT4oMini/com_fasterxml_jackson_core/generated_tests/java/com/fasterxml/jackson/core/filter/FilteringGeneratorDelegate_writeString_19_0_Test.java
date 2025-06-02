package com.fasterxml.jackson.core.filter;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;

public class FilteringGeneratorDelegate_writeString_19_0_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private TokenFilterContext mockTokenFilterContext;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true);
    }

    @Test
    public void testWriteString_withNullItemFilter() throws IOException {
        filteringGeneratorDelegate._itemFilter = null;
        filteringGeneratorDelegate.writeString(new StringReader("test"), 4);
        verify(mockJsonGenerator, never()).writeString(any(Reader.class), anyInt());
    }

    @Test
    public void testWriteString_withIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate.writeString(new StringReader("test"), 4);
        verify(mockJsonGenerator, times(1)).writeString(any(Reader.class), anyInt());
    }

    @Test
    public void testWriteString_withFilteredItem() throws IOException {
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeString(any(Reader.class), anyInt())).thenReturn(true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeString(new StringReader("test"), 4);
        verify(mockJsonGenerator, times(1)).writeString(any(Reader.class), anyInt());
    }

    @Test
    public void testWriteString_withFilteredItem_exclude() throws IOException {
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeString(any(Reader.class), anyInt())).thenReturn(false);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeString(new StringReader("test"), 4);
        verify(mockJsonGenerator, never()).writeString(any(Reader.class), anyInt());
    }

    @Test
    public void testWriteString_withNullState() throws IOException {
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeString(new StringReader("test"), 4);
        verify(mockJsonGenerator, never()).writeString(any(Reader.class), anyInt());
    }

    @Test
    public void testWriteString_withValidState() throws IOException {
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeString(any(Reader.class), anyInt())).thenReturn(true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeString(new StringReader("test"), 4);
        verify(mockJsonGenerator, times(1)).writeString(any(Reader.class), anyInt());
    }
}
