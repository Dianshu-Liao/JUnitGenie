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

public class WriterBasedJsonGenerator_writeString_21_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        generator = new WriterBasedJsonGenerator(mock(IOContext.class), 0, mock(ObjectCodec.class), writer, '"');
        // Initialize the output buffer
        generator._outputBuffer = new char[64];
        // Set the output end
        generator._outputEnd = 64;
        // Initialize the output tail
        generator._outputTail = 0;
    }

    @Test
    public void testWriteString_WithValidInput_ShouldWriteQuotedString() throws IOException {
        char[] text = "Hello".toCharArray();
        generator.writeString(text, 0, text.length);
        String result = writer.toString();
        assertEquals("\"Hello\"", result);
    }

    @Test
    public void testWriteString_WithBufferFlush_ShouldFlushBufferCorrectly() throws IOException {
        // Set output tail close to the end to trigger flush
        generator._outputTail = 63;
        char[] text = "World".toCharArray();
        generator.writeString(text, 0, text.length);
        String result = writer.toString();
        assertTrue(result.contains("\"World\""));
    }

    @Test
    public void testWriteString_WithEmptyInput_ShouldWriteEmptyQuotedString() throws IOException {
        char[] text = "".toCharArray();
        generator.writeString(text, 0, text.length);
        String result = writer.toString();
        assertEquals("\"\"", result);
    }

    @Test
    public void testWriteString_WithSpecialCharacters_ShouldHandleSpecialChars() throws IOException {
        char[] text = "Hello\nWorld".toCharArray();
        generator.writeString(text, 0, text.length);
        String result = writer.toString();
        assertEquals("\"Hello\\nWorld\"", result);
    }

    @Test
    public void testWriteString_WithLongInput_ShouldNotThrowException() throws IOException {
        char[] text = new char[100];
        for (int i = 0; i < text.length; i++) {
            // Fill with 'a'
            text[i] = 'a';
        }
        assertDoesNotThrow(() -> generator.writeString(text, 0, text.length));
    }

    @Test
    public void testWriteString_WithInvalidOffset_ShouldThrowException() {
        char[] text = "Hello".toCharArray();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            generator.writeString(text, -1, text.length);
        });
    }

    @Test
    public void testWriteString_WithNegativeLength_ShouldThrowException() {
        char[] text = "Hello".toCharArray();
        assertThrows(IllegalArgumentException.class, () -> {
            generator.writeString(text, 0, -1);
        });
    }
}
