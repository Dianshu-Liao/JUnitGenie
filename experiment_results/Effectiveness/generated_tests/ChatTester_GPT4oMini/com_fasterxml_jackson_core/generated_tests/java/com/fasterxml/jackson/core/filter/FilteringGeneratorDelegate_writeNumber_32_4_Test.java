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

class FilteringGeneratorDelegate_writeNumber_32_4_Test {

    private JsonGenerator mockJsonGenerator;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, null, true, true);
    }

    @Test
    void testWriteNumber_ItemFilterIsNull() throws IOException {
        filteringGeneratorDelegate.writeNumber((short) 5);
        verify(mockJsonGenerator, never()).writeNumber(anyShort());
    }

    @Test
    void testWriteNumber_ItemFilterIsNotIncludeAll() throws IOException {
        TokenFilter mockItemFilter = mock(TokenFilter.class);
        TokenFilterContext mockFilterContext = mock(TokenFilterContext.class);
        when(mockItemFilter).thenReturn(mockItemFilter);
        filteringGeneratorDelegate._itemFilter = mockItemFilter;
        filteringGeneratorDelegate._filterContext = mockFilterContext;
        when(mockFilterContext.checkValue(mockItemFilter)).thenReturn(null);
        filteringGeneratorDelegate.writeNumber((short) 5);
        verify(mockJsonGenerator, never()).writeNumber(anyShort());
    }

    @Test
    void testWriteNumber_StateIsNotIncludeAllAndDoesNotIncludeNumber() throws IOException {
        TokenFilter mockItemFilter = mock(TokenFilter.class);
        TokenFilterContext mockFilterContext = mock(TokenFilterContext.class);
        TokenFilter mockState = mock(TokenFilter.class);
        when(mockItemFilter).thenReturn(mockItemFilter);
        filteringGeneratorDelegate._itemFilter = mockItemFilter;
        filteringGeneratorDelegate._filterContext = mockFilterContext;
        when(mockFilterContext.checkValue(mockItemFilter)).thenReturn(mockState);
        when(mockState.includeNumber((short) 5)).thenReturn(false);
        filteringGeneratorDelegate.writeNumber((short) 5);
        verify(mockJsonGenerator, never()).writeNumber(anyShort());
    }

    @Test
    void testWriteNumber_StateIncludesNumber() throws IOException {
        TokenFilter mockItemFilter = mock(TokenFilter.class);
        TokenFilterContext mockFilterContext = mock(TokenFilterContext.class);
        TokenFilter mockState = mock(TokenFilter.class);
        when(mockItemFilter).thenReturn(mockItemFilter);
        filteringGeneratorDelegate._itemFilter = mockItemFilter;
        filteringGeneratorDelegate._filterContext = mockFilterContext;
        when(mockFilterContext.checkValue(mockItemFilter)).thenReturn(mockState);
        when(mockState.includeNumber((short) 5)).thenReturn(true);
        filteringGeneratorDelegate.writeNumber((short) 5);
        verify(mockJsonGenerator, times(1)).writeNumber((short) 5);
    }

    @Test
    void testWriteNumber_ThrowsIOException() throws IOException {
        TokenFilter mockItemFilter = mock(TokenFilter.class);
        TokenFilterContext mockFilterContext = mock(TokenFilterContext.class);
        TokenFilter mockState = mock(TokenFilter.class);
        when(mockItemFilter).thenReturn(mockItemFilter);
        filteringGeneratorDelegate._itemFilter = mockItemFilter;
        filteringGeneratorDelegate._filterContext = mockFilterContext;
        when(mockFilterContext.checkValue(mockItemFilter)).thenReturn(mockState);
        when(mockState.includeNumber((short) 5)).thenReturn(true);
        doThrow(new IOException("Test Exception")).when(mockJsonGenerator).writeNumber((short) 5);
        assertThrows(IOException.class, () -> filteringGeneratorDelegate.writeNumber((short) 5));
    }
}
