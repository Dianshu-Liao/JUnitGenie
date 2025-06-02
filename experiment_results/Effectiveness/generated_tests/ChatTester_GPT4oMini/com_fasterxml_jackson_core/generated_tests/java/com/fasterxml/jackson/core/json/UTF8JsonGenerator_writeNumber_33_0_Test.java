package com.fasterxml.jackson.core.json;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.IOContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.NumberOutput;

public class UTF8JsonGenerator_writeNumber_33_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() throws Exception {
        outputStream = new ByteArrayOutputStream();
        // Assuming IOContext and ObjectCodec are mocked or created as needed
        IOContext context = mock(IOContext.class);
        ObjectCodec codec = mock(ObjectCodec.class);
        generator = new UTF8JsonGenerator(context, 0, codec, outputStream, '"');
        setPrivateField(generator, "_outputBuffer", new byte[512]);
        setPrivateField(generator, "_outputTail", 0);
        setPrivateField(generator, "_outputEnd", 512);
        // Set to false for direct number output
        setPrivateField(generator, "_cfgNumbersAsStrings", false);
    }

    @Test
    public void testWriteNumber() throws Exception {
        // Test writing a positive number
        invokeWriteNumber(123);
        assertEquals("123", outputStream.toString("UTF-8"));
        // Clear output for next test
        outputStream.reset();
        // Test writing a negative number
        invokeWriteNumber(-456);
        assertEquals("-456", outputStream.toString("UTF-8"));
        // Clear output for next test
        outputStream.reset();
        // Test writing zero
        invokeWriteNumber(0);
        assertEquals("0", outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteNumberFlushBuffer() throws Exception {
        // Set the output tail to a value that requires a flush
        // Set tail close to buffer limit
        setPrivateField(generator, "_outputTail", 502);
        // Set end to buffer size
        setPrivateField(generator, "_outputEnd", 512);
        // This should trigger a buffer flush
        invokeWriteNumber(1000);
        assertEquals("1000", outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteNumberAsString() throws Exception {
        // Set configuration to write numbers as strings
        setPrivateField(generator, "_cfgNumbersAsStrings", true);
        invokeWriteNumber(789);
        // Check for quoted output
        assertEquals("\"789\"", outputStream.toString("UTF-8"));
        outputStream.reset();
        invokeWriteNumber(-321);
        // Check for quoted output
        assertEquals("\"-321\"", outputStream.toString("UTF-8"));
    }

    private void invokeWriteNumber(int number) throws Exception {
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("writeNumber", int.class);
        method.setAccessible(true);
        method.invoke(generator, number);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
