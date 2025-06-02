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

public class UTF8JsonGenerator_writeBinary_29_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        ioContext = Mockito.mock(IOContext.class);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteBinary_ValidInput() throws IOException, JsonGenerationException {
        Base64Variant base64Variant = new Base64Variant("Test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] data = { 1, 2, 3, 4, 5 };
        generator.writeBinary(base64Variant, data, 0, data.length);
        String expectedOutput = "\"AQIDBAU=\"";
        assertEquals(expectedOutput, outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteBinary_EmptyInput() throws IOException, JsonGenerationException {
        Base64Variant base64Variant = new Base64Variant("Test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] data = {};
        generator.writeBinary(base64Variant, data, 0, data.length);
        String expectedOutput = "\"\"";
        assertEquals(expectedOutput, outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteBinary_NegativeOffset() {
        Base64Variant base64Variant = new Base64Variant("Test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] data = { 1, 2, 3 };
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            generator.writeBinary(base64Variant, data, -1, 3);
        });
        String expectedMessage = "Offset is out of bounds";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    public void testWriteBinary_ExceedingLength() {
        Base64Variant base64Variant = new Base64Variant("Test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] data = { 1, 2, 3 };
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            generator.writeBinary(base64Variant, data, 0, 4);
        });
        String expectedMessage = "Length exceeds the byte array limit";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    public void testWriteBinary_ValidInputWithFlush() throws IOException, JsonGenerationException {
        Base64Variant base64Variant = new Base64Variant("Test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        // Fill with some data
        byte[] data = new byte[512];
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) (i % 256);
        }
        generator.writeBinary(base64Variant, data, 0, data.length);
        // Check that the output includes the expected output
        assertTrue(outputStream.toString("UTF-8").contains("\""));
    }

    @Test
    public void testWriteBinary_NullData() {
        Base64Variant base64Variant = new Base64Variant("Test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        Exception exception = assertThrows(NullPointerException.class, () -> {
            generator.writeBinary(base64Variant, null, 0, 0);
        });
        String expectedMessage = "data cannot be null";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }
}
