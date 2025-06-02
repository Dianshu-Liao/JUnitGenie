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

class WriterBasedJsonGenerator_writeStartArray_9_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter stringWriter;

    @BeforeEach
    void setUp() {
        stringWriter = new StringWriter();
        generator = new WriterBasedJsonGenerator(new IOContext(StreamReadConstraints.defaults(), StreamWriteConstraints.defaults(), ErrorReportConfiguration.defaults(), new BufferRecycler(), null, false), 0, null, stringWriter);
    }

    @Test
    void testWriteStartArray_ValidCall() throws IOException {
        generator.writeStartArray();
        assertEquals("[", stringWriter.toString());
    }

    @Test
    void testWriteStartArray_NestingDepth() throws IOException {
        generator.writeStartArray();
        generator.writeStartArray();
        assertEquals("[[", stringWriter.toString());
    }

    @Test
    void testWriteStartArray_WhenNestingDepthExceeded() {
        assertThrows(IOException.class, () -> {
            for (int i = 0; i < StreamWriteConstraints.DEFAULT_MAX_DEPTH + 1; i++) {
                generator.writeStartArray();
            }
        });
    }

    @Test
    void testWriteStartArray_EmptyBuffer() throws IOException {
        generator.writeStartArray();
        generator.writeStartArray();
        // Simulate an empty output buffer
        generator._outputTail = generator._outputEnd;
        generator.writeStartArray();
        assertEquals("[[[", stringWriter.toString());
    }

    @Test
    void testWriteStartArray_WithPrettyPrinter() throws IOException {
        generator.setPrettyPrinter(new PrettyPrinterMock());
        generator.writeStartArray();
        assertEquals("[\n", stringWriter.toString());
    }

    // Mock implementation of a pretty printer for testing purposes
    private static class PrettyPrinterMock extends com.fasterxml.jackson.core.util.DefaultPrettyPrinter {

        @Override
        public void writeStartArray(JsonGenerator jg) throws IOException {
            jg.writeRaw("[\n");
        }
    }
}
