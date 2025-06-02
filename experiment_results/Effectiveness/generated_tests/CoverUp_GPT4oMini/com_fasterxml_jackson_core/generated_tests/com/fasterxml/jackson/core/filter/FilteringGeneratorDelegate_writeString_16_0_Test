package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.mockito.ArgumentMatchers.any;
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

class FilteringGeneratorDelegate_writeString_16_0_Test {

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
    void testWriteString_ItemFilterIsNull() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = null;
        // Act
        filteringGeneratorDelegate.writeString("test");
        // Assert
        verify(mockJsonGenerator, never()).writeString(any(String.class));
    }

    @Test
    void testWriteString_ItemFilterIsIncludeAll() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        // Act
        filteringGeneratorDelegate.writeString("test");
        // Assert
        verify(mockJsonGenerator).writeString("test");
    }

    @Test
    void testWriteString_ItemFilterCheckValueReturnsNull() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        when(mockTokenFilterContext.checkValue(any())).thenReturn(null);
        // Act
        filteringGeneratorDelegate.writeString("test");
        // Assert
        verify(mockJsonGenerator, never()).writeString(any(String.class));
    }

    @Test
    void testWriteString_ItemFilterDoesNotIncludeString() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        when(mockTokenFilterContext.checkValue(any())).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeString(any())).thenReturn(false);
        // Act
        filteringGeneratorDelegate.writeString("test");
        // Assert
        verify(mockJsonGenerator, never()).writeString(any(String.class));
    }

    @Test
    void testWriteString_ItemFilterIncludesString() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        when(mockTokenFilterContext.checkValue(any())).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeString(any())).thenReturn(true);
        // Act
        filteringGeneratorDelegate.writeString("test");
        // Assert
        verify(mockJsonGenerator).writeString("test");
    }

    @Test
    void testWriteString_CheckParentPathCalled() throws Exception {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        when(mockTokenFilterContext.checkValue(any())).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeString(any())).thenReturn(true);
        // Use reflection to access the private method
        Method checkParentPathMethod = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkParentPath");
        checkParentPathMethod.setAccessible(true);
        // Act
        filteringGeneratorDelegate.writeString("test");
        // Assert
        verify(mockJsonGenerator).writeString("test");
        verify(filteringGeneratorDelegate, times(1))._checkParentPath();
    }
}
