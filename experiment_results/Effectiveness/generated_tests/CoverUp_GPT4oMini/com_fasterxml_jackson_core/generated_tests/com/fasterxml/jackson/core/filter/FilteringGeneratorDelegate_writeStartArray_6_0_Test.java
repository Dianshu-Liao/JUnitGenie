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

class FilteringGeneratorDelegate_writeStartArray_6_0_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private TokenFilterContext mockTokenFilterContext;

    @BeforeEach
    void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        // Initialize FilteringGeneratorDelegate with mocks
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, TokenFilter.Inclusion.INCLUDE_NON_NULL, true);
        // Set up the filter context to return the mock context
        when(mockTokenFilterContext.createChildArrayContext(any(), anyBoolean())).thenReturn(mockTokenFilterContext);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test
    void testWriteStartArray_ItemFilterNull() throws Exception {
        // Arrange
        filteringGeneratorDelegate._itemFilter = null;
        // Act
        invokeWriteStartArray(filteringGeneratorDelegate, new Object());
        // Assert
        verify(mockTokenFilterContext).createChildArrayContext(null, false);
        verify(mockJsonGenerator, never()).writeStartArray(any());
    }

    @Test
    void testWriteStartArray_ItemFilterIncludeAll() throws Exception {
        // Arrange
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        // Act
        invokeWriteStartArray(filteringGeneratorDelegate, new Object());
        // Assert
        verify(mockTokenFilterContext).createChildArrayContext(filteringGeneratorDelegate._itemFilter, true);
        verify(mockJsonGenerator).writeStartArray(any());
    }

    @Test
    void testWriteStartArray_ItemFilterCheckValueReturnsNull() throws Exception {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
        // Act
        invokeWriteStartArray(filteringGeneratorDelegate, new Object());
        // Assert
        verify(mockTokenFilterContext).createChildArrayContext(null, false);
    }

    @Test
    void testWriteStartArray_ItemFilterNotIncludeAll() throws Exception {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.filterStartArray()).thenReturn(mockTokenFilter);
        // Act
        invokeWriteStartArray(filteringGeneratorDelegate, new Object());
        // Assert
        verify(mockTokenFilterContext).createChildArrayContext(mockTokenFilter, true);
        verify(mockJsonGenerator).writeStartArray(any());
    }

    @Test
    void testWriteStartArray_ItemFilterNonNullInclusion() throws Exception {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        filteringGeneratorDelegate._inclusion = TokenFilter.Inclusion.INCLUDE_NON_NULL;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.filterStartArray()).thenReturn(mockTokenFilter);
        // Act
        invokeWriteStartArray(filteringGeneratorDelegate, new Object());
        // Assert
        verify(mockTokenFilterContext).createChildArrayContext(mockTokenFilter, true);
        verify(mockJsonGenerator).writeStartArray(any());
    }

    private void invokeWriteStartArray(FilteringGeneratorDelegate instance, Object forValue) throws Exception {
        Method method = FilteringGeneratorDelegate.class.getDeclaredMethod("writeStartArray", Object.class);
        method.setAccessible(true);
        method.invoke(instance, forValue);
    }
}
