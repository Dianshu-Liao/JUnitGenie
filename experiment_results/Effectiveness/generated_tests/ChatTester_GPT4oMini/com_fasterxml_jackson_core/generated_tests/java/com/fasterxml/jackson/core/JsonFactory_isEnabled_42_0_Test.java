package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonGenerator;
import java.lang.reflect.Field;
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

public class JsonFactory_isEnabled_42_0_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testIsEnabled_WhenFeatureIsEnabled_ReturnsTrue() throws Exception {
        // Set the _generatorFeatures to enable a specific feature
        setPrivateField(jsonFactory, "_generatorFeatures", JsonGenerator.Feature.QUOTE_FIELD_NAMES.getMask());
        boolean result = jsonFactory.isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES);
        assertTrue(result);
    }

    @Test
    public void testIsEnabled_WhenFeatureIsDisabled_ReturnsFalse() throws Exception {
        // Set the _generatorFeatures to 0 (no features enabled)
        setPrivateField(jsonFactory, "_generatorFeatures", 0);
        boolean result = jsonFactory.isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES);
        assertFalse(result);
    }

    private void setPrivateField(Object obj, String fieldName, int value) throws Exception {
        // Fixed the buggy line
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.setInt(obj, value);
    }
}
