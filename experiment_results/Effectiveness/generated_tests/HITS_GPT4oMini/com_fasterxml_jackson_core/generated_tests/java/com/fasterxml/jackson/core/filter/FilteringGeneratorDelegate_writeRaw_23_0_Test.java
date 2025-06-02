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

public class FilteringGeneratorDelegate_writeRaw_23_0_Test {

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
    public void testWriteRaw_WhenCheckRawValueWriteIsTrue() throws IOException {
        // Arrange
        when(mockTokenFilter.includeRawValue()).thenReturn(true);
        // Act
        filteringGeneratorDelegate.writeRaw("test", 0, 4);
        // Assert
        verify(mockJsonGenerator).writeRaw("test", 0, 4);
    }

    @Test
    public void testWriteRaw_WhenCheckRawValueWriteIsFalse() throws IOException {
        // Arrange
        when(mockTokenFilter.includeRawValue()).thenReturn(false);
        // Act
        filteringGeneratorDelegate.writeRaw("test", 0, 4);
        // Assert
        verify(mockJsonGenerator, never()).writeRaw(anyString(), anyInt(), anyInt());
    }

    @Test
    public void testWriteRaw_WhenItemFilterIsNull() throws IOException {
        // Arrange
        FilteringGeneratorDelegate delegateWithNullFilter = new FilteringGeneratorDelegate(mockJsonGenerator, null, TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH, true);
        // Act
        delegateWithNullFilter.writeRaw("test", 0, 4);
        // Assert
        verify(mockJsonGenerator, never()).writeRaw(anyString(), anyInt(), anyInt());
    }

    @Test
    public void testWriteRaw_WhenItemFilterIsIncludeAll() throws IOException {
        // Arrange
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, TokenFilter.INCLUDE_ALL, TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH, true);
        // Act
        filteringGeneratorDelegate.writeRaw("test", 0, 4);
        // Assert
        verify(mockJsonGenerator).writeRaw("test", 0, 4);
    }
}
