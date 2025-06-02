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
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.*;

public class JsonFactory__checkInvalidCopy_3_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testCheckInvalidCopy_WithDifferentClass_ThrowsIllegalStateException() throws Exception {
        // Arrange
        // A different class to trigger the exception
        Class<?> expectedClass = String.class;
        // Act & Assert
        Method method = JsonFactory.class.getDeclaredMethod("_checkInvalidCopy", Class.class);
        method.setAccessible(true);
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            method.invoke(jsonFactory, expectedClass);
        });
        // Assert
        assertEquals("Failed copy(): " + jsonFactory.getClass().getName() + " (version: " + jsonFactory.version() + ") does not override copy(); it has to", exception.getMessage());
    }

    @Test
    public void testCheckInvalidCopy_WithSameClass_DoesNotThrowException() throws Exception {
        // Arrange
        // Same class to not trigger the exception
        Class<?> expectedClass = JsonFactory.class;
        // Act
        Method method = JsonFactory.class.getDeclaredMethod("_checkInvalidCopy", Class.class);
        method.setAccessible(true);
        method.invoke(jsonFactory, expectedClass);
        // Assert
        // No exception means the test passes
    }
}
