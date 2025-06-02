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

public class UTF8JsonGenerator_writeRaw_21_3_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, false);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteRaw_SmallString() throws IOException {
        String input = "Hello, World!";
        generator.writeRaw(input);
        byte[] expected = input.getBytes("UTF-8");
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteRaw_EmptyString() throws IOException {
        String input = "";
        generator.writeRaw(input);
        assertArrayEquals(new byte[0], outputStream.toByteArray());
    }

    @Test
    public void testWriteRaw_SpecialCharacters() throws IOException {
        String input = "Special chars: \n\t\r\\\"";
        generator.writeRaw(input);
        byte[] expected = input.getBytes("UTF-8");
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteRaw_LongString() throws IOException {
        StringBuilder inputBuilder = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            inputBuilder.append("LongString");
        }
        String input = inputBuilder.toString();
        generator.writeRaw(input);
        byte[] expected = input.getBytes("UTF-8");
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteRaw_NullString() {
        assertThrows(NullPointerException.class, () -> {
            generator.writeRaw((String) null);
        });
    }

    @Test
    public void testWriteRaw_TooLongString() throws IOException {
        StringBuilder inputBuilder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            inputBuilder.append("A");
        }
        String input = inputBuilder.toString();
        generator.writeRaw(input);
        byte[] expected = input.getBytes("UTF-8");
        assertArrayEquals(expected, outputStream.toByteArray());
    }
}
