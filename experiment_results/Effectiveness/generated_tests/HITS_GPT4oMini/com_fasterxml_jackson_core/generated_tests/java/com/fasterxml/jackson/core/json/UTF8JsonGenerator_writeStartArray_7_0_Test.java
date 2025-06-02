package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
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

public class UTF8JsonGenerator_writeStartArray_7_0_Test {

    private ByteArrayOutputStream outputStream;

    private UTF8JsonGenerator jsonGenerator;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        BufferRecycler bufferRecycler = new BufferRecycler();
        IOContext ioContext = new IOContext(StreamReadConstraints.defaults(), StreamWriteConstraints.defaults(), ErrorReportConfiguration.defaults(), bufferRecycler, null, false);
        jsonGenerator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteStartArray() throws IOException {
        Object currentValue = new Object();
        int size = 0;
        jsonGenerator.writeStartArray(currentValue, size);
        assertEquals("[", outputStream.toString(), "Output should contain the start of an array");
    }

    @Test
    public void testWriteStartArrayWithNonZeroSize() throws IOException {
        Object currentValue = new Object();
        int size = 5;
        jsonGenerator.writeStartArray(currentValue, size);
        assertEquals("[", outputStream.toString(), "Output should contain the start of an array");
    }

    @Test
    public void testWriteStartArrayFlushesBuffer() throws IOException {
        Object currentValue = new Object();
        int size = 1;
        jsonGenerator.writeStartArray(currentValue, size);
        assertEquals("[", outputStream.toString(), "Output should contain the start of an array");
    }

    @Test
    public void testWriteStartArrayHandlesNestingDepth() throws IOException {
        Object currentValue = new Object();
        int size = 1;
        jsonGenerator.writeStartArray(currentValue, size);
        jsonGenerator.writeStartArray(currentValue, size);
        assertEquals("[[", outputStream.toString(), "Output should contain the start of a nested array");
    }

    @Test
    public void testWriteStartArrayThrowsExceptionOnMaxDepthExceeded() {
        Object currentValue = new Object();
        int size = 1;
        try {
            jsonGenerator.streamWriteConstraints().validateNestingDepth(1001);
            jsonGenerator.writeStartArray(currentValue, size);
            fail("Expected StreamConstraintsException to be thrown");
        } catch (StreamConstraintsException e) {
            assertEquals("Document nesting depth (1001) exceeds the maximum allowed (1000, from getMaxNestingDepth)", e.getMessage());
        } catch (IOException e) {
            fail("Expected StreamConstraintsException but caught IOException: " + e.getMessage());
        }
    }
}
