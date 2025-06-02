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

public class UTF8StreamJsonParser_getValueAsInt_9_1_Test {

    private UTF8StreamJsonParser parser;

    private IOContext context;

    private ObjectCodec codec;

    private ByteQuadsCanonicalizer symbols;

    private InputStream inputStream;

    private byte[] inputBuffer;

    @BeforeEach
    public void setUp() {
        context = Mockito.mock(IOContext.class);
        codec = Mockito.mock(ObjectCodec.class);
        symbols = Mockito.mock(ByteQuadsCanonicalizer.class);
        inputStream = Mockito.mock(InputStream.class);
        inputBuffer = new byte[16];
        parser = new UTF8StreamJsonParser(context, 0, inputStream, codec, symbols, inputBuffer, 0, inputBuffer.length, true);
    }

    @Test
    public void testGetValueAsInt_NumberInt() throws IOException {
        setPrivateField(parser, "_currToken", JsonToken.VALUE_NUMBER_INT);
        setPrivateField(parser, "_numTypesValid", 1);
        setPrivateField(parser, "_numberInt", 42);
        int result = parser.getValueAsInt();
        assertEquals(42, result);
    }

    @Test
    public void testGetValueAsInt_NumberFloat() throws IOException {
        setPrivateField(parser, "_currToken", JsonToken.VALUE_NUMBER_FLOAT);
        setPrivateField(parser, "_numTypesValid", 1);
        setPrivateField(parser, "_numberInt", 42);
        int result = parser.getValueAsInt();
        assertEquals(42, result);
    }

    @Test
    public void testGetValueAsInt_Unknown() throws IOException {
        setPrivateField(parser, "_currToken", JsonToken.VALUE_NUMBER_INT);
        setPrivateField(parser, "_numTypesValid", 0);
        int result = parser.getValueAsInt();
        assertEquals(0, result);
    }

    @Test
    public void testGetValueAsInt_NotNumber() throws IOException {
        setPrivateField(parser, "_currToken", JsonToken.VALUE_STRING);
        int result = parser.getValueAsInt();
        assertEquals(0, result);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Failed to set private field: " + fieldName);
        }
    }
}
