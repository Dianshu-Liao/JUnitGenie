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

public class FilteringGeneratorDelegate_writeStartObject_9_0_Test {

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
    public void testWriteStartObject_ItemFilterIsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = null;
        when(mockFilterContext.createChildObjectContext(any(), anyBoolean())).thenReturn(mockFilterContext);
        filteringGeneratorDelegate.writeStartObject();
        verify(mockFilterContext).createChildObjectContext(null, false);
    }

    @Test
    public void testWriteStartObject_ItemFilterIsIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        when(mockFilterContext.createChildObjectContext(any(), anyBoolean())).thenReturn(mockFilterContext);
        filteringGeneratorDelegate.writeStartObject();
        verify(mockFilterContext).createChildObjectContext(TokenFilter.INCLUDE_ALL, true);
        verify(mockJsonGenerator).writeStartObject();
    }

    @Test
    public void testWriteStartObject_ItemFilterIsNotNullAndCheckValueReturnsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
        when(mockFilterContext.createChildObjectContext(any(), anyBoolean())).thenReturn(mockFilterContext);
        filteringGeneratorDelegate.writeStartObject();
        verify(mockFilterContext).checkValue(mockTokenFilter);
        verify(mockFilterContext).createChildObjectContext(null, false);
    }

    @Test
    public void testWriteStartObject_ItemFilterIsNotNullAndCheckValueReturnsFilter() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        TokenFilter returnedFilter = mock(TokenFilter.class);
        when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(returnedFilter);
        when(returnedFilter.filterStartObject()).thenReturn(returnedFilter);
        when(mockFilterContext.createChildObjectContext(any(), anyBoolean())).thenReturn(mockFilterContext);
        filteringGeneratorDelegate.writeStartObject();
        verify(mockFilterContext).checkValue(mockTokenFilter);
        verify(returnedFilter).filterStartObject();
        verify(mockFilterContext).createChildObjectContext(returnedFilter, true);
        verify(mockJsonGenerator).writeStartObject();
    }

    @Test
    public void testWriteStartObject_FilterOut() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        TokenFilter returnedFilter = mock(TokenFilter.class);
        when(mockFilterContext.checkValue(mockTokenFilter)).thenReturn(returnedFilter);
        when(returnedFilter.filterStartObject()).thenReturn(null);
        when(mockFilterContext.createChildObjectContext(any(), anyBoolean())).thenReturn(mockFilterContext);
        filteringGeneratorDelegate.writeStartObject();
        verify(mockFilterContext).createChildObjectContext(returnedFilter, false);
    }
}
