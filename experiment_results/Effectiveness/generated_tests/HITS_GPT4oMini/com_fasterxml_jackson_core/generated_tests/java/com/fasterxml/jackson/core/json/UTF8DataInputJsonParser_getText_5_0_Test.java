package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.io.IOContext;
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

public class UTF8DataInputJsonParser_getText_5_0_Test {

    private UTF8DataInputJsonParser parser;

    private Writer writer;

    @BeforeEach
    public void setUp() {
        IOContext ioContext = new IOContext(null, null, null, null, null, false);
        ByteQuadsCanonicalizer symbols = ByteQuadsCanonicalizer.createRoot();
        parser = new UTF8DataInputJsonParser(ioContext, 0, null, null, symbols, 0);
        writer = new StringWriter();
    }

    private void setCurrToken(JsonToken token) throws Exception {
        java.lang.reflect.Field field = UTF8DataInputJsonParser.class.getDeclaredField("_currToken");
        field.setAccessible(true);
        field.set(parser, token);
    }

    private void setTextBuffer(TextBuffer textBuffer) throws Exception {
        java.lang.reflect.Field field = UTF8DataInputJsonParser.class.getDeclaredField("_textBuffer");
        field.setAccessible(true);
        field.set(parser, textBuffer);
    }

    private void setParsingContext(JsonReadContext context) throws Exception {
        java.lang.reflect.Field field = UTF8DataInputJsonParser.class.getDeclaredField("_parsingContext");
        field.setAccessible(true);
        field.set(parser, context);
    }

    @Test
    public void testGetTextWithValueString() throws Exception {
        setCurrToken(JsonToken.VALUE_STRING);
        TextBuffer textBuffer = new TextBuffer(null);
        setTextBuffer(textBuffer);
        textBuffer.setCurrentLength("testString".length());
        char[] segment = textBuffer.getCurrentSegment();
        System.arraycopy("testString".toCharArray(), 0, segment, 0, "testString".length());
        int length = parser.getText(writer);
        assertEquals("testString", writer.toString());
        assertEquals(10, length);
    }

    @Test
    public void testGetTextWithFieldName() throws Exception {
        setCurrToken(JsonToken.FIELD_NAME);
        JsonReadContext context = JsonReadContext.createRootContext(null);
        context.setCurrentName("fieldName");
        setParsingContext(context);
        int length = parser.getText(writer);
        assertEquals("fieldName", writer.toString());
        assertEquals(9, length);
    }

    @Test
    public void testGetTextWithNumericToken() throws Exception {
        setCurrToken(JsonToken.VALUE_NUMBER_INT);
        TextBuffer textBuffer = new TextBuffer(null);
        setTextBuffer(textBuffer);
        textBuffer.setCurrentLength("12345".length());
        char[] segment = textBuffer.getCurrentSegment();
        System.arraycopy("12345".toCharArray(), 0, segment, 0, "12345".length());
        int length = parser.getText(writer);
        assertEquals("12345", writer.toString());
        assertEquals(5, length);
    }

    @Test
    public void testGetTextWithNullToken() throws Exception {
        setCurrToken(null);
        int length = parser.getText(writer);
        assertEquals(0, length);
    }
}
