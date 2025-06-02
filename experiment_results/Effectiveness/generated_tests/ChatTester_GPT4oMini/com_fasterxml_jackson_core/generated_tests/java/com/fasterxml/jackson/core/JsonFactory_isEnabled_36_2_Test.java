package com.fasterxml.jackson.core;

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

public class JsonFactory_isEnabled_36_2_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testIsEnabledWithEnabledFeature() throws Exception {
        // Create a feature with a specific mask that we will enable
        // Example mask
        StreamReadFeature feature = StreamReadFeature.createFeatureWithMask(1);
        // Set parser features to enable the feature
        invokeSetParserFeatures(1);
        boolean result = jsonFactory.isEnabled(feature);
        assertTrue(result, "Feature should be enabled.");
    }

    @Test
    public void testIsEnabledWithDisabledFeature() throws Exception {
        // Example mask
        StreamReadFeature feature = StreamReadFeature.createFeatureWithMask(2);
        // Set parser features to a different value
        invokeSetParserFeatures(1);
        boolean result = jsonFactory.isEnabled(feature);
        assertFalse(result, "Feature should be disabled.");
    }

    // Reflection method to set the _parserFeatures field
    private void invokeSetParserFeatures(int value) throws Exception {
        java.lang.reflect.Field field = JsonFactory.class.getDeclaredField("_parserFeatures");
        field.setAccessible(true);
        field.setInt(jsonFactory, value);
    }
}

// Mock implementation of StreamReadFeature for testing purposes
class StreamReadFeature {

    private final int mask;

    private StreamReadFeature(int mask) {
        this.mask = mask;
    }

    public static StreamReadFeature createFeatureWithMask(int mask) {
        return new StreamReadFeature(mask);
    }

    public int getMask() {
        return mask;
    }

    public StreamReadFeature mappedFeature() {
        // Simplified for the test
        return this;
    }
}
