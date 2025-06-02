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

public class FilteringGeneratorDelegate_writeNumber_37_2_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private TokenFilterContext mockTokenFilterContext;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test
    public void testWriteNumber_itemFilterIsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = null;
        filteringGeneratorDelegate.writeNumber(1.0f);
        verify(mockJsonGenerator, never()).writeNumber(anyFloat());
    }

    @Test
    public void testWriteNumber_itemFilterIsIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate.writeNumber(1.0f);
        verify(mockJsonGenerator).writeNumber(1.0f);
    }

    @Test
    public void testWriteNumber_itemFilterCheckValueReturnsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(filteringGeneratorDelegate._itemFilter)).thenReturn(null);
        filteringGeneratorDelegate.writeNumber(1.0f);
        verify(mockJsonGenerator, never()).writeNumber(anyFloat());
    }

    @Test
    public void testWriteNumber_itemFilterDoesNotIncludeNumber() throws IOException {
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(filteringGeneratorDelegate._itemFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(anyFloat())).thenReturn(false);
        filteringGeneratorDelegate.writeNumber(1.0f);
        verify(mockJsonGenerator, never()).writeNumber(anyFloat());
    }

    @Test
    public void testWriteNumber_itemFilterIncludesNumber() throws IOException {
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(filteringGeneratorDelegate._itemFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(anyFloat())).thenReturn(true);
        filteringGeneratorDelegate.writeNumber(1.0f);
        verify(mockJsonGenerator).writeNumber(1.0f);
    }

    @Test
    public void testWriteNumber_checkParentPathCalled() throws IOException {
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(filteringGeneratorDelegate._itemFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(anyFloat())).thenReturn(true);
        filteringGeneratorDelegate.writeNumber(1.0f);
        verify(filteringGeneratorDelegate, times(1))._checkParentPath();
    }
}
