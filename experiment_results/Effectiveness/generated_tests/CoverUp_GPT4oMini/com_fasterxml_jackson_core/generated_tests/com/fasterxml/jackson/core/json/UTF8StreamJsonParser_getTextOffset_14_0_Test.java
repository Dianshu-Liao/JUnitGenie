package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8StreamJsonParser_getTextOffset_14_0_Test {

    private UTF8StreamJsonParser parser;

    private ByteQuadsCanonicalizer symbols;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        BufferRecycler bufferRecycler = new BufferRecycler();
        symbols = ByteQuadsCanonicalizer.createRoot();
        ioContext = new IOContext(bufferRecycler, null, true);
        byte[] inputBuffer = new byte[1024];
        parser = new UTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream(inputBuffer), null, symbols, inputBuffer, 0, inputBuffer.length, true);
    }

    @Test
    public void testGetTextOffsetWithFieldName() throws Exception {
        setCurrToken(JsonToken.FIELD_NAME);
        int offset = parser.getTextOffset();
        assertEquals(0, offset);
    }

    @Test
    public void testGetTextOffsetWithString() throws Exception {
        setCurrToken(JsonToken.VALUE_STRING);
        // Simulate token as incomplete
        setTokenIncomplete(true);
        // This will call _finishString
        parser.getTextOffset();
        int offset = parser.getTextOffset();
        // Should return offset from _textBuffer.getTextOffset()
        assertEquals(0, offset);
    }

    @Test
    public void testGetTextOffsetWithNumberInt() throws Exception {
        setCurrToken(JsonToken.VALUE_NUMBER_INT);
        int offset = parser.getTextOffset();
        // Should return offset from _textBuffer.getTextOffset()
        assertEquals(0, offset);
    }

    @Test
    public void testGetTextOffsetWithNumberFloat() throws Exception {
        setCurrToken(JsonToken.VALUE_NUMBER_FLOAT);
        int offset = parser.getTextOffset();
        // Should return offset from _textBuffer.getTextOffset()
        assertEquals(0, offset);
    }

    @Test
    public void testGetTextOffsetWithNullToken() throws Exception {
        setCurrToken(null);
        int offset = parser.getTextOffset();
        // Should return 0
        assertEquals(0, offset);
    }

    private void setCurrToken(JsonToken token) throws Exception {
        java.lang.reflect.Field field = UTF8StreamJsonParser.class.getDeclaredField("_currToken");
        field.setAccessible(true);
        field.set(parser, token);
    }

    private void setTokenIncomplete(boolean incomplete) throws Exception {
        java.lang.reflect.Field field = UTF8StreamJsonParser.class.getDeclaredField("_tokenIncomplete");
        field.setAccessible(true);
        field.set(parser, incomplete);
    }
}
