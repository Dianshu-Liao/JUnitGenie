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

public class WriterBasedJsonGenerator__writeBinary_65_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    private IOContext ioContext;

    private Base64Variant base64Variant;

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        ioContext = new IOContext(null, writer, true);
        base64Variant = new Base64Variant("Base64", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, writer);
    }

    @Test
    public void testWriteBinary_withFullChunks() throws Exception {
        byte[] input = { 1, 2, 3, 4, 5, 6 };
        generator._writeBinary(base64Variant, input, 0, input.length);
        // Base64 encoding of the input
        String expectedOutput = "AQIDBAUG";
        assertEquals(expectedOutput, writer.toString());
    }

    @Test
    public void testWriteBinary_withPartialChunk() throws Exception {
        byte[] input = { 1, 2 };
        generator._writeBinary(base64Variant, input, 0, input.length);
        // Base64 encoding of the input
        String expectedOutput = "AQI=";
        assertEquals(expectedOutput, writer.toString());
    }

    @Test
    public void testWriteBinary_withEmptyInput() throws Exception {
        byte[] input = {};
        generator._writeBinary(base64Variant, input, 0, input.length);
        // No output for empty input
        String expectedOutput = "";
        assertEquals(expectedOutput, writer.toString());
    }

    @Test
    public void testWriteBinary_withLineFeed() throws Exception {
        // 10 bytes
        byte[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        generator._writeBinary(base64Variant, input, 0, input.length);
        // Base64 encoding with line feed
        String expectedOutput = "AQIDBAUGCkA=";
        assertEquals(expectedOutput, writer.toString());
    }

    @Test
    public void testWriteBinary_withFlushing() throws Exception {
        // Create a small output buffer
        byte[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        // Small buffer to force flush
        generator._outputBuffer = new char[10];
        generator._writeBinary(base64Variant, input, 0, input.length);
        // Base64 encoding with forced flush
        String expectedOutput = "AQIDBAUGCkA=";
        assertEquals(expectedOutput, writer.toString());
    }

    @Test
    public void testWriteBinary_withInvalidInput() {
        // Test for invalid input that should throw an exception
        byte[] input = null;
        assertThrows(JsonGenerationException.class, () -> {
            generator._writeBinary(base64Variant, input, 0, 0);
        });
    }
}
