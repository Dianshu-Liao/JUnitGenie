package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
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

public class UTF8JsonGenerator_writeNumber_39_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, null, null, null, null, false);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteNumber_FiniteFloat() throws Exception {
        float value = 123.45f;
        invokeWriteNumber(value);
        byte[] expectedOutput = "123.45".getBytes();
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWriteNumber_NegativeFloat() throws Exception {
        float value = -123.45f;
        invokeWriteNumber(value);
        byte[] expectedOutput = "-123.45".getBytes();
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWriteNumber_Zero() throws Exception {
        float value = 0.0f;
        invokeWriteNumber(value);
        byte[] expectedOutput = "0.0".getBytes();
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWriteNumber_NaN() throws Exception {
        float value = Float.NaN;
        invokeWriteNumber(value);
        // Assuming it quotes NaN
        byte[] expectedOutput = "\"NaN\"".getBytes();
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWriteNumber_Infinity() throws Exception {
        float value = Float.POSITIVE_INFINITY;
        invokeWriteNumber(value);
        // Assuming it quotes Infinity
        byte[] expectedOutput = "\"Infinity\"".getBytes();
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    private void invokeWriteNumber(float value) throws Exception {
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("writeNumber", float.class);
        method.setAccessible(true);
        method.invoke(generator, value);
        // Reset the output stream for the next test
        outputStream.reset();
    }
}
