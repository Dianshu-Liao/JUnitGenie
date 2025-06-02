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

public class JsonFactory_createParser_56_3_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testCreateParser_ValidReader() throws IOException {
        // Arrange
        String jsonInput = "{\"key\":\"value\"}";
        Reader reader = new StringReader(jsonInput);
        // Act
        JsonParser parser = jsonFactory.createParser(reader);
        // Assert
        assertNotNull(parser);
        // Ensure to close the parser to avoid resource leaks
        parser.close();
    }

    @Test
    public void testCreateParser_NullReader() {
        // Arrange
        Reader reader = null;
        // Act & Assert
        assertThrows(IOException.class, () -> {
            jsonFactory.createParser(reader);
        });
    }

    @Test
    public void testCreateParser_EmptyReader() throws IOException {
        // Arrange
        String jsonInput = "";
        Reader reader = new StringReader(jsonInput);
        // Act
        JsonParser parser = jsonFactory.createParser(reader);
        // Assert
        assertNotNull(parser);
        // Ensure to close the parser to avoid resource leaks
        parser.close();
    }

    @Test
    public void testCreateParser_InvalidJson() {
        // Arrange
        // Missing closing brace
        String invalidJsonInput = "{\"key\":\"value\"";
        Reader reader = new StringReader(invalidJsonInput);
        // Act & Assert
        assertThrows(JsonParseException.class, () -> {
            jsonFactory.createParser(reader);
        });
    }
}
