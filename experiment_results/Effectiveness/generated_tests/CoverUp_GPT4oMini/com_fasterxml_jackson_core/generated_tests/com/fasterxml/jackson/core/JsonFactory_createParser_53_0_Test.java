package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonToken;
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
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.*;

class JsonFactory_createParser_53_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    void testCreateParser_ValidFile() throws IOException, JsonParseException {
        // Create a temporary file with valid JSON content
        File tempFile = File.createTempFile("test", ".json");
        // Ensure the file is deleted after the test
        tempFile.deleteOnExit();
        // Write valid JSON content to the file
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("{\"key\":\"value\"}");
        }
        // Invoke the focal method
        JsonParser parser = jsonFactory.createParser(tempFile);
        // Validate the parser
        assertNotNull(parser);
        // Move to the first token
        parser.nextToken();
        assertEquals(JsonToken.START_OBJECT, parser.currentToken());
        parser.close();
    }

    @Test
    void testCreateParser_NonExistentFile() {
        // Test with a non-existent file
        File nonExistentFile = new File("nonExistent.json");
        // Verify that an IOException is thrown
        assertThrows(IOException.class, () -> {
            jsonFactory.createParser(nonExistentFile);
        });
    }

    @Test
    void testCreateParser_InvalidJson() throws IOException {
        // Create a temporary file with invalid JSON content
        File tempFile = File.createTempFile("invalidTest", ".json");
        // Ensure the file is deleted after the test
        tempFile.deleteOnExit();
        // Write invalid JSON content to the file
        try (FileWriter writer = new FileWriter(tempFile)) {
            // Invalid JSON
            writer.write("{key:value}");
        }
        // Verify that a JsonParseException is thrown
        assertThrows(JsonParseException.class, () -> {
            jsonFactory.createParser(tempFile);
        });
    }

    @Test
    void testCreateParser_EmptyFile() throws IOException {
        // Create a temporary empty file
        File tempFile = File.createTempFile("emptyTest", ".json");
        // Ensure the file is deleted after the test
        tempFile.deleteOnExit();
        // Invoke the focal method
        JsonParser parser = jsonFactory.createParser(tempFile);
        // Validate that the parser is not null and is at the end of input
        assertNotNull(parser);
        // No tokens in an empty file
        assertNull(parser.currentToken());
        parser.close();
    }
}
