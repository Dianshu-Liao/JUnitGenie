package com.fasterxml.jackson.core;

import java.net.MalformedURLException;
import java.net.URL;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.lang.ref.SoftReference;
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

public class JsonFactory_createParser_54_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testCreateParser_ValidUrl() throws IOException {
        // Arrange
        String jsonUrl = "http://example.com/sample.json";
        URL url = new URL(jsonUrl);
        // Act
        JsonParser parser = jsonFactory.createParser(url);
        // Assert
        assertNotNull(parser, "Parser should not be null for a valid URL");
        // Ensure resources are closed
        parser.close();
    }

    @Test
    public void testCreateParser_InvalidUrl() {
        // Arrange
        String invalidUrl = "invalid-url";
        // Act & Assert
        assertThrows(MalformedURLException.class, () -> {
            jsonFactory.createParser(new URL(invalidUrl));
        }, "Expected a MalformedURLException for an invalid URL");
    }

    @Test
    public void testCreateParser_NullUrl() {
        // Arrange
        URL url = null;
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            jsonFactory.createParser(url);
        }, "Expected a NullPointerException for a null URL");
    }

    @Test
    public void testCreateParser_EmptyUrl() {
        // Arrange
        String emptyUrl = "";
        URL url;
        try {
            url = new URL(emptyUrl);
        } catch (MalformedURLException e) {
            fail("Should not throw an exception for empty URL when creating URL object");
            // Early return to avoid using uninitialized url
            return;
        }
        // Act & Assert
        assertThrows(IOException.class, () -> {
            jsonFactory.createParser(url);
        }, "Expected an IOException for an empty URL");
    }

    @Test
    public void testCreateParser_Timeout() {
        // Arrange
        // Assuming this URL would lead to a timeout
        String timeoutUrl = "http://example.com/timeout";
        // Act & Assert
        assertThrows(IOException.class, () -> {
            jsonFactory.createParser(new URL(timeoutUrl));
        }, "Expected an IOException for a timeout situation");
    }
}
