package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.StreamReadConstraints;
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

class JsonFactory_createParser_56_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    void testCreateParser_ValidReader() throws IOException {
        // Arrange
        String json = "{\"key\":\"value\"}";
        Reader reader = new StringReader(json);
        // Act
        JsonParser parser = jsonFactory.createParser(reader);
        // Assert
        assertNotNull(parser);
        // Ensure resources are cleaned up
        parser.close();
    }

    @Test
    void testCreateParser_NullReader() {
        // Arrange
        Reader reader = null;
        // Act & Assert
        assertThrows(IOException.class, () -> {
            jsonFactory.createParser(reader);
        });
    }

    @Test
    void testCreateParser_EmptyReader() throws IOException {
        // Arrange
        String json = "";
        Reader reader = new StringReader(json);
        // Act
        JsonParser parser = jsonFactory.createParser(reader);
        // Assert
        assertNotNull(parser);
        // Ensure resources are cleaned up
        parser.close();
    }

    @Test
    void testCreateParser_InvalidJson() {
        // Arrange
        String json = "{key:value}";
        Reader reader = new StringReader(json);
        // Act & Assert
        assertThrows(JsonParseException.class, () -> {
            jsonFactory.createParser(reader);
        });
    }
}
