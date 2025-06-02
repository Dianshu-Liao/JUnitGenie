package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
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

public class WriterBasedJsonGenerator_writeNumber_42_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter stringWriter;

    @BeforeEach
    public void setUp() {
        stringWriter = new StringWriter();
        IOContext ioContext = new IOContext(null, null, null, null, null, false);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, stringWriter);
    }

    @Test
    public void testWriteNumber_FiniteFloat() throws Exception {
        float value = 123.45f;
        invokeWriteNumber(value);
        assertEquals("123.45", stringWriter.toString());
    }

    @Test
    public void testWriteNumber_NegativeFloat() throws Exception {
        float value = -123.45f;
        invokeWriteNumber(value);
        assertEquals("-123.45", stringWriter.toString());
    }

    @Test
    public void testWriteNumber_Zero() throws Exception {
        float value = 0.0f;
        invokeWriteNumber(value);
        assertEquals("0.0", stringWriter.toString());
    }

    @Test
    public void testWriteNumber_NonFiniteFloat_NaN() throws Exception {
        float value = Float.NaN;
        invokeWriteNumber(value);
        assertEquals("NaN", stringWriter.toString());
    }

    @Test
    public void testWriteNumber_NonFiniteFloat_Infinity() throws Exception {
        float value = Float.POSITIVE_INFINITY;
        invokeWriteNumber(value);
        assertEquals("Infinity", stringWriter.toString());
    }

    @Test
    public void testWriteNumber_NonFiniteFloat_NegativeInfinity() throws Exception {
        float value = Float.NEGATIVE_INFINITY;
        invokeWriteNumber(value);
        assertEquals("-Infinity", stringWriter.toString());
    }

    private void invokeWriteNumber(float value) throws Exception {
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("writeNumber", float.class);
        method.setAccessible(true);
        method.invoke(generator, value);
    }
}
