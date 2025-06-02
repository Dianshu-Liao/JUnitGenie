package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8StreamJsonParser_nextBooleanValue_30_0_Test {

    private UTF8StreamJsonParser parser;

    private IOContext ioContext;

    private ByteQuadsCanonicalizer byteQuadsCanonicalizer;

    @BeforeEach
    public void setUp() {
        ioContext = mock(IOContext.class);
        byteQuadsCanonicalizer = mock(ByteQuadsCanonicalizer.class);
        InputStream inputStream = mock(InputStream.class);
        parser = new UTF8StreamJsonParser(ioContext, 0, inputStream, null, byteQuadsCanonicalizer, null, 0, 0, false);
    }

    private void setCurrToken(JsonToken token) throws Exception {
        Field field = UTF8StreamJsonParser.class.getDeclaredField("_currToken");
        field.setAccessible(true);
        field.set(parser, token);
    }

    private void setNextToken(JsonToken token) throws Exception {
        Field field = UTF8StreamJsonParser.class.getDeclaredField("_nextToken");
        field.setAccessible(true);
        field.set(parser, token);
    }

    @Test
    public void testNextBooleanValue_TrueAfterFieldName() throws Exception {
        setCurrToken(JsonToken.FIELD_NAME);
        setNextToken(JsonToken.VALUE_TRUE);
        Boolean result = parser.nextBooleanValue();
        assertTrue(result);
    }

    @Test
    public void testNextBooleanValue_FalseAfterFieldName() throws Exception {
        setCurrToken(JsonToken.FIELD_NAME);
        setNextToken(JsonToken.VALUE_FALSE);
        Boolean result = parser.nextBooleanValue();
        assertFalse(result);
    }

    @Test
    public void testNextBooleanValue_NullAfterFieldName() throws Exception {
        setCurrToken(JsonToken.FIELD_NAME);
        setNextToken(JsonToken.START_ARRAY);
        Boolean result = parser.nextBooleanValue();
        assertNull(result);
    }

    @Test
    public void testNextBooleanValue_TrueWithoutFieldName() throws Exception {
        setCurrToken(null);
        setNextToken(JsonToken.VALUE_TRUE);
        Boolean result = parser.nextBooleanValue();
        assertTrue(result);
    }

    @Test
    public void testNextBooleanValue_FalseWithoutFieldName() throws Exception {
        setCurrToken(null);
        setNextToken(JsonToken.VALUE_FALSE);
        Boolean result = parser.nextBooleanValue();
        assertFalse(result);
    }

    @Test
    public void testNextBooleanValue_NullWithoutFieldName() throws Exception {
        setCurrToken(null);
        setNextToken(JsonToken.START_OBJECT);
        Boolean result = parser.nextBooleanValue();
        assertNull(result);
    }

    @Test
    public void testNextBooleanValue_EndOfInput() throws Exception {
        setCurrToken(null);
        setNextToken(null);
        Boolean result = parser.nextBooleanValue();
        assertNull(result);
    }

    @Test
    public void testNextBooleanValue_ThrowsIOException() throws Exception {
        setCurrToken(JsonToken.FIELD_NAME);
        setNextToken(JsonToken.VALUE_TRUE);
        // Simulate an IOException
        doThrow(new IOException("Test Exception")).when(parser).nextToken();
        assertThrows(IOException.class, () -> {
            parser.nextBooleanValue();
        });
    }
}
