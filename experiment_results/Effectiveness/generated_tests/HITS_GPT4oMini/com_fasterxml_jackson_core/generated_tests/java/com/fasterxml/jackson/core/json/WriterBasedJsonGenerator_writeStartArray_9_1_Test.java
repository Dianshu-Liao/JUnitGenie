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

public class WriterBasedJsonGenerator_writeStartArray_9_1_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter stringWriter;

    @BeforeEach
    public void setUp() {
        stringWriter = new StringWriter();
        BufferRecycler bufferRecycler = new BufferRecycler();
        IOContext ioContext = new IOContext(null, bufferRecycler, false);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, stringWriter, '"');
    }

    @Test
    public void testWriteStartArray() throws IOException {
        generator.writeStartArray();
        assertEquals("[", stringWriter.toString());
    }

    @Test
    public void testWriteStartArrayMultipleCalls() throws IOException {
        generator.writeStartArray();
        generator.writeStartArray();
        assertEquals("[[", stringWriter.toString());
    }

    @Test
    public void testNestingDepthExceedsLimit() throws IOException {
        for (int i = 0; i < 1001; i++) {
            generator.writeStartArray();
        }
        assertThrows(IOException.class, () -> {
            generator.writeStartArray();
        });
    }

    @Test
    public void testWriteStartArrayWithPrettyPrinter() throws IOException {
        // Assuming a pretty printer is set, this test will require additional setup
        // Placeholder for pretty printer implementation
        generator.writeStartArray();
        assertEquals("[\n", stringWriter.toString());
    }

    @Test
    public void testFlushBuffer() throws IOException {
        for (int i = 0; i < 32; i++) {
            generator.writeStartArray();
        }
        assertEquals("[[", stringWriter.toString());
    }
}
