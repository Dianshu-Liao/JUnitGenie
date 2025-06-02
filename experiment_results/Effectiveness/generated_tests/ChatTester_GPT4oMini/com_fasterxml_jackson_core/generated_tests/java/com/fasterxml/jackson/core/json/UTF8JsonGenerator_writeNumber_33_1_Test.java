package com.fasterxml.jackson.core.json;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
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

public class UTF8JsonGenerator_writeNumber_33_1_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() throws Exception {
        outputStream = new ByteArrayOutputStream();
        IOContext ctxt = mock(IOContext.class);
        ObjectCodec codec = mock(ObjectCodec.class);
        generator = new UTF8JsonGenerator(ctxt, 0, codec, outputStream, '"');
        setPrivateField(generator, "_outputBuffer", new byte[512]);
        setPrivateField(generator, "_outputTail", 0);
        setPrivateField(generator, "_outputEnd", 512);
        setPrivateField(generator, "_cfgNumbersAsStrings", false);
    }

    @Test
    public void testWriteNumber() throws Exception {
        // Test writing a positive number
        generator.writeNumber(123);
        assertArrayEquals(new byte[] { '1', '2', '3' }, outputStream.toByteArray());
        // Clear output stream for the next test
        outputStream.reset();
        // Test writing a negative number
        generator.writeNumber(-456);
        assertArrayEquals(new byte[] { '-', '4', '5', '6' }, outputStream.toByteArray());
        // Clear output stream for the next test
        outputStream.reset();
        // Test writing a number that requires buffer flush
        setPrivateField(generator, "_outputTail", 500);
        generator.writeNumber(7890);
        assertArrayEquals(new byte[] { '7', '8', '9', '0' }, outputStream.toByteArray());
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private void invokePrivateMethod(Object obj, String methodName, Class<?>[] parameterTypes, Object... args) throws Exception {
        Method method = obj.getClass().getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        method.invoke(obj, args);
    }
}
