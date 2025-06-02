package com.fasterxml.jackson.core.json;

import java.nio.charset.StandardCharsets;
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

class WriterBasedJsonGenerator__writeBinary_66_3_Test {

    private WriterBasedJsonGenerator generator;

    private Base64Variant base64Variant;

    private Writer writer;

    @BeforeEach
    void setUp() {
        writer = mock(Writer.class);
        generator = new WriterBasedJsonGenerator(null, 0, null, writer, '"');
        base64Variant = mock(Base64Variant.class);
        // Example line length
        when(base64Variant.getMaxLineLength()).thenReturn(76);
    }

    @Test
    void testWriteBinaryFullTriplet() throws IOException, JsonGenerationException {
        byte[] inputData = { (byte) 0b10101010, (byte) 0b11110000, (byte) 0b11001100 };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData);
        byte[] readBuffer = new byte[3];
        int bytesLeft = 3;
        int result = invokeWriteBinary(generator, base64Variant, inputStream, readBuffer, bytesLeft);
        // All bytes should be consumed
        assertEquals(0, result);
        // Ensure writer is called
        verify(writer, times(1)).write(any(char[].class), anyInt(), anyInt());
    }

    @Test
    void testWriteBinaryPartialTriplet() throws IOException, JsonGenerationException {
        byte[] inputData = { (byte) 0b10101010, (byte) 0b11110000 };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData);
        byte[] readBuffer = new byte[3];
        int bytesLeft = 2;
        int result = invokeWriteBinary(generator, base64Variant, inputStream, readBuffer, bytesLeft);
        // All bytes should be consumed
        assertEquals(0, result);
        // Ensure writer is called
        verify(writer, times(1)).write(any(char[].class), anyInt(), anyInt());
    }

    @Test
    void testWriteBinaryEmptyInput() throws IOException, JsonGenerationException {
        byte[] inputData = {};
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData);
        byte[] readBuffer = new byte[3];
        int bytesLeft = 0;
        int result = invokeWriteBinary(generator, base64Variant, inputStream, readBuffer, bytesLeft);
        // No bytes to process
        assertEquals(0, result);
        // Ensure writer is not called
        verify(writer, never()).write(any(char[].class), anyInt(), anyInt());
    }

    @Test
    void testWriteBinaryWithLineFeed() throws IOException, JsonGenerationException {
        byte[] inputData = { (byte) 0b10101010, (byte) 0b11110000, (byte) 0b11001100, (byte) 0b00001111, (byte) 0b11111111, (byte) 0b00000000 };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData);
        byte[] readBuffer = new byte[3];
        int bytesLeft = 6;
        int result = invokeWriteBinary(generator, base64Variant, inputStream, readBuffer, bytesLeft);
        // All bytes should be consumed
        assertEquals(0, result);
        // Ensure writer is called twice for two chunks
        verify(writer, times(2)).write(any(char[].class), anyInt(), anyInt());
    }

    private int invokeWriteBinary(WriterBasedJsonGenerator generator, Base64Variant b64variant, InputStream data, byte[] readBuffer, int bytesLeft) throws IOException, JsonGenerationException {
        try {
            java.lang.reflect.Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("_writeBinary", Base64Variant.class, InputStream.class, byte[].class, int.class);
            method.setAccessible(true);
            return (int) method.invoke(generator, b64variant, data, readBuffer, bytesLeft);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
