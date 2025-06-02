package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
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

public class ReaderBasedJsonParser_getTextLength_14_0_Test {

    private ReaderBasedJsonParser parser;

    private CharsToNameCanonicalizer symbols;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        symbols = CharsToNameCanonicalizer.createRoot();
        ioContext = new IOContext(StreamReadConstraints.defaults(), null, null, true);
        parser = new ReaderBasedJsonParser(ioContext, 0, new StringReader(""), null, symbols);
    }

    private void setProtectedFields(JsonToken token, String fieldName) throws Exception {
        java.lang.reflect.Field currTokenField = ReaderBasedJsonParser.class.getDeclaredField("_currToken");
        currTokenField.setAccessible(true);
        currTokenField.set(parser, token);
        if (fieldName != null) {
            java.lang.reflect.Field parsingContextField = ReaderBasedJsonParser.class.getDeclaredField("_parsingContext");
            parsingContextField.setAccessible(true);
            JsonReadContext context = mock(JsonReadContext.class);
            when(context.getCurrentName()).thenReturn(fieldName);
            parsingContextField.set(parser, context);
        }
    }

    private void setTextBuffer(int length) throws Exception {
        TextBuffer textBuffer = new TextBuffer(new BufferRecycler());
        textBuffer.setCurrentLength(length);
        java.lang.reflect.Field textBufferField = ReaderBasedJsonParser.class.getDeclaredField("_textBuffer");
        textBufferField.setAccessible(true);
        textBufferField.set(parser, textBuffer);
    }

    @Test
    public void testGetTextLengthWithNullToken() throws Exception {
        setProtectedFields(null, null);
        assertEquals(0, parser.getTextLength());
    }

    @Test
    public void testGetTextLengthWithFieldName() throws Exception {
        setProtectedFields(JsonToken.FIELD_NAME, "testField");
        assertEquals(9, parser.getTextLength());
    }

    @Test
    public void testGetTextLengthWithStringToken() throws Exception {
        setProtectedFields(JsonToken.VALUE_STRING, null);
        setTextBuffer(5);
        assertEquals(5, parser.getTextLength());
    }

    @Test
    public void testGetTextLengthWithIncompleteStringToken() throws Exception {
        setProtectedFields(JsonToken.VALUE_STRING, null);
        java.lang.reflect.Field tokenIncompleteField = ReaderBasedJsonParser.class.getDeclaredField("_tokenIncomplete");
        tokenIncompleteField.setAccessible(true);
        tokenIncompleteField.set(parser, true);
        setTextBuffer(5);
        parser.getTextLength();
        assertEquals(5, parser.getTextLength());
    }

    @Test
    public void testGetTextLengthWithNumberToken() throws Exception {
        setProtectedFields(JsonToken.VALUE_NUMBER_INT, null);
        setTextBuffer(3);
        assertEquals(3, parser.getTextLength());
    }

    @Test
    public void testGetTextLengthWithFloatToken() throws Exception {
        setProtectedFields(JsonToken.VALUE_NUMBER_FLOAT, null);
        setTextBuffer(4);
        assertEquals(4, parser.getTextLength());
    }
}
