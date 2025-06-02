package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import java.io.IOException;
import java.math.BigDecimal;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;

public class FilteringGeneratorDelegate_writeNumber_38_0_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private TokenFilterContext mockTokenFilterContext;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
    }

    @Test
    public void testWriteNumber_ItemFilterIsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = null;
        filteringGeneratorDelegate.writeNumber(BigDecimal.ONE);
        verify(mockJsonGenerator, never()).writeNumber(any(BigDecimal.class));
    }

    @Test
    public void testWriteNumber_ItemFilterIsIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate.writeNumber(BigDecimal.ONE);
        verify(mockJsonGenerator).writeNumber(BigDecimal.ONE);
    }

    @Test
    public void testWriteNumber_ItemFilterCheckValueReturnsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeNumber(BigDecimal.ONE);
        verify(mockJsonGenerator, never()).writeNumber(any(BigDecimal.class));
    }

    @Test
    public void testWriteNumber_ItemFilterDoesNotIncludeNumber() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(any(BigDecimal.class))).thenReturn(false);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeNumber(BigDecimal.ONE);
        verify(mockJsonGenerator, never()).writeNumber(any(BigDecimal.class));
    }

    @Test
    public void testWriteNumber_ItemFilterIncludesNumber() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(any(BigDecimal.class))).thenReturn(true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeNumber(BigDecimal.ONE);
        verify(mockJsonGenerator).writeNumber(BigDecimal.ONE);
    }

    @Test
    public void testWriteNumber_CheckParentPathCalled() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(any(BigDecimal.class))).thenReturn(true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeNumber(BigDecimal.ONE);
        verify(mockJsonGenerator).writeNumber(BigDecimal.ONE);
        verify(filteringGeneratorDelegate, times(1))._checkParentPath();
    }
}
