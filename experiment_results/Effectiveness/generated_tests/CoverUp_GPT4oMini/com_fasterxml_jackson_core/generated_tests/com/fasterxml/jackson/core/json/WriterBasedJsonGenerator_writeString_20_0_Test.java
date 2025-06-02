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

public class WriterBasedJsonGenerator_writeString_20_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        ioContext = mock(IOContext.class);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, writer, '"');
    }

    @Test
    public void testWriteString_NullReader() {
        assertThrows(IOException.class, () -> {
            generator.writeString(null, 5);
        });
    }

    @Test
    public void testWriteString_EmptyReader() throws IOException {
        Reader reader = new StringReader("");
        generator.writeString(reader, 0);
        assertEquals("\"\"", writer.toString());
    }

    @Test
    public void testWriteString_SingleCharacter() throws IOException {
        Reader reader = new StringReader("a");
        generator.writeString(reader, 1);
        assertEquals("\"a\"", writer.toString());
    }

    @Test
    public void testWriteString_MultipleCharacters() throws IOException {
        Reader reader = new StringReader("Hello, World!");
        generator.writeString(reader, 13);
        assertEquals("\"Hello, World!\"", writer.toString());
    }

    @Test
    public void testWriteString_ReadingLessThanRequested() {
        Reader reader = new StringReader("Short");
        assertThrows(IOException.class, () -> {
            generator.writeString(reader, 10);
        });
    }

    @Test
    public void testWriteString_FlushBufferCalled() throws IOException {
        // Create a reader that has more characters than the buffer can hold
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append("a");
        }
        Reader reader = new StringReader(sb.toString());
        generator.writeString(reader, sb.length());
        assertTrue(writer.toString().startsWith("\""));
        assertTrue(writer.toString().endsWith("\""));
    }
}
