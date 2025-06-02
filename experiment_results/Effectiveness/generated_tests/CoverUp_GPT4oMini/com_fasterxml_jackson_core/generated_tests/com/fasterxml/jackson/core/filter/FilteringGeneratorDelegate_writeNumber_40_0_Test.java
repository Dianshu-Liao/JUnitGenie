package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
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

class FilteringGeneratorDelegate_writeNumber_40_0_Test {

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
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test
    void testWriteNumber_ItemFilterIsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = null;
        filteringGeneratorDelegate.writeNumber(new char[] { '1' }, 0, 1);
        verify(mockJsonGenerator, never()).writeNumber(any(char[].class), anyInt(), anyInt());
    }

    @Test
    void testWriteNumber_ItemFilterIsIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate.writeNumber(new char[] { '1' }, 0, 1);
        verify(mockJsonGenerator).writeNumber(any(char[].class), anyInt(), anyInt());
    }

    @Test
    void testWriteNumber_ItemFilterCheckValueReturnsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
        filteringGeneratorDelegate.writeNumber(new char[] { '1' }, 0, 1);
        verify(mockJsonGenerator, never()).writeNumber(any(char[].class), anyInt(), anyInt());
    }

    @Test
    void testWriteNumber_ItemFilterCheckValueReturnsIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(TokenFilter.INCLUDE_ALL);
        filteringGeneratorDelegate.writeNumber(new char[] { '1' }, 0, 1);
        verify(mockJsonGenerator).writeNumber(any(char[].class), anyInt(), anyInt());
    }

    @Test
    void testWriteNumber_ItemFilterCheckValueIncludeRawValueFalse() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeRawValue()).thenReturn(false);
        filteringGeneratorDelegate.writeNumber(new char[] { '1' }, 0, 1);
        verify(mockJsonGenerator, never()).writeNumber(any(char[].class), anyInt(), anyInt());
    }

    @Test
    void testWriteNumber_ItemFilterCheckValueIncludeRawValueTrue() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeRawValue()).thenReturn(true);
        filteringGeneratorDelegate.writeNumber(new char[] { '1' }, 0, 1);
        verify(mockJsonGenerator).writeNumber(any(char[].class), anyInt(), anyInt());
    }

    @Test
    void testWriteNumber_CheckParentPath() throws Exception {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeRawValue()).thenReturn(true);
        Method checkParentPathMethod = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkParentPath");
        checkParentPathMethod.setAccessible(true);
        checkParentPathMethod.invoke(filteringGeneratorDelegate);
        filteringGeneratorDelegate.writeNumber(new char[] { '1' }, 0, 1);
        verify(mockJsonGenerator).writeNumber(any(char[].class), anyInt(), anyInt());
    }
}
