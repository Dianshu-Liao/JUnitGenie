package com.fasterxml.jackson.core.json;

import java.lang.reflect.Field;
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

public class UTF8JsonGenerator__writeNull_77_1_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        generator = new UTF8JsonGenerator(Mockito.mock(IOContext.class), 0, null, outputStream, '"');
    }

    @Test
    public void testWriteNull() throws Exception {
        // Prepare the generator's internal state
        Method writeNullMethod = UTF8JsonGenerator.class.getDeclaredMethod("_writeNull");
        writeNullMethod.setAccessible(true);
        // Invoke the method to test
        writeNullMethod.invoke(generator);
        // Verify the output
        byte[] expectedOutput = { 'n', 'u', 'l', 'l' };
        byte[] actualOutput = outputStream.toByteArray();
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testWriteNullBufferFlush() throws Exception {
        // Set the output buffer to a state that requires flushing
        // Set tail close to limit
        setOutputTail(510);
        Method writeNullMethod = UTF8JsonGenerator.class.getDeclaredMethod("_writeNull");
        writeNullMethod.setAccessible(true);
        // Invoke the method to test
        writeNullMethod.invoke(generator);
        // Verify the output
        byte[] expectedOutput = { 'n', 'u', 'l', 'l' };
        byte[] actualOutput = outputStream.toByteArray();
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testWriteNullMultipleInvocations() throws Exception {
        Method writeNullMethod = UTF8JsonGenerator.class.getDeclaredMethod("_writeNull");
        writeNullMethod.setAccessible(true);
        // Invoke the method multiple times
        writeNullMethod.invoke(generator);
        writeNullMethod.invoke(generator);
        // Verify the output
        byte[] expectedOutput = { 'n', 'u', 'l', 'l', 'n', 'u', 'l', 'l' };
        byte[] actualOutput = outputStream.toByteArray();
        assertArrayEquals(expectedOutput, actualOutput);
    }

    // Helper method to set the output tail
    private void setOutputTail(int tail) throws Exception {
        Field field = UTF8JsonGenerator.class.getDeclaredField("_outputTail");
        field.setAccessible(true);
        field.setInt(generator, tail);
    }

    @Test
    public void testWriteNullBufferOverflow() throws Exception {
        // Set output buffer to full capacity
        // Set tail at limit
        setOutputTail(512);
        // Call the method that should trigger a buffer flush
        Method writeNullMethod = UTF8JsonGenerator.class.getDeclaredMethod("_writeNull");
        writeNullMethod.setAccessible(true);
        // Invoke the method to test
        writeNullMethod.invoke(generator);
        // Verify the output
        byte[] expectedOutput = { 'n', 'u', 'l', 'l' };
        byte[] actualOutput = outputStream.toByteArray();
        assertArrayEquals(expectedOutput, actualOutput);
    }
}
