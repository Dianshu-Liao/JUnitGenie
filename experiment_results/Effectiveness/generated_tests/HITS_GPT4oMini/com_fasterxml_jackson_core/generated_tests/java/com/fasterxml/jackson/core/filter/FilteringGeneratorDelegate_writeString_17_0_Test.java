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

public class FilteringGeneratorDelegate_writeString_17_0_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private TokenFilterContext mockTokenFilterContext;

    @BeforeEach
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test
    public void testWriteString_ItemFilterIsNull() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = null;
        char[] text = "test".toCharArray();
        int offset = 0;
        int len = 4;
        // Act
        filteringGeneratorDelegate.writeString(text, offset, len);
        // Assert
        verify(mockJsonGenerator, never()).writeString(any(char[].class), anyInt(), anyInt());
    }

    @Test
    public void testWriteString_ItemFilterIsIncludeAll() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        char[] text = "test".toCharArray();
        int offset = 0;
        int len = 4;
        // Act
        filteringGeneratorDelegate.writeString(text, offset, len);
        // Assert
        verify(mockJsonGenerator).writeString(text, offset, len);
    }

    @Test
    public void testWriteString_ItemFilterIsNotIncludeAll() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(filteringGeneratorDelegate._itemFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeString(anyString())).thenReturn(true);
        char[] text = "test".toCharArray();
        int offset = 0;
        int len = 4;
        // Act
        filteringGeneratorDelegate.writeString(text, offset, len);
        // Assert
        verify(mockJsonGenerator).writeString(text, offset, len);
    }

    @Test
    public void testWriteString_ItemFilterDoesNotIncludeString() throws IOException {
        // Arrange
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(filteringGeneratorDelegate._itemFilter)).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeString(anyString())).thenReturn(false);
        char[] text = "test".toCharArray();
        int offset = 0;
        int len = 4;
        // Act
        filteringGeneratorDelegate.writeString(text, offset, len);
        // Assert
        verify(mockJsonGenerator, never()).writeString(any(char[].class), anyInt(), anyInt());
    }
}
