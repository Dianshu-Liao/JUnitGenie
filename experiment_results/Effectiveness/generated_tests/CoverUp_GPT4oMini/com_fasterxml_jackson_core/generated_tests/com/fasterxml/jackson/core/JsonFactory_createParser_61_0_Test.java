package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
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
import com.fasterxml.jackson.core.util.*;

public class JsonFactory_createParser_61_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testCreateParser_ValidInput() throws Exception {
        char[] content = "{\"key\":\"value\"}".toCharArray();
        int offset = 0;
        int len = content.length;
        JsonParser parser = invokeCreateParser(content, offset, len);
        assertNotNull(parser);
    }

    @Test
    public void testCreateParser_NullContent() {
        assertThrows(IOException.class, () -> {
            invokeCreateParser(null, 0, 0);
        });
    }

    @Test
    public void testCreateParser_InvalidOffset() {
        char[] content = "{\"key\":\"value\"}".toCharArray();
        int offset = -1;
        int len = content.length;
        assertThrows(IOException.class, () -> {
            invokeCreateParser(content, offset, len);
        });
    }

    @Test
    public void testCreateParser_InvalidLength() {
        char[] content = "{\"key\":\"value\"}".toCharArray();
        int offset = 0;
        int len = content.length + 1;
        assertThrows(IOException.class, () -> {
            invokeCreateParser(content, offset, len);
        });
    }

    private JsonParser invokeCreateParser(char[] content, int offset, int len) throws Exception {
        Method method = JsonFactory.class.getDeclaredMethod("createParser", char[].class, int.class, int.class);
        method.setAccessible(true);
        return (JsonParser) method.invoke(jsonFactory, content, offset, len);
    }

    @Test
    public void testCreateParser_WithInputDecorator() throws Exception {
        jsonFactory.setStreamReadConstraints(StreamReadConstraints.defaults());
        jsonFactory.setErrorReportConfiguration(new ErrorReportConfiguration(256, 500));
        char[] content = "{\"key\":\"value\"}".toCharArray();
        int offset = 0;
        int len = content.length;
        JsonParser parser = invokeCreateParser(content, offset, len);
        assertNotNull(parser);
    }

    @Test
    public void testCreateParser_WithCharacterEscapes() throws Exception {
        // Set a valid CharacterEscapes if needed
        jsonFactory.setCharacterEscapes(null);
        char[] content = "{\"key\":\"value\"}".toCharArray();
        int offset = 0;
        int len = content.length;
        JsonParser parser = invokeCreateParser(content, offset, len);
        assertNotNull(parser);
    }
}
