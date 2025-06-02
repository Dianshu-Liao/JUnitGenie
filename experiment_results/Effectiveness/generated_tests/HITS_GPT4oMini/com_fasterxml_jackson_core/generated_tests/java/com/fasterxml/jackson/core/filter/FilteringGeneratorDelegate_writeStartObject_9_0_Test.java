package com.fasterxml.jackson.core.filter;

import java.io.IOException;
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

public class FilteringGeneratorDelegate_writeStartObject_9_0_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private TokenFilterContext mockTokenFilterContext;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, false);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test
    public void testWriteStartObject_ItemFilterIsNull() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = null;
        // Act
        filteringGeneratorDelegate.writeStartObject();
        // Assert
        verify(mockTokenFilterContext, times(1)).createChildObjectContext(null, false);
        // Ensure that writeStartObject is not called on the delegate
        verify(mockJsonGenerator, never()).writeStartObject();
    }

    @Test
    public void testWriteStartObject_ItemFilterIsIncludeAll() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        // Act
        filteringGeneratorDelegate.writeStartObject();
        // Assert
        verify(mockTokenFilterContext, times(1)).createChildObjectContext(TokenFilter.INCLUDE_ALL, true);
        verify(mockJsonGenerator, times(1)).writeStartObject();
    }

    @Test
    public void testWriteStartObject_ItemFilterIsNotNull() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(mockTokenFilter);
        // Act
        filteringGeneratorDelegate.writeStartObject();
        // Assert
        verify(mockTokenFilterContext, times(1)).checkValue(mockTokenFilter);
        verify(mockTokenFilter, times(1)).filterStartObject();
        verify(mockJsonGenerator, times(1)).writeStartObject();
    }
}
