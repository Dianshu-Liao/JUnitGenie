package com.fasterxml.jackson.core.json;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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

class UTF8JsonGenerator_writeNumber_41_0_Test {

    private UTF8JsonGenerator jsonGenerator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        jsonGenerator = new UTF8JsonGenerator(null, 0, null, outputStream, '"');
    }

    @Test
    void testWriteNumber_NullValue() throws Exception {
        invokeWriteNumber(null);
        assertEquals("null", outputStream.toString());
    }

    @Test
    void testWriteNumber_QuotedValue() throws Exception {
        setConfigNumbersAsStrings(true);
        invokeWriteNumber("123");
        assertEquals("\"123\"", outputStream.toString());
    }

    @Test
    void testWriteNumber_RawValue() throws Exception {
        setConfigNumbersAsStrings(false);
        invokeWriteNumber("123");
        assertEquals("123", outputStream.toString());
    }

    @Test
    void testWriteNumber_EmptyString() throws Exception {
        setConfigNumbersAsStrings(false);
        invokeWriteNumber("");
        assertEquals("", outputStream.toString());
    }

    @Test
    void testWriteNumber_QuotedEmptyString() throws Exception {
        setConfigNumbersAsStrings(true);
        invokeWriteNumber("");
        assertEquals("\"\"", outputStream.toString());
    }

    private void setConfigNumbersAsStrings(boolean value) throws Exception {
        Field field = UTF8JsonGenerator.class.getDeclaredField("_cfgNumbersAsStrings");
        field.setAccessible(true);
        field.set(jsonGenerator, value);
    }

    private void invokeWriteNumber(String value) throws Exception {
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("writeNumber", String.class);
        method.setAccessible(true);
        method.invoke(jsonGenerator, value);
    }
}
