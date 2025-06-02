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

public class UTF8JsonGenerator_writeStartArray_6_1_Test {

    private ByteArrayOutputStream outputStream;

    private UTF8JsonGenerator jsonGenerator;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(new BufferRecycler(), null, true);
        jsonGenerator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteStartArray() throws IOException {
        jsonGenerator.writeStartArray(null);
        jsonGenerator.flush();
        byte[] expectedOutput = new byte[] { '[' };
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWriteStartArrayWithNestedContext() throws IOException {
        // Start first array
        jsonGenerator.writeStartArray(null);
        // Start nested array
        jsonGenerator.writeStartArray(null);
        jsonGenerator.flush();
        byte[] expectedOutput = new byte[] { '[', '[' };
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    @SuppressWarnings("deprecation")
    public void testWriteStartArrayMaxNestingDepth() throws IOException {
        // Set a low max nesting depth
        StreamWriteConstraints constraints = StreamWriteConstraints.defaults();
        IOContext ioContext = new IOContext(new BufferRecycler(), null, true);
        jsonGenerator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
        // Start first array
        jsonGenerator.writeStartArray(null);
        assertThrows(IOException.class, () -> {
            // Attempt to start nested array
            jsonGenerator.writeStartArray(null);
        });
    }

    @Test
    public void testWriteStartArrayFlushesBuffer() throws IOException {
        // Fill the output buffer to test flushing
        for (int i = 0; i < 512; i++) {
            outputStream.write(i);
        }
        // This should trigger a flush
        jsonGenerator.writeStartArray(null);
        jsonGenerator.flush();
        byte[] expectedOutput = new byte[512 + 1];
        for (int i = 0; i < 512; i++) {
            expectedOutput[i] = (byte) i;
        }
        expectedOutput[512] = '[';
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }
}
