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

class WriterBasedJsonGenerator__writeBinary_67_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    private IOContext ioContext;

    @BeforeEach
    void setUp() {
        writer = new StringWriter();
        ioContext = new IOContext(null, writer, true);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, writer);
    }

    @Test
    void testWriteBinary_CompleteChunk() throws IOException, JsonGenerationException {
        Base64Variant base64Variant = new Base64Variant("Test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        // 3 bytes
        byte[] inputData = { (byte) 0xFF, (byte) 0xFE, (byte) 0xFD };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData);
        byte[] readBuffer = new byte[3];
        int bytesWritten = generator._writeBinary(base64Variant, inputStream, readBuffer);
        assertEquals(3, bytesWritten);
        // Base64 encoding of FF FE FD is ///
        assertEquals("///", writer.toString());
    }

    @Test
    void testWriteBinary_PartialChunk() throws IOException, JsonGenerationException {
        Base64Variant base64Variant = new Base64Variant("Test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        // 2 bytes
        byte[] inputData = { (byte) 0xFF, (byte) 0xFE };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData);
        byte[] readBuffer = new byte[3];
        int bytesWritten = generator._writeBinary(base64Variant, inputStream, readBuffer);
        assertEquals(2, bytesWritten);
        // Base64 encoding of FF FE is ///=
        assertEquals("///=", writer.toString());
    }

    @Test
    void testWriteBinary_EmptyInputStream() throws IOException, JsonGenerationException {
        Base64Variant base64Variant = new Base64Variant("Test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        // Empty input
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[0]);
        byte[] readBuffer = new byte[3];
        int bytesWritten = generator._writeBinary(base64Variant, inputStream, readBuffer);
        assertEquals(0, bytesWritten);
        // No output
        assertEquals("", writer.toString());
    }

    @Test
    void testWriteBinary_NullInputStream() {
        Base64Variant base64Variant = new Base64Variant("Test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        assertThrows(IOException.class, () -> {
            generator._writeBinary(base64Variant, null, new byte[3]);
        });
    }

    @Test
    void testWriteBinary_NullReadBuffer() throws IOException, JsonGenerationException {
        Base64Variant base64Variant = new Base64Variant("Test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        // 3 bytes
        byte[] inputData = { (byte) 0xFF, (byte) 0xFE, (byte) 0xFD };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData);
        int bytesWritten = generator._writeBinary(base64Variant, inputStream, null);
        assertEquals(3, bytesWritten);
        // Base64 encoding of FF FE FD is ///
        assertEquals("///", writer.toString());
    }
}
