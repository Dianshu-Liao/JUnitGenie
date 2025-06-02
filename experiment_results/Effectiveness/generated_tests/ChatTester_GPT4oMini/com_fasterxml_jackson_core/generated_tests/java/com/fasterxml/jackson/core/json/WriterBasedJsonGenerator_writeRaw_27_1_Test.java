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

public class WriterBasedJsonGenerator_writeRaw_27_1_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        generator = new WriterBasedJsonGenerator(mock(IOContext.class), 0, mock(ObjectCodec.class), writer);
        // Set up necessary fields for the test
        generator._outputBuffer = new char[64];
        generator._outputTail = 0;
        generator._outputEnd = generator._outputBuffer.length;
    }

    @Test
    public void testWriteRaw_WithSufficientRoom() throws IOException {
        String text = "Hello, World!";
        int offset = 0;
        // "Hello"
        int len = 5;
        generator.writeRaw(text, offset, len);
        assertEquals("Hello", writer.toString());
        assertEquals(5, generator._outputTail);
    }

    @Test
    public void testWriteRaw_WithInsufficientRoom() throws IOException {
        String text = "Hello, World!";
        int offset = 0;
        // Exceeds buffer length
        int len = 20;
        generator.writeRaw(text, offset, len);
        assertEquals("Hello, World!", writer.toString());
        assertTrue(generator._outputTail > 0);
    }

    @Test
    public void testWriteRaw_WithExactBufferSize() throws IOException {
        String text = "Hello, World!";
        int offset = 0;
        // Buffer exactly fits
        int len = 32;
        // Reset tail
        generator._outputTail = 0;
        // Set end to 32
        generator._outputEnd = 32;
        generator.writeRaw(text, offset, len);
        assertEquals("Hello, World!", writer.toString());
        assertEquals(32, generator._outputTail);
    }

    @Test
    public void testWriteRaw_WithEmptyString() throws IOException {
        String text = "";
        int offset = 0;
        // Empty string
        int len = 0;
        generator.writeRaw(text, offset, len);
        assertEquals("", writer.toString());
        assertEquals(0, generator._outputTail);
    }

    @Test
    public void testWriteRaw_WithNegativeOffset() {
        String text = "Hello, World!";
        int offset = -1;
        int len = 5;
        Exception exception = assertThrows(IOException.class, () -> {
            generator.writeRaw(text, offset, len);
        });
        assertEquals("Index out of bounds", exception.getMessage());
    }

    @Test
    public void testWriteRaw_WithInvalidLength() {
        String text = "Hello, World!";
        int offset = 0;
        // Exceeds length of text
        int len = 100;
        Exception exception = assertThrows(IOException.class, () -> {
            generator.writeRaw(text, offset, len);
        });
        assertEquals("Index out of bounds", exception.getMessage());
    }
}
