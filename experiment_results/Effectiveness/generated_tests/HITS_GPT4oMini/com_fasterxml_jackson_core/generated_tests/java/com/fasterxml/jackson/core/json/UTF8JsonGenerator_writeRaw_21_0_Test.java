package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.BufferRecycler;
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
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.NumberOutput;

class UTF8JsonGenerator_writeRaw_21_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() throws IOException {
        BufferRecycler bufferRecycler = new BufferRecycler();
        IOContext ioContext = new IOContext(null, bufferRecycler, false);
        outputStream = new ByteArrayOutputStream();
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    void testWriteRawWithValidString() throws IOException {
        String input = "Hello, World!";
        generator.writeRaw(input);
        generator.flush();
        assertEquals("Hello, World!", outputStream.toString("UTF-8"));
    }

    @Test
    void testWriteRawWithSpecialCharacters() throws IOException {
        String input = "Special characters: \n\t\r";
        generator.writeRaw(input);
        generator.flush();
        String expected = "Special characters: \n\t\r";
        assertEquals(expected, outputStream.toString("UTF-8"));
    }

    @Test
    void testWriteRawWithLongString() throws IOException {
        StringBuilder longInput = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            longInput.append("Long string ");
        }
        generator.writeRaw(longInput.toString());
        generator.flush();
        assertEquals(longInput.toString(), outputStream.toString("UTF-8"));
    }

    @Test
    void testWriteRawWithEmptyString() throws IOException {
        String input = "";
        generator.writeRaw(input);
        generator.flush();
        assertEquals("", outputStream.toString("UTF-8"));
    }

    @Test
    void testWriteRawWithNull() throws IOException {
        String input = null;
        generator.writeRaw(input);
        generator.flush();
        // Assuming writeRaw handles null as empty
        assertEquals("", outputStream.toString("UTF-8"));
    }
}
