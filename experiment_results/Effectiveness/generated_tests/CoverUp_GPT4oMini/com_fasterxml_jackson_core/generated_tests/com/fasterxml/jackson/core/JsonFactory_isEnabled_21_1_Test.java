package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.StreamWriteConstraints;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
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
import com.fasterxml.jackson.core.util.*;

public class JsonFactory_isEnabled_21_1_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testIsEnabledFeatureEnabled() throws Exception {
        // Set a feature as enabled
        invokeSetFactoryFeature(jsonFactory, JsonFactory.Feature.CANONICALIZE_FIELD_NAMES, true);
        // Now check if it's enabled
        assertTrue(jsonFactory.isEnabled(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES));
    }

    @Test
    public void testIsEnabledFeatureDisabled() throws Exception {
        // Ensure the feature is disabled by default
        assertFalse(jsonFactory.isEnabled(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES));
    }

    @Test
    public void testIsEnabledDifferentFeature() throws Exception {
        // Set another feature as enabled
        invokeSetFactoryFeature(jsonFactory, JsonFactory.Feature.INTERN_FIELD_NAMES, true);
        // Now check if it's enabled
        assertTrue(jsonFactory.isEnabled(JsonFactory.Feature.INTERN_FIELD_NAMES));
        assertFalse(jsonFactory.isEnabled(JsonFactory.Feature.CANONICALIZE_FIELD_NAMES));
    }

    private void invokeSetFactoryFeature(JsonFactory jsonFactory, JsonFactory.Feature feature, boolean state) throws Exception {
        Method method = JsonFactory.class.getDeclaredMethod("setFeature", JsonFactory.Feature.class, boolean.class);
        method.setAccessible(true);
        method.invoke(jsonFactory, feature, state);
    }
}
