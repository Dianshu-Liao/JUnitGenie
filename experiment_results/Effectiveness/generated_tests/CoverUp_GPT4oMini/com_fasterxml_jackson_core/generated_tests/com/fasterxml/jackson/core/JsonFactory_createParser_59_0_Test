package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParseException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
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

class JsonFactory_createParser_59_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    void testCreateParserWithValidString() throws IOException {
        String jsonContent = "{\"name\":\"John\", \"age\":30}";
        JsonParser parser = jsonFactory.createParser(jsonContent);
        assertNotNull(parser);
        parser.close();
    }

    @Test
    void testCreateParserWithEmptyString() throws IOException {
        String jsonContent = "";
        JsonParser parser = jsonFactory.createParser(jsonContent);
        assertNotNull(parser);
        parser.close();
    }

    @Test
    void testCreateParserWithLongString() throws IOException {
        StringBuilder longJson = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            longJson.append("{\"name\":\"John").append(i).append("\", \"age\":").append(i).append("}");
        }
        JsonParser parser = jsonFactory.createParser(longJson.toString());
        assertNotNull(parser);
        parser.close();
    }

    @Test
    void testCreateParserWithNullString() {
        assertThrows(NullPointerException.class, () -> jsonFactory.createParser((String) null));
    }

    @Test
    void testCreateParserWithInputDecorator() throws Exception {
        Method setInputDecoratorMethod = JsonFactory.class.getDeclaredMethod("setInputDecorator", InputDecorator.class);
        setInputDecoratorMethod.setAccessible(true);
        setInputDecoratorMethod.invoke(jsonFactory, (InputDecorator) null);
        String jsonContent = "{\"name\":\"John\", \"age\":30}";
        JsonParser parser = jsonFactory.createParser(jsonContent);
        assertNotNull(parser);
        parser.close();
    }

    @Test
    void testCreateParserWithNonCharArrayUsable() throws Exception {
        Method canUseCharArraysMethod = JsonFactory.class.getDeclaredMethod("canUseCharArrays");
        canUseCharArraysMethod.setAccessible(true);
        assertFalse((Boolean) canUseCharArraysMethod.invoke(jsonFactory));
        String jsonContent = "{\"name\":\"John\", \"age\":30}";
        JsonParser parser = jsonFactory.createParser(jsonContent);
        assertNotNull(parser);
        parser.close();
    }
}
