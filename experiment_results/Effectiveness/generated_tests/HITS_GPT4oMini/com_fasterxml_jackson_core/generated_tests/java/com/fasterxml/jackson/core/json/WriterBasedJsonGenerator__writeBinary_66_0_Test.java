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

class WriterBasedJsonGenerator__writeBinary_66_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    private IOContext ioContext;

    @BeforeEach
    void setUp() {
        writer = new StringWriter();
        ioContext = new IOContext(null, writer, false);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, writer);
    }

    @Test
    void testWriteBinary_FullTriplet() throws IOException, JsonGenerationException {
        Base64Variant base64Variant = new Base64Variant("Base64", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] data = new byte[] { (byte) 0xFF, (byte) 0xFE, (byte) 0xFD };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        generator._writeBinary(base64Variant, inputStream, new byte[3], 3);
        // Expected output based on input data
        String expectedOutput = "///";
        assertEquals(expectedOutput, writer.toString());
    }

    @Test
    void testWriteBinary_WithLeftoverBytes() throws IOException, JsonGenerationException {
        Base64Variant base64Variant = new Base64Variant("Base64", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        // Only two bytes
        byte[] data = new byte[] { (byte) 0xFF, (byte) 0xFE };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        generator._writeBinary(base64Variant, inputStream, new byte[3], 2);
        // Expected output based on input data
        String expectedOutput = "///";
        assertEquals(expectedOutput, writer.toString());
    }

    @Test
    void testWriteBinary_EmptyInput() throws IOException, JsonGenerationException {
        Base64Variant base64Variant = new Base64Variant("Base64", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        // Empty byte array
        byte[] data = new byte[0];
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        int bytesLeft = generator._writeBinary(base64Variant, inputStream, new byte[3], 0);
        assertEquals(0, bytesLeft);
    }

    @Test
    void testWriteBinary_NullInputStream() {
        Base64Variant base64Variant = new Base64Variant("Base64", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        assertThrows(IOException.class, () -> {
            generator._writeBinary(base64Variant, null, new byte[3], 3);
        });
    }

    @Test
    void testWriteBinary_NegativeBytesLeft() {
        Base64Variant base64Variant = new Base64Variant("Base64", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] data = new byte[] { (byte) 0xFF, (byte) 0xFE, (byte) 0xFD };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        assertThrows(JsonGenerationException.class, () -> {
            generator._writeBinary(base64Variant, inputStream, new byte[3], -1);
        });
    }
}
