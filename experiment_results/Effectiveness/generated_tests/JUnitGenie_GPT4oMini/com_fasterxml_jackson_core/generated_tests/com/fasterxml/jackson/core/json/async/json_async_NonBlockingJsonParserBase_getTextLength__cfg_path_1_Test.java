package com.fasterxml.jackson.core.json.async;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParserBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.fasterxml.jackson.core.JsonStreamContext;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import java.io.IOException;
import java.io.OutputStream;

public class json_async_NonBlockingJsonParserBase_getTextLength__cfg_path_1_Test {

    private class TestParser extends NonBlockingJsonParserBase {
        protected TestParser(IOContext ctxt, int features, ByteQuadsCanonicalizer sym) {
            super(ctxt, features, sym);
        }

        @Override
        public JsonToken nextToken() {
            return null; // Implement as needed for your tests
        }

        @Override
        public int releaseBuffered(OutputStream out) { // Change return type to int
            return 0; // Implement as needed for your tests
        }

        @Override
        public JsonToken getCurrentToken() {
            return null; // Implement as needed for your tests
        }

        public TextBuffer getTextBuffer() {
            return new TextBuffer(new com.fasterxml.jackson.core.util.BufferRecycler()); // Use fully qualified name for BufferRecycler
        }

        @Override
        public int getTextLength() {
            JsonToken token = getCurrentToken();
            if (token == null) {
                return 0;
            } else if (token == JsonToken.FIELD_NAME) {
                return getParsingContext().getCurrentName().length();
            } else if (token == JsonToken.VALUE_STRING) {
                return getTextBuffer().size();
            } else if (token == JsonToken.VALUE_NUMBER_INT) {
                return getTextBuffer().size();
            } else {
                return token.asCharArray().length;
            }
        }
    }

    @Test(timeout = 4000)
    public void testGetTextLengthWhenCurrTokenIsNull() throws IOException {
        TestParser parser = new TestParser(mock(IOContext.class), 0, mock(ByteQuadsCanonicalizer.class));
        assertEquals(0, parser.getTextLength());
    }

    @Test(timeout = 4000)
    public void testGetTextLengthWhenCurrTokenIsFieldName() throws IOException {
        TestParser parser = new TestParser(mock(IOContext.class), 0, mock(ByteQuadsCanonicalizer.class));
        parser.getParsingContext().setCurrentName("fieldName");

        int length = parser.getTextLength();
        assertEquals("fieldName".length(), length);
    }

    @Test(timeout = 4000)
    public void testGetTextLengthWhenCurrTokenIsString() throws IOException {
        TestParser parser = new TestParser(mock(IOContext.class), 0, mock(ByteQuadsCanonicalizer.class));
        TextBuffer textBuffer = mock(TextBuffer.class);
        when(textBuffer.size()).thenReturn(10);
        when(parser.getTextBuffer()).thenReturn(textBuffer);

        int length = parser.getTextLength();
        assertEquals(10, length);
    }

    @Test(timeout = 4000)
    public void testGetTextLengthWhenCurrTokenIsNumber() throws IOException {
        TestParser parser = new TestParser(mock(IOContext.class), 0, mock(ByteQuadsCanonicalizer.class));
        TextBuffer textBuffer = mock(TextBuffer.class);
        when(textBuffer.size()).thenReturn(5);
        when(parser.getTextBuffer()).thenReturn(textBuffer);

        int length = parser.getTextLength();
        assertEquals(5, length);
    }

    @Test(timeout = 4000)
    public void testGetTextLengthWhenCurrTokenIsDefault() throws IOException {
        TestParser parser = new TestParser(mock(IOContext.class), 0, mock(ByteQuadsCanonicalizer.class));
        char[] charArray = new char[]{'a', 'b', 'c'};
        when(parser.getCurrentToken()).thenReturn(JsonToken.VALUE_STRING);
        when(parser.getCurrentToken().asCharArray()).thenReturn(charArray);

        int length = parser.getTextLength();
        assertEquals(3, length);
    }

}