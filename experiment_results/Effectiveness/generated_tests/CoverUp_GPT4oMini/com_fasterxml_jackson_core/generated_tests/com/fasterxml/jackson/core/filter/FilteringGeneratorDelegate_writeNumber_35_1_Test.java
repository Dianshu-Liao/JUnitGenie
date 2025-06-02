package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import java.io.IOException;
import java.math.BigInteger;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;

class FilteringGeneratorDelegate_writeNumber_35_1_Test {

    private FilteringGeneratorDelegate delegate;

    private JsonGenerator jsonGeneratorMock;

    private TokenFilter tokenFilterMock;

    private TokenFilterContext filterContextMock;

    @BeforeEach
    void setUp() {
        jsonGeneratorMock = mock(JsonGenerator.class);
        tokenFilterMock = mock(TokenFilter.class);
        filterContextMock = mock(TokenFilterContext.class);
        delegate = new FilteringGeneratorDelegate(jsonGeneratorMock, tokenFilterMock, true, true);
        delegate._filterContext = filterContextMock;
    }

    @Test
    void testWriteNumber_ItemFilterNull() throws IOException {
        delegate._itemFilter = null;
        delegate.writeNumber(BigInteger.ONE);
        verify(jsonGeneratorMock, never()).writeNumber(any(BigInteger.class));
    }

    @Test
    void testWriteNumber_ItemFilterIncludeAll() throws IOException {
        delegate._itemFilter = TokenFilter.INCLUDE_ALL;
        delegate.writeNumber(BigInteger.ONE);
        verify(jsonGeneratorMock).writeNumber(BigInteger.ONE);
    }

    @Test
    void testWriteNumber_ItemFilterNotIncludeAll() throws IOException {
        delegate._itemFilter = tokenFilterMock;
        when(filterContextMock.checkValue(tokenFilterMock)).thenReturn(tokenFilterMock);
        when(tokenFilterMock.includeNumber(any(BigInteger.class))).thenReturn(true);
        delegate.writeNumber(BigInteger.ONE);
        verify(jsonGeneratorMock).writeNumber(BigInteger.ONE);
    }

    @Test
    void testWriteNumber_ItemFilterNotIncluded() throws IOException {
        delegate._itemFilter = tokenFilterMock;
        when(filterContextMock.checkValue(tokenFilterMock)).thenReturn(tokenFilterMock);
        when(tokenFilterMock.includeNumber(any(BigInteger.class))).thenReturn(false);
        delegate.writeNumber(BigInteger.ONE);
        verify(jsonGeneratorMock, never()).writeNumber(any(BigInteger.class));
    }

    @Test
    void testWriteNumber_CheckValueReturnsNull() throws IOException {
        delegate._itemFilter = tokenFilterMock;
        when(filterContextMock.checkValue(tokenFilterMock)).thenReturn(null);
        delegate.writeNumber(BigInteger.ONE);
        verify(jsonGeneratorMock, never()).writeNumber(any(BigInteger.class));
    }

    @Test
    void testWriteNumber_CheckValueReturnsNonIncludeAll() throws IOException {
        delegate._itemFilter = tokenFilterMock;
        when(filterContextMock.checkValue(tokenFilterMock)).thenReturn(tokenFilterMock);
        when(tokenFilterMock.includeNumber(any(BigInteger.class))).thenReturn(true);
        delegate.writeNumber(BigInteger.ONE);
        verify(jsonGeneratorMock).writeNumber(BigInteger.ONE);
    }

    @Test
    void testWriteNumber_WithParentPathCheck() throws Exception {
        delegate._itemFilter = tokenFilterMock;
        when(filterContextMock.checkValue(tokenFilterMock)).thenReturn(tokenFilterMock);
        when(tokenFilterMock.includeNumber(any(BigInteger.class))).thenReturn(true);
        // Use reflection to invoke the private method _checkParentPath
        delegate.getClass().getDeclaredMethod("_checkParentPath").invoke(delegate);
        delegate.writeNumber(BigInteger.ONE);
        verify(jsonGeneratorMock).writeNumber(BigInteger.ONE);
    }
}
