package com.fasterxml.jackson.core.json;

import java.math.BigInteger;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
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

class UTF8JsonGenerator_writeNumber_37_1_Test {

    private ByteArrayOutputStream outputStream;

    private UTF8JsonGenerator generator;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        generator = new UTF8JsonGenerator(mock(IOContext.class), 0, mock(ObjectCodec.class), outputStream, '"');
    }

    @Test
    void testWriteNumber_NullValue() throws IOException {
        // Fixed ambiguous reference
        generator.writeNumber((BigDecimal) null);
        assertEquals("null", outputStream.toString("UTF-8"));
    }

    @Test
    void testWriteNumber_AsString() throws IOException {
        // Set the configuration to write numbers as strings
        setPrivateField(generator, "_cfgNumbersAsStrings", true);
        generator.writeNumber(BigInteger.valueOf(123));
        assertEquals("\"123\"", outputStream.toString("UTF-8"));
    }

    @Test
    void testWriteNumber_AsRaw() throws IOException {
        // Set the configuration to not write numbers as strings
        setPrivateField(generator, "_cfgNumbersAsStrings", false);
        generator.writeNumber(BigInteger.valueOf(456));
        assertEquals("456", outputStream.toString("UTF-8"));
    }

    @Test
    void testWriteNumber_NegativeValue() throws IOException {
        generator.writeNumber(BigInteger.valueOf(-789));
        assertEquals("-789", outputStream.toString("UTF-8"));
    }

    @Test
    void testWriteNumber_LargeValue() throws IOException {
        generator.writeNumber(new BigInteger("123456789012345678901234567890"));
        assertEquals("123456789012345678901234567890", outputStream.toString("UTF-8"));
    }

    private void setPrivateField(Object object, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object, value);
        } catch (Exception e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }
}
