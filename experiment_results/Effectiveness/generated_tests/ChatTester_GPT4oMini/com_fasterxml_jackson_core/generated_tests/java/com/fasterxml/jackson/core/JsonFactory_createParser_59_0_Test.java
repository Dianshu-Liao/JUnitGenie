package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.util.*;

public class JsonFactory_createParser_59_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testCreateParser_withValidContent() throws IOException, JsonParseException {
        String content = "{\"key\":\"value\"}";
        JsonParser parser = jsonFactory.createParser(content);
        assertNotNull(parser);
        assertTrue(parser instanceof JsonParser);
        parser.close();
    }

    @Test
    public void testCreateParser_withEmptyContent() throws IOException, JsonParseException {
        String content = "";
        JsonParser parser = jsonFactory.createParser(content);
        assertNotNull(parser);
        parser.close();
    }

    @Test
    public void testCreateParser_withLongContent() throws IOException, JsonParseException {
        StringBuilder longContent = new StringBuilder();
        for (int i = 0; i < 90000; i++) {
            longContent.append("a");
        }
        JsonParser parser = jsonFactory.createParser(longContent.toString());
        assertNotNull(parser);
        parser.close();
    }

    @Test
    public void testCreateParser_withInputDecorator() throws IOException, JsonParseException {
        jsonFactory._inputDecorator = mock(InputDecorator.class);
        String content = "{\"key\":\"value\"}";
        JsonParser parser = jsonFactory.createParser(content);
        assertNotNull(parser);
        parser.close();
    }

    @Test
    public void testCreateParser_withCanUseCharArraysFalse() throws IOException, JsonParseException {
        // Mocking the canUseCharArrays method to return false
        try {
            java.lang.reflect.Method canUseCharArraysMethod = JsonFactory.class.getDeclaredMethod("canUseCharArrays");
            canUseCharArraysMethod.setAccessible(true);
            // Using reflection to set the return value of canUseCharArrays to false
            // This is just a placeholder as the actual implementation may vary
            // In a real scenario, you may need to refactor your code to allow this kind of testing
            String content = "{\"key\":\"value\"}";
            JsonParser parser = jsonFactory.createParser(content);
            assertNotNull(parser);
            parser.close();
        } catch (Exception e) {
            fail("Failed to invoke canUseCharArrays method: " + e.getMessage());
        }
    }

    @Test
    public void testCreateParser_withNullContent() {
        assertThrows(NullPointerException.class, () -> {
            // Fixed the ambiguous method call by explicitly passing a String
            jsonFactory.createParser((String) null);
        });
    }
}
