package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import java.math.BigDecimal;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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
        IOContext ioContext = new IOContext(null, outputStream, false);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteNumber_NullValue() throws Exception {
        invokeWriteNumber(null);
        String result = outputStream.toString("UTF-8");
        assertEquals("null", result);
    }

    @Test
    public void testWriteNumber_Zero() throws Exception {
        invokeWriteNumber(BigDecimal.ZERO);
        String result = outputStream.toString("UTF-8");
        assertEquals("0", result);
    }

    @Test
    public void testWriteNumber_PositiveValue() throws Exception {
        invokeWriteNumber(new BigDecimal("123.45"));
        String result = outputStream.toString("UTF-8");
        assertEquals("123.45", result);
    }

    @Test
    public void testWriteNumber_NegativeValue() throws Exception {
        invokeWriteNumber(new BigDecimal("-123.45"));
        String result = outputStream.toString("UTF-8");
        assertEquals("-123.45", result);
    }

    @Test
    public void testWriteNumber_BigValue() throws Exception {
        invokeWriteNumber(new BigDecimal("12345678901234567890.123456789"));
        String result = outputStream.toString("UTF-8");
        assertEquals("12345678901234567890.123456789", result);
    }

    private void invokeWriteNumber(BigDecimal value) throws Exception {
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("writeNumber", BigDecimal.class);
        method.setAccessible(true);
        method.invoke(generator, value);
        generator.flush();
    }
}
