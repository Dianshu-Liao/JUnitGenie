package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

class UTF8StreamJsonParser__decodeUtf8_2_83_4_Test {

    private UTF8StreamJsonParser parser;

    private ByteQuadsCanonicalizer symbols;

    private IOContext ioContext;

    private byte[] inputBuffer;

    @BeforeEach
    void setUp() {
        symbols = ByteQuadsCanonicalizer.createRoot();
        ioContext = new IOContext(null, null, false);
        // UTF-8 encoded © (0xA9)
        inputBuffer = new byte[] { (byte) 0xC2, (byte) 0xA9 };
        parser = new UTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream(inputBuffer), null, symbols, inputBuffer, 0, inputBuffer.length, true);
    }

    @Test
    void testDecodeUtf8_2_ValidInput() throws IOException, NoSuchFieldException, IllegalAccessException {
        // Prepare input buffer for valid UTF-8 sequence
        setProtectedField(parser, "_inputPtr", 0);
        setProtectedField(parser, "_inputEnd", inputBuffer.length);
        // 0xC2 is the first byte of the © character
        int result = invokeDecodeUtf8_2(0xC2);
        // Expect the result to be the decoded value of ©
        assertEquals(0xA9, result);
    }

    @Test
    void testDecodeUtf8_2_InvalidInput() throws NoSuchFieldException, IllegalAccessException {
        // Prepare input buffer for invalid UTF-8 sequence
        // Invalid continuation byte
        inputBuffer = new byte[] { (byte) 0xC2, (byte) 0x80 };
        parser = new UTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream(inputBuffer), null, symbols, inputBuffer, 0, inputBuffer.length, true);
        setProtectedField(parser, "_inputPtr", 0);
        setProtectedField(parser, "_inputEnd", inputBuffer.length);
        assertThrows(JsonParseException.class, () -> {
            // Expect an exception due to invalid continuation
            invokeDecodeUtf8_2(0xC2);
        });
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

    private void setProtectedField(Object target, String fieldName, int value) throws NoSuchFieldException, IllegalAccessException {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.setInt(target, value);
    }
}
