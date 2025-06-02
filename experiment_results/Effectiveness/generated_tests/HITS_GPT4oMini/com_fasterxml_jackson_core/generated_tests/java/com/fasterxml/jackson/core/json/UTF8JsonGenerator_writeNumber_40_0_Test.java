package com.fasterxml.jackson.core.json;

import java.math.BigDecimal;
import com.fasterxml.jackson.core.io.IOContext;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.NumberOutput;

public class UTF8JsonGenerator_writeNumber_40_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = mock(IOContext.class);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteNumber_NullValue() throws IOException {
        generator.writeNumber((BigDecimal) null);
        String result = outputStream.toString();
        // Verify that null is written correctly (as "null")
        assertEquals("null", result);
    }

    @Test
    public void testWriteNumber_ZeroValue() throws IOException {
        generator.writeNumber(BigDecimal.ZERO);
        String result = outputStream.toString();
        // Verify that 0 is written correctly
        assertEquals("0", result);
    }

    @Test
    public void testWriteNumber_PositiveValue() throws IOException {
        generator.writeNumber(new BigDecimal("123.45"));
        String result = outputStream.toString();
        // Verify that positive decimal is written correctly
        assertEquals("123.45", result);
    }

    @Test
    public void testWriteNumber_NegativeValue() throws IOException {
        generator.writeNumber(new BigDecimal("-123.45"));
        String result = outputStream.toString();
        // Verify that negative decimal is written correctly
        assertEquals("-123.45", result);
    }

    @Test
    public void testWriteNumber_VeryLargeValue() throws IOException {
        generator.writeNumber(new BigDecimal("123456789012345678901234567890"));
        String result = outputStream.toString();
        // Verify that very large decimal is written correctly
        assertEquals("123456789012345678901234567890", result);
    }

    @Test
    public void testWriteNumber_VerySmallValue() throws IOException {
        generator.writeNumber(new BigDecimal("0.0000000001"));
        String result = outputStream.toString();
        // Verify that very small decimal is written correctly
        assertEquals("0.0000000001", result);
    }

    @Test
    public void testWriteNumber_ThrowsIOException() {
        // Simulate an IOException by closing the outputStream
        assertThrows(IOException.class, () -> {
            outputStream.close();
            generator.writeNumber(new BigDecimal("123.45"));
        });
    }
}
