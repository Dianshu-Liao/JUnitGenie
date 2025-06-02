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

public class FilteringGeneratorDelegate_writeRaw_24_0_Test {

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
    public void testWriteRaw_AllowsRawValueWrite() throws IOException {
        // Arrange
        SerializableString serializableString = mock(SerializableString.class);
        when(mockTokenFilter.includeRawValue()).thenReturn(true);
        // Act
        filteringGeneratorDelegate.writeRaw(serializableString);
        // Assert
        verify(mockJsonGenerator).writeRaw(serializableString);
    }

    @Test
    public void testWriteRaw_DisallowsRawValueWrite_WhenItemFilterIsNull() throws IOException {
        // Arrange
        SerializableString serializableString = mock(SerializableString.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, TokenFilter.INCLUDE_ALL, TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH, true);
        // Act
        filteringGeneratorDelegate.writeRaw(serializableString);
        // Assert
        verify(mockJsonGenerator, never()).writeRaw(any(SerializableString.class));
    }

    @Test
    public void testWriteRaw_DisallowsRawValueWrite_WhenItemFilterIsNotIncludeAll() throws IOException {
        // Arrange
        SerializableString serializableString = mock(SerializableString.class);
        when(mockTokenFilter.includeRawValue()).thenReturn(false);
        // Act
        filteringGeneratorDelegate.writeRaw(serializableString);
        // Assert
        verify(mockJsonGenerator, never()).writeRaw(any(SerializableString.class));
    }

    @Test
    public void testWriteRaw_AllowsRawValueWrite_WhenItemFilterIsIncludeAll() throws IOException {
        // Arrange
        SerializableString serializableString = mock(SerializableString.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH, true);
        when(mockTokenFilter.includeRawValue()).thenReturn(true);
        // Act
        filteringGeneratorDelegate.writeRaw(serializableString);
        // Assert
        verify(mockJsonGenerator).writeRaw(serializableString);
    }
}
