package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import java.io.IOException;
import java.io.StringWriter;
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

class FilteringGeneratorDelegate_writeNumber_37_0_Test {

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
    void testWriteNumberWithNullItemFilter() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = null;
        // Act
        filteringGeneratorDelegate.writeNumber(1.0f);
        // Assert
        verify(mockJsonGenerator, never()).writeNumber(anyFloat());
    }

    @Test
    void testWriteNumberWithIncludeAllItemFilter() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        // Act
        filteringGeneratorDelegate.writeNumber(1.0f);
        // Assert
        verify(mockJsonGenerator).writeNumber(1.0f);
    }

    @Test
    void testWriteNumberWithNonIncludeAllItemFilterAndNullState() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
        // Act
        filteringGeneratorDelegate.writeNumber(1.0f);
        // Assert
        verify(mockJsonGenerator, never()).writeNumber(anyFloat());
    }

    @Test
    void testWriteNumberWithNonIncludeAllItemFilterAndExcludedNumber() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(1.0f)).thenReturn(false);
        // Act
        filteringGeneratorDelegate.writeNumber(1.0f);
        // Assert
        verify(mockJsonGenerator, never()).writeNumber(anyFloat());
    }

    @Test
    void testWriteNumberWithNonIncludeAllItemFilterAndIncludedNumber() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(1.0f)).thenReturn(true);
        doNothing().when(mockJsonGenerator).writeNumber(1.0f);
        // Act
        filteringGeneratorDelegate.writeNumber(1.0f);
        // Assert
        verify(mockJsonGenerator).writeNumber(1.0f);
    }

    @Test
    void testWriteNumberCallsCheckParentPath() throws Exception {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(1.0f)).thenReturn(true);
        Method checkParentPathMethod = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkParentPath");
        checkParentPathMethod.setAccessible(true);
        // Act
        filteringGeneratorDelegate.writeNumber(1.0f);
        // Assert
        verify(mockJsonGenerator).writeNumber(1.0f);
        verify(filteringGeneratorDelegate, times(1))._checkParentPath();
    }
}
