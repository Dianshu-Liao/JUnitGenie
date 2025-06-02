package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
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

public class UTF8DataInputJsonParser_getValueAsString_7_0_Test {

    private UTF8DataInputJsonParser parser;

    private ByteQuadsCanonicalizer symbols;

    private IOContext ioContext;

    private DataInput inputData;

    @BeforeEach
    public void setUp() {
        symbols = mock(ByteQuadsCanonicalizer.class);
        BufferRecycler bufferRecycler = new BufferRecycler();
        ioContext = new IOContext(bufferRecycler, null, true);
        inputData = mock(DataInput.class);
        parser = new UTF8DataInputJsonParser(ioContext, 0, inputData, null, symbols, 0);
    }

    @Test
    public void testGetValueAsString_ReturnsStringWhenCurrentTokenIsValueString() throws Exception {
        setField(parser, "_currToken", JsonToken.VALUE_STRING);
        String expectedString = "testValue";
        setField(parser, "_tokenIncomplete", false);
        TextBuffer textBuffer = mock(TextBuffer.class);
        when(textBuffer.contentsAsString()).thenReturn(expectedString);
        setField(parser, "_textBuffer", textBuffer);
        String result = parser.getValueAsString(null);
        assertEquals(expectedString, result);
    }

    @Test
    public void testGetValueAsString_ReturnsStringWhenCurrentTokenIsValueStringAndTokenIsIncomplete() throws Exception {
        setField(parser, "_currToken", JsonToken.VALUE_STRING);
        String expectedString = "incompleteValue";
        setField(parser, "_tokenIncomplete", true);
        TextBuffer textBuffer = mock(TextBuffer.class);
        when(textBuffer.contentsAsString()).thenReturn(expectedString);
        setField(parser, "_textBuffer", textBuffer);
        String result = parser.getValueAsString(null);
        assertEquals(expectedString, result);
        verify(textBuffer, times(1)).contentsAsString();
    }

    @Test
    public void testGetValueAsString_ReturnsCurrentNameWhenCurrentTokenIsFieldName() throws Exception {
        setField(parser, "_currToken", JsonToken.FIELD_NAME);
        String expectedName = "fieldName";
        when(parser.currentName()).thenReturn(expectedName);
        String result = parser.getValueAsString(null);
        assertEquals(expectedName, result);
    }

    @Test
    public void testGetValueAsString_ReturnsDefaultValueWhenCurrentTokenIsNeitherValueStringNorFieldName() throws Exception {
        setField(parser, "_currToken", JsonToken.VALUE_NUMBER_INT);
        String defaultValue = "default";
        String result = parser.getValueAsString(defaultValue);
        assertEquals(defaultValue, result);
    }

    private void setField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
