package com.fasterxml.jackson.core.json;

import java.math.BigDecimal;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        generator = new UTF8JsonGenerator(mock(IOContext.class), 0, mock(ObjectCodec.class), outputStream, '"');
    }

    @Test
    public void testWriteNumber_NullValue() throws IOException {
        // Fixed the ambiguous reference
        generator.writeNumber((BigDecimal) null);
        assertEquals("null", outputStream.toString());
    }

    @Test
    public void testWriteNumber_AsString() throws IOException {
        // Simulate the _cfgNumbersAsStrings being true
        setPrivateField(generator, "_cfgNumbersAsStrings", true);
        generator.writeNumber(new BigDecimal("123.45"));
        assertEquals("\"123.45\"", outputStream.toString());
    }

    @Test
    public void testWriteNumber_NotAsString() throws IOException {
        // Simulate the _cfgNumbersAsStrings being false
        setPrivateField(generator, "_cfgNumbersAsStrings", false);
        generator.writeNumber(new BigDecimal("123.45"));
        assertEquals("123.45", outputStream.toString());
    }

    @Test
    public void testWriteNumber_NegativeValue() throws IOException {
        generator.writeNumber(new BigDecimal("-123.45"));
        assertEquals("-123.45", outputStream.toString());
    }

    @Test
    public void testWriteNumber_ZeroValue() throws IOException {
        generator.writeNumber(BigDecimal.ZERO);
        assertEquals("0", outputStream.toString());
    }

    @Test
    public void testWriteNumber_LargeValue() throws IOException {
        generator.writeNumber(new BigDecimal("12345678901234567890.123456789"));
        assertEquals("12345678901234567890.123456789", outputStream.toString());
    }

    private void setPrivateField(Object target, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
