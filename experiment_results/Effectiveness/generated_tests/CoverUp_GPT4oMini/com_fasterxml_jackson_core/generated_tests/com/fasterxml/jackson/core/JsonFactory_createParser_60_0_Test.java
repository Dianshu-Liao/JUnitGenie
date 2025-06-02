package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.*;

public class JsonFactory_createParser_60_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testCreateParser_ValidInput() throws Exception {
        char[] content = "{\"key\":\"value\"}".toCharArray();
        JsonParser parser = invokeCreateParser(content);
        assertNotNull(parser);
        parser.close();
    }

    @Test
    public void testCreateParser_EmptyInput() throws Exception {
        char[] content = "".toCharArray();
        JsonParser parser = invokeCreateParser(content);
        assertNotNull(parser);
        parser.close();
    }

    @Test
    public void testCreateParser_NullInput() {
        assertThrows(NullPointerException.class, () -> {
            invokeCreateParser(null);
        });
    }

    @Test
    public void testCreateParser_WithOffsetAndLength() throws Exception {
        char[] content = "{\"key\":\"value\"}".toCharArray();
        JsonParser parser = invokeCreateParser(content, 0, content.length);
        assertNotNull(parser);
        parser.close();
    }

    @Test
    public void testCreateParser_OffsetOutOfBounds() {
        char[] content = "{\"key\":\"value\"}".toCharArray();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            invokeCreateParser(content, 1, content.length);
        });
    }

    @Test
    public void testCreateParser_LengthExceedsContent() {
        char[] content = "{\"key\":\"value\"}".toCharArray();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            invokeCreateParser(content, 0, content.length + 1);
        });
    }

    @Test
    public void testCreateParser_NegativeOffset() {
        char[] content = "{\"key\":\"value\"}".toCharArray();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            invokeCreateParser(content, -1, content.length);
        });
    }

    @Test
    public void testCreateParser_NegativeLength() {
        char[] content = "{\"key\":\"value\"}".toCharArray();
        assertThrows(IllegalArgumentException.class, () -> {
            invokeCreateParser(content, 0, -1);
        });
    }

    private JsonParser invokeCreateParser(char[] content, int offset, int length) throws Exception {
        Method method = JsonFactory.class.getDeclaredMethod("createParser", char[].class, int.class, int.class);
        method.setAccessible(true);
        return (JsonParser) method.invoke(jsonFactory, content, offset, length);
    }

    private JsonParser invokeCreateParser(char[] content) throws Exception {
        Method method = JsonFactory.class.getDeclaredMethod("createParser", char[].class);
        method.setAccessible(true);
        return (JsonParser) method.invoke(jsonFactory, content);
    }
}
