package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;
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

public class UTF8JsonGenerator_writeNumber_31_1_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, null, null, null, null, false);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, (char) '"');
    }

    @Test
    public void testWriteNumber() throws Exception {
        // Test writing a positive short
        invokeWriteNumber((short) 12345);
        assertArrayEquals("12345".getBytes(), outputStream.toByteArray());
        // Clear the output stream for the next test
        outputStream.reset();
        // Test writing a negative short
        invokeWriteNumber((short) -123);
        assertArrayEquals("-123".getBytes(), outputStream.toByteArray());
        // Clear the output stream for the next test
        outputStream.reset();
        // Test writing zero
        invokeWriteNumber((short) 0);
        assertArrayEquals("0".getBytes(), outputStream.toByteArray());
    }

    private void invokeWriteNumber(short value) throws Exception {
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("writeNumber", short.class);
        method.setAccessible(true);
        method.invoke(generator, value);
    }
}
