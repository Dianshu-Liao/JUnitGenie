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

public class WriterBasedJsonGenerator_writeRaw_30_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter stringWriter;

    @BeforeEach
    public void setUp() {
        stringWriter = new StringWriter();
        IOContext ioContext = Mockito.mock(IOContext.class);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, stringWriter, '"');
        // Initialize output buffer
        generator._outputBuffer = new char[WriterBasedJsonGenerator.SHORT_WRITE];
        generator._outputTail = 0;
        generator._outputEnd = generator._outputBuffer.length;
    }

    @Test
    public void testWriteRaw_WithSingleCharacter() throws Exception {
        char inputChar = 'A';
        generator.writeRaw(inputChar);
        assertEquals("A", stringWriter.toString());
        assertEquals(1, generator._outputTail);
    }

    @Test
    public void testWriteRaw_BufferFlush() throws Exception {
        for (int i = 0; i < WriterBasedJsonGenerator.SHORT_WRITE; i++) {
            generator.writeRaw((char) ('A' + i));
        }
        assertEquals(WriterBasedJsonGenerator.SHORT_WRITE, generator._outputTail);
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", stringWriter.toString());
    }

    @Test
    public void testWriteRaw_ExceedBufferSize() throws Exception {
        for (int i = 0; i < WriterBasedJsonGenerator.SHORT_WRITE + 1; i++) {
            generator.writeRaw((char) ('A' + i));
        }
        assertEquals(WriterBasedJsonGenerator.SHORT_WRITE + 1, generator._outputTail);
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZA", stringWriter.toString());
    }

    @Test
    public void testWriteRaw_EmptyBuffer() throws Exception {
        // Simulate an empty buffer
        generator._outputTail = 0;
        generator.writeRaw('B');
        assertEquals("B", stringWriter.toString());
        assertEquals(1, generator._outputTail);
    }

    @Test
    public void testWriteRaw_SpecialCharacter() throws Exception {
        // Writing a newline character
        generator.writeRaw('\n');
        assertEquals("\n", stringWriter.toString());
        assertEquals(1, generator._outputTail);
    }

    @Test
    public void testWriteRaw_MultipleSpecialCharacters() throws Exception {
        generator.writeRaw('\n');
        // Writing a tab character
        generator.writeRaw('\t');
        assertEquals("\n\t", stringWriter.toString());
        assertEquals(2, generator._outputTail);
    }
}
