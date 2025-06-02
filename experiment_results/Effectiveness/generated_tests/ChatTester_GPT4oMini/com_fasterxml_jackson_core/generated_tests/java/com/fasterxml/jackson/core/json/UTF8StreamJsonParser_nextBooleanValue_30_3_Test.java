package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8StreamJsonParser_nextBooleanValue_30_3_Test {

    private UTF8StreamJsonParser parser;

    private IOContext mockContext;

    private ObjectCodec mockCodec;

    private ByteQuadsCanonicalizer mockSymbols;

    private InputStream mockInputStream;

    @BeforeEach
    public void setUp() {
        mockContext = mock(IOContext.class);
        mockCodec = mock(ObjectCodec.class);
        mockSymbols = mock(ByteQuadsCanonicalizer.class);
        mockInputStream = mock(InputStream.class);
        parser = new UTF8StreamJsonParser(mockContext, 0, mockInputStream, mockCodec, mockSymbols, new byte[0], 0, 0, true);
    }

    @Test
    public void testNextBooleanValue_FieldNameTrue() throws Exception {
        setPrivateField(parser, "_currToken", JsonToken.FIELD_NAME);
        setPrivateField(parser, "_nextToken", JsonToken.VALUE_TRUE);
        Boolean result = parser.nextBooleanValue();
        assertTrue(result);
    }

    @Test
    public void testNextBooleanValue_FieldNameFalse() throws Exception {
        setPrivateField(parser, "_currToken", JsonToken.FIELD_NAME);
        setPrivateField(parser, "_nextToken", JsonToken.VALUE_FALSE);
        Boolean result = parser.nextBooleanValue();
        assertFalse(result);
    }

    @Test
    public void testNextBooleanValue_FieldNameStartArray() throws Exception {
        setPrivateField(parser, "_currToken", JsonToken.FIELD_NAME);
        setPrivateField(parser, "_nextToken", JsonToken.START_ARRAY);
        Boolean result = parser.nextBooleanValue();
        assertNull(result);
        // Fixed the buggy line by removing the method invocation, as it's not necessary for this test case.
    }

    @Test
    public void testNextBooleanValue_FieldNameStartObject() throws Exception {
        setPrivateField(parser, "_currToken", JsonToken.FIELD_NAME);
        setPrivateField(parser, "_nextToken", JsonToken.START_OBJECT);
        Boolean result = parser.nextBooleanValue();
        assertNull(result);
        // Fixed the buggy line by removing the method invocation, as it's not necessary for this test case.
    }

    @Test
    public void testNextBooleanValue_NoFieldNameTrue() throws Exception {
        setPrivateField(parser, "_currToken", null);
        when(parser.nextToken()).thenReturn(JsonToken.VALUE_TRUE);
        Boolean result = parser.nextBooleanValue();
        assertTrue(result);
    }

    @Test
    public void testNextBooleanValue_NoFieldNameFalse() throws Exception {
        setPrivateField(parser, "_currToken", null);
        when(parser.nextToken()).thenReturn(JsonToken.VALUE_FALSE);
        Boolean result = parser.nextBooleanValue();
        assertFalse(result);
    }

    @Test
    public void testNextBooleanValue_NoFieldNameNull() throws Exception {
        setPrivateField(parser, "_currToken", null);
        when(parser.nextToken()).thenReturn(null);
        Boolean result = parser.nextBooleanValue();
        assertNull(result);
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}
