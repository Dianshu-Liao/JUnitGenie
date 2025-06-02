package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.NumberOutput;

public class UTF8JsonGenerator_writeNumber_38_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext context = mock(IOContext.class);
        when(context.allocWriteEncodingBuffer()).thenReturn(new byte[512]);
        generator = new UTF8JsonGenerator(context, 0, mock(ObjectCodec.class), outputStream, '"');
    }

    @Test
    public void testWriteNumber_ValidDouble() throws IOException {
        generator.writeNumber(123.456);
        String result = outputStream.toString("UTF-8");
        assertEquals("123.456", result);
    }

    @Test
    public void testWriteNumber_NegativeDouble() throws IOException {
        generator.writeNumber(-123.456);
        String result = outputStream.toString("UTF-8");
        assertEquals("-123.456", result);
    }

    @Test
    public void testWriteNumber_Zero() throws IOException {
        generator.writeNumber(0.0);
        String result = outputStream.toString("UTF-8");
        assertEquals("0.0", result);
    }

    @Test
    public void testWriteNumber_PositiveInfinity() throws IOException {
        generator.writeNumber(Double.POSITIVE_INFINITY);
        String result = outputStream.toString("UTF-8");
        assertTrue(result.contains("Infinity"));
    }

    @Test
    public void testWriteNumber_NegativeInfinity() throws IOException {
        generator.writeNumber(Double.NEGATIVE_INFINITY);
        String result = outputStream.toString("UTF-8");
        assertTrue(result.contains("-Infinity"));
    }

    @Test
    public void testWriteNumber_NaN() throws IOException {
        generator.writeNumber(Double.NaN);
        String result = outputStream.toString("UTF-8");
        assertTrue(result.contains("NaN"));
    }

    @Test
    public void testWriteNumber_FiniteNegative() throws IOException {
        generator.writeNumber(-1.23456789);
        String result = outputStream.toString("UTF-8");
        assertEquals("-1.23456789", result);
    }

    @Test
    public void testWriteNumber_FinitePositive() throws IOException {
        generator.writeNumber(1.23456789);
        String result = outputStream.toString("UTF-8");
        assertEquals("1.23456789", result);
    }

    @Test
    public void testWriteNumber_VeryLargeDouble() throws IOException {
        // Max double value
        generator.writeNumber(1.7976931348623157E308);
        String result = outputStream.toString("UTF-8");
        assertEquals("1.7976931348623157E308", result);
    }

    @Test
    public void testWriteNumber_VerySmallDouble() throws IOException {
        // Min positive double value
        generator.writeNumber(4.9E-324);
        String result = outputStream.toString("UTF-8");
        assertEquals("4.9E-324", result);
    }
}
