package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
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

public class WriterBasedJsonGenerator__flushBuffer_75_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        IOContext ioContext = new IOContext(null, null, null, null, null, false);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, writer);
        // Initialize output buffer
        generator._outputBuffer = new char[64];
        generator._outputHead = 0;
        generator._outputTail = 0;
    }

    @Test
    public void testFlushBuffer_EmptyBuffer() throws Exception {
        // Invoke the _flushBuffer method
        invokeFlushBuffer();
        // Verify that the writer is still empty
        assertEquals("", writer.toString());
    }

    @Test
    public void testFlushBuffer_NonEmptyBuffer() throws Exception {
        // Prepare the buffer with some data
        String testData = "Hello, World!";
        generator._outputBuffer = testData.toCharArray();
        generator._outputTail = testData.length();
        // Invoke the _flushBuffer method
        invokeFlushBuffer();
        // Verify that the written content matches the buffer content
        assertEquals(testData, writer.toString());
    }

    @Test
    public void testFlushBuffer_MultipleFlushes() throws Exception {
        // Prepare the buffer with some data
        String testData1 = "First flush.";
        String testData2 = "Second flush.";
        generator._outputBuffer = testData1.toCharArray();
        generator._outputTail = testData1.length();
        // First flush
        invokeFlushBuffer();
        assertEquals(testData1, writer.toString());
        // Prepare for second flush
        generator._outputBuffer = testData2.toCharArray();
        generator._outputTail = testData2.length();
        // Second flush
        invokeFlushBuffer();
        assertEquals(testData1 + testData2, writer.toString());
    }

    private void invokeFlushBuffer() throws Exception {
        Method flushBufferMethod = WriterBasedJsonGenerator.class.getDeclaredMethod("_flushBuffer");
        flushBufferMethod.setAccessible(true);
        flushBufferMethod.invoke(generator);
    }
}
