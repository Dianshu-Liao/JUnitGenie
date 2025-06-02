package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.mockito.ArgumentMatchers.anyInt;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;

class FilteringGeneratorDelegate_writeNumber_40_1_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private TokenFilterContext mockTokenFilterContext;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
    }

    @Test
    void testWriteNumber_ItemFilterIsNull() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = null;
        char[] buffer = new char[] { '1', '2', '3' };
        int offset = 0;
        int length = 3;
        // Act
        filteringGeneratorDelegate.writeNumber(buffer, offset, length);
        // Assert
        verify(mockJsonGenerator, never()).writeNumber(any(char[].class), anyInt(), anyInt());
    }

    @Test
    void testWriteNumber_ItemFilterIsIncludeAll() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        char[] buffer = new char[] { '1', '2', '3' };
        int offset = 0;
        int length = 3;
        // Act
        filteringGeneratorDelegate.writeNumber(buffer, offset, length);
        // Assert
        verify(mockJsonGenerator).writeNumber(buffer, offset, length);
    }

    @Test
    void testWriteNumber_ItemFilterCheckValueReturnsNull() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        char[] buffer = new char[] { '1', '2', '3' };
        int offset = 0;
        int length = 3;
        // Act
        filteringGeneratorDelegate.writeNumber(buffer, offset, length);
        // Assert
        verify(mockJsonGenerator, never()).writeNumber(any(char[].class), anyInt(), anyInt());
    }

    @Test
    void testWriteNumber_ItemFilterCheckValueIncludesRawValueFalse() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeRawValue()).thenReturn(false);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        char[] buffer = new char[] { '1', '2', '3' };
        int offset = 0;
        int length = 3;
        // Act
        filteringGeneratorDelegate.writeNumber(buffer, offset, length);
        // Assert
        verify(mockJsonGenerator, never()).writeNumber(any(char[].class), anyInt(), anyInt());
    }

    @Test
    void testWriteNumber_ItemFilterCheckValueIncludesRawValueTrue() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeRawValue()).thenReturn(true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        char[] buffer = new char[] { '1', '2', '3' };
        int offset = 0;
        int length = 3;
        // Act
        filteringGeneratorDelegate.writeNumber(buffer, offset, length);
        // Assert
        verify(mockJsonGenerator).writeNumber(buffer, offset, length);
    }

    @Test
    void testWriteNumber_CheckParentPathCalled() throws Exception {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeRawValue()).thenReturn(true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        char[] buffer = new char[] { '1', '2', '3' };
        int offset = 0;
        int length = 3;
        Method checkParentPathMethod = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkParentPath");
        checkParentPathMethod.setAccessible(true);
        // Act
        filteringGeneratorDelegate.writeNumber(buffer, offset, length);
    }
}
