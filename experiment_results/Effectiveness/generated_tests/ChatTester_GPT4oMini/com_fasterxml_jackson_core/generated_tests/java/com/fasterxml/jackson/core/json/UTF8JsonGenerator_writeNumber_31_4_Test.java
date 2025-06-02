// Test method
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

public class UTF8JsonGenerator_writeNumber_31_4_Test {

    private ByteArrayOutputStream outputStream;

    private UTF8JsonGenerator jsonGenerator;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        jsonGenerator = new UTF8JsonGenerator(mock(IOContext.class), 0, mock(ObjectCodec.class), outputStream, '"');
    }

    @Test
    public void testWriteNumber() throws Exception {
        // Set up the output buffer and necessary fields for the test
        byte[] outputBuffer = new byte[512];
        setPrivateField(jsonGenerator, "_outputBuffer", outputBuffer);
        setPrivateField(jsonGenerator, "_outputTail", 0);
        setPrivateField(jsonGenerator, "_outputEnd", outputBuffer.length);
        setPrivateField(jsonGenerator, "_cfgNumbersAsStrings", false);
        // Invoke the focal method
        short numberToWrite = 123;
        jsonGenerator.writeNumber(numberToWrite);
        // Verify the output buffer content
        assertArrayEquals("123".getBytes(), outputStream.toByteArray());
        assertEquals(3, getPrivateField(jsonGenerator, "_outputTail"));
    }

    @Test
    public void testWriteNumberWithBufferFlush() throws Exception {
        // Set up the output buffer to trigger a flush
        // Small buffer to force a flush
        byte[] outputBuffer = new byte[5];
        setPrivateField(jsonGenerator, "_outputBuffer", outputBuffer);
        setPrivateField(jsonGenerator, "_outputTail", 0);
        setPrivateField(jsonGenerator, "_outputEnd", outputBuffer.length);
        setPrivateField(jsonGenerator, "_cfgNumbersAsStrings", false);
        // Mock the flush method
        Method flushBufferMethod = UTF8JsonGenerator.class.getDeclaredMethod("_flushBuffer");
        flushBufferMethod.setAccessible(true);
        flushBufferMethod.invoke(jsonGenerator);
        // Invoke the focal method
        short numberToWrite = 12345;
        jsonGenerator.writeNumber(numberToWrite);
        // Verify the output buffer content
        assertArrayEquals("12345".getBytes(), outputStream.toByteArray());
        assertEquals(5, getPrivateField(jsonGenerator, "_outputTail"));
    }

    @Test
    public void testWriteNumberAsString() throws Exception {
        // Set up the output buffer and necessary fields for the test
        byte[] outputBuffer = new byte[512];
        setPrivateField(jsonGenerator, "_outputBuffer", outputBuffer);
        setPrivateField(jsonGenerator, "_outputTail", 0);
        setPrivateField(jsonGenerator, "_outputEnd", outputBuffer.length);
        setPrivateField(jsonGenerator, "_cfgNumbersAsStrings", true);
        // Mock the method for writing quoted short
        Method writeQuotedShortMethod = UTF8JsonGenerator.class.getDeclaredMethod("_writeQuotedShort", short.class);
        writeQuotedShortMethod.setAccessible(true);
        // Invoke the focal method
        short numberToWrite = 123;
        writeQuotedShortMethod.invoke(jsonGenerator, numberToWrite);
        // Verify the output buffer content
        assertArrayEquals("\"123\"".getBytes(), outputStream.toByteArray());
        assertEquals(5, getPrivateField(jsonGenerator, "_outputTail"));
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private Object getPrivateField(Object obj, String fieldName) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}
