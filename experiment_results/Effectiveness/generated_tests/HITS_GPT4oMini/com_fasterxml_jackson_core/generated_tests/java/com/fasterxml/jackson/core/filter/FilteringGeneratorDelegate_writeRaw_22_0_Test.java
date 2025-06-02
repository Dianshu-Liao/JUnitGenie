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

public class FilteringGeneratorDelegate_writeRaw_22_0_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH, true);
    }

    @Test
    public void testWriteRaw_WithValidInput_ShouldCallDelegate() throws IOException {
        // Arrange
        String text = "test raw text";
        when(mockTokenFilter.includeRawValue()).thenReturn(true);
        // Act
        filteringGeneratorDelegate.writeRaw(text);
        // Assert
        verify(mockJsonGenerator).writeRaw(eq(text));
    }

    @Test
    public void testWriteRaw_WithNullInput_ShouldNotCallDelegate() throws IOException {
        // Arrange
        String text = null;
        when(mockTokenFilter.includeRawValue()).thenReturn(true);
        // Act
        filteringGeneratorDelegate.writeRaw(text);
        // Assert
        verify(mockJsonGenerator, never()).writeRaw(any(String.class));
    }

    @Test
    public void testWriteRaw_WhenItemFilterIsIncludeAll_ShouldCallDelegate() throws IOException {
        // Arrange
        String text = "test raw text";
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, TokenFilter.INCLUDE_ALL, TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH, true);
        // Act
        filteringGeneratorDelegate.writeRaw(text);
        // Assert
        verify(mockJsonGenerator).writeRaw(eq(text));
    }

    @Test
    public void testWriteRaw_WhenItemFilterIsNull_ShouldNotCallDelegate() throws IOException {
        // Arrange
        String text = "test raw text";
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, null, TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH, true);
        // Act
        filteringGeneratorDelegate.writeRaw(text);
        // Assert
        verify(mockJsonGenerator, never()).writeRaw(eq(text));
    }

    @Test
    public void testWriteRaw_WhenItemFilterDoesNotAllowRawValue_ShouldNotCallDelegate() throws IOException {
        // Arrange
        String text = "test raw text";
        when(mockTokenFilter.includeRawValue()).thenReturn(false);
        // Act
        filteringGeneratorDelegate.writeRaw(text);
        // Assert
        verify(mockJsonGenerator, never()).writeRaw(eq(text));
    }
}
