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

public class JsonFactory_isEnabled_42_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testIsEnabled_WithFeatureEnabled() {
        // Enable a feature
        jsonFactory._generatorFeatures |= JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT.getMask();
        // Verify that the feature is enabled
        assertTrue(jsonFactory.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT));
    }

    @Test
    public void testIsEnabled_WithFeatureDisabled() {
        // Ensure the feature is disabled
        jsonFactory._generatorFeatures &= ~JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT.getMask();
        // Verify that the feature is disabled
        assertFalse(jsonFactory.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT));
    }

    @Test
    public void testIsEnabled_WithMultipleFeatures() {
        // Enable multiple features
        jsonFactory._generatorFeatures |= (JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT.getMask() | JsonGenerator.Feature.QUOTE_FIELD_NAMES.getMask());
        // Verify that both features are enabled
        assertTrue(jsonFactory.isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT));
        assertTrue(jsonFactory.isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES));
    }

    @Test
    public void testIsEnabled_WithFeatureNotSet() {
        // Check a feature that is not set
        assertFalse(jsonFactory.isEnabled(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS));
    }
}
