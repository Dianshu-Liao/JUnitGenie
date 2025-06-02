package com.fasterxml.jackson.core.json;

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
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;

public class UTF8JsonGenerator_writeNumber_39_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        // Assuming IOContext and ObjectCodec are mocked or created accordingly
        IOContext ioContext = mock(IOContext.class);
        ObjectCodec objectCodec = mock(ObjectCodec.class);
        generator = new UTF8JsonGenerator(ioContext, 0, objectCodec, outputStream, '"');
    }

    @Test
    public void testWriteNumber_ValidFloat() throws IOException {
        generator.writeNumber(3.14f);
        String result = outputStream.toString("UTF-8");
        assertEquals("3.14", result);
    }

    @Test
    public void testWriteNumber_NegativeFloat() throws IOException {
        generator.writeNumber(-2.71f);
        String result = outputStream.toString("UTF-8");
        assertEquals("-2.71", result);
    }

    @Test
    public void testWriteNumber_NonFiniteFloat() throws IOException {
        generator.writeNumber(Float.NaN);
        String result = outputStream.toString("UTF-8");
        assertEquals("NaN", result);
        // Clear output stream for next test
        outputStream.reset();
        generator.writeNumber(Float.POSITIVE_INFINITY);
        result = outputStream.toString("UTF-8");
        assertEquals("Infinity", result);
        // Clear output stream for next test
        outputStream.reset();
        generator.writeNumber(Float.NEGATIVE_INFINITY);
        result = outputStream.toString("UTF-8");
        assertEquals("-Infinity", result);
    }

    @Test
    public void testWriteNumber_QuotingNonNumeric() throws IOException {
        // Assuming _cfgNumbersAsStrings is set to true
        // Mocking the private field using reflection
        setPrivateField(generator, "_cfgNumbersAsStrings", true);
        generator.writeNumber(Float.NaN);
        String result = outputStream.toString("UTF-8");
        assertEquals("\"NaN\"", result);
        // Clear output stream for next test
        outputStream.reset();
        generator.writeNumber(Float.POSITIVE_INFINITY);
        result = outputStream.toString("UTF-8");
        assertEquals("\"Infinity\"", result);
        // Clear output stream for next test
        outputStream.reset();
        generator.writeNumber(Float.NEGATIVE_INFINITY);
        result = outputStream.toString("UTF-8");
        assertEquals("\"-Infinity\"", result);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }
}
