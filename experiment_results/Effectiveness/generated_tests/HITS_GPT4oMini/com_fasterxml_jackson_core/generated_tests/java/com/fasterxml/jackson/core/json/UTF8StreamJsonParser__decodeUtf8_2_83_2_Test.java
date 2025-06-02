package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import java.lang.reflect.Method;
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

public class UTF8StreamJsonParser__decodeUtf8_2_83_2_Test {

    private static class TestUTF8StreamJsonParser extends UTF8StreamJsonParser {

        public TestUTF8StreamJsonParser(IOContext ctxt, int features, InputStream in, ObjectCodec codec, ByteQuadsCanonicalizer sym, byte[] inputBuffer, int start, int end, boolean bufferRecyclable) {
            super(ctxt, features, in, codec, sym, inputBuffer, start, end, bufferRecyclable);
        }

        public void setInputPtr(int inputPtr) {
            this._inputPtr = inputPtr;
        }

        public void setInputEnd(int inputEnd) {
            this._inputEnd = inputEnd;
        }

        public int decodeUtf8_2(int c) throws Exception {
            Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_decodeUtf8_2", int.class);
            method.setAccessible(true);
            return (int) method.invoke(this, c);
        }
    }

    private TestUTF8StreamJsonParser parser;

    private ByteQuadsCanonicalizer symbols;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        symbols = ByteQuadsCanonicalizer.createRoot();
        ioContext = new IOContext(null, null, null, null, null, false);
        byte[] inputBuffer = new byte[2];
        parser = new TestUTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream(inputBuffer), null, symbols, inputBuffer, 0, 2, true);
    }

    @Test
    public void testDecodeUtf8_2_ValidInput() throws Exception {
        parser.setInputPtr(0);
        parser.setInputEnd(2);
        parser._inputBuffer = new byte[] { (byte) 0xC2, (byte) 0xA9 };
        int result = parser.decodeUtf8_2(0xC2);
        assertEquals(0xA9, result, "The decoded value should be U+00A9 (©)");
    }

    @Test
    public void testDecodeUtf8_2_InvalidContinuationByte() {
        parser.setInputPtr(0);
        parser.setInputEnd(2);
        parser._inputBuffer = new byte[] { (byte) 0xC2, (byte) 0x80 };
        assertThrows(IOException.class, () -> {
            parser.decodeUtf8_2(0xC2);
        }, "Expected IOException for invalid continuation byte");
    }
}
