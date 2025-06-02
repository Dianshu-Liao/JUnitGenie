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

public class JsonFactory_isEnabled_36_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testIsEnabled_WithEnabledFeature() {
        JsonFactory.Feature feature = JsonFactory.Feature.CANONICALIZE_FIELD_NAMES;
        // Enable the feature for testing
        jsonFactory.enable(feature);
        assertTrue(jsonFactory.isEnabled(feature), "Feature should be enabled.");
    }

    @Test
    public void testIsEnabled_WithDisabledFeature() {
        JsonFactory.Feature feature = JsonFactory.Feature.CANONICALIZE_FIELD_NAMES;
        assertFalse(jsonFactory.isEnabled(feature), "Feature should be disabled.");
    }

    @Test
    public void testIsEnabled_WithMultipleFeatures() {
        JsonFactory.Feature featureOne = JsonFactory.Feature.CANONICALIZE_FIELD_NAMES;
        // Reusing the same feature
        JsonFactory.Feature featureTwo = JsonFactory.Feature.CANONICALIZE_FIELD_NAMES;
        // Enable first feature
        jsonFactory.enable(featureOne);
        assertTrue(jsonFactory.isEnabled(featureOne), "Feature One should be enabled.");
        assertFalse(jsonFactory.isEnabled(featureTwo), "Feature Two should be disabled.");
    }

    @Test
    public void testIsEnabled_WithDifferentFeature() {
        JsonFactory.Feature feature = JsonFactory.Feature.CANONICALIZE_FIELD_NAMES;
        // Enable this feature
        jsonFactory.enable(feature);
        assertTrue(jsonFactory.isEnabled(feature), "Feature should be enabled.");
    }
}
