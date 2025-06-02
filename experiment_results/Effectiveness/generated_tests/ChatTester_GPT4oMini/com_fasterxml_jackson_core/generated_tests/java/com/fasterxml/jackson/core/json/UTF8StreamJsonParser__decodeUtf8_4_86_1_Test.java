package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8StreamJsonParser__decodeUtf8_4_86_1_Test {

    private UTF8StreamJsonParser parser;

    private InputStream mockInputStream;

    private byte[] inputBuffer;

    @BeforeEach
    public void setUp() {
        // Initialize the necessary dependencies for the parser
        mockInputStream = Mockito.mock(InputStream.class);
        // Example UTF-8 bytes for "😀"
        inputBuffer = new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x81 };
        parser = new UTF8StreamJsonParser(null, 0, mockInputStream, null, null, inputBuffer, 0, inputBuffer.length, true);
        try {
            // Accessing protected fields using reflection
            java.lang.reflect.Field inputPtrField = UTF8StreamJsonParser.class.getDeclaredField("_inputPtr");
            inputPtrField.setAccessible(true);
            inputPtrField.setInt(parser, 0);
            java.lang.reflect.Field inputEndField = UTF8StreamJsonParser.class.getDeclaredField("_inputEnd");
            inputEndField.setAccessible(true);
            inputEndField.setInt(parser, inputBuffer.length);
            java.lang.reflect.Field inputBufferField = UTF8StreamJsonParser.class.getDeclaredField("_inputBuffer");
            inputBufferField.setAccessible(true);
            inputBufferField.set(parser, inputBuffer);
        } catch (Exception e) {
            fail("Failed to set up parser: " + e.getMessage());
        }
    }

    @Test
    public void testDecodeUtf8_4_ValidInput() throws Exception {
        // Use reflection to access the private method
        java.lang.reflect.Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_decodeUtf8_4", int.class);
        method.setAccessible(true);
        // The first byte of the surrogate
        int result = (int) method.invoke(parser, 0xF0);
        // Check if the result is the correct code point for "😀"
        assertEquals(0x1F600, result);
    }

    @Test
    public void testDecodeUtf8_4_InvalidLeadingByte() throws Exception {
        // Modify the input buffer to simulate an invalid leading byte
        parser._inputBuffer = new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x80 };
        // Accessing protected fields using reflection
        java.lang.reflect.Field inputPtrField = UTF8StreamJsonParser.class.getDeclaredField("_inputPtr");
        inputPtrField.setAccessible(true);
        inputPtrField.setInt(parser, 0);
        java.lang.reflect.Field inputEndField = UTF8StreamJsonParser.class.getDeclaredField("_inputEnd");
        inputEndField.setAccessible(true);
        inputEndField.setInt(parser, parser._inputBuffer.length);
        // Use reflection to access the private method
        java.lang.reflect.Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_decodeUtf8_4", int.class);
        method.setAccessible(true);
        Exception exception = assertThrows(IOException.class, () -> {
            method.invoke(parser, 0xF0);
        });
        assertTrue(exception.getMessage().contains("Invalid UTF-8"));
    }
}
