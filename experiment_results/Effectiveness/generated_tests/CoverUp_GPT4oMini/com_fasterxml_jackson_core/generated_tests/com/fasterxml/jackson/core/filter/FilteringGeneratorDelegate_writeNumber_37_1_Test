package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import java.io.IOException;
import java.lang.reflect.Method;
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

class FilteringGeneratorDelegate_writeNumber_37_1_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private TokenFilterContext mockTokenFilterContext;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test
    void testWriteNumber_ItemFilterNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = null;
        filteringGeneratorDelegate.writeNumber(1.0f);
        verify(mockJsonGenerator, never()).writeNumber(anyFloat());
    }

    @Test
    void testWriteNumber_ItemFilterIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate.writeNumber(1.0f);
        verify(mockJsonGenerator).writeNumber(1.0f);
    }

    @Test
    void testWriteNumber_ItemFilterDoesNotIncludeNumber() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(anyFloat())).thenReturn(false);
        filteringGeneratorDelegate.writeNumber(1.0f);
        verify(mockJsonGenerator, never()).writeNumber(anyFloat());
    }

    @Test
    void testWriteNumber_ItemFilterIncludesNumber() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(anyFloat())).thenReturn(true);
        filteringGeneratorDelegate.writeNumber(1.0f);
        verify(mockJsonGenerator).writeNumber(1.0f);
    }

    @Test
    void testWriteNumber_CheckParentPathCalled() throws Exception {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(anyFloat())).thenReturn(true);
        Method checkParentPathMethod = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkParentPath");
        checkParentPathMethod.setAccessible(true);
        filteringGeneratorDelegate.writeNumber(1.0f);
        verify(filteringGeneratorDelegate, times(1))._checkParentPath();
    }

    @Test
    void testWriteNumber_ItemFilterReturnsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
        filteringGeneratorDelegate.writeNumber(1.0f);
        verify(mockJsonGenerator, never()).writeNumber(anyFloat());
    }
}
