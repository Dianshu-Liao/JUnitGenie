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

public class WriterBasedJsonGenerator_writeRaw_26_3_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        IOContext context = new IOContext(null, writer, true);
        generator = new WriterBasedJsonGenerator(context, 0, null, writer, '"');
    }

    @Test
    public void testWriteRaw_SmallText() throws IOException {
        String text = "Hello";
        generator.writeRaw(text);
        assertEquals("Hello", writer.toString());
    }

    @Test
    public void testWriteRaw_ExactBufferSize() throws IOException {
        String text = "12345678901234567890123456789012";
        generator.writeRaw(text);
        assertEquals(text, writer.toString());
    }

    @Test
    public void testWriteRaw_LargeText() throws IOException {
        String text = "This is a long text that exceeds the buffer size. " + "It should be written in chunks to the underlying writer.";
        generator.writeRaw(text);
        assertEquals(text, writer.toString());
    }

    @Test
    public void testWriteRaw_EmptyText() throws IOException {
        String text = "";
        generator.writeRaw(text);
        assertEquals("", writer.toString());
    }

    @Test
    public void testWriteRaw_NullText() {
        assertThrows(NullPointerException.class, () -> {
            generator.writeRaw((String) null);
        });
    }

    @Test
    public void testWriteRaw_SpecialCharacters() throws IOException {
        String text = "Special characters: \n \t \r \\ \" '";
        generator.writeRaw(text);
        assertEquals(text, writer.toString());
    }

    @Test
    public void testWriteRaw_ConsecutiveWrites() throws IOException {
        String text1 = "First part. ";
        String text2 = "Second part.";
        generator.writeRaw(text1);
        generator.writeRaw(text2);
        assertEquals(text1 + text2, writer.toString());
    }
}
