// Test method
package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;

class UTF8JsonGenerator_writeNumber_38_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        generator = new UTF8JsonGenerator(mock(IOContext.class), 0, mock(ObjectCodec.class), outputStream, '"');
    }

    @Test
    void testWriteNumber_WithFiniteNumber() throws IOException {
        generator.writeNumber(123.456);
        assertEquals("123.456", outputStream.toString("UTF-8"));
    }

    @Test
    void testWriteNumber_WithNegativeFiniteNumber() throws IOException {
        generator.writeNumber(-123.456);
        assertEquals("-123.456", outputStream.toString("UTF-8"));
    }

    @Test
    void testWriteNumber_WithZero() throws IOException {
        generator.writeNumber(0.0);
        assertEquals("0.0", outputStream.toString("UTF-8"));
    }

    @Test
    void testWriteNumber_WithNaN() throws IOException {
        when(generator.isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS)).thenReturn(true);
        generator.writeNumber(Double.NaN);
        assertEquals("\"NaN\"", outputStream.toString("UTF-8"));
    }

    @Test
    void testWriteNumber_WithPositiveInfinity() throws IOException {
        when(generator.isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS)).thenReturn(true);
        generator.writeNumber(Double.POSITIVE_INFINITY);
        assertEquals("\"Infinity\"", outputStream.toString("UTF-8"));
    }

    @Test
    void testWriteNumber_WithNegativeInfinity() throws IOException {
        when(generator.isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS)).thenReturn(true);
        generator.writeNumber(Double.NEGATIVE_INFINITY);
        assertEquals("\"-Infinity\"", outputStream.toString("UTF-8"));
    }

    @Test
    void testWriteNumber_WithNonFiniteNumber_WithoutQuoting() throws IOException {
        when(generator.isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS)).thenReturn(false);
        generator.writeNumber(Double.NaN);
        assertEquals("NaN", outputStream.toString("UTF-8"));
    }

    @Test
    void testWriteNumber_WithNegativeNonFiniteNumber_WithoutQuoting() throws IOException {
        when(generator.isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS)).thenReturn(false);
        generator.writeNumber(Double.NEGATIVE_INFINITY);
        assertEquals("-Infinity", outputStream.toString("UTF-8"));
    }

    @Test
    void testWriteNumber_WithPositiveNonFiniteNumber_WithoutQuoting() throws IOException {
        when(generator.isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS)).thenReturn(false);
        generator.writeNumber(Double.POSITIVE_INFINITY);
        assertEquals("Infinity", outputStream.toString("UTF-8"));
    }
}
