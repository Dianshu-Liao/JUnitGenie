package com.fasterxml.jackson.core.json;

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

public class WriterBasedJsonGenerator__flushBuffer_75_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        generator = new WriterBasedJsonGenerator(null, 0, null, writer);
        // Assuming _outputBuffer is initialized in the constructor or somewhere
        // Example size
        generator._outputBuffer = new char[64];
        generator._outputHead = 0;
        generator._outputTail = 0;
    }

    @Test
    public void testFlushBufferWithEmptyBuffer() throws IOException {
        generator._flushBuffer();
        assertEquals("", writer.toString());
    }

    @Test
    public void testFlushBufferWithData() throws IOException {
        // Prepare the buffer with data
        String data = "Hello, World!";
        generator._outputBuffer = data.toCharArray();
        generator._outputTail = data.length();
        generator._outputHead = 0;
        generator._flushBuffer();
        assertEquals(data, writer.toString());
        assertEquals(0, generator._outputHead);
        assertEquals(0, generator._outputTail);
    }

    @Test
    public void testFlushBufferWithPartialData() throws IOException {
        // Prepare the buffer with data
        String data = "Hello, World!";
        generator._outputBuffer = data.toCharArray();
        // Only flush the first 5 characters
        generator._outputTail = 5;
        generator._outputHead = 0;
        generator._flushBuffer();
        assertEquals("Hello", writer.toString());
        assertEquals(0, generator._outputHead);
        assertEquals(0, generator._outputTail);
    }

    @Test
    public void testFlushBufferWithNegativeLength() throws IOException {
        // Invalid state for testing
        generator._outputHead = 10;
        // Invalid state for testing
        generator._outputTail = 5;
        assertThrows(IOException.class, () -> {
            generator._flushBuffer();
        });
    }

    @Test
    public void testFlushBufferWithExactBufferSize() throws IOException {
        // Prepare the buffer with data exactly fitting the buffer size
        String data = "ExactSizeData";
        generator._outputBuffer = data.toCharArray();
        generator._outputTail = data.length();
        generator._outputHead = 0;
        generator._flushBuffer();
        assertEquals(data, writer.toString());
        assertEquals(0, generator._outputHead);
        assertEquals(0, generator._outputTail);
    }
}
