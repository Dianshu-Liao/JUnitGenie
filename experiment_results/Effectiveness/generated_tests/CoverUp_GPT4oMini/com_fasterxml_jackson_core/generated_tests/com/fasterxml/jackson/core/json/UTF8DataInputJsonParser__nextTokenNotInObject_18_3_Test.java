package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.UTF8DataInputJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.io.IOContext;
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

class UTF8DataInputJsonParser__nextTokenNotInObject_18_3_Test {

    private UTF8DataInputJsonParser parser;

    private DataInput inputData;

    private ByteQuadsCanonicalizer symbols;

    @BeforeEach
    void setUp() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[] { '"', '[', '{', 't', 'f', 'n', '-', '+', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' });
        inputData = new DataInputStream(byteArrayInputStream);
        symbols = ByteQuadsCanonicalizer.createRoot();
        IOContext ioContext = new IOContext(null, inputData, false);
        parser = new UTF8DataInputJsonParser(ioContext, 0, inputData, null, symbols, byteArrayInputStream.read());
    }

    @Test
    void testNextTokenNotInObject() throws Exception {
        Method method = UTF8DataInputJsonParser.class.getDeclaredMethod("_nextTokenNotInObject", int.class);
        method.setAccessible(true);
        assertEquals(JsonToken.VALUE_STRING, method.invoke(parser, '"'));
        assertEquals(JsonToken.START_ARRAY, method.invoke(parser, '['));
        assertEquals(JsonToken.START_OBJECT, method.invoke(parser, '{'));
        assertEquals(JsonToken.VALUE_TRUE, method.invoke(parser, 't'));
        assertEquals(JsonToken.VALUE_FALSE, method.invoke(parser, 'f'));
        assertEquals(JsonToken.VALUE_NULL, method.invoke(parser, 'n'));
        assertTrue(method.invoke(parser, '-') instanceof JsonToken);
        assertTrue(method.invoke(parser, '+') instanceof JsonToken);
        assertTrue(method.invoke(parser, '0') instanceof JsonToken);
        assertTrue(method.invoke(parser, '1') instanceof JsonToken);
        assertTrue(method.invoke(parser, '2') instanceof JsonToken);
        assertTrue(method.invoke(parser, '3') instanceof JsonToken);
        assertTrue(method.invoke(parser, '4') instanceof JsonToken);
        assertTrue(method.invoke(parser, '5') instanceof JsonToken);
        assertTrue(method.invoke(parser, '6') instanceof JsonToken);
        assertTrue(method.invoke(parser, '7') instanceof JsonToken);
        assertTrue(method.invoke(parser, '8') instanceof JsonToken);
        assertTrue(method.invoke(parser, '9') instanceof JsonToken);
    }

    @Test
    void testUnexpectedValue() throws Exception {
        Method method = UTF8DataInputJsonParser.class.getDeclaredMethod("_nextTokenNotInObject", int.class);
        method.setAccessible(true);
        // Test unexpected character
        assertThrows(IOException.class, () -> method.invoke(parser, ']'));
        assertThrows(IOException.class, () -> method.invoke(parser, ','));
        assertThrows(IOException.class, () -> method.invoke(parser, 'I'));
        assertThrows(IOException.class, () -> method.invoke(parser, 'N'));
        assertThrows(IOException.class, () -> method.invoke(parser, '+'));
    }
}
