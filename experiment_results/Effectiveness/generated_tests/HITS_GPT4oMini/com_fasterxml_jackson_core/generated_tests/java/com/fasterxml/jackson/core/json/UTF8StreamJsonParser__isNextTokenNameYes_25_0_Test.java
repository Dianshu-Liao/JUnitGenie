package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.CharTypes;
import java.lang.reflect.InvocationTargetException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8StreamJsonParser__isNextTokenNameYes_25_0_Test {

    private UTF8StreamJsonParser parser;

    @BeforeEach
    public void setUp() throws IOException {
        BufferRecycler bufferRecycler = new BufferRecycler();
        IOContext ioContext = new IOContext(null, bufferRecycler, null, true);
        ByteQuadsCanonicalizer symbolTable = ByteQuadsCanonicalizer.createRoot();
        byte[] inputBuffer = new byte[1];
        parser = new UTF8StreamJsonParser(ioContext, 0, new ByteArrayInputStream(inputBuffer), null, symbolTable, inputBuffer, 0, 1, true);
    }

    private void invokeIsNextTokenNameYes(int token) {
        try {
            // Use reflection to call the private method _isNextTokenNameYes
            java.lang.reflect.Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_isNextTokenNameYes", int.class);
            method.setAccessible(true);
            method.invoke(parser, token);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            fail("Exception thrown while invoking _isNextTokenNameYes: " + e.getMessage());
        }
    }

    @Test
    public void testIsNextTokenNameYesWithQuote() throws IOException {
        invokeIsNextTokenNameYes('"');
        assertEquals(JsonToken.VALUE_STRING, parser.getCurrentToken());
    }

    @Test
    public void testIsNextTokenNameYesWithStartArray() throws IOException {
        invokeIsNextTokenNameYes('[');
        assertEquals(JsonToken.START_ARRAY, parser.getCurrentToken());
    }

    @Test
    public void testIsNextTokenNameYesWithStartObject() throws IOException {
        invokeIsNextTokenNameYes('{');
        assertEquals(JsonToken.START_OBJECT, parser.getCurrentToken());
    }

    @Test
    public void testIsNextTokenNameYesWithTrue() throws IOException {
        invokeIsNextTokenNameYes('t');
        assertEquals(JsonToken.VALUE_TRUE, parser.getCurrentToken());
    }

    @Test
    public void testIsNextTokenNameYesWithFalse() throws IOException {
        invokeIsNextTokenNameYes('f');
        assertEquals(JsonToken.VALUE_FALSE, parser.getCurrentToken());
    }

    @Test
    public void testIsNextTokenNameYesWithNull() throws IOException {
        invokeIsNextTokenNameYes('n');
        assertEquals(JsonToken.VALUE_NULL, parser.getCurrentToken());
    }

    @Test
    public void testIsNextTokenNameYesWithNumber() throws IOException {
        invokeIsNextTokenNameYes('1');
        assertEquals(JsonToken.VALUE_NUMBER_INT, parser.getCurrentToken());
    }
}
