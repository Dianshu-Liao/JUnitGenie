package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
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

class UTF8StreamJsonParser_nextBooleanValue_30_0_Test {

    private UTF8StreamJsonParser parser;

    private ByteQuadsCanonicalizer symbolTable;

    @BeforeEach
    void setUp() {
        BufferRecycler bufferRecycler = new BufferRecycler();
        IOContext ioContext = new IOContext(null, bufferRecycler, true);
        symbolTable = ByteQuadsCanonicalizer.createRoot();
        parser = new UTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream(new byte[0]), null, symbolTable, null, 0, 0, true);
    }

    @Test
    void testNextBooleanValueWithFieldNameTrue() throws Exception {
        setField(parser, "_currToken", JsonToken.FIELD_NAME);
        setField(parser, "_nextToken", JsonToken.VALUE_TRUE);
        Boolean result = parser.nextBooleanValue();
        assertTrue(result);
    }

    @Test
    void testNextBooleanValueWithFieldNameFalse() throws Exception {
        setField(parser, "_currToken", JsonToken.FIELD_NAME);
        setField(parser, "_nextToken", JsonToken.VALUE_FALSE);
        Boolean result = parser.nextBooleanValue();
        assertFalse(result);
    }

    @Test
    void testNextBooleanValueWithFieldNameStartArray() throws Exception {
        setField(parser, "_currToken", JsonToken.FIELD_NAME);
        setField(parser, "_nextToken", JsonToken.START_ARRAY);
        Boolean result = parser.nextBooleanValue();
        // Should not return a boolean
        assertNull(result);
    }

    @Test
    void testNextBooleanValueWithFieldNameStartObject() throws Exception {
        setField(parser, "_currToken", JsonToken.FIELD_NAME);
        setField(parser, "_nextToken", JsonToken.START_OBJECT);
        Boolean result = parser.nextBooleanValue();
        // Should not return a boolean
        assertNull(result);
    }

    @Test
    void testNextBooleanValueWithoutFieldNameTrue() throws Exception {
        // Simulate input for the parser
        // No field name
        setField(parser, "_currToken", null);
        setField(parser, "_nextToken", JsonToken.VALUE_TRUE);
        Boolean result = parser.nextBooleanValue();
        assertTrue(result);
    }

    @Test
    void testNextBooleanValueWithoutFieldNameFalse() throws Exception {
        // Simulate input for the parser
        // No field name
        setField(parser, "_currToken", null);
        setField(parser, "_nextToken", JsonToken.VALUE_FALSE);
        Boolean result = parser.nextBooleanValue();
        assertFalse(result);
    }

    @Test
    void testNextBooleanValueWithoutFieldNameNull() throws Exception {
        // Simulate input for the parser
        // No field name
        setField(parser, "_currToken", null);
        setField(parser, "_nextToken", JsonToken.VALUE_NULL);
        Boolean result = parser.nextBooleanValue();
        // Should return null for null token
        assertNull(result);
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}
