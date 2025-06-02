package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import java.lang.reflect.Method;
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
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

class UTF8StreamJsonParser__isNextTokenNameYes_25_4_Test {

    private UTF8StreamJsonParser parser;

    private ByteQuadsCanonicalizer symbols;

    private IOContext ioContext;

    @BeforeEach
    void setUp() {
        // Mock the dependencies
        symbols = mock(ByteQuadsCanonicalizer.class);
        ioContext = mock(IOContext.class);
        // Create a UTF8StreamJsonParser with an InputStream
        byte[] input = "{\"key\": \"value\"}".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
        parser = new UTF8StreamJsonParser(ioContext, 0, inputStream, null, symbols, new byte[1024], 0, input.length, true);
    }

    @Test
    void testIsNextTokenNameYes_String() throws Exception {
        invokeIsNextTokenNameYes('"');
        assertEquals(JsonToken.VALUE_STRING, parser.getCurrentToken());
    }

    @Test
    void testIsNextTokenNameYes_StartArray() throws Exception {
        invokeIsNextTokenNameYes('[');
        assertEquals(JsonToken.START_ARRAY, parser.getCurrentToken());
    }

    @Test
    void testIsNextTokenNameYes_StartObject() throws Exception {
        invokeIsNextTokenNameYes('{');
        assertEquals(JsonToken.START_OBJECT, parser.getCurrentToken());
    }

    @Test
    void testIsNextTokenNameYes_True() throws Exception {
        invokeIsNextTokenNameYes('t');
        assertEquals(JsonToken.VALUE_TRUE, parser.getCurrentToken());
    }

    @Test
    void testIsNextTokenNameYes_False() throws Exception {
        invokeIsNextTokenNameYes('f');
        assertEquals(JsonToken.VALUE_FALSE, parser.getCurrentToken());
    }

    @Test
    void testIsNextTokenNameYes_Null() throws Exception {
        invokeIsNextTokenNameYes('n');
        assertEquals(JsonToken.VALUE_NULL, parser.getCurrentToken());
    }

    @Test
    void testIsNextTokenNameYes_NegativeNumber() throws Exception {
        invokeIsNextTokenNameYes('-');
        assertTrue(parser.getCurrentToken().isNumeric());
    }

    @Test
    void testIsNextTokenNameYes_PositiveNumber() throws Exception {
        invokeIsNextTokenNameYes('1');
        assertTrue(parser.getCurrentToken().isNumeric());
    }

    @Test
    void testIsNextTokenNameYes_UnexpectedValue() throws Exception {
        // An unexpected character
        int unexpectedValue = 'x';
        assertThrows(IOException.class, () -> invokeIsNextTokenNameYes(unexpectedValue));
    }

    private void invokeIsNextTokenNameYes(int value) throws Exception {
        Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_isNextTokenNameYes", int.class);
        method.setAccessible(true);
        method.invoke(parser, value);
    }
}
