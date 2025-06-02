package com.fasterxml.jackson.core.filter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;

public class FilteringGeneratorDelegate_writeBinary_31_0_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    @BeforeEach
    public void setUp() {
        mockJsonGenerator = Mockito.mock(JsonGenerator.class);
        mockTokenFilter = Mockito.mock(TokenFilter.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
    }

    @Test
    public void testWriteBinary_WhenBinaryWriteAllowed() throws IOException {
        // Arrange
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] data = "test data".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        when(mockTokenFilter.includeBinary()).thenReturn(true);
        // Act
        int result = filteringGeneratorDelegate.writeBinary(base64Variant, inputStream, data.length);
        // Assert
        verify(mockJsonGenerator).writeBinary(eq(base64Variant), any(InputStream.class), eq(data.length));
        assertEquals(data.length, result);
    }

    @Test
    public void testWriteBinary_WhenBinaryWriteNotAllowed() throws IOException {
        // Arrange
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] data = "test data".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        when(mockTokenFilter.includeBinary()).thenReturn(false);
        // Act
        int result = filteringGeneratorDelegate.writeBinary(base64Variant, inputStream, data.length);
        // Assert
        verify(mockJsonGenerator, never()).writeBinary(any(Base64Variant.class), any(InputStream.class), anyInt());
        assertEquals(-1, result);
    }

    @Test
    public void testWriteBinary_WhenIOExceptionThrown() throws IOException {
        // Arrange
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] data = "test data".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        when(mockTokenFilter.includeBinary()).thenReturn(true);
        doThrow(new IOException("Test IOException")).when(mockJsonGenerator).writeBinary(any(Base64Variant.class), any(InputStream.class), anyInt());
        // Act & Assert
        IOException exception = assertThrows(IOException.class, () -> {
            filteringGeneratorDelegate.writeBinary(base64Variant, inputStream, data.length);
        });
        assertEquals("Test IOException", exception.getMessage());
    }
}
