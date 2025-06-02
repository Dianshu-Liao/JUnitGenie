package com.fasterxml.jackson.core.json;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8StreamJsonParser_currentTokenLocation_102_0_Test {

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
        // Initialize the parser with some dummy parameters
        parser = new UTF8StreamJsonParser(mockContext, 0, mockInputStream, mockCodec, mockSymbols, new byte[16], 0, 16, true);
    }

    @Test
    public void testCurrentTokenLocation_FieldName() throws Exception {
        // Set up the internal state to simulate FIELD_NAME token
        setPrivateField(parser, "_currToken", JsonToken.FIELD_NAME);
        setPrivateField(parser, "_currInputProcessed", 100L);
        setPrivateField(parser, "_nameStartOffset", 10);
        setPrivateField(parser, "_nameStartRow", 1);
        setPrivateField(parser, "_nameStartCol", 5);
        JsonLocation location = parser.currentTokenLocation();
        assertEquals(109L, location.getCharOffset());
        assertEquals(1, location.getLineNr());
        assertEquals(5, location.getColumnNr());
    }

    @Test
    public void testCurrentTokenLocation_OtherToken() throws Exception {
        // Set up the internal state to simulate a different token
        setPrivateField(parser, "_currToken", JsonToken.VALUE_STRING);
        setPrivateField(parser, "_tokenInputTotal", 200L);
        setPrivateField(parser, "_tokenInputRow", 2);
        setPrivateField(parser, "_tokenInputCol", 3);
        JsonLocation location = parser.currentTokenLocation();
        assertEquals(199L, location.getCharOffset());
        assertEquals(2, location.getLineNr());
        assertEquals(3, location.getColumnNr());
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
