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

public class FilteringGeneratorDelegate_writeStartObject_11_1_Test {

    private FilteringGeneratorDelegate delegate;

    private JsonGenerator jsonGeneratorMock;

    private TokenFilter tokenFilterMock;

    private TokenFilterContext tokenFilterContextMock;

    @BeforeEach
    public void setUp() {
        jsonGeneratorMock = mock(JsonGenerator.class);
        tokenFilterMock = mock(TokenFilter.class);
        tokenFilterContextMock = mock(TokenFilterContext.class);
        delegate = new FilteringGeneratorDelegate(jsonGeneratorMock, tokenFilterMock, true, false);
        // Set the mock context
        delegate._filterContext = tokenFilterContextMock;
    }

    @Test
    public void testWriteStartObject_ItemFilterNull() throws Exception {
        // Arrange
        delegate._itemFilter = null;
        when(tokenFilterContextMock.createChildObjectContext(any(), anyBoolean())).thenReturn(tokenFilterContextMock);
        // Act
        invokeWriteStartObject(delegate, new Object(), 0);
        // Assert
        verify(tokenFilterContextMock).createChildObjectContext(null, false);
    }

    @Test
    public void testWriteStartObject_ItemFilterIncludeAll() throws Exception {
        // Arrange
        delegate._itemFilter = TokenFilter.INCLUDE_ALL;
        when(tokenFilterContextMock.createChildObjectContext(any(), anyBoolean())).thenReturn(tokenFilterContextMock);
        // Act
        invokeWriteStartObject(delegate, new Object(), 0);
        // Assert
        verify(tokenFilterContextMock).createChildObjectContext(TokenFilter.INCLUDE_ALL, true);
        verify(jsonGeneratorMock).writeStartObject(any(), anyInt());
    }

    @Test
    public void testWriteStartObject_ItemFilterCheckValueReturnsNull() throws Exception {
        // Arrange
        delegate._itemFilter = tokenFilterMock;
        when(tokenFilterContextMock.checkValue(tokenFilterMock)).thenReturn(null);
        when(tokenFilterContextMock.createChildObjectContext(any(), anyBoolean())).thenReturn(tokenFilterContextMock);
        // Act
        invokeWriteStartObject(delegate, new Object(), 0);
        // Assert
        verify(tokenFilterContextMock).createChildObjectContext(null, false);
    }

    @Test
    public void testWriteStartObject_ItemFilterCheckValueReturnsIncludeAll() throws Exception {
        // Arrange
        delegate._itemFilter = tokenFilterMock;
        when(tokenFilterContextMock.checkValue(tokenFilterMock)).thenReturn(TokenFilter.INCLUDE_ALL);
        when(tokenFilterContextMock.createChildObjectContext(any(), anyBoolean())).thenReturn(tokenFilterContextMock);
        doNothing().when(tokenFilterMock).filterStartObject();
        // Act
        invokeWriteStartObject(delegate, new Object(), 0);
        // Assert
        verify(tokenFilterContextMock).createChildObjectContext(TokenFilter.INCLUDE_ALL, true);
        verify(jsonGeneratorMock).writeStartObject(any(), anyInt());
    }

    @Test
    public void testWriteStartObject_ItemFilterCheckValueReturnsNonIncludeAll() throws Exception {
        // Arrange
        delegate._itemFilter = tokenFilterMock;
        TokenFilter nonIncludeAllFilterMock = mock(TokenFilter.class);
        when(tokenFilterContextMock.checkValue(tokenFilterMock)).thenReturn(nonIncludeAllFilterMock);
        when(nonIncludeAllFilterMock.filterStartObject()).thenReturn(nonIncludeAllFilterMock);
        when(tokenFilterContextMock.createChildObjectContext(any(), anyBoolean())).thenReturn(tokenFilterContextMock);
        // Act
        invokeWriteStartObject(delegate, new Object(), 0);
        // Assert
        verify(tokenFilterContextMock).createChildObjectContext(nonIncludeAllFilterMock, false);
    }

    private void invokeWriteStartObject(FilteringGeneratorDelegate delegate, Object forValue, int size) throws Exception {
        Method method = FilteringGeneratorDelegate.class.getDeclaredMethod("writeStartObject", Object.class, int.class);
        method.setAccessible(true);
        method.invoke(delegate, forValue, size);
    }
}
