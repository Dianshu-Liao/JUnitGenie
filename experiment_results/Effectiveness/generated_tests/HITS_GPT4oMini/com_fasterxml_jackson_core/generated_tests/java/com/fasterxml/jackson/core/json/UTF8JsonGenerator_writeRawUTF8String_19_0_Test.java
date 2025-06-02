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

public class UTF8JsonGenerator_writeRawUTF8String_19_0_Test {

    private ByteArrayOutputStream outputStream;

    private UTF8JsonGenerator jsonGenerator;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, true);
        jsonGenerator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteRawUTF8String_ValidInput() {
        try {
            byte[] input = "Hello".getBytes("UTF-8");
            jsonGenerator.writeRawUTF8String(input, 0, input.length);
            String expectedOutput = "\"Hello\"";
            assertEquals(expectedOutput, outputStream.toString("UTF-8"));
        } catch (IOException e) {
            fail("IOException should not occur");
        }
    }

    @Test
    public void testWriteRawUTF8String_EmptyInput() {
        try {
            byte[] input = "".getBytes("UTF-8");
            jsonGenerator.writeRawUTF8String(input, 0, input.length);
            String expectedOutput = "\"\"";
            assertEquals(expectedOutput, outputStream.toString("UTF-8"));
        } catch (IOException e) {
            fail("IOException should not occur");
        }
    }

    @Test
    public void testWriteRawUTF8String_NegativeOffset() {
        // Empty input to avoid UnsupportedEncodingException
        byte[] input = new byte[0];
        assertThrows(IndexOutOfBoundsException.class, () -> {
            jsonGenerator.writeRawUTF8String(input, -1, input.length);
        });
    }

    @Test
    public void testWriteRawUTF8String_ExceedingLength() {
        // Empty input to avoid UnsupportedEncodingException
        byte[] input = new byte[0];
        assertThrows(IndexOutOfBoundsException.class, () -> {
            jsonGenerator.writeRawUTF8String(input, 0, input.length + 1);
        });
    }

    @Test
    public void testWriteRawUTF8String_ValidInputWithFlush() {
        try {
            byte[] input = "World".getBytes("UTF-8");
            jsonGenerator.writeRawUTF8String(input, 0, input.length);
            jsonGenerator.writeRawUTF8String(input, 0, input.length);
            String expectedOutput = "\"World\"\"World\"";
            assertEquals(expectedOutput, outputStream.toString("UTF-8"));
        } catch (IOException e) {
            fail("IOException should not occur");
        }
    }
}
