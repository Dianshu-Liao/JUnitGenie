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

public class WriterBasedJsonGenerator_writeRaw_27_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter stringWriter;

    @BeforeEach
    public void setUp() {
        stringWriter = new StringWriter();
        generator = new WriterBasedJsonGenerator(Mockito.mock(IOContext.class), 0, null, stringWriter, '"');
        // Initialize output buffer for testing
        generator._outputBuffer = new char[64];
        generator._outputTail = 0;
        generator._outputEnd = generator._outputBuffer.length;
    }

    @Test
    public void testWriteRaw_FitsInBuffer() throws IOException {
        String text = "Hello, World!";
        int offset = 0;
        int len = text.length();
        generator.writeRaw(text, offset, len);
        assertEquals("Hello, World!", stringWriter.toString());
        assertEquals(len, generator._outputTail);
    }

    @Test
    public void testWriteRaw_NeedsFlush() throws IOException {
        String text = "This is a long text that exceeds the buffer size.";
        int offset = 0;
        int len = text.length();
        // Set output buffer to a smaller size
        // Simulate a smaller buffer
        generator._outputEnd = 16;
        generator.writeRaw(text, offset, len);
        assertTrue(stringWriter.toString().contains("This is a long text that exceeds the buffer size."));
        assertEquals(len, generator._outputTail);
    }

    @Test
    public void testWriteRaw_EmptyString() throws IOException {
        String text = "";
        int offset = 0;
        int len = text.length();
        generator.writeRaw(text, offset, len);
        assertEquals("", stringWriter.toString());
        assertEquals(0, generator._outputTail);
    }

    @Test
    public void testWriteRaw_InvalidRange() {
        String text = "Hello";
        assertThrows(IndexOutOfBoundsException.class, () -> {
            // Invalid length
            generator.writeRaw(text, 0, 10);
        });
    }

    @Test
    public void testWriteRaw_NegativeOffset() {
        String text = "Hello";
        assertThrows(IndexOutOfBoundsException.class, () -> {
            // Invalid offset
            generator.writeRaw(text, -1, 3);
        });
    }

    @Test
    public void testWriteRaw_NegativeLength() {
        String text = "Hello";
        assertThrows(IndexOutOfBoundsException.class, () -> {
            // Invalid length
            generator.writeRaw(text, 0, -1);
        });
    }

    @Test
    public void testWriteRaw_ExactBufferSize() throws IOException {
        String text = "BufferSizeTest";
        int offset = 0;
        int len = text.length();
        // Adjust output buffer size to match the text length
        generator._outputEnd = len;
        generator.writeRaw(text, offset, len);
        assertEquals("BufferSizeTest", stringWriter.toString());
        assertEquals(len, generator._outputTail);
    }

    @Test
    public void testWriteRaw_SmallBufferAfterFlush() throws IOException {
        String text = "Short text";
        int offset = 0;
        int len = text.length();
        // Set output buffer to a smaller size
        // Simulate a smaller buffer
        generator._outputEnd = 5;
        generator.writeRaw(text, offset, len);
        assertTrue(stringWriter.toString().contains("Short text"));
        assertEquals(len, generator._outputTail);
    }
}
