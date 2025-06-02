package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.BufferRecycler;
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

public class UTF8JsonGenerator_writeStartArray_5_1_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        BufferRecycler bufferRecycler = new BufferRecycler();
        IOContext ioContext = new IOContext(bufferRecycler, null, false);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteStartArray() throws IOException {
        generator.writeStartArray();
        assertEquals("[", outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteStartArrayWithBufferFlush() throws IOException {
        for (int i = 0; i < 511; i++) {
            generator.writeStartArray();
        }
        generator.writeStartArray();
        assertEquals("[", outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteStartArrayMultipleCalls() throws IOException {
        generator.writeStartArray();
        generator.writeStartArray();
        assertEquals("[[", outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteStartArrayThrowsExceptionOnNestingLimit() {
        // Use defaults instead
        StreamWriteConstraints constraints = StreamWriteConstraints.defaults();
        BufferRecycler bufferRecycler = new BufferRecycler();
        IOContext ioContext = new IOContext(bufferRecycler, constraints, false);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
        try {
            generator.writeStartArray();
            generator.writeStartArray();
            fail("Expected IOException was not thrown");
        } catch (IOException exception) {
            String expectedMessage = "Document nesting depth (2) exceeds the maximum allowed (1, from getMaxNestingDepth)";
            assertTrue(exception.getMessage().contains(expectedMessage));
        }
    }
}
