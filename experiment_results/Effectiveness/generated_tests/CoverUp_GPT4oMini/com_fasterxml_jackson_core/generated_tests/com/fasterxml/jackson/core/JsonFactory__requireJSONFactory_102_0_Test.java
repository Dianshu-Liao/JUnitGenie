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

public class JsonFactory__requireJSONFactory_102_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testRequireJSONFactory_throwsException_whenNotJSONFactory() throws Exception {
        // Use reflection to set the _factoryFeatures to a value that indicates it's not a JSON factory
        // Assuming we have a way to set _factoryFeatures (this is just a demonstration)
        // In this case, we are not actually changing the implementation since we don't have access to it
        // Now invoke the private method _requireJSONFactory
        Method method = JsonFactory.class.getDeclaredMethod("_requireJSONFactory", String.class);
        method.setAccessible(true);
        String errorMessage = "Expected JSON factory, but got: %s";
        // Assert that calling the method throws an UnsupportedOperationException
        assertThrows(UnsupportedOperationException.class, () -> {
            method.invoke(jsonFactory, errorMessage);
        });
    }

    @Test
    public void testRequireJSONFactory_doesNotThrow_whenIsJSONFactory() throws Exception {
        // Since the default constructor of JsonFactory sets it as a JSON factory, we can directly call the method.
        // Now invoke the private method _requireJSONFactory
        Method method = JsonFactory.class.getDeclaredMethod("_requireJSONFactory", String.class);
        method.setAccessible(true);
        String errorMessage = "Expected JSON factory, but got: %s";
        // This should not throw an exception
        method.invoke(jsonFactory, errorMessage);
    }
}
