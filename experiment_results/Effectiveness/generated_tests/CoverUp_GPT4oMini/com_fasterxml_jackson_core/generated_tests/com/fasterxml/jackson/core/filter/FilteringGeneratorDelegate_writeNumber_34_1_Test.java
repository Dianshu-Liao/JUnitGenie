package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import java.io.IOException;
import static org.mockito.ArgumentMatchers.anyLong;
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

class FilteringGeneratorDelegate_writeNumber_34_1_Test {

    private FilteringGeneratorDelegate delegate;

    private JsonGenerator jsonGeneratorMock;

    private TokenFilter tokenFilterMock;

    private TokenFilterContext tokenFilterContextMock;

    @BeforeEach
    void setUp() {
        jsonGeneratorMock = mock(JsonGenerator.class);
        tokenFilterMock = mock(TokenFilter.class);
        tokenFilterContextMock = mock(TokenFilterContext.class);
        delegate = new FilteringGeneratorDelegate(jsonGeneratorMock, tokenFilterMock, true, false);
        delegate._filterContext = tokenFilterContextMock;
    }

    @Test
    void testWriteNumber_ItemFilterNull() throws IOException {
        delegate._itemFilter = null;
        delegate.writeNumber(123L);
        verify(jsonGeneratorMock, never()).writeNumber(anyLong());
    }

    @Test
    void testWriteNumber_ItemFilterNotIncludeAll() throws IOException {
        when(tokenFilterMock).thenReturn(tokenFilterMock);
        delegate._itemFilter = tokenFilterMock;
        when(tokenFilterContextMock.checkValue(tokenFilterMock)).thenReturn(null);
        delegate.writeNumber(123L);
        verify(jsonGeneratorMock, never()).writeNumber(anyLong());
    }

    @Test
    void testWriteNumber_ItemFilterDoesNotIncludeNumber() throws IOException {
        delegate._itemFilter = tokenFilterMock;
        when(tokenFilterContextMock.checkValue(tokenFilterMock)).thenReturn(tokenFilterMock);
        when(tokenFilterMock.includeNumber(123L)).thenReturn(false);
        delegate.writeNumber(123L);
        verify(jsonGeneratorMock, never()).writeNumber(anyLong());
    }

    @Test
    void testWriteNumber_ItemFilterIncludesNumber() throws IOException {
        delegate._itemFilter = tokenFilterMock;
        when(tokenFilterContextMock.checkValue(tokenFilterMock)).thenReturn(tokenFilterMock);
        when(tokenFilterMock.includeNumber(123L)).thenReturn(true);
        delegate.writeNumber(123L);
        verify(jsonGeneratorMock).writeNumber(123L);
    }

    @Test
    void testWriteNumber_ItemFilterIncludeAll() throws IOException {
        delegate._itemFilter = TokenFilter.INCLUDE_ALL;
        delegate.writeNumber(123L);
        verify(jsonGeneratorMock).writeNumber(123L);
    }

    @Test
    void testWriteNumber_CheckParentPathCalled() throws IOException {
        delegate._itemFilter = tokenFilterMock;
        when(tokenFilterContextMock.checkValue(tokenFilterMock)).thenReturn(tokenFilterMock);
        when(tokenFilterMock.includeNumber(123L)).thenReturn(true);
        delegate.writeNumber(123L);
        verify(delegate, times(1))._checkParentPath();
    }

    @Test
    void testWriteNumber_ThrowsIOException() {
        delegate._itemFilter = tokenFilterMock;
        when(tokenFilterContextMock.checkValue(tokenFilterMock)).thenReturn(tokenFilterMock);
        when(tokenFilterMock.includeNumber(123L)).thenThrow(new IOException());
        assertThrows(IOException.class, () -> delegate.writeNumber(123L));
    }
}
