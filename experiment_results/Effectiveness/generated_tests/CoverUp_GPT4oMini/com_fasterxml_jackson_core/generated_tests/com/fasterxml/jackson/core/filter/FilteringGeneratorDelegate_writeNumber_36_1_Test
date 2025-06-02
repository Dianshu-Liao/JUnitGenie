package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
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

class FilteringGeneratorDelegate_writeNumber_36_1_Test {

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
    }

    @Test
    void testWriteNumber_ItemFilterIsNull() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = null;
        // Act
        filteringGeneratorDelegate.writeNumber(5.0);
        // Assert
        verify(mockJsonGenerator, never()).writeNumber(anyDouble());
    }

    @Test
    void testWriteNumber_ItemFilterIsIncludeAll() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        // Act
        filteringGeneratorDelegate.writeNumber(5.0);
        // Assert
        verify(mockJsonGenerator).writeNumber(5.0);
    }

    @Test
    void testWriteNumber_ItemFilterCheckValueReturnsNull() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
        // Act
        filteringGeneratorDelegate.writeNumber(5.0);
        // Assert
        verify(mockJsonGenerator, never()).writeNumber(anyDouble());
    }

    @Test
    void testWriteNumber_ItemFilterDoesNotIncludeNumber() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(5.0)).thenReturn(false);
        // Act
        filteringGeneratorDelegate.writeNumber(5.0);
        // Assert
        verify(mockJsonGenerator, never()).writeNumber(anyDouble());
    }

    @Test
    void testWriteNumber_ItemFilterIncludesNumber() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(5.0)).thenReturn(true);
        // Act
        filteringGeneratorDelegate.writeNumber(5.0);
        // Assert
        verify(mockJsonGenerator).writeNumber(5.0);
    }

    @Test
    void testWriteNumber_CheckParentPathCalled() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(5.0)).thenReturn(true);
        // Act
        filteringGeneratorDelegate.writeNumber(5.0);
        // Assert
        verify(filteringGeneratorDelegate, times(1))._checkParentPath();
    }
}
