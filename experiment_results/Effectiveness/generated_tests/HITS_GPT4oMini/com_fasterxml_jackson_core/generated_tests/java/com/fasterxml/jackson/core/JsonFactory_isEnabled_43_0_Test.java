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

public class JsonFactory_isEnabled_43_0_Test {

    @Test
    public void testIsEnabledWhenFeatureEnabled() {
        JsonFactory jsonFactory = new JsonFactory();
        // Use JsonGenerator.Feature
        JsonGenerator.Feature feature = JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS;
        // Enable the feature
        jsonFactory.enable(feature);
        assertTrue(jsonFactory.isEnabled(feature), "Feature should be enabled");
    }

    @Test
    public void testIsEnabledWhenFeatureDisabled() {
        JsonFactory jsonFactory = new JsonFactory();
        // Use JsonGenerator.Feature
        JsonGenerator.Feature feature = JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS;
        assertFalse(jsonFactory.isEnabled(feature), "Feature should be disabled by default");
    }

    @Test
    public void testIsEnabledWithMultipleFeatures() {
        JsonFactory jsonFactory = new JsonFactory();
        // Use JsonGenerator.Feature
        JsonGenerator.Feature feature1 = JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS;
        // Use JsonGenerator.Feature
        JsonGenerator.Feature feature2 = JsonGenerator.Feature.ESCAPE_NON_ASCII;
        // Enable the first feature
        jsonFactory.enable(feature1);
        assertTrue(jsonFactory.isEnabled(feature1), "Feature 1 should be enabled");
        assertFalse(jsonFactory.isEnabled(feature2), "Feature 2 should be disabled by default");
        // Enable the second feature
        jsonFactory.enable(feature2);
        assertTrue(jsonFactory.isEnabled(feature2), "Feature 2 should now be enabled");
    }

    @Test
    public void testIsEnabledWithNoFeatures() {
        JsonFactory jsonFactory = new JsonFactory();
        // Use JsonGenerator.Feature
        JsonGenerator.Feature feature = JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS;
        assertFalse(jsonFactory.isEnabled(feature), "Feature should be disabled with no features enabled");
    }
}
