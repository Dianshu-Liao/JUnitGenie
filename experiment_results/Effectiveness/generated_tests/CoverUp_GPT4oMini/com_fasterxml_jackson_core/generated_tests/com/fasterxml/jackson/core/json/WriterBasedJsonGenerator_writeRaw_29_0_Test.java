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

public class WriterBasedJsonGenerator_writeRaw_29_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        IOContext ioContext = new IOContext(null, null, null, null, null, true);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, writer);
        // Initialize output buffer
        // Assuming a buffer size
        generator._outputBuffer = new char[64];
        generator._outputEnd = generator._outputBuffer.length;
        generator._outputTail = 0;
        generator._outputHead = 0;
    }

    @Test
    public void testWriteRawShortWrite() throws Exception {
        char[] input = "Hello".toCharArray();
        generator.writeRaw(input, 0, 5);
        assertEquals("Hello", writer.toString());
    }

    @Test
    public void testWriteRawLongWrite() throws Exception {
        char[] input = "This is a long write test".toCharArray();
        generator.writeRaw(input, 0, input.length);
        assertEquals("This is a long write test", writer.toString());
    }

    @Test
    public void testWriteRawEmptyInput() throws Exception {
        char[] input = new char[0];
        generator.writeRaw(input, 0, 0);
        assertEquals("", writer.toString());
    }

    @Test
    public void testWriteRawInvalidRange() {
        char[] input = "Test".toCharArray();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            // Invalid length
            generator.writeRaw(input, 0, 10);
        });
    }

    @Test
    public void testWriteRawNegativeOffset() {
        char[] input = "Test".toCharArray();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            // Invalid offset
            generator.writeRaw(input, -1, 4);
        });
    }

    @Test
    public void testWriteRawNegativeLength() {
        char[] input = "Test".toCharArray();
        assertThrows(IllegalArgumentException.class, () -> {
            // Invalid length
            generator.writeRaw(input, 0, -1);
        });
    }

    @Test
    public void testFlushBufferCalledOnLongWrite() throws Exception {
        char[] input = "This is a long write test".toCharArray();
        Method flushBufferMethod = WriterBasedJsonGenerator.class.getDeclaredMethod("_flushBuffer");
        flushBufferMethod.setAccessible(true);
        // Mock the flushBuffer behavior
        // Simulate full buffer
        generator._outputTail = generator._outputEnd;
        generator.writeRaw(input, 0, input.length);
        // Verify that the content is written to the writer
        assertEquals("This is a long write test", writer.toString());
    }
}
