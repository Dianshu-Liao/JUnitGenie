package com.fasterxml.jackson.core.filter;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;

public class FilteringGeneratorDelegate_writeString_19_0_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private TokenFilterContext mockTokenFilterContext;

    @BeforeEach
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
        // Set up the filter context
        when(mockTokenFilterContext.checkValue(any(TokenFilter.class))).thenReturn(mockTokenFilter);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test
    public void testWriteString_ItemFilterNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = null;
        filteringGeneratorDelegate.writeString(new StringReader("test"), 4);
        verify(mockJsonGenerator, never()).writeString(any(Reader.class), anyInt());
    }

    @Test
    public void testWriteString_ItemFilterIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate.writeString(new StringReader("test"), 4);
        verify(mockJsonGenerator).writeString(any(Reader.class), eq(4));
    }

    @Test
    public void testWriteString_ItemFilterDoesNotInclude() throws IOException {
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(any(TokenFilter.class))).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeString(any(Reader.class), anyInt())).thenReturn(false);
        filteringGeneratorDelegate.writeString(new StringReader("test"), 4);
        verify(mockJsonGenerator, never()).writeString(any(Reader.class), anyInt());
    }

    @Test
    public void testWriteString_ItemFilterIncludes() throws IOException {
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(any(TokenFilter.class))).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeString(any(Reader.class), anyInt())).thenReturn(true);
        filteringGeneratorDelegate.writeString(new StringReader("test"), 4);
        verify(mockJsonGenerator).writeString(any(Reader.class), eq(4));
    }

    @Test
    public void testWriteString_CheckParentPathCalled() throws IOException {
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(any(TokenFilter.class))).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeString(any(Reader.class), anyInt())).thenReturn(true);
        // Using reflection to invoke the private method
        filteringGeneratorDelegate.writeString(new StringReader("test"), 4);
        ArgumentCaptor<Reader> readerCaptor = ArgumentCaptor.forClass(Reader.class);
        verify(mockJsonGenerator).writeString(readerCaptor.capture(), eq(4));
        assertNotNull(readerCaptor.getValue());
    }
}
