package com.fasterxml.jackson.core.json;

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

public class UTF8DataInputJsonParser_getValueAsString_6_4_Test {

    private TestUTF8DataInputJsonParser parser;

    private DataInput inputData;

    private ByteQuadsCanonicalizer symbols;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        symbols = ByteQuadsCanonicalizer.createRoot();
        inputData = new DataInputStream(new ByteArrayInputStream(new byte[0]));
        ioContext = new IOContext(new BufferRecycler(), null, true);
        parser = new TestUTF8DataInputJsonParser(ioContext, 0, inputData, null, symbols, 0);
    }

    @Test
    public void testGetValueAsStringWithValueString() throws IOException {
        parser.setCurrToken(JsonToken.VALUE_STRING);
        parser._tokenIncomplete = false;
        parser.getTextBuffer().setCurrentLength(5);
        parser.getTextBuffer().setCurrentAndReturn(5);
        String result = parser.getValueAsString();
        assertEquals("value", result);
    }

    @Test
    public void testGetValueAsStringWithIncompleteValueString() throws IOException {
        parser.setCurrToken(JsonToken.VALUE_STRING);
        parser._tokenIncomplete = true;
        parser.getTextBuffer().setCurrentLength(5);
        parser.getTextBuffer().setCurrentAndReturn(5);
        String result = parser.getValueAsString();
        assertEquals("value", result);
    }

    @Test
    public void testGetValueAsStringWithFieldName() throws IOException {
        parser.setCurrToken(JsonToken.FIELD_NAME);
        String fieldName = "fieldName";
        parser.getParsingContext().setCurrentName(fieldName);
        String result = parser.getValueAsString();
        assertEquals(fieldName, result);
    }

    @Test
    public void testGetValueAsStringWithNullToken() throws IOException {
        parser.setCurrToken(null);
        String result = parser.getValueAsString();
        assertNull(result);
    }

    @Test
    public void testGetValueAsStringWithInvalidToken() throws IOException {
        parser.setCurrToken(JsonToken.VALUE_NUMBER_INT);
        String result = parser.getValueAsString();
        assertNull(result);
    }

    // Subclass to expose protected fields for testing
    private static class TestUTF8DataInputJsonParser extends UTF8DataInputJsonParser {

        public TestUTF8DataInputJsonParser(IOContext ctxt, int features, DataInput inputData, ObjectCodec codec, ByteQuadsCanonicalizer sym, int firstByte) {
            super(ctxt, features, inputData, codec, sym, firstByte);
        }

        public TextBuffer getTextBuffer() {
            return _textBuffer;
        }

        public void setCurrToken(JsonToken token) {
            this._currToken = token;
        }
    }
}
