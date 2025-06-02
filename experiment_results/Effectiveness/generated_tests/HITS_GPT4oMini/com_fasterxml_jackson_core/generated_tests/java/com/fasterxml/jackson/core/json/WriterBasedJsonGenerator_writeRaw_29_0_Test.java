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

public class WriterBasedJsonGenerator_writeRaw_29_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter stringWriter;

    @BeforeEach
    public void setUp() {
        stringWriter = new StringWriter();
        IOContext ioContext = mock(IOContext.class);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, stringWriter);
        // Pre-allocate buffer
        generator._outputBuffer = new char[64];
        generator._outputEnd = generator._outputBuffer.length;
        generator._outputTail = 0;
        generator._outputHead = 0;
    }

    @Test
    public void testWriteRaw_ShortWrite() throws IOException {
        char[] input = "Hello".toCharArray();
        generator.writeRaw(input, 0, input.length);
        assertEquals("Hello", stringWriter.toString());
    }

    @Test
    public void testWriteRaw_ExactBufferSize() throws IOException {
        // Exactly the buffer size
        char[] input = new char[32];
        for (int i = 0; i < input.length; i++) {
            input[i] = 'A';
        }
        generator.writeRaw(input, 0, input.length);
        assertEquals(String.valueOf(input), stringWriter.toString());
    }

    @Test
    public void testWriteRaw_LargeWrite() throws IOException {
        char[] input = "This is a long string that exceeds the buffer size.".toCharArray();
        generator.writeRaw(input, 0, input.length);
        assertEquals("This is a long string that exceeds the buffer size.", stringWriter.toString());
    }

    @Test
    public void testWriteRaw_NegativeOffset() {
        char[] input = "Hello".toCharArray();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            generator.writeRaw(input, -1, input.length);
        });
    }

    @Test
    public void testWriteRaw_OffsetOutOfBounds() {
        char[] input = "Hello".toCharArray();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            generator.writeRaw(input, 10, 1);
        });
    }

    @Test
    public void testWriteRaw_LengthOutOfBounds() {
        char[] input = "Hello".toCharArray();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            generator.writeRaw(input, 0, 10);
        });
    }

    @Test
    public void testWriteRaw_ZeroLength() throws IOException {
        char[] input = "Hello".toCharArray();
        generator.writeRaw(input, 0, 0);
        assertEquals("", stringWriter.toString());
    }

    @Test
    public void testWriteRaw_EmptyArray() throws IOException {
        char[] input = new char[0];
        generator.writeRaw(input, 0, 0);
        assertEquals("", stringWriter.toString());
    }

    @Test
    public void testWriteRaw_FlushBufferCalled() throws IOException {
        // More than SHORT_WRITE
        char[] input = new char[64];
        for (int i = 0; i < input.length; i++) {
            input[i] = 'B';
        }
        generator.writeRaw(input, 0, input.length);
        assertEquals(String.valueOf(input), stringWriter.toString());
    }
}
