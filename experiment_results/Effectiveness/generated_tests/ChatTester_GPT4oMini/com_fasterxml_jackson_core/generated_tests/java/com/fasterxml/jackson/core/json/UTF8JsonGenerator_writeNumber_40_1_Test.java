package com.fasterxml.jackson.core.json;

import java.math.BigDecimal;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

public class UTF8JsonGenerator_writeNumber_40_1_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ctxt = mock(IOContext.class);
        ObjectCodec codec = mock(ObjectCodec.class);
        generator = new UTF8JsonGenerator(ctxt, 0, codec, outputStream, '"');
    }

    @Test
    public void testWriteNumber_NullValue() throws IOException {
        // Fixing the ambiguous call by casting null to BigDecimal
        generator.writeNumber((BigDecimal) null);
        assertEquals("null", outputStream.toString());
    }

    @Test
    public void testWriteNumber_AsString() throws IOException {
        // Assuming _cfgNumbersAsStrings is true
        setPrivateField(generator, "_cfgNumbersAsStrings", true);
        BigDecimal value = new BigDecimal("123.45");
        generator.writeNumber(value);
        assertEquals("\"123.45\"", outputStream.toString());
    }

    @Test
    public void testWriteNumber_AsRaw() throws IOException {
        // Assuming _cfgNumbersAsStrings is false
        setPrivateField(generator, "_cfgNumbersAsStrings", false);
        BigDecimal value = new BigDecimal("123.45");
        generator.writeNumber(value);
        assertEquals("123.45", outputStream.toString());
    }

    @Test
    public void testWriteNumber_NegativeValue() throws IOException {
        BigDecimal value = new BigDecimal("-123.45");
        generator.writeNumber(value);
        assertEquals("-123.45", outputStream.toString());
    }

    @Test
    public void testWriteNumber_ZeroValue() throws IOException {
        BigDecimal value = new BigDecimal("0");
        generator.writeNumber(value);
        assertEquals("0", outputStream.toString());
    }

    @Test
    public void testWriteNumber_LargeValue() throws IOException {
        BigDecimal value = new BigDecimal("12345678901234567890.123456789");
        generator.writeNumber(value);
        assertEquals("12345678901234567890.123456789", outputStream.toString());
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
