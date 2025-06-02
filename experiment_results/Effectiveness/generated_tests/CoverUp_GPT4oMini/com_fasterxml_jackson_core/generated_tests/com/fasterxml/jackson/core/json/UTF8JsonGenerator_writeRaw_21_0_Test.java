package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
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

public class UTF8JsonGenerator_writeRaw_21_0_Test {

    private UTF8JsonGenerator jsonGenerator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, false);
        jsonGenerator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteRaw_withShortString() throws IOException {
        String input = "Hello";
        jsonGenerator.writeRaw(input);
        jsonGenerator.flush();
        byte[] expectedOutput = "Hello".getBytes("UTF-8");
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWriteRaw_withLongString() throws IOException {
        String input = "This is a long string that exceeds the buffer size limit of the generator.";
        jsonGenerator.writeRaw(input);
        jsonGenerator.flush();
        byte[] expectedOutput = input.getBytes("UTF-8");
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWriteRaw_withEmptyString() throws IOException {
        String input = "";
        jsonGenerator.writeRaw(input);
        jsonGenerator.flush();
        byte[] expectedOutput = "".getBytes("UTF-8");
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWriteRaw_withNullString() throws IOException {
        String input = null;
        // Expecting an IOException to be thrown for null input
        try {
            jsonGenerator.writeRaw(input);
        } catch (IOException e) {
            // Expected exception
            return;
        }
        throw new AssertionError("Expected IOException for null input");
    }

    @Test
    public void testWriteRaw_withSpecialCharacters() throws IOException {
        String input = "Special characters: \n \t \" \\";
        jsonGenerator.writeRaw(input);
        jsonGenerator.flush();
        byte[] expectedOutput = input.getBytes("UTF-8");
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }
}
