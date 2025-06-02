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

public class FilteringGeneratorDelegate_writeNumber_32_0_Test {

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
    public void testWriteNumber_ItemFilterNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = null;
        filteringGeneratorDelegate.writeNumber((short) 5);
        verify(mockJsonGenerator, never()).writeNumber(anyShort());
    }

    @Test
    public void testWriteNumber_ItemFilterIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate.writeNumber((short) 5);
        verify(mockJsonGenerator).writeNumber((short) 5);
    }

    @Test
    public void testWriteNumber_ItemFilterCheckValueReturnsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeNumber((short) 5);
        verify(mockJsonGenerator, never()).writeNumber(anyShort());
    }

    @Test
    public void testWriteNumber_ItemFilterIncludeNumberFalse() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(anyInt())).thenReturn(false);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeNumber((short) 5);
        verify(mockJsonGenerator, never()).writeNumber(anyShort());
    }

    @Test
    public void testWriteNumber_ItemFilterIncludeNumberTrue() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(anyInt())).thenReturn(true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeNumber((short) 5);
        verify(mockJsonGenerator).writeNumber((short) 5);
    }

    @Test
    public void testWriteNumber_CheckParentPathCalled() throws Exception {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(anyInt())).thenReturn(true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        Method checkParentPathMethod = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkParentPath");
        checkParentPathMethod.setAccessible(true);
        filteringGeneratorDelegate.writeNumber((short) 5);
        verify(mockJsonGenerator).writeNumber((short) 5);
        checkParentPathMethod.invoke(filteringGeneratorDelegate);
    }
}
