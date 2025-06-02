// Test method
package com.fasterxml.jackson.core;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.util.*;

public class JsonFactory_isEnabled_21_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testIsEnabledFeatureEnabled() {
        // Corrected line: Using the correct feature from JsonFactory
        // Replace with a valid feature
        JsonFactory.Feature feature = JsonFactory.Feature.INTERN_FIELD_NAMES;
        // Method to enable the feature for testing
        enableFeature(feature);
        assertTrue(jsonFactory.isEnabled(feature), "Feature should be enabled");
    }

    @Test
    public void testIsEnabledFeatureDisabled() {
        // Corrected line: Using the correct feature from JsonFactory
        // Replace with a valid feature
        JsonFactory.Feature feature = JsonFactory.Feature.INTERN_FIELD_NAMES;
        assertFalse(jsonFactory.isEnabled(feature), "Feature should be disabled by default");
    }

    // Reflection method to enable a feature for testing
    private void enableFeature(JsonFactory.Feature feature) {
        try {
            java.lang.reflect.Field field = JsonFactory.class.getDeclaredField("_factoryFeatures");
            field.setAccessible(true);
            int currentFeatures = (int) field.get(jsonFactory);
            field.set(jsonFactory, currentFeatures | feature.getMask());
        } catch (Exception e) {
            fail("Failed to enable feature: " + e.getMessage());
        }
    }
}
