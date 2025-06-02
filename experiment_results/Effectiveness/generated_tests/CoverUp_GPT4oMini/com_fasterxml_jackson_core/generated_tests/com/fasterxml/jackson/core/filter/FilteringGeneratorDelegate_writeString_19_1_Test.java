package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;

class FilteringGeneratorDelegate_writeString_19_1_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private TokenFilterContext mockTokenFilterContext;

    @BeforeEach
    void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
    }

    @Test
    void testWriteString_ItemFilterNull() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = null;
        Reader reader = new StringReader("test");
        // Act & Assert
        assertDoesNotThrow(() -> filteringGeneratorDelegate.writeString(reader, 4));
    }

    @Test
    void testWriteString_ItemFilterIncludeAll() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        Reader reader = new StringReader("test");
        // Act & Assert
        assertDoesNotThrow(() -> filteringGeneratorDelegate.writeString(reader, 4));
        verify(mockJsonGenerator, times(1)).writeString(reader, 4);
    }

    @Test
    void testWriteString_ItemFilterNotIncludeAllAndStateNull() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(any())).thenReturn(null);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        Reader reader = new StringReader("test");
        // Act & Assert
        assertDoesNotThrow(() -> filteringGeneratorDelegate.writeString(reader, 4));
        verify(mockJsonGenerator, never()).writeString(any(), anyInt());
    }

    @Test
    void testWriteString_ItemFilterNotIncludeAllAndStateIncludeAll() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(any())).thenReturn(TokenFilter.INCLUDE_ALL);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        Reader reader = new StringReader("test");
        // Act & Assert
        assertDoesNotThrow(() -> filteringGeneratorDelegate.writeString(reader, 4));
        verify(mockJsonGenerator, times(1)).writeString(reader, 4);
    }

    @Test
    void testWriteString_ItemFilterNotIncludeAllAndStateDoesNotIncludeString() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(any())).thenReturn(mock(TokenFilter.class));
        when(mockTokenFilter.includeString(any(), anyInt())).thenReturn(false);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        Reader reader = new StringReader("test");
        // Act & Assert
        assertDoesNotThrow(() -> filteringGeneratorDelegate.writeString(reader, 4));
        verify(mockJsonGenerator, never()).writeString(any(), anyInt());
    }

    @Test
    void testWriteString_ItemFilterNotIncludeAllAndStateIncludeString() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(any())).thenReturn(mock(TokenFilter.class));
        when(mockTokenFilter.includeString(any(), anyInt())).thenReturn(true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        Reader reader = new StringReader("test");
        // Act & Assert
        assertDoesNotThrow(() -> filteringGeneratorDelegate.writeString(reader, 4));
        verify(mockJsonGenerator, times(1)).writeString(reader, 4);
    }

    @Test
    void testWriteString_CheckParentPathCalled() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(any())).thenReturn(mock(TokenFilter.class));
        when(mockTokenFilter.includeString(any(), anyInt())).thenReturn(true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        Reader reader = new StringReader("test");
        // Act
        filteringGeneratorDelegate.writeString(reader, 4);
        // Assert
        verify(filteringGeneratorDelegate, times(1))._checkParentPath();
    }
}
