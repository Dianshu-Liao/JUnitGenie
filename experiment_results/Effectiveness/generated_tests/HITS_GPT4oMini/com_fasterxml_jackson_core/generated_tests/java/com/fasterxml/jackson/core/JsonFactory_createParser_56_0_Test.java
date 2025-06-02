package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonParseException;
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

public class JsonFactory_createParser_56_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testCreateParser_ValidReader() throws IOException, JsonParseException {
        // Arrange
        String jsonInput = "{\"key\":\"value\"}";
        StringReader reader = new StringReader(jsonInput);
        // Act
        JsonParser parser = jsonFactory.createParser(reader);
        // Assert
        assertNotNull(parser, "Parser should not be null for valid input");
        // Ensure resources are released
        parser.close();
    }

    @Test
    public void testCreateParser_EmptyReader() throws IOException, JsonParseException {
        // Arrange
        StringReader reader = new StringReader("");
        // Act
        JsonParser parser = jsonFactory.createParser(reader);
        // Assert
        assertNotNull(parser, "Parser should not be null for empty input");
        // Ensure resources are released
        parser.close();
    }

    @Test
    public void testCreateParser_NullReader() {
        // Arrange
        StringReader reader = null;
        // Act & Assert
        assertThrows(IOException.class, () -> {
            jsonFactory.createParser(reader);
        }, "Expected IOException when passing null Reader");
    }

    @Test
    public void testCreateParser_InvalidJson() {
        // Arrange
        // Missing closing brace
        String invalidJson = "{\"key\":\"value\"";
        StringReader reader = new StringReader(invalidJson);
        // Act & Assert
        assertThrows(JsonParseException.class, () -> {
            jsonFactory.createParser(reader);
        }, "Expected JsonParseException for invalid JSON input");
    }
}
