package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonParser;
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
    public void testIsEnabled_FeatureEnabled() {
        // Assuming that DEFAULT_PARSER_FEATURE_FLAGS has certain features enabled
        // Create a mock feature that is expected to be enabled
        // Example feature
        JsonParser.Feature feature = JsonParser.Feature.ALLOW_COMMENTS;
        // Use reflection to set the _parserFeatures to include this feature's mask
        setParserFeatures(feature.getMask());
        assertTrue(jsonFactory.isEnabled(feature));
    }

    @Test
    public void testIsEnabled_FeatureDisabled() {
        // Create a mock feature that is expected to be disabled
        // Example feature
        JsonParser.Feature feature = JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES;
        // Use reflection to ensure this feature's mask is not included
        setParserFeatures(0);
        assertFalse(jsonFactory.isEnabled(feature));
    }

    private void setParserFeatures(int features) {
        try {
            java.lang.reflect.Field field = JsonFactory.class.getDeclaredField("_parserFeatures");
            field.setAccessible(true);
            field.setInt(jsonFactory, features);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set _parserFeatures: " + e.getMessage());
        }
    }
}
