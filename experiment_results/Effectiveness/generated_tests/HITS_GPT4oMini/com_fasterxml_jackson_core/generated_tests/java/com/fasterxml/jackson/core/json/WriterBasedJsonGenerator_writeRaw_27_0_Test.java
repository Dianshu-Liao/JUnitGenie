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

class WriterBasedJsonGenerator_writeRaw_27_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    @BeforeEach
    void setUp() {
        writer = new StringWriter();
        // Create IOContext without ContentReference
        IOContext context = new IOContext(null, null, null, false);
        generator = new WriterBasedJsonGenerator(context, 0, null, writer);
    }

    @Test
    void testWriteRaw_ValidInput() throws IOException {
        String text = "Hello, World!";
        generator.writeRaw(text, 0, text.length());
        assertEquals("Hello, World!", writer.toString());
    }

    @Test
    void testWriteRaw_EmptyString() throws IOException {
        String text = "";
        generator.writeRaw(text, 0, 0);
        assertEquals("", writer.toString());
    }

    @Test
    void testWriteRaw_NegativeOffset() {
        String text = "Hello";
        assertThrows(IndexOutOfBoundsException.class, () -> {
            generator.writeRaw(text, -1, 3);
        });
    }

    @Test
    void testWriteRaw_OffsetOutOfBounds() {
        String text = "Hello";
        assertThrows(IndexOutOfBoundsException.class, () -> {
            generator.writeRaw(text, 6, 1);
        });
    }

    @Test
    void testWriteRaw_LengthOutOfBounds() {
        String text = "Hello";
        assertThrows(IndexOutOfBoundsException.class, () -> {
            generator.writeRaw(text, 0, 10);
        });
    }

    @Test
    void testWriteRaw_ValidInputWithFlush() throws IOException {
        String text = "Hello, World!";
        generator.writeRaw(text, 0, 5);
        generator.writeRaw(", World!", 0, 8);
        assertEquals("Hello, World!", writer.toString());
    }

    @Test
    void testWriteRaw_ValidInputWithFlushAndLargeInput() throws IOException {
        StringBuilder largeText = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            largeText.append("A");
        }
        generator.writeRaw(largeText.toString(), 0, largeText.length());
        assertEquals(largeText.toString(), writer.toString());
    }
}
