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

public class JsonFactory_isEnabled_35_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testIsEnabledFeatureEnabled() {
        // Assuming JsonParser.Feature has a feature that can be enabled
        // Example feature
        JsonParser.Feature feature = JsonParser.Feature.ALLOW_COMMENTS;
        // Hypothetical method to enable the feature
        jsonFactory.enable(feature);
        assertTrue(jsonFactory.isEnabled(feature), "Feature should be enabled");
    }

    @Test
    public void testIsEnabledFeatureDisabled() {
        // Example feature
        JsonParser.Feature feature = JsonParser.Feature.ALLOW_COMMENTS;
        assertFalse(jsonFactory.isEnabled(feature), "Feature should be disabled by default");
    }

    @Test
    public void testIsEnabledMultipleFeatures() {
        // Example feature
        JsonParser.Feature feature1 = JsonParser.Feature.ALLOW_COMMENTS;
        // Example feature
        JsonParser.Feature feature2 = JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES;
        // Hypothetical method to enable feature1
        jsonFactory.enable(feature1);
        assertTrue(jsonFactory.isEnabled(feature1), "Feature1 should be enabled");
        assertFalse(jsonFactory.isEnabled(feature2), "Feature2 should be disabled by default");
    }

    @Test
    public void testIsEnabledAfterDisabling() {
        // Example feature
        JsonParser.Feature feature = JsonParser.Feature.ALLOW_COMMENTS;
        // Hypothetical method to enable the feature
        jsonFactory.enable(feature);
        assertTrue(jsonFactory.isEnabled(feature), "Feature should be enabled");
        // Hypothetical method to disable the feature
        jsonFactory.disable(feature);
        assertFalse(jsonFactory.isEnabled(feature), "Feature should be disabled after disabling");
    }
}
