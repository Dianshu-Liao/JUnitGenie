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

public class JsonFactory_isEnabled_43_3_Test {

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
    }

    @Test
    public void testIsEnabled_WhenFeatureIsEnabled_ShouldReturnTrue() {
        // Arrange
        JsonGenerator.Feature feature = JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS;
        jsonFactory.enable(feature);
        // Act
        boolean result = jsonFactory.isEnabled(feature);
        // Assert
        assertTrue(result, "Expected feature to be enabled");
    }

    @Test
    public void testIsEnabled_WhenFeatureIsDisabled_ShouldReturnFalse() {
        // Arrange
        JsonGenerator.Feature feature = JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS;
        // Act
        boolean result = jsonFactory.isEnabled(feature);
        // Assert
        assertFalse(result, "Expected feature to be disabled");
    }

    @Test
    public void testIsEnabled_WhenFeatureIsNotSet_ShouldReturnFalse() {
        // Arrange
        JsonGenerator.Feature feature = JsonGenerator.Feature.ESCAPE_NON_ASCII;
        // Act
        boolean result = jsonFactory.isEnabled(feature);
        // Assert
        assertFalse(result, "Expected feature to be disabled when not set");
    }

    @Test
    public void testIsEnabled_WhenMultipleFeaturesSet_ShouldReturnCorrectStatus() {
        // Arrange
        JsonGenerator.Feature feature1 = JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS;
        JsonGenerator.Feature feature2 = JsonGenerator.Feature.ESCAPE_NON_ASCII;
        jsonFactory.enable(feature1);
        jsonFactory.enable(feature2);
        // Act & Assert
        assertTrue(jsonFactory.isEnabled(feature1), "Expected feature1 to be enabled");
        assertTrue(jsonFactory.isEnabled(feature2), "Expected feature2 to be enabled");
    }

    @Test
    public void testIsEnabled_WithDifferentFeatures_ShouldReturnCorrectStatus() {
        // Arrange
        JsonGenerator.Feature feature1 = JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS;
        JsonGenerator.Feature feature2 = JsonGenerator.Feature.ESCAPE_NON_ASCII;
        jsonFactory.enable(feature1);
        // Act & Assert
        assertTrue(jsonFactory.isEnabled(feature1), "Expected feature1 to be enabled");
        assertFalse(jsonFactory.isEnabled(feature2), "Expected feature2 to be disabled");
    }
}
