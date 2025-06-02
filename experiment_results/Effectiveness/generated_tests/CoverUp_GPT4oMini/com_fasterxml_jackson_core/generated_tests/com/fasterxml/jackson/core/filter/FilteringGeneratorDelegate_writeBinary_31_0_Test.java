package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import java.io.ByteArrayInputStream;
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

class FilteringGeneratorDelegate_writeBinary_31_0_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    private Base64Variant base64Variant;

    @BeforeEach
    void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        // Using INCLUDE_ALL for testing
        mockTokenFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
        base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
    }

    @Test
    void testWriteBinaryWithValidData() throws IOException {
        byte[] data = "test data".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        when(mockJsonGenerator.writeBinary(eq(base64Variant), any(InputStream.class), eq(data.length))).thenReturn(data.length);
        int result = filteringGeneratorDelegate.writeBinary(base64Variant, inputStream, data.length);
        assertEquals(data.length, result);
        verify(mockJsonGenerator).writeBinary(eq(base64Variant), any(InputStream.class), eq(data.length));
    }

    @Test
    void testWriteBinaryWithNullFilter() throws IOException {
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, null, true, true);
        byte[] data = "test data".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        int result = filteringGeneratorDelegate.writeBinary(base64Variant, inputStream, data.length);
        assertEquals(-1, result);
    }

    @Test
    void testWriteBinaryWithExcludedFilter() throws IOException {
        TokenFilter excludedFilter = mock(TokenFilter.class);
        when(excludedFilter.includeBinary()).thenReturn(false);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, excludedFilter, true, true);
        byte[] data = "test data".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        int result = filteringGeneratorDelegate.writeBinary(base64Variant, inputStream, data.length);
        assertEquals(-1, result);
    }

    @Test
    void testWriteBinaryWithIOException() throws IOException {
        byte[] data = "test data".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        when(mockJsonGenerator.writeBinary(eq(base64Variant), any(InputStream.class), eq(data.length))).thenThrow(new IOException("Test IOException"));
        assertThrows(IOException.class, () -> {
            filteringGeneratorDelegate.writeBinary(base64Variant, inputStream, data.length);
        });
    }
}
