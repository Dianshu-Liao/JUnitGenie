package com.fasterxml.jackson.core;

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

public class JsonFactory_createParser_55_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testCreateParser_ValidInputStream() throws IOException {
        String jsonInput = "{\"key\":\"value\"}";
        InputStream inputStream = new ByteArrayInputStream(jsonInput.getBytes());
        JsonParser parser = jsonFactory.createParser(inputStream);
        assertNotNull(parser);
        assertEquals(JsonToken.START_OBJECT, parser.nextToken());
        assertEquals("key", parser.nextFieldName());
        assertEquals(JsonToken.VALUE_STRING, parser.nextToken());
        assertEquals("value", parser.getText());
        assertEquals(JsonToken.END_OBJECT, parser.nextToken());
        parser.close();
    }

    @Test
    public void testCreateParser_EmptyInputStream() throws IOException {
        InputStream inputStream = new ByteArrayInputStream("".getBytes());
        JsonParser parser = jsonFactory.createParser(inputStream);
        assertNotNull(parser);
        assertEquals(JsonToken.NOT_AVAILABLE, parser.nextToken());
        parser.close();
    }

    @Test
    public void testCreateParser_InvalidJson() {
        String invalidJson = "{key:value}";
        InputStream inputStream = new ByteArrayInputStream(invalidJson.getBytes());
        assertThrows(JsonParseException.class, () -> {
            jsonFactory.createParser(inputStream);
        });
    }

    @Test
    public void testCreateParser_NullInputStream() {
        assertThrows(IOException.class, () -> {
            jsonFactory.createParser((InputStream) null);
        });
    }

    @Test
    public void testCreateParser_ClosedInputStream() throws IOException {
        InputStream inputStream = new ByteArrayInputStream("{}".getBytes());
        inputStream.close();
        assertThrows(IOException.class, () -> {
            jsonFactory.createParser(inputStream);
        });
    }

    @Test
    public void testCreateParser_ValidJsonWithDecorator() throws IOException {
        String jsonInput = "{\"name\":\"test\"}";
        InputStream inputStream = new ByteArrayInputStream(jsonInput.getBytes());
        jsonFactory.setInputDecorator(new InputDecorator() {

            @Override
            public InputStream decorate(IOContext ctxt, InputStream inputStream) throws IOException {
                // No decoration
                return inputStream;
            }

            @Override
            public Reader decorate(IOContext ctxt, Reader reader) throws IOException {
                // No decoration for Reader
                return reader;
            }

            @Override
            public InputStream decorate(IOContext ctxt, byte[] inputStream, int offset, int length) throws IOException {
                // No decoration for byte array
                return new ByteArrayInputStream(inputStream, offset, length);
            }
        });
        JsonParser parser = jsonFactory.createParser(inputStream);
        assertNotNull(parser);
        assertEquals(JsonToken.START_OBJECT, parser.nextToken());
        assertEquals("name", parser.nextFieldName());
        assertEquals(JsonToken.VALUE_STRING, parser.nextToken());
    }
}
