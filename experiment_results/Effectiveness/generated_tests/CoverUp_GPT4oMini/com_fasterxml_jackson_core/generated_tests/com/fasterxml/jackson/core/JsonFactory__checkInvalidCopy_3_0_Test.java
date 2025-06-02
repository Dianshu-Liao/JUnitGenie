package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
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

class JsonFactory__checkInvalidCopy_3_0_Test {

    @Test
    void testCheckInvalidCopyThrowsException() throws Exception {
        JsonFactory jsonFactory = new JsonFactory();
        Class<?> wrongClass = JsonFactory.class;
        // Use reflection to access the private method
        Method method = JsonFactory.class.getDeclaredMethod("_checkInvalidCopy", Class.class);
        method.setAccessible(true);
        // Assert that an IllegalStateException is thrown when the wrong class is passed
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            method.invoke(jsonFactory, wrongClass);
        });
        String expectedMessage = "Failed copy(): " + jsonFactory.getClass().getName() + " (version: " + jsonFactory.version() + ") does not override copy(); it has to";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void testCheckInvalidCopyDoesNotThrowException() throws Exception {
        JsonFactory jsonFactory = new JsonFactory();
        Class<?> correctClass = jsonFactory.getClass();
        // Use reflection to access the private method
        Method method = JsonFactory.class.getDeclaredMethod("_checkInvalidCopy", Class.class);
        method.setAccessible(true);
        // This should not throw an exception
        method.invoke(jsonFactory, correctClass);
    }
}
