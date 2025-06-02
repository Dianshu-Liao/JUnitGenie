package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonParser;
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
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.*;

public class // Reflection test for private methods if needed
// Note: This is a placeholder for testing private methods, which might not be necessary for this context.
// You can add tests for private methods using reflection if required.
JsonFactory_createParser_55_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testCreateParser_ValidInputStream() throws IOException, JsonParseException {
        // Arrange
        InputStream inputStream = new ByteArrayInputStream("{\"key\":\"value\"}".getBytes());
        // Act
        JsonParser parser = jsonFactory.createParser(inputStream);
        // Assert
        assertNotNull(parser);
        assertEquals(JsonParser.Feature.AUTO_CLOSE_SOURCE, parser.getFeatureMask());
        parser.close();
    }

    @Test
    public void testCreateParser_NullInputStream() {
        // Arrange
        InputStream inputStream = null;
        // Act & Assert
        assertThrows(IOException.class, () -> {
            jsonFactory.createParser(inputStream);
        });
    }

    @Test
    public void testCreateParser_EmptyInputStream() throws IOException, JsonParseException {
        // Arrange
        InputStream inputStream = new ByteArrayInputStream("".getBytes());
        // Act
        JsonParser parser = jsonFactory.createParser(inputStream);
        // Assert
        assertNotNull(parser);
        parser.close();
    }

    @Test
    public void testCreateParser_InvalidJson() {
        // Arrange
        InputStream inputStream = new ByteArrayInputStream("{key:value}".getBytes());
        // Act & Assert
        assertThrows(JsonParseException.class, () -> {
            jsonFactory.createParser(inputStream);
        });
    }

    @Test
    public void testCreateParser_ValidJsonWithSpecialCharacters() throws IOException, JsonParseException {
        // Arrange
        InputStream inputStream = new ByteArrayInputStream("{\"key\":\"value with special characters !@#$%^&*()\"}".getBytes());
        // Act
        JsonParser parser = jsonFactory.createParser(inputStream);
        // Assert
        assertNotNull(parser);
        parser.close();
    }

    @Test
    public void testCreateParser_ValidJsonWithNestedObjects() throws IOException, JsonParseException {
        // Arrange
        InputStream inputStream = new ByteArrayInputStream("{\"key\":{\"nestedKey\":\"nestedValue\"}}".getBytes());
        // Act
        JsonParser parser = jsonFactory.createParser(inputStream);
        // Assert
        assertNotNull(parser);
        parser.close();
    }
}
