package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonReadContext;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

class ReaderBasedJsonParser_getTextLength_14_0_Test {

    private ReaderBasedJsonParser parser;

    private IOContext ctxt;

    private ObjectCodec codec;

    private CharsToNameCanonicalizer symbols;

    private char[] inputBuffer;

    @BeforeEach
    void setUp() {
        ctxt = new IOContext(null, null, false);
        codec = null;
        symbols = CharsToNameCanonicalizer.createRoot();
        inputBuffer = new char[1024];
        parser = new ReaderBasedJsonParser(ctxt, 0, (Reader) null, codec, symbols, inputBuffer, 0, 0, false);
    }

    @Test
    void testGetTextLengthWithFieldNameToken() throws Exception {
        setCurrToken(JsonToken.FIELD_NAME, "testField");
        int length = invokeGetTextLength();
        assertEquals(9, length);
    }

    @Test
    void testGetTextLengthWithStringToken() throws Exception {
        setCurrToken(JsonToken.VALUE_STRING, "testString");
        int length = invokeGetTextLength();
        assertEquals(11, length);
    }

    @Test
    void testGetTextLengthWithNumberIntToken() throws Exception {
        setCurrToken(JsonToken.VALUE_NUMBER_INT, "123");
        int length = invokeGetTextLength();
        assertEquals(3, length);
    }

    @Test
    void testGetTextLengthWithNumberFloatToken() throws Exception {
        setCurrToken(JsonToken.VALUE_NUMBER_FLOAT, "123.45");
        int length = invokeGetTextLength();
        assertEquals(6, length);
    }

    @Test
    void testGetTextLengthWithNullToken() throws Exception {
        setCurrToken(null, null);
        int length = invokeGetTextLength();
        assertEquals(0, length);
    }

    @Test
    void testGetTextLengthWithIncompleteToken() throws Exception {
        setCurrToken(JsonToken.VALUE_STRING, "incomplete");
        parser._tokenIncomplete = true;
        invokeGetTextLength();
        int length = invokeGetTextLength();
        assertEquals(10, length);
    }

    private int invokeGetTextLength() throws Exception {
        return (int) ReaderBasedJsonParser.class.getDeclaredMethod("getTextLength").invoke(parser);
    }

    private void setCurrToken(JsonToken token, String value) throws Exception {
        Field currTokenField = ReaderBasedJsonParser.class.getDeclaredField("_currToken");
        currTokenField.setAccessible(true);
        currTokenField.set(parser, token);
        if (token != null) {
            Field parsingContextField = ReaderBasedJsonParser.class.getDeclaredField("_parsingContext");
            parsingContextField.setAccessible(true);
            JsonReadContext context = JsonReadContext.createRootContext(0, 0, null);
            parsingContextField.set(parser, context);
            context.setCurrentName(value);
        }
    }
}
