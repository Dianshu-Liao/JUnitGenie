package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

class UTF8StreamJsonParser__decodeUtf8_2_83_1_Test {

    private UTF8StreamJsonParser parser;

    private ByteQuadsCanonicalizer symbols;

    private IOContext ioContext;

    private byte[] inputBuffer;

    @BeforeEach
    void setUp() {
        // Initialize required components
        symbols = ByteQuadsCanonicalizer.createRoot();
        ioContext = new IOContext(null, null, null, null, null, true);
        // UTF-8 encoded for ©
        inputBuffer = new byte[] { (byte) 0xC2, (byte) 0xA9 };
        parser = new UTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream(inputBuffer), null, symbols, inputBuffer, 0, inputBuffer.length, true);
    }

    @Test
    void testDecodeUtf8_2_ValidInput() throws IOException {
        // Prepare the input for the method
        // Reset input pointer using reflection
        setInputPtr(0);
        // First byte of a 2-byte UTF-8 character
        int c = 0xC2;
        int result = invokeDecodeUtf8_2(c);
        // Expected result for © (U+00A9) is 0x00A9
        assertEquals(0x00A9, result);
    }

    @Test
    void testDecodeUtf8_2_InvalidInput() {
        // Prepare the input for the method
        // Reset input pointer using reflection
        setInputPtr(0);
        // First byte of a 2-byte UTF-8 character
        int c = 0xC2;
        // Simulate an invalid second byte
        // Valid continuation byte
        parser._inputBuffer[1] = (byte) 0x80;
        // Move input pointer to second byte using reflection
        setInputPtr(1);
        // Expecting an exception for invalid continuation byte
        assertThrows(JsonParseException.class, () -> invokeDecodeUtf8_2(c));
    }

    private int invokeDecodeUtf8_2(int c) throws IOException {
        try {
            java.lang.reflect.Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_decodeUtf8_2", int.class);
            method.setAccessible(true);
            return (int) method.invoke(parser, c);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private void setInputPtr(int value) {
        try {
            java.lang.reflect.Field field = UTF8StreamJsonParser.class.getDeclaredField("_inputPtr");
            field.setAccessible(true);
            field.setInt(parser, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
