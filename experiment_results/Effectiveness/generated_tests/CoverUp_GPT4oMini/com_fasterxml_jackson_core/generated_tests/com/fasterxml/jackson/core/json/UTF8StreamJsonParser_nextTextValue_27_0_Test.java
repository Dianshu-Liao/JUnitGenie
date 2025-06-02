package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

class UTF8StreamJsonParser_nextTextValue_27_0_Test {

    private UTF8StreamJsonParser parser;

    private ByteQuadsCanonicalizer symbols;

    private IOContext ioContext;

    private BufferRecycler bufferRecycler;

    @BeforeEach
    void setUp() {
        bufferRecycler = new BufferRecycler();
        symbols = ByteQuadsCanonicalizer.createRoot();
        ioContext = new IOContext(bufferRecycler, null, true);
        parser = new UTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream(new byte[0]), null, symbols, new byte[1024], 0, 1024, true);
    }

    @Test
    void testNextTextValueWhenCurrentTokenIsFieldName() throws IOException {
        // Move to FIELD_NAME
        parser.nextToken();
        // Simulate FIELD_NAME
        setField(parser, "_currToken", JsonToken.FIELD_NAME);
        // Simulate next token as VALUE_STRING
        setField(parser, "_nextToken", JsonToken.VALUE_STRING);
        // Simulate complete token
        setField(parser, "_tokenIncomplete", false);
        setTextBuffer("value");
        String result = parser.nextTextValue();
        assertEquals("value", result);
    }

    @Test
    void testNextTextValueWhenCurrentTokenIsFieldNameAndTokenIncomplete() throws IOException {
        // Move to FIELD_NAME
        parser.nextToken();
        // Simulate FIELD_NAME
        setField(parser, "_currToken", JsonToken.FIELD_NAME);
        // Simulate next token as VALUE_STRING
        setField(parser, "_nextToken", JsonToken.VALUE_STRING);
        // Simulate incomplete token
        setField(parser, "_tokenIncomplete", true);
        // Mock the _finishAndReturnString method using reflection
        String result = invokeNextTextValue();
        assertEquals("value", result);
    }

    @Test
    void testNextTextValueWhenCurrentTokenIsNotFieldName() throws IOException {
        // Simulate START_ARRAY
        setField(parser, "_currToken", JsonToken.START_ARRAY);
        // Simulate next token as VALUE_STRING
        setField(parser, "_nextToken", JsonToken.VALUE_STRING);
        String result = parser.nextTextValue();
        assertNull(result);
    }

    @Test
    void testNextTextValueWhenNextTokenIsNotValueString() throws IOException {
        // Simulate FIELD_NAME
        setField(parser, "_currToken", JsonToken.FIELD_NAME);
        // Simulate next token as START_OBJECT
        setField(parser, "_nextToken", JsonToken.START_OBJECT);
        String result = parser.nextTextValue();
        assertNull(result);
    }

    private String invokeNextTextValue() throws IOException {
        try {
            java.lang.reflect.Method method = UTF8StreamJsonParser.class.getDeclaredMethod("nextTextValue");
            method.setAccessible(true);
            return (String) method.invoke(parser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setField(Object obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setTextBuffer(String value) {
        try {
            java.lang.reflect.Field field = UTF8StreamJsonParser.class.getDeclaredField("_textBuffer");
            field.setAccessible(true);
            TextBuffer textBuffer = new TextBuffer(bufferRecycler);
            textBuffer.setCurrentLength(value.length());
            System.arraycopy(value.toCharArray(), 0, textBuffer.getCurrentSegment(), 0, value.length());
            field.set(parser, textBuffer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
