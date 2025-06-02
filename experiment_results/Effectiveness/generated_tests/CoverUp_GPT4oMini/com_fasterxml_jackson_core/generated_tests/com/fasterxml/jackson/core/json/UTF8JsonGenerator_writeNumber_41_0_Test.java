package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
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
import com.fasterxml.jackson.core.io.NumberOutput;

public class UTF8JsonGenerator_writeNumber_41_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, null, null, false);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteNumber_NullValue() throws Exception {
        invokeWriteNumber(null);
        assertArrayEquals("null".getBytes(), outputStream.toByteArray());
    }

    @Test
    public void testWriteNumber_StringValue() throws Exception {
        invokeWriteNumber("123");
        assertArrayEquals("123".getBytes(), outputStream.toByteArray());
    }

    @Test
    public void testWriteNumber_StringValueAsQuoted() throws Exception {
        setNumbersAsStrings(true);
        invokeWriteNumber("123");
        assertArrayEquals("\"123\"".getBytes(), outputStream.toByteArray());
    }

    @Test
    public void testWriteNumber_EmptyString() throws Exception {
        invokeWriteNumber("");
        assertArrayEquals("".getBytes(), outputStream.toByteArray());
    }

    private void invokeWriteNumber(String value) throws Exception {
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("writeNumber", String.class);
        method.setAccessible(true);
        method.invoke(generator, value);
    }

    private void setNumbersAsStrings(boolean value) throws Exception {
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("setNumbersAsStrings", boolean.class);
        method.setAccessible(true);
        method.invoke(generator, value);
    }
}
