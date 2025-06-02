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

public class UTF8JsonGenerator_writeNumber_33_0_Test {

    private ByteArrayOutputStream outputStream;

    private UTF8JsonGenerator jsonGenerator;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, null, null, null, null, true);
        jsonGenerator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteNumberPositive() throws Exception {
        invokeWriteNumber(123);
        assertArrayEquals("123".getBytes(), outputStream.toByteArray());
    }

    @Test
    public void testWriteNumberNegative() throws Exception {
        invokeWriteNumber(-456);
        assertArrayEquals("-456".getBytes(), outputStream.toByteArray());
    }

    @Test
    public void testWriteNumberZero() throws Exception {
        invokeWriteNumber(0);
        assertArrayEquals("0".getBytes(), outputStream.toByteArray());
    }

    @Test
    public void testWriteNumberMaxInteger() throws Exception {
        invokeWriteNumber(Integer.MAX_VALUE);
        assertArrayEquals("2147483647".getBytes(), outputStream.toByteArray());
    }

    @Test
    public void testWriteNumberMinInteger() throws Exception {
        invokeWriteNumber(Integer.MIN_VALUE);
        assertArrayEquals("-2147483648".getBytes(), outputStream.toByteArray());
    }

    private void invokeWriteNumber(int number) throws Exception {
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("writeNumber", int.class);
        method.setAccessible(true);
        method.invoke(jsonGenerator, number);
    }
}
