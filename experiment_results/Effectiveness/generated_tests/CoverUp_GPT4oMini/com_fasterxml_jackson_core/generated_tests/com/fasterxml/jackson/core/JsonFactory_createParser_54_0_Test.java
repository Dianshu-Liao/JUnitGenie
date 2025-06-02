package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import java.lang.reflect.Field;
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

class JsonFactory_createParser_54_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    void testCreateParser_ValidUrl() throws Exception {
        // Arrange
        URL url = new URL("http://example.com/test.json");
        // Act
        JsonParser parser = jsonFactory.createParser(url);
        // Assert
        assertNotNull(parser);
        assertTrue(parser instanceof JsonParser);
        parser.close();
    }

    @Test
    void testCreateParser_InvalidUrl() {
        // Arrange
        URL url = null;
        // Act & Assert
        assertThrows(IOException.class, () -> {
            jsonFactory.createParser(url);
        });
    }

    @Test
    void testCreateParser_ConnectionError() throws Exception {
        // Arrange
        URL url = mock(URL.class);
        when(url.openStream()).thenThrow(new IOException("Connection error"));
        // Act & Assert
        assertThrows(IOException.class, () -> {
            jsonFactory.createParser(url);
        });
    }

    @Test
    void testSetStreamReadConstraints() {
        // Arrange
        StreamReadConstraints constraints = StreamReadConstraints.defaults();
        // Act
        jsonFactory.setStreamReadConstraints(constraints);
        // Assert
        assertEquals(constraints, getProtectedField(jsonFactory, "_streamReadConstraints"));
    }

    @Test
    void testSetErrorReportConfiguration() {
        // Arrange
        ErrorReportConfiguration config = new ErrorReportConfiguration(256, 500);
        // Act
        jsonFactory.setErrorReportConfiguration(config);
        // Assert
        assertEquals(config, getProtectedField(jsonFactory, "_errorReportConfiguration"));
    }

    private Object getProtectedField(Object obj, String fieldName) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
