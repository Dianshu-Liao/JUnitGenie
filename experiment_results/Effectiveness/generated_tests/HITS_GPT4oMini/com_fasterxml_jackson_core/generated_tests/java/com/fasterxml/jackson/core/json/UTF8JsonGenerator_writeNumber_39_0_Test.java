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

public class UTF8JsonGenerator_writeNumber_39_0_Test {

    private class TestUTF8JsonGenerator extends UTF8JsonGenerator {

        public TestUTF8JsonGenerator(IOContext ctxt, int features, ObjectCodec codec, OutputStream out, char quoteChar) {
            super(ctxt, features, codec, out, quoteChar);
        }

        public void setNumbersAsStrings(boolean value) {
            _cfgNumbersAsStrings = value;
        }
    }

    private TestUTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, true);
        generator = new TestUTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteNumber_FiniteFloat() throws IOException {
        float input = 123.45f;
        generator.writeNumber(input);
        generator.flush();
        String expectedOutput = "123.45";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testWriteNumber_NegativeFiniteFloat() throws IOException {
        float input = -123.45f;
        generator.writeNumber(input);
        generator.flush();
        String expectedOutput = "-123.45";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testWriteNumber_Zero() throws IOException {
        float input = 0.0f;
        generator.writeNumber(input);
        generator.flush();
        String expectedOutput = "0.0";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testWriteNumber_PositiveInfinity() throws IOException {
        float input = Float.POSITIVE_INFINITY;
        generator.writeNumber(input);
        generator.flush();
        String expectedOutput = "Infinity";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testWriteNumber_NegativeInfinity() throws IOException {
        float input = Float.NEGATIVE_INFINITY;
        generator.writeNumber(input);
        generator.flush();
        String expectedOutput = "-Infinity";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testWriteNumber_NaN() throws IOException {
        float input = Float.NaN;
        generator.writeNumber(input);
        generator.flush();
        String expectedOutput = "NaN";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testWriteNumber_QuotingNonFinite() throws IOException {
        generator.setNumbersAsStrings(true);
        float input = Float.NaN;
        generator.writeNumber(input);
        generator.flush();
        String expectedOutput = "\"NaN\"";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testWriteNumber_QuotingNegativeInfinity() throws IOException {
        generator.setNumbersAsStrings(true);
        float input = Float.NEGATIVE_INFINITY;
        generator.writeNumber(input);
        generator.flush();
        String expectedOutput = "\"-Infinity\"";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
