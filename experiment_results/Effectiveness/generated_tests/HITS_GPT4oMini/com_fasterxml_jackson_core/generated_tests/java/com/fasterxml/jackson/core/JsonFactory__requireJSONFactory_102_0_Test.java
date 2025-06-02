package com.fasterxml.jackson.core;

import java.lang.reflect.Method;
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

public class JsonFactory__requireJSONFactory_102_0_Test {

    @Test
    public void testRequireJSONFactory_ThrowsException_WhenNotJSONFactory() throws Exception {
        // Arrange
        JsonFactory jsonFactory = new JsonFactory() {

            @Override
            public String getFormatName() {
                // Override to simulate a non-JSON factory
                return "NonJSON";
            }
        };
        String expectedMessage = String.format("Expected JSON format but got: %s", "NonJSON");
        // Act
        Method method = JsonFactory.class.getDeclaredMethod("_requireJSONFactory", String.class);
        // Make the private method accessible
        method.setAccessible(true);
        // Assert
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> {
            method.invoke(jsonFactory, expectedMessage);
        });
        // Verify
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testRequireJSONFactory_DoesNotThrowException_WhenJSONFactory() throws Exception {
        // Arrange
        JsonFactory jsonFactory = new JsonFactory();
        // Act
        Method method = JsonFactory.class.getDeclaredMethod("_requireJSONFactory", String.class);
        // Make the private method accessible
        method.setAccessible(true);
        // This should not throw any exception
        method.invoke(jsonFactory, "This message should not be seen");
    }
}
