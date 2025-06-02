package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
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

class JsonFactory_isEnabled_35_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    void testIsEnabledWithEnabledFeature() throws Exception {
        // Enable a feature by directly manipulating the _parserFeatures field
        Method setParserFeaturesMethod = JsonFactory.class.getDeclaredMethod("setParserFeatures", int.class);
        setParserFeaturesMethod.setAccessible(true);
        setParserFeaturesMethod.invoke(jsonFactory, JsonParser.Feature.ALLOW_COMMENTS.getMask());
        // Test if the feature is enabled
        Method isEnabledMethod = JsonFactory.class.getDeclaredMethod("isEnabled", JsonParser.Feature.class);
        isEnabledMethod.setAccessible(true);
        boolean result = (boolean) isEnabledMethod.invoke(jsonFactory, JsonParser.Feature.ALLOW_COMMENTS);
        assertTrue(result);
    }

    @Test
    void testIsEnabledWithDisabledFeature() throws Exception {
        // Test if a feature that is not enabled returns false
        Method isEnabledMethod = JsonFactory.class.getDeclaredMethod("isEnabled", JsonParser.Feature.class);
        isEnabledMethod.setAccessible(true);
        boolean result = (boolean) isEnabledMethod.invoke(jsonFactory, JsonParser.Feature.ALLOW_COMMENTS);
        assertFalse(result);
    }

    @Test
    void testIsEnabledWithMultipleFeatures() throws Exception {
        // Enable multiple features
        Method setParserFeaturesMethod = JsonFactory.class.getDeclaredMethod("setParserFeatures", int.class);
        setParserFeaturesMethod.setAccessible(true);
        int features = JsonParser.Feature.ALLOW_COMMENTS.getMask() | JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES.getMask();
        setParserFeaturesMethod.invoke(jsonFactory, features);
        // Test if both features are enabled
        Method isEnabledMethod = JsonFactory.class.getDeclaredMethod("isEnabled", JsonParser.Feature.class);
        isEnabledMethod.setAccessible(true);
        boolean result1 = (boolean) isEnabledMethod.invoke(jsonFactory, JsonParser.Feature.ALLOW_COMMENTS);
        boolean result2 = (boolean) isEnabledMethod.invoke(jsonFactory, JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
        assertTrue(result1);
        assertTrue(result2);
    }
}
