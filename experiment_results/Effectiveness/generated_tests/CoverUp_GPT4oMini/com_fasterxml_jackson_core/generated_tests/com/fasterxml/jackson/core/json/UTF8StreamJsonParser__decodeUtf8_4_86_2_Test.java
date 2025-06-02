package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

class UTF8StreamJsonParser__decodeUtf8_4_86_2_Test {

    private UTF8StreamJsonParser parser;

    private ByteQuadsCanonicalizer symbols;

    private IOContext context;

    private byte[] inputBuffer;

    @BeforeEach
    void setUp() {
        symbols = ByteQuadsCanonicalizer.createRoot();
        // U+1F601 (😁)
        inputBuffer = new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x81 };
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBuffer);
        context = new IOContext(null, null, false);
        parser = new UTF8StreamJsonParser(context, 0, inputStream, null, symbols, inputBuffer, 0, inputBuffer.length, false);
    }

    @Test
    void testDecodeUtf8_4_validInput() throws IOException {
        // We need to invoke the private method _decodeUtf8_4
        int result = invokeDecodeUtf8_4(0xF0);
        assertEquals(0x1F601, result);
    }

    @Test
    void testDecodeUtf8_4_invalidFirstByte() {
        // Test for invalid first byte
        // Invalid UTF-8 start byte
        parser._inputBuffer[0] = (byte) 0xC0;
        assertThrows(JsonParseException.class, () -> invokeDecodeUtf8_4(0xC0));
    }

    @Test
    void testDecodeUtf8_4_invalidSecondByte() {
        // Test for invalid second byte
        // Invalid continuation byte
        parser._inputBuffer[1] = (byte) 0xC0;
        assertThrows(JsonParseException.class, () -> invokeDecodeUtf8_4(0xF0));
    }

    @Test
    void testDecodeUtf8_4_invalidThirdByte() {
        // Test for invalid third byte
        // Invalid continuation byte
        parser._inputBuffer[2] = (byte) 0xC0;
        assertThrows(JsonParseException.class, () -> invokeDecodeUtf8_4(0xF0));
    }

    private int invokeDecodeUtf8_4(int c) throws IOException {
        try {
            java.lang.reflect.Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_decodeUtf8_4", int.class);
            method.setAccessible(true);
            return (int) method.invoke(parser, c);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
