package com.fasterxml.jackson.core.json;

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

public class UTF8JsonGenerator_writeNumber_35_1_Test {

    private UTF8JsonGenerator jsonGenerator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        jsonGenerator = new UTF8JsonGenerator(null, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteNumber() throws Exception {
        // Prepare the test input
        long testNumber = 123456789L;
        // Invoke the focal method using reflection
        Method writeNumberMethod = UTF8JsonGenerator.class.getDeclaredMethod("writeNumber", long.class);
        writeNumberMethod.setAccessible(true);
        // Call the method
        writeNumberMethod.invoke(jsonGenerator, testNumber);
        // Verify the output
        String output = outputStream.toString("UTF-8");
        assertEquals("123456789", output);
    }

    @Test
    public void testWriteNumberWithBufferFlush() throws Exception {
        // Set up the output buffer to be small
        byte[] smallBuffer = new byte[10];
        jsonGenerator = new UTF8JsonGenerator(null, 0, null, outputStream, '"', smallBuffer, 0, true);
        // This will require flushing the buffer
        long testNumber = 1234567890123456789L;
        // Invoke the focal method using reflection
        Method writeNumberMethod = UTF8JsonGenerator.class.getDeclaredMethod("writeNumber", long.class);
        writeNumberMethod.setAccessible(true);
        // Call the method
        writeNumberMethod.invoke(jsonGenerator, testNumber);
        // Verify the output
        String output = outputStream.toString("UTF-8");
        assertEquals("1234567890123456789", output);
    }

    @Test
    public void testWriteNumberNegative() throws Exception {
        long testNumber = -987654321L;
        // Invoke the focal method using reflection
        Method writeNumberMethod = UTF8JsonGenerator.class.getDeclaredMethod("writeNumber", long.class);
        writeNumberMethod.setAccessible(true);
        // Call the method
        writeNumberMethod.invoke(jsonGenerator, testNumber);
        // Verify the output
        String output = outputStream.toString("UTF-8");
        assertEquals("-987654321", output);
    }

    @Test
    public void testWriteNumberZero() throws Exception {
        long testNumber = 0L;
        // Invoke the focal method using reflection
        Method writeNumberMethod = UTF8JsonGenerator.class.getDeclaredMethod("writeNumber", long.class);
        writeNumberMethod.setAccessible(true);
        // Call the method
        writeNumberMethod.invoke(jsonGenerator, testNumber);
        // Verify the output
        String output = outputStream.toString("UTF-8");
        assertEquals("0", output);
    }

    @Test
    public void testWriteNumberMaxLong() throws Exception {
        long testNumber = Long.MAX_VALUE;
        // Invoke the focal method using reflection
        Method writeNumberMethod = UTF8JsonGenerator.class.getDeclaredMethod("writeNumber", long.class);
        writeNumberMethod.setAccessible(true);
        // Call the method
        writeNumberMethod.invoke(jsonGenerator, testNumber);
        // Verify the output
        String output = outputStream.toString("UTF-8");
        assertEquals("9223372036854775807", output);
    }

    @Test
    public void testWriteNumberMinLong() throws Exception {
        long testNumber = Long.MIN_VALUE;
        // Invoke the focal method using reflection
        Method writeNumberMethod = UTF8JsonGenerator.class.getDeclaredMethod("writeNumber", long.class);
        writeNumberMethod.setAccessible(true);
        // Call the method
        writeNumberMethod.invoke(jsonGenerator, testNumber);
        // Verify the output
        String output = outputStream.toString("UTF-8");
        assertEquals("-9223372036854775808", output);
    }
}
