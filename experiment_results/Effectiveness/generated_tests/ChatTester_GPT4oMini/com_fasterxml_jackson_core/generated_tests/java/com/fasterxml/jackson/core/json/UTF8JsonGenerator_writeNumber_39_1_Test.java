// Test method
package com.fasterxml.jackson.core.json;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.NumberOutput;

public class UTF8JsonGenerator_writeNumber_39_1_Test {

    private UTF8JsonGenerator jsonGenerator;

    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        // Use ByteArrayOutputStream for testing
        IOContext ioContext = mock(IOContext.class);
        ObjectCodec codec = mock(ObjectCodec.class);
        jsonGenerator = new UTF8JsonGenerator(ioContext, 0, codec, byteArrayOutputStream, '"');
    }

    @Test
    public void testWriteNumber_ValidFloat() throws IOException {
        float input = 123.45f;
        jsonGenerator.writeNumber(input);
        // Expected raw output
        String expectedOutput = "123.45";
        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }

    @Test
    public void testWriteNumber_NonFiniteFloat() throws IOException {
        // Test with NaN
        float input = Float.NaN;
        jsonGenerator.writeNumber(input);
        // Expected output when quoting non-finite
        String expectedOutput = "\"NaN\"";
        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }

    @Test
    public void testWriteNumber_NegativeFloat() throws IOException {
        float input = -123.45f;
        jsonGenerator.writeNumber(input);
        // Expected raw output
        String expectedOutput = "-123.45";
        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }

    @Test
    public void testWriteNumber_ZeroFloat() throws IOException {
        float input = 0.0f;
        jsonGenerator.writeNumber(input);
        // Expected raw output
        String expectedOutput = "0.0";
        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }

    @Test
    public void testWriteNumber_QuoteNonNumeric() throws IOException {
        // Fixing the buggy line: Use reflection to access the private field _features
        try {
            Method method = UTF8JsonGenerator.class.getDeclaredMethod("setFeature", int.class);
            method.setAccessible(true);
            // Corrected line
            method.invoke(jsonGenerator, Feature.QUOTE_NON_NUMERIC_NUMBERS.getMask());
        } catch (Exception e) {
            fail("Reflection failed to set feature: " + e.getMessage());
        }
        // Test with NaN
        float input = Float.NaN;
        jsonGenerator.writeNumber(input);
        // Expected output when quoting non-finite
        String expectedOutput = "\"NaN\"";
        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }

    @Test
    public void testWriteNumber_Infinity() throws IOException {
        // Test with positive infinity
        float input = Float.POSITIVE_INFINITY;
        jsonGenerator.writeNumber(input);
        // Expected output when quoting non-finite
        String expectedOutput = "\"Infinity\"";
        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }

    @Test
    public void testWriteNumber_NegativeInfinity() throws IOException {
        // Test with negative infinity
        float input = Float.NEGATIVE_INFINITY;
        jsonGenerator.writeNumber(input);
        // Expected output when quoting non-finite
        String expectedOutput = "\"-Infinity\"";
        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }
}
