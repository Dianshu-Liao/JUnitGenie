package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import java.io.IOException;
import java.io.StringWriter;
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

class FilteringGeneratorDelegate_writeNumber_34_0_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private TokenFilterContext mockTokenFilterContext;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
    }

    @Test
    void testWriteNumber_ItemFilterNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = null;
        filteringGeneratorDelegate.writeNumber(123L);
        verify(mockJsonGenerator, never()).writeNumber(anyLong());
    }

    @Test
    void testWriteNumber_ItemFilterIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate.writeNumber(123L);
        verify(mockJsonGenerator).writeNumber(123L);
    }

    @Test
    void testWriteNumber_ItemFilterNotIncludeAll_StateNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(any())).thenReturn(null);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeNumber(123L);
        verify(mockJsonGenerator, never()).writeNumber(anyLong());
    }

    @Test
    void testWriteNumber_ItemFilterNotIncludeAll_StateNotIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        TokenFilter state = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(any())).thenReturn(state);
        when(state != TokenFilter.INCLUDE_ALL).thenReturn(true);
        when(state.includeNumber(123L)).thenReturn(false);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeNumber(123L);
        verify(mockJsonGenerator, never()).writeNumber(anyLong());
    }

    @Test
    void testWriteNumber_ItemFilterNotIncludeAll_StateIncludeNumber() throws IOException {
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        TokenFilter state = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(any())).thenReturn(state);
        when(state != TokenFilter.INCLUDE_ALL).thenReturn(true);
        when(state.includeNumber(123L)).thenReturn(true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeNumber(123L);
        verify(mockJsonGenerator).writeNumber(123L);
    }

    @Test
    void testWriteNumber_CheckParentPathCalled() throws IOException {
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        TokenFilter state = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(any())).thenReturn(state);
        when(state.includeNumber(123L)).thenReturn(true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeNumber(123L);
        verify(filteringGeneratorDelegate, times(1))._checkParentPath();
    }

    // Use reflection to test private method _checkParentPath
    @Test
    void testCheckParentPath() throws Exception {
        filteringGeneratorDelegate.getClass().getDeclaredMethod("_checkParentPath").setAccessible(true);
        filteringGeneratorDelegate._checkParentPath();
        // Add assertions if necessary, depending on the implementation
    }
}
