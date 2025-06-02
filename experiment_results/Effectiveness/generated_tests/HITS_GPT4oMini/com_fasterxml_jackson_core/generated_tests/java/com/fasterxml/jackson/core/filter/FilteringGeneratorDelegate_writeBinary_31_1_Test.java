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

public class FilteringGeneratorDelegate_writeBinary_31_1_Test {

    private JsonGenerator generator;

    private TokenFilter filter;

    private FilteringGeneratorDelegate filteringDelegate;

    @BeforeEach
    public void setUp() {
        generator = mock(JsonGenerator.class);
        // Using INCLUDE_ALL for the test
        filter = TokenFilter.INCLUDE_ALL;
        filteringDelegate = new FilteringGeneratorDelegate(generator, filter, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true);
    }

    @Test
    public void testWriteBinary() throws IOException {
        // Arrange
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] binaryData = "test".getBytes();
        InputStream inputStream = new ByteArrayInputStream(binaryData);
        int dataLength = binaryData.length;
        // Act
        int result = filteringDelegate.writeBinary(base64Variant, inputStream, dataLength);
        // Assert
        // Assuming the method returns the length of the data written
        assertEquals(dataLength, result);
        verify(generator).writeBinary(eq(base64Variant), any(InputStream.class), eq(dataLength));
    }

    @Test
    public void testWriteBinaryWithNoFilter() throws IOException {
        // Arrange
        filteringDelegate = new FilteringGeneratorDelegate(generator, TokenFilter.INCLUDE_ALL, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, false);
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] binaryData = "test".getBytes();
        InputStream inputStream = new ByteArrayInputStream(binaryData);
        int dataLength = binaryData.length;
        // Act
        int result = filteringDelegate.writeBinary(base64Variant, inputStream, dataLength);
        // Assert
        // Expecting -1 because filtering is not allowed
        assertEquals(-1, result);
    }
}
