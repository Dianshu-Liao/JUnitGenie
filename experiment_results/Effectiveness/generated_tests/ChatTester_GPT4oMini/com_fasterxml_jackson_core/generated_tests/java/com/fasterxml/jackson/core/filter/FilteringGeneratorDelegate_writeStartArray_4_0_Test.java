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

public class FilteringGeneratorDelegate_writeStartArray_4_0_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private TokenFilterContext mockFilterContext;

    @BeforeEach
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, TokenFilter.Inclusion.INCLUDE_NON_NULL, true);
        filteringGeneratorDelegate._filterContext = mockFilterContext;
    }

    @Test
    public void testWriteStartArray_ItemFilterIsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = null;
        filteringGeneratorDelegate.writeStartArray();
        verify(mockFilterContext).createChildArrayContext(null, false);
        verifyNoMoreInteractions(mockJsonGenerator);
    }

    @Test
    public void testWriteStartArray_ItemFilterIsIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate.writeStartArray();
        verify(mockFilterContext).createChildArrayContext(filteringGeneratorDelegate._itemFilter, true);
        verify(mockJsonGenerator).writeStartArray();
    }

    @Test
    public void testWriteStartArray_ItemFilterIsNotIncludeAllAndCheckValueReturnsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
        filteringGeneratorDelegate.writeStartArray();
        verify(mockFilterContext).createChildArrayContext(null, false);
        verifyNoMoreInteractions(mockJsonGenerator);
    }

    @Test
    public void testWriteStartArray_ItemFilterIsNotIncludeAllAndCheckValueReturnsAnotherFilter() throws IOException {
        TokenFilter anotherFilter = mock(TokenFilter.class);
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(anotherFilter);
        when(anotherFilter.filterStartArray()).thenReturn(anotherFilter);
        filteringGeneratorDelegate.writeStartArray();
        verify(mockFilterContext).createChildArrayContext(anotherFilter, true);
        verify(mockJsonGenerator).writeStartArray();
    }

    @Test
    public void testWriteStartArray_ItemFilterIsNotIncludeAllAndInclusionIsIncludeNonNull() throws IOException {
        TokenFilter anotherFilter = mock(TokenFilter.class);
        filteringGeneratorDelegate._itemFilter = anotherFilter;
        when(mockFilterContext.checkValue(anotherFilter)).thenReturn(anotherFilter);
        when(anotherFilter.filterStartArray()).thenReturn(null);
        filteringGeneratorDelegate.writeStartArray();
        verify(mockFilterContext).createChildArrayContext(anotherFilter, false);
        verifyNoMoreInteractions(mockJsonGenerator);
    }

    @Test
    public void testWriteStartArray_ItemFilterIsNotIncludeAllAndInclusionIsIncludeNonNullAndFilterReturnsAnotherFilter() throws IOException {
        TokenFilter anotherFilter = mock(TokenFilter.class);
        filteringGeneratorDelegate._itemFilter = anotherFilter;
        when(mockFilterContext.checkValue(anotherFilter)).thenReturn(anotherFilter);
        when(anotherFilter.filterStartArray()).thenReturn(TokenFilter.INCLUDE_ALL);
        filteringGeneratorDelegate.writeStartArray();
        verify(mockFilterContext).createChildArrayContext(anotherFilter, true);
        verify(mockJsonGenerator).writeStartArray();
    }
}
