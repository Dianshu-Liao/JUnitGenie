package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.exc.StreamConstraintsException;
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
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8StreamJsonParser__finishAndReturnString_58_0_Test {

    private static class TestUTF8StreamJsonParser extends UTF8StreamJsonParser {

        public TestUTF8StreamJsonParser(IOContext ctxt, int features, InputStream in, ObjectCodec codec, ByteQuadsCanonicalizer sym, byte[] inputBuffer, int start, int end, boolean bufferRecyclable) {
            super(ctxt, features, in, codec, sym, inputBuffer, start, end, bufferRecyclable);
        }

        public TextBuffer getTextBuffer() {
            return _textBuffer;
        }

        public int getInputEnd() {
            return _inputEnd;
        }

        public int getInputPtr() {
            return _inputPtr;
        }

        public void setInputEnd(int inputEnd) {
            _inputEnd = inputEnd;
        }

        public void setInputPtr(int inputPtr) {
            _inputPtr = inputPtr;
        }
    }

    private TestUTF8StreamJsonParser parser;

    private ByteQuadsCanonicalizer symbols;

    private TextBuffer textBuffer;

    @BeforeEach
    public void setUp() {
        BufferRecycler bufferRecycler = new BufferRecycler();
        textBuffer = new TextBuffer(bufferRecycler);
        symbols = ByteQuadsCanonicalizer.createRoot();
        IOContext ioContext = new IOContext(null, bufferRecycler, false);
        byte[] inputBuffer = new byte[1024];
        parser = new TestUTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream(inputBuffer), null, symbols, inputBuffer, 0, 0, true);
        // Initialize input end for the parser
        parser.setInputEnd(0);
    }

    @Test
    public void testFinishAndReturnString_EmptyInput() throws IOException {
        parser._inputBuffer = new byte[] {};
        parser.setInputEnd(0);
        parser.setInputPtr(0);
        String result = parser._finishAndReturnString();
        assertEquals("", result);
    }

    @Test
    public void testFinishAndReturnString_SingleCharacter() throws IOException {
        parser._inputBuffer = new byte[] { 'a', (byte) '"' };
        parser.setInputEnd(2);
        parser.setInputPtr(0);
        String result = parser._finishAndReturnString();
        assertEquals("a", result);
    }

    @Test
    public void testFinishAndReturnString_MultipleCharacters() throws IOException {
        parser._inputBuffer = new byte[] { 'h', 'e', 'l', 'l', 'o', (byte) '"' };
        parser.setInputEnd(6);
        parser.setInputPtr(0);
        String result = parser._finishAndReturnString();
        assertEquals("hello", result);
    }
}
