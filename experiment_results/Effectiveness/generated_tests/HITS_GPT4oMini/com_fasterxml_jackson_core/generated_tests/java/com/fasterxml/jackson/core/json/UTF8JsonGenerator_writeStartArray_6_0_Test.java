package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.ContentReference;
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

public class UTF8JsonGenerator_writeStartArray_6_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() throws IOException {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(StreamReadConstraints.defaults(), StreamWriteConstraints.defaults(), ErrorReportConfiguration.defaults(), new BufferRecycler(), ContentReference.rawReference(null), true);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteStartArray() throws IOException {
        generator.writeStartArray(null);
        assertEquals("[", outputStream.toString());
    }

    @Test
    public void testWriteStartArray_EmptyBuffer() throws IOException {
        byte[] smallBuffer = new byte[1];
        generator = new UTF8JsonGenerator(new IOContext(StreamReadConstraints.defaults(), StreamWriteConstraints.defaults(), ErrorReportConfiguration.defaults(), new BufferRecycler(), ContentReference.rawReference(null), true), 0, null, outputStream, '"', smallBuffer, 0, true);
        generator.writeStartArray(null);
        assertEquals("[", outputStream.toString());
    }

    @Test
    public void testWriteStartArray_NestingDepthExceeded() {
        StreamReadConstraints readConstraints = StreamReadConstraints.defaults();
        StreamWriteConstraints writeConstraints = StreamWriteConstraints.defaults();
        generator = new UTF8JsonGenerator(new IOContext(readConstraints, writeConstraints, ErrorReportConfiguration.defaults(), new BufferRecycler(), ContentReference.rawReference(null), true), 0, null, outputStream, '"');
        assertDoesNotThrow(() -> generator.writeStartArray(null));
        assertThrows(StreamConstraintsException.class, () -> {
            for (int i = 0; i < 2; i++) {
                generator.writeStartArray(null);
            }
        });
    }
}
