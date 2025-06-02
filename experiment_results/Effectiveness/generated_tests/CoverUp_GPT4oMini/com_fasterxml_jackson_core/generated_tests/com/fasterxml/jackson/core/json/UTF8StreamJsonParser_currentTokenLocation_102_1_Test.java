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

public class UTF8StreamJsonParser_currentTokenLocation_102_1_Test {

    private UTF8StreamJsonParser parser;

    private ByteQuadsCanonicalizer symbols;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        // Initialize dependencies
        symbols = ByteQuadsCanonicalizer.createRoot();
        ioContext = new IOContext(null, new byte[0], true);
        parser = new UTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream(new byte[0]), null, symbols, new byte[0], 0, 0, true);
    }

    @Test
    public void testCurrentTokenLocation_FieldName() throws Exception {
        // Set up the parser state for FIELD_NAME
        invokeSetCurrToken(JsonToken.FIELD_NAME);
        // Example offset
        parser._nameStartOffset = 5;
        // Example row
        parser._nameStartRow = 1;
        // Example column
        parser._nameStartCol = 10;
        // Example input processed
        setField(parser, "_currInputProcessed", 100);
        JsonLocation location = parser.currentTokenLocation();
        assertNotNull(location);
        // 100 + (5 - 1)
        assertEquals(104, getField(location, "totalOffset"));
        assertEquals(1, getField(location, "lineNumber"));
        assertEquals(10, getField(location, "columnNumber"));
    }

    @Test
    public void testCurrentTokenLocation_OtherToken() throws Exception {
        // Set up the parser state for a different token
        invokeSetCurrToken(JsonToken.VALUE_STRING);
        // Example total input processed
        setField(parser, "_tokenInputTotal", 200);
        // Example row
        setField(parser, "_tokenInputRow", 2);
        // Example column
        setField(parser, "_tokenInputCol", 15);
        JsonLocation location = parser.currentTokenLocation();
        assertNotNull(location);
        // 200 - 1
        assertEquals(199, getField(location, "totalOffset"));
        assertEquals(2, getField(location, "lineNumber"));
        assertEquals(15, getField(location, "columnNumber"));
    }

    private void invokeSetCurrToken(JsonToken token) throws Exception {
        // Use reflection to set the private field _currToken
        java.lang.reflect.Field currTokenField = UTF8StreamJsonParser.class.getDeclaredField("_currToken");
        currTokenField.setAccessible(true);
        currTokenField.set(parser, token);
    }

    private void setField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private Object getField(Object obj, String fieldName) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}
