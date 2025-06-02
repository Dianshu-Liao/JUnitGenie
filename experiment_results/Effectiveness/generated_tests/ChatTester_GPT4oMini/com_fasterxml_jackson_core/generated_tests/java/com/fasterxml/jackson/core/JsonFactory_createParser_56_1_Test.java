package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParseException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.*;

public class JsonFactory_createParser_56_1_Test {

    private JsonFactory jsonFactory;

    private Reader mockReader;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
        mockReader = mock(Reader.class);
    }

    @Test
    public void testCreateParser_ValidReader() throws IOException, JsonParseException {
        // Arrange
        String jsonString = "{\"key\":\"value\"}";
        mockReader = new StringReader(jsonString);
        // Act
        JsonParser parser = jsonFactory.createParser(mockReader);
        // Assert
        assertNotNull(parser);
        assertEquals(JsonParser.class, parser.getClass());
        // Clean up
        parser.close();
    }

    @Test
    public void testCreateParser_IOException() throws IOException {
        // Arrange
        when(mockReader.read(any(char[].class), anyInt(), anyInt())).thenThrow(new IOException("Reader error"));
        // Act & Assert
        assertThrows(JsonParseException.class, () -> {
            jsonFactory.createParser(mockReader);
        });
    }

    @Test
    public void testCreateParser_NullReader() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            jsonFactory.createParser((Reader) null);
        });
    }

    @Test
    public void testCreateParser_EmptyReader() throws IOException, JsonParseException {
        // Arrange
        mockReader = new StringReader("");
        // Act
        JsonParser parser = jsonFactory.createParser(mockReader);
        // Assert
        assertNotNull(parser);
        assertEquals(JsonParser.class, parser.getClass());
        // Clean up
        parser.close();
    }

    // Additional test for handling a malformed JSON input
    @Test
    public void testCreateParser_MalformedJson() {
        // Arrange
        // Missing closing brace
        String malformedJson = "{\"key\":\"value\"";
        mockReader = new StringReader(malformedJson);
        // Act & Assert
        assertThrows(JsonParseException.class, () -> {
            jsonFactory.createParser(mockReader);
        });
    }
}
