package com.fasterxml.jackson.core.json;

import java.lang.reflect.Method;
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

public class WriterBasedJsonGenerator_writeRaw_30_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        IOContext ioContext = Mockito.mock(IOContext.class);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, writer);
        // Initialize the output buffer and other fields
        generator._outputBuffer = new char[WriterBasedJsonGenerator.SHORT_WRITE];
        generator._outputEnd = generator._outputBuffer.length;
        generator._outputTail = 0;
        generator._outputHead = 0;
    }

    @Test
    public void testWriteRaw_singleCharacter() throws Exception {
        char inputChar = 'a';
        generator.writeRaw(inputChar);
        assertEquals("a", writer.toString());
        assertEquals(1, generator.getOutputBuffered());
    }

    @Test
    public void testWriteRaw_bufferFlush() throws Exception {
        for (int i = 0; i < WriterBasedJsonGenerator.SHORT_WRITE; i++) {
            generator.writeRaw((char) ('a' + i));
        }
        assertEquals(WriterBasedJsonGenerator.SHORT_WRITE, generator.getOutputBuffered());
        assertEquals("abcdefghijklmnopqrstuvwxyz", writer.toString());
    }

    @Test
    public void testWriteRaw_exceedBuffer() throws Exception {
        // Fill the buffer
        for (int i = 0; i < WriterBasedJsonGenerator.SHORT_WRITE; i++) {
            generator.writeRaw((char) ('a' + i));
        }
        // Now write one more character to trigger the flush
        generator.writeRaw('z');
        // Verify the output
        assertEquals(WriterBasedJsonGenerator.SHORT_WRITE + 1, generator.getOutputBuffered());
        assertEquals("abcdefghijklmnopqrstuvwxyz", writer.toString());
    }

    @Test
    public void testWriteRaw_multipleFlushes() throws Exception {
        // Fill the buffer and trigger a flush
        for (int i = 0; i < WriterBasedJsonGenerator.SHORT_WRITE; i++) {
            generator.writeRaw((char) ('a' + i));
        }
        // Write additional characters to exceed buffer size
        for (char c = 'z'; c <= 'z' + 5; c++) {
            generator.writeRaw(c);
        }
        // Verify output
        assertEquals(WriterBasedJsonGenerator.SHORT_WRITE + 6, generator.getOutputBuffered());
        assertEquals("abcdefghijklmnopqrstuvwxyz{|}~", writer.toString());
    }

    @Test
    public void testWriteRaw_emptyBuffer() throws Exception {
        generator.writeRaw('A');
        assertEquals("A", writer.toString());
        assertEquals(1, generator.getOutputBuffered());
    }
}
