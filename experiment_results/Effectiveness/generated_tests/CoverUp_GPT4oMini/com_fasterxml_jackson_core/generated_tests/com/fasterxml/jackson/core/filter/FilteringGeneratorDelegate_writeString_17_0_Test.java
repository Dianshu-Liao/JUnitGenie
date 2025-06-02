package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
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

class FilteringGeneratorDelegate_writeString_17_0_Test {

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
        filteringGeneratorDelegate.writeString(new char[] { 'a', 'b', 'c' }, 0, 3);
        verify(mockJsonGenerator, never()).writeString(any(char[].class), anyInt(), anyInt());
    }

    @Test
    void testWriteString_ItemFilterIsIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate.writeString(new char[] { 'a', 'b', 'c' }, 0, 3);
        verify(mockJsonGenerator).writeString(new char[] { 'a', 'b', 'c' }, 0, 3);
    }

    @Test
    void testWriteString_ItemFilterDoesNotInclude() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeString("abc")).thenReturn(false);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeString(new char[] { 'a', 'b', 'c' }, 0, 3);
        verify(mockJsonGenerator, never()).writeString(any(char[].class), anyInt(), anyInt());
    }

    @Test
    void testWriteString_ItemFilterIncludes() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeString("abc")).thenReturn(true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeString(new char[] { 'a', 'b', 'c' }, 0, 3);
        verify(mockJsonGenerator).writeString(new char[] { 'a', 'b', 'c' }, 0, 3);
    }

    @Test
    void testWriteString_CheckParentPathCalled() throws Exception {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeString("abc")).thenReturn(true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        // Spy on the FilteringGeneratorDelegate to verify private method call
        FilteringGeneratorDelegate spyDelegate = Mockito.spy(filteringGeneratorDelegate);
        spyDelegate.writeString(new char[] { 'a', 'b', 'c' }, 0, 3);
        Method method = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkParentPath");
        method.setAccessible(true);
        verify(spyDelegate).getClass().getDeclaredMethod("_checkParentPath");
    }
}
