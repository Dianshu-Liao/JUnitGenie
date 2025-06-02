package com.fasterxml.jackson.core.filter;

import java.io.IOException;
import java.io.InputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;

public class FilteringGeneratorDelegate_writeBinary_31_3_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    @BeforeEach
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
    }

    @Test
    public void testWriteBinary_WhenCheckBinaryWriteReturnsTrue() throws Exception {
        // Arrange
        Base64Variant mockBase64Variant = mock(Base64Variant.class);
        InputStream mockInputStream = mock(InputStream.class);
        int dataLength = 10;
        when(filteringGeneratorDelegate._checkBinaryWrite()).thenReturn(true);
        when(mockJsonGenerator.writeBinary(mockBase64Variant, mockInputStream, dataLength)).thenReturn(5);
        // Act
        int result = callWriteBinary(mockBase64Variant, mockInputStream, dataLength);
        // Assert
        assertEquals(5, result);
        verify(mockJsonGenerator).writeBinary(mockBase64Variant, mockInputStream, dataLength);
    }

    @Test
    public void testWriteBinary_WhenCheckBinaryWriteReturnsFalse() throws Exception {
        // Arrange
        Base64Variant mockBase64Variant = mock(Base64Variant.class);
        InputStream mockInputStream = mock(InputStream.class);
        int dataLength = 10;
        when(filteringGeneratorDelegate._checkBinaryWrite()).thenReturn(false);
        // Act
        int result = callWriteBinary(mockBase64Variant, mockInputStream, dataLength);
        // Assert
        assertEquals(-1, result);
        verify(mockJsonGenerator, never()).writeBinary(any(), any(), anyInt());
    }

    private int callWriteBinary(Base64Variant b64variant, InputStream data, int dataLength) throws Exception {
        // Use reflection to invoke the private method
        return (int) FilteringGeneratorDelegate.class.getDeclaredMethod("writeBinary", Base64Variant.class, InputStream.class, int.class).invoke(filteringGeneratorDelegate, b64variant, data, dataLength);
    }
}
