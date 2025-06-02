package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
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

public class JsonFactory_createParser_53_0_Test {

    @Test
    public void testCreateParser_ValidFile() throws IOException, JsonParseException {
        // Arrange
        JsonFactory jsonFactory = new JsonFactory();
        // Create a temporary valid JSON file
        File validJsonFile = File.createTempFile("valid", ".json");
        try (PrintWriter writer = new PrintWriter(validJsonFile)) {
            // Valid JSON content
            writer.write("{\"key\": \"value\"}");
        }
        // Act
        try (JsonParser parser = jsonFactory.createParser(new FileInputStream(validJsonFile))) {
            // Assert
            assertNotNull(parser);
        }
    }

    @Test
    public void testCreateParser_InvalidFile() {
        // Arrange
        JsonFactory jsonFactory = new JsonFactory();
        // Create a temporary file with invalid JSON content
        File invalidJsonFile = new File("src/test/resources/invalid.json");
        // Act & Assert
        assertThrows(JsonParseException.class, () -> {
            jsonFactory.createParser(new FileInputStream(invalidJsonFile));
        });
    }

    @Test
    public void testCreateParser_NonExistentFile() {
        // Arrange
        JsonFactory jsonFactory = new JsonFactory();
        File nonExistentFile = new File("src/test/resources/non_existent.json");
        // Act & Assert
        assertThrows(IOException.class, () -> {
            jsonFactory.createParser(new FileInputStream(nonExistentFile));
        });
    }

    @Test
    public void testCreateParser_NullFile() {
        // Arrange
        JsonFactory jsonFactory = new JsonFactory();
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            jsonFactory.createParser((File) null);
        });
    }
}
