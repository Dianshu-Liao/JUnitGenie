package com.fasterxml.jackson.core;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.core.format.InputAccessor;
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

public class JsonFactory_isEnabled_43_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testIsEnabledFeatureEnabled() throws Exception {
        // Assuming StreamWriteFeature has a feature that corresponds to a mask
        // Here we are using reflection to set _generatorFeatures for testing
        // Assuming 1 is the mask for a feature
        setPrivateField(jsonFactory, "_generatorFeatures", 1);
        // Assuming the first feature corresponds to the mask 1
        StreamWriteFeature feature = StreamWriteFeature.values()[0];
        boolean result = jsonFactory.isEnabled(feature);
        assertTrue(result, "Feature should be enabled");
    }

    @Test
    public void testIsEnabledFeatureDisabled() throws Exception {
        // Assuming 2 is not set in _generatorFeatures
        // No features enabled
        setPrivateField(jsonFactory, "_generatorFeatures", 0);
        // Assuming the first feature corresponds to the mask 1
        StreamWriteFeature feature = StreamWriteFeature.values()[0];
        boolean result = jsonFactory.isEnabled(feature);
        assertFalse(result, "Feature should be disabled");
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        // Fixed buggy line: Changed 'var' to 'Field' for proper type declaration
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
