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

public class FilteringGeneratorDelegate_writeNumber_39_0_Test {

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
    }

    @Test
    public void testWriteNumber_ItemFilterIsNull() throws IOException {
        // Set item filter to null
        filteringGeneratorDelegate._itemFilter = null;
        filteringGeneratorDelegate.writeNumber("123");
        // Should not call writeNumber
        verify(mockJsonGenerator, never()).writeNumber(anyString());
    }

    @Test
    public void testWriteNumber_ItemFilterIsIncludeAll() throws IOException {
        // Set item filter to INCLUDE_ALL
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate.writeNumber("123");
        // Should call writeNumber
        verify(mockJsonGenerator).writeNumber("123");
    }

    @Test
    public void testWriteNumber_ItemFilterCheckValueReturnsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeNumber("123");
        // Should not call writeNumber
        verify(mockJsonGenerator, never()).writeNumber(anyString());
    }

    @Test
    public void testWriteNumber_ItemFilterCheckValueDoesNotIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeRawValue()).thenReturn(false);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeNumber("123");
        // Should not call writeNumber
        verify(mockJsonGenerator, never()).writeNumber(anyString());
    }

    @Test
    public void testWriteNumber_ItemFilterCheckValueIncludesRawValue() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeRawValue()).thenReturn(true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate.writeNumber("123");
        // Should call writeNumber
        verify(mockJsonGenerator).writeNumber("123");
    }

    @Test
    public void testWriteNumber_CheckParentPathCalled() throws Exception {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeRawValue()).thenReturn(true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        Method checkParentPathMethod = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkParentPath");
        checkParentPathMethod.setAccessible(true);
        filteringGeneratorDelegate.writeNumber("123");
        // Should call writeNumber
        verify(mockJsonGenerator).writeNumber("123");
    }
}
