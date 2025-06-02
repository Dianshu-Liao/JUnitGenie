package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.StreamReadFeature;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.util.*;

public class JsonFactory_isEnabled_36_4_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testIsEnabledWithEnabledFeature() throws Exception {
        Method method = JsonFactory.class.getDeclaredMethod("isEnabled", StreamReadFeature.class);
        method.setAccessible(true);
        // Enable a feature by directly manipulating the _parserFeatures field
        // Ensure this feature exists
        StreamReadFeature feature = StreamReadFeature.valueOf("ALLOW_UNQUOTED_FIELD_NAMES");
        jsonFactory._parserFeatures |= feature.mappedFeature().getMask();
        boolean result = (boolean) method.invoke(jsonFactory, feature);
        assertTrue(result, "Feature should be enabled");
    }

    @Test
    public void testIsEnabledWithDisabledFeature() throws Exception {
        Method method = JsonFactory.class.getDeclaredMethod("isEnabled", StreamReadFeature.class);
        method.setAccessible(true);
        // Ensure this feature exists
        StreamReadFeature feature = StreamReadFeature.valueOf("ALLOW_UNQUOTED_FIELD_NAMES");
        boolean result = (boolean) method.invoke(jsonFactory, feature);
        assertFalse(result, "Feature should be disabled");
    }
}
