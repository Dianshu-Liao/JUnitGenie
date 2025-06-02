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

class FilteringGeneratorDelegate_writeStartObject_11_0_Test {

    private JsonGenerator mockGenerator;

    private FilteringGeneratorDelegate filteringDelegate;

    private TokenFilter mockFilter;

    private TokenFilterContext mockContext;

    @BeforeEach
    void setUp() throws IOException {
        mockGenerator = mock(JsonGenerator.class);
        mockFilter = mock(TokenFilter.class);
        mockContext = mock(TokenFilterContext.class);
        when(mockContext.createChildObjectContext(any(), anyBoolean())).thenReturn(mockContext);
        when(mockContext.checkValue(any())).thenReturn(mockFilter);
        filteringDelegate = new FilteringGeneratorDelegate(mockGenerator, TokenFilter.INCLUDE_ALL, true, true);
        filteringDelegate._filterContext = mockContext;
    }

    @Test
    void testWriteStartObjectWithNullItemFilter() throws IOException {
        filteringDelegate._itemFilter = null;
        filteringDelegate.writeStartObject(new Object(), 0);
        verify(mockContext).createChildObjectContext(null, false);
    }

    @Test
    void testWriteStartObjectWithIncludeAllItemFilter() throws IOException {
        filteringDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        filteringDelegate.writeStartObject(new Object(), 0);
        verify(mockGenerator).writeStartObject(any(), anyInt());
        verify(mockContext).createChildObjectContext(TokenFilter.INCLUDE_ALL, true);
    }

    @Test
    void testWriteStartObjectWithFilteredItem() throws IOException {
        filteringDelegate._itemFilter = mockFilter;
        when(mockContext.checkValue(mockFilter)).thenReturn(mockFilter);
        filteringDelegate.writeStartObject(new Object(), 0);
        verify(mockFilter).filterStartObject();
        verify(mockContext).createChildObjectContext(mockFilter, false);
    }

    @Test
    void testWriteStartObjectWithNonMatchingFilter() throws IOException {
        filteringDelegate._itemFilter = mockFilter;
        when(mockContext.checkValue(mockFilter)).thenReturn(null);
        filteringDelegate.writeStartObject(new Object(), 0);
        verify(mockContext).createChildObjectContext(null, false);
    }
}
