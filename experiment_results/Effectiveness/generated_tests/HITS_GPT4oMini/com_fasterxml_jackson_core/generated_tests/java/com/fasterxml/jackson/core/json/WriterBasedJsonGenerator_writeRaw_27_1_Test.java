package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
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

public class WriterBasedJsonGenerator_writeRaw_27_1_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter stringWriter;

    @BeforeEach
    public void setUp() {
        StringWriter writer = new StringWriter();
        IOContext ioContext = new IOContext(null, writer, false);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, writer);
        stringWriter = writer;
    }

    @Test
    public void testWriteRaw_withValidInput() throws Exception {
        String text = "Hello, World!";
        generator.writeRaw(text, 0, text.length());
        assertEquals("Hello, World!", stringWriter.toString());
    }

    @Test
    public void testWriteRaw_withOffsetAndLength() throws Exception {
        String text = "Hello, World!";
        // "World!"
        generator.writeRaw(text, 7, 6);
        assertEquals("World!", stringWriter.toString());
    }

    @Test
    public void testWriteRaw_withEmptyString() throws Exception {
        String text = "";
        generator.writeRaw(text, 0, 0);
        assertEquals("", stringWriter.toString());
    }

    @Test
    public void testWriteRaw_withLongString() throws Exception {
        String text = "This is a very long string that exceeds the buffer size.";
        generator.writeRaw(text, 0, text.length());
        assertEquals(text, stringWriter.toString());
    }

    @Test
    public void testWriteRaw_withBufferOverflow() throws Exception {
        String text = "Short text";
        generator.writeRaw(text, 0, text.length());
        // This should cause a buffer flush
        generator.writeRaw(" more text", 0, 10);
        assertEquals("Short text more text", stringWriter.toString());
    }

    @Test
    public void testWriteRaw_withInvalidRange() {
        String text = "Hello";
        assertThrows(IndexOutOfBoundsException.class, () -> {
            // Invalid length
            generator.writeRaw(text, 0, 10);
        });
    }

    @Test
    public void testWriteRaw_withNegativeOffset() {
        String text = "Hello";
        assertThrows(IndexOutOfBoundsException.class, () -> {
            // Invalid offset
            generator.writeRaw(text, -1, 3);
        });
    }

    @Test
    public void testWriteRaw_withNegativeLength() {
        String text = "Hello";
        assertThrows(IllegalArgumentException.class, () -> {
            // Invalid length
            generator.writeRaw(text, 0, -1);
        });
    }
}
