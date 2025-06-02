package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
import com.fasterxml.jackson.core.json.JsonReadContext;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

class ReaderBasedJsonParser_getTextLength_14_0_Test {

    private ReaderBasedJsonParser parser;

    private IOContext ioContext;

    private CharsToNameCanonicalizer canonicalizer;

    private BufferRecycler bufferRecycler;

    @BeforeEach
    void setUp() {
        bufferRecycler = new BufferRecycler();
        ioContext = new IOContext(null, bufferRecycler, null, false);
        canonicalizer = CharsToNameCanonicalizer.createRoot();
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader("{\"key\":\"value\"}"), null, canonicalizer);
    }

    @Test
    void testGetTextLengthWithFieldName() throws Exception {
        setFieldValue(parser, "_currToken", JsonToken.FIELD_NAME);
        JsonReadContext context = new JsonReadContext(null, 0, null, 0, 0, 0);
        setFieldValue(parser, "_parsingContext", context);
        context.setCurrentName("key");
        int length = parser.getTextLength();
        assertEquals(3, length);
    }

    @Test
    void testGetTextLengthWithStringValue() throws Exception {
        setFieldValue(parser, "_currToken", JsonToken.VALUE_STRING);
        TextBuffer textBuffer = new TextBuffer(bufferRecycler);
        setFieldValue(parser, "_textBuffer", textBuffer);
        textBuffer.setCurrentLength(5);
        int length = parser.getTextLength();
        assertEquals(5, length);
    }

    @Test
    void testGetTextLengthWithIncompleteToken() throws Exception {
        setFieldValue(parser, "_currToken", JsonToken.VALUE_STRING);
        setFieldValue(parser, "_tokenIncomplete", true);
        TextBuffer textBuffer = new TextBuffer(bufferRecycler);
        setFieldValue(parser, "_textBuffer", textBuffer);
        textBuffer.setCurrentLength(5);
        parser.getTextLength();
        int length = parser.getTextLength();
        assertEquals(5, length);
    }

    @Test
    void testGetTextLengthWithNumber() throws Exception {
        setFieldValue(parser, "_currToken", JsonToken.VALUE_NUMBER_INT);
        TextBuffer textBuffer = new TextBuffer(bufferRecycler);
        setFieldValue(parser, "_textBuffer", textBuffer);
        textBuffer.setCurrentLength(4);
        int length = parser.getTextLength();
        assertEquals(4, length);
    }

    @Test
    void testGetTextLengthWithNullToken() throws Exception {
        setFieldValue(parser, "_currToken", null);
        int length = parser.getTextLength();
        assertEquals(0, length);
    }

    private void setFieldValue(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
