package com.fasterxml.jackson.core.filter;

import java.io.IOException;
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

class FilteringGeneratorDelegate_writeBinary_30_0_Test {

    private JsonGenerator mockGenerator;

    private TokenFilter mockFilter;

    private FilteringGeneratorDelegate delegate;

    @BeforeEach
    void setUp() {
        mockGenerator = mock(JsonGenerator.class);
        mockFilter = mock(TokenFilter.class);
        delegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true);
    }

    @Test
    void testWriteBinary_WithValidInput_ShouldCallDelegate() throws IOException {
        // Arrange
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] data = new byte[] { 1, 2, 3, 4, 5 };
        int offset = 0;
        int len = data.length;
        // Act
        delegate.writeBinary(base64Variant, data, offset, len);
        // Assert
        verify(mockGenerator).writeBinary(base64Variant, data, offset, len);
    }

    @Test
    void testWriteBinary_WhenFilterDoesNotAllowBinaryWrite_ShouldNotCallDelegate() throws IOException {
        // Arrange
        when(mockFilter.includeBinary()).thenReturn(false);
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] data = new byte[] { 1, 2, 3, 4, 5 };
        int offset = 0;
        int len = data.length;
        // Act
        delegate.writeBinary(base64Variant, data, offset, len);
        // Assert
        verify(mockGenerator, never()).writeBinary(any(Base64Variant.class), any(byte[].class), anyInt(), anyInt());
    }
}
