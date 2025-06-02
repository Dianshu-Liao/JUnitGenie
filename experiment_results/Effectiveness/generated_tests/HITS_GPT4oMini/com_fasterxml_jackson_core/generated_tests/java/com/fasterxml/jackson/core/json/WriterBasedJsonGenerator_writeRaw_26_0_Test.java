package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;

public class WriterBasedJsonGenerator_writeRaw_26_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter stringWriter;

    @BeforeEach
    public void setUp() {
        stringWriter = new StringWriter();
        IOContext ioContext = Mockito.mock(IOContext.class);
        // Mock buffer size
        Mockito.when(ioContext.allocConcatBuffer()).thenReturn(new char[64]);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, stringWriter, '"');
    }

    @Test
    public void testWriteRaw_WithEmptyString_ShouldNotFlush() throws IOException {
        generator.writeRaw("");
        assertEquals("", stringWriter.toString());
    }

    @Test
    public void testWriteRaw_WithSingleCharacter_ShouldNotFlush() throws IOException {
        generator.writeRaw("A");
        assertEquals("A", stringWriter.toString());
    }

    @Test
    public void testWriteRaw_WithBufferFull_ShouldFlushAndWrite() throws IOException {
        // Fill the buffer to its capacity
        generator.writeRaw("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", stringWriter.toString());
    }

    @Test
    public void testWriteRaw_WithLongString_ShouldFlushMultipleTimes() throws IOException {
        String longString = "This is a long string that should cause multiple flushes. ";
        generator.writeRaw(longString);
        assertEquals(longString, stringWriter.toString());
    }

    @Test
    public void testWriteRaw_WithNullString_ShouldThrowIOException() {
        assertThrows(IOException.class, () -> {
            // Explicitly cast to String
            generator.writeRaw((String) null);
        });
    }

    @Test
    public void testWriteRaw_WithStringExceedingBufferSize_ShouldFlushCorrectly() throws IOException {
        String longString = "This string is definitely longer than the buffer size, causing multiple flushes.";
        generator.writeRaw(longString);
        assertEquals(longString, stringWriter.toString());
    }

    @Test
    public void testWriteRaw_WithSpecialCharacters_ShouldHandleCorrectly() throws IOException {
        String specialChars = "Special chars: \n\t\"'\\";
        generator.writeRaw(specialChars);
        assertEquals(specialChars, stringWriter.toString());
    }
}
