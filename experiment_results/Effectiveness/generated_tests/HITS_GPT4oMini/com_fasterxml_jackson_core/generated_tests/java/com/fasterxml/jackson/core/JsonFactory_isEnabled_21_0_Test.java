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
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.*;

public class JsonFactory_isEnabled_21_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testIsEnabled_WhenFeatureIsEnabled() {
        // Enable a specific feature
        jsonFactory.enable(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES);
        assertTrue(jsonFactory.isEnabled(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES), "Expected CANONICALIZE_FIELD_NAMES to be enabled");
    }

    @Test
    public void testIsEnabled_WhenFeatureIsDisabled() {
        // Ensure feature is disabled by default
        assertFalse(jsonFactory.isEnabled(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES), "Expected CANONICALIZE_FIELD_NAMES to be disabled by default");
    }

    @Test
    public void testIsEnabled_WhenFeatureIsNotSet() {
        // Check for a feature that is not set
        assertFalse(jsonFactory.isEnabled(JsonFactory.Feature.INTERN_FIELD_NAMES), "Expected INTERN_FIELD_NAMES to be disabled");
    }

    @Test
    public void testIsEnabled_WithMultipleFeatures() {
        // Enable multiple features and check their status
        jsonFactory.enable(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES);
        jsonFactory.enable(JsonFactory.Feature.INTERN_FIELD_NAMES);
        assertTrue(jsonFactory.isEnabled(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES), "Expected CANONICALIZE_FIELD_NAMES to be enabled");
        assertTrue(jsonFactory.isEnabled(JsonFactory.Feature.INTERN_FIELD_NAMES), "Expected INTERN_FIELD_NAMES to be enabled");
    }

    @Test
    public void testIsEnabled_AfterDisablingFeature() {
        // Enable and then disable a feature
        jsonFactory.enable(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES);
        assertTrue(jsonFactory.isEnabled(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES), "Expected CANONICALIZE_FIELD_NAMES to be enabled");
        jsonFactory.disable(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES);
        assertFalse(jsonFactory.isEnabled(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES), "Expected CANONICALIZE_FIELD_NAMES to be disabled after disabling it");
    }
}
