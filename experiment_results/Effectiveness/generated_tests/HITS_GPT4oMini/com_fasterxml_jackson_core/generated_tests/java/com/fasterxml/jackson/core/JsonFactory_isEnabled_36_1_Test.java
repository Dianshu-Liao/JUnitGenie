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

public class JsonFactory_isEnabled_36_1_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testIsEnabled_WhenFeatureIsEnabled_ShouldReturnTrue() {
        JsonFactory.Feature feature = JsonFactory.Feature.CANONICALIZE_FIELD_NAMES;
        jsonFactory.enable(feature);
        assertTrue(jsonFactory.isEnabled(feature));
    }

    @Test
    public void testIsEnabled_WhenFeatureIsDisabled_ShouldReturnFalse() {
        JsonFactory.Feature feature = JsonFactory.Feature.INTERN_FIELD_NAMES;
        assertFalse(jsonFactory.isEnabled(feature));
    }

    @Test
    public void testIsEnabled_WhenFeatureIsNotSet_ShouldReturnFalse() {
        // Using an existing feature
        JsonFactory.Feature feature = JsonFactory.Feature.CANONICALIZE_FIELD_NAMES;
        assertFalse(jsonFactory.isEnabled(feature));
    }

    @Test
    public void testIsEnabled_WhenMultipleFeaturesSet_ShouldReturnCorrectStatus() {
        JsonFactory.Feature feature1 = JsonFactory.Feature.CANONICALIZE_FIELD_NAMES;
        JsonFactory.Feature feature2 = JsonFactory.Feature.INTERN_FIELD_NAMES;
        jsonFactory.enable(feature1);
        assertTrue(jsonFactory.isEnabled(feature1));
        assertFalse(jsonFactory.isEnabled(feature2));
    }

    @Test
    public void testIsEnabled_WithDifferentFeatureMasks_ShouldReturnCorrectValues() {
        JsonFactory.Feature feature1 = JsonFactory.Feature.CANONICALIZE_FIELD_NAMES;
        // Using an existing feature
        JsonFactory.Feature feature2 = JsonFactory.Feature.INTERN_FIELD_NAMES;
        jsonFactory.enable(feature1);
        assertTrue(jsonFactory.isEnabled(feature1));
        assertFalse(jsonFactory.isEnabled(feature2));
    }
}
