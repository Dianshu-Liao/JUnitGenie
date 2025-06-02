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

public class UTF8JsonGenerator_writeBinary_30_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        ioContext = new IOContext(null, outputStream, true);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteBinaryWithKnownLength() throws IOException, JsonGenerationException {
        Base64Variant base64Variant = new Base64Variant("DEFAULT", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', Integer.MAX_VALUE);
        byte[] inputData = "Hello".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData);
        int bytesWritten = generator.writeBinary(base64Variant, inputStream, inputData.length);
        assertEquals(inputData.length, bytesWritten);
        assertEquals("\"SGVsbG8=\"", outputStream.toString());
    }

    @Test
    public void testWriteBinaryWithUnknownLength() throws IOException, JsonGenerationException {
        Base64Variant base64Variant = new Base64Variant("DEFAULT", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', Integer.MAX_VALUE);
        byte[] inputData = "Hello".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData);
        int bytesWritten = generator.writeBinary(base64Variant, inputStream, -1);
        assertEquals(inputData.length, bytesWritten);
        assertEquals("\"SGVsbG8=\"", outputStream.toString());
    }

    @Test
    public void testWriteBinaryWithInsufficientData() {
        Base64Variant base64Variant = new Base64Variant("DEFAULT", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', Integer.MAX_VALUE);
        byte[] inputData = "Hi".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData);
        assertThrows(JsonGenerationException.class, () -> {
            generator.writeBinary(base64Variant, inputStream, 10);
        });
    }

    @Test
    public void testWriteBinaryWithEmptyInput() throws IOException, JsonGenerationException {
        Base64Variant base64Variant = new Base64Variant("DEFAULT", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', Integer.MAX_VALUE);
        byte[] inputData = new byte[0];
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData);
        int bytesWritten = generator.writeBinary(base64Variant, inputStream, inputData.length);
        assertEquals(0, bytesWritten);
        assertEquals("\"\"", outputStream.toString());
    }

    @Test
    public void testWriteBinaryWithNullInputStream() {
        Base64Variant base64Variant = new Base64Variant("DEFAULT", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', Integer.MAX_VALUE);
        assertThrows(IOException.class, () -> {
            generator.writeBinary(base64Variant, null, 0);
        });
    }
}
