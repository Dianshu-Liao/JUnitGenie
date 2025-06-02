package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
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

public class JsonFactory_isEnabled_42_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testIsEnabledWithFeatureEnabled() throws Exception {
        // Enable a feature
        Method setGeneratorFeaturesMethod = JsonFactory.class.getDeclaredMethod("setGeneratorFeatures", int.class);
        setGeneratorFeaturesMethod.setAccessible(true);
        setGeneratorFeaturesMethod.invoke(jsonFactory, JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT.getMask());
        // Test if the feature is enabled
        assertTrue(invokeIsEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT));
    }

    @Test
    public void testIsEnabledWithFeatureDisabled() throws Exception {
        // Ensure the feature is not enabled
        assertFalse(invokeIsEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT));
    }

    @Test
    public void testIsEnabledWithAnotherFeatureEnabled() throws Exception {
        // Enable another feature
        Method setGeneratorFeaturesMethod = JsonFactory.class.getDeclaredMethod("setGeneratorFeatures", int.class);
        setGeneratorFeaturesMethod.setAccessible(true);
        setGeneratorFeaturesMethod.invoke(jsonFactory, JsonGenerator.Feature.QUOTE_FIELD_NAMES.getMask());
        // Test if the feature is enabled
        assertTrue(invokeIsEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES));
    }

    private boolean invokeIsEnabled(JsonGenerator.Feature feature) throws Exception {
        Method isEnabledMethod = JsonFactory.class.getDeclaredMethod("isEnabled", JsonGenerator.Feature.class);
        isEnabledMethod.setAccessible(true);
        return (boolean) isEnabledMethod.invoke(jsonFactory, feature);
    }
}
