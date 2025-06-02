package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import java.io.IOException;
import java.math.BigDecimal;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

class FilteringGeneratorDelegate_writeNumber_38_1_Test {

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
    void testWriteNumber_ItemFilterNull() throws Exception {
        filteringGeneratorDelegate._itemFilter = null;
        invokeWriteNumber(BigDecimal.TEN);
        verify(mockJsonGenerator, never()).writeNumber(any(BigDecimal.class));
    }

    @Test
    void testWriteNumber_ItemFilterIncludeAll() throws Exception {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        invokeWriteNumber(BigDecimal.TEN);
        verify(mockJsonGenerator).writeNumber(BigDecimal.TEN);
    }

    @Test
    void testWriteNumber_ItemFilterCheckValueReturnsNull() throws Exception {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
        invokeWriteNumber(BigDecimal.TEN);
        verify(mockJsonGenerator, never()).writeNumber(any(BigDecimal.class));
    }

    @Test
    void testWriteNumber_ItemFilterIncludeAllWithCheckValue() throws Exception {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(TokenFilter.INCLUDE_ALL);
        invokeWriteNumber(BigDecimal.TEN);
        verify(mockJsonGenerator).writeNumber(BigDecimal.TEN);
    }

    @Test
    void testWriteNumber_ItemFilterIncludeNumberReturnsFalse() throws Exception {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(any(BigDecimal.class))).thenReturn(false);
        invokeWriteNumber(BigDecimal.TEN);
        verify(mockJsonGenerator, never()).writeNumber(any(BigDecimal.class));
    }

    @Test
    void testWriteNumber_ItemFilterIncludeNumberReturnsTrue() throws Exception {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(any(BigDecimal.class))).thenReturn(true);
        invokeWriteNumber(BigDecimal.TEN);
        verify(mockJsonGenerator).writeNumber(BigDecimal.TEN);
    }

    @Test
    void testWriteNumber_CheckParentPathCalled() throws Exception {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(any(BigDecimal.class))).thenReturn(true);
        invokeWriteNumber(BigDecimal.TEN);
        verify(filteringGeneratorDelegate, times(1))._checkParentPath();
    }

    private void invokeWriteNumber(BigDecimal value) throws Exception {
        Method method = FilteringGeneratorDelegate.class.getDeclaredMethod("writeNumber", BigDecimal.class);
        method.setAccessible(true);
        method.invoke(filteringGeneratorDelegate, value);
    }
}
