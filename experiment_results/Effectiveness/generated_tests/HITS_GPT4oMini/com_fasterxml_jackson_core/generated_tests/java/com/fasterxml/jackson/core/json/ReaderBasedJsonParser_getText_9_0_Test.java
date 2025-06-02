package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.CharTypes;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class ReaderBasedJsonParser_getText_9_0_Test {

    private static class TestReaderBasedJsonParser extends ReaderBasedJsonParser {

        private TextBuffer textBuffer;

        public TestReaderBasedJsonParser(IOContext ctxt, int features, Reader r, ObjectCodec codec, CharsToNameCanonicalizer st) {
            super(ctxt, features, r, codec, st);
            this.textBuffer = new TextBuffer(null);
        }

        public TextBuffer getTextBuffer() {
            return textBuffer;
        }

        @Override
        public int getText(Writer writer) throws IOException {
            return textBuffer.contentsToWriter(writer);
        }

        public JsonToken getCurrToken() {
            return _currToken;
        }

        public void setCurrToken(JsonToken token) {
            this._currToken = token;
        }

        public JsonReadContext getParsingContext() {
            return _parsingContext;
        }

        public void setParsingContext(JsonReadContext parsingContext) {
            this._parsingContext = parsingContext;
        }
    }

    private TestReaderBasedJsonParser parser;

    private IOContext ioContext;

    private CharsToNameCanonicalizer symbols;

    @BeforeEach
    public void setUp() {
        ioContext = new IOContext(null, null, null, true);
        symbols = CharsToNameCanonicalizer.createRoot();
        parser = new TestReaderBasedJsonParser(ioContext, 0, mock(Reader.class), null, symbols);
        parser.getTextBuffer().setCurrentLength(0);
    }

    @Test
    public void testGetTextForStringToken() throws IOException {
        parser.setCurrToken(JsonToken.VALUE_STRING);
        parser.getTextBuffer().setCurrentLength(5);
        parser.getTextBuffer().setCurrentAndReturn("value".length());
        Writer writer = new StringWriter();
        int length = parser.getText(writer);
        assertEquals(5, length);
        assertEquals("value", writer.toString());
    }

    @Test
    public void testGetTextForFieldNameToken() throws IOException {
        parser.setCurrToken(JsonToken.FIELD_NAME);
        parser.setParsingContext(mock(JsonReadContext.class));
        when(parser.getParsingContext().getCurrentName()).thenReturn("fieldName");
        Writer writer = new StringWriter();
        int length = parser.getText(writer);
        assertEquals(9, length);
        assertEquals("fieldName", writer.toString());
    }
}
