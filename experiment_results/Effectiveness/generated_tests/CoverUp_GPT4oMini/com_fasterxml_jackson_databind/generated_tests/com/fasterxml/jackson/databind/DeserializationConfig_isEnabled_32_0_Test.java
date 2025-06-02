package com.fasterxml.jackson.databind;

import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.cfg.*;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.introspect.*;
import com.fasterxml.jackson.databind.jsontype.*;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.LinkedNode;
import com.fasterxml.jackson.databind.util.RootNameLookup;

public class DeserializationConfig_isEnabled_32_0_Test {

    private DeserializationConfig deserializationConfig;

    private JsonFactory jsonFactory;

    @BeforeEach
    public void setUp() {
        // Initialize the JsonFactory
        jsonFactory = new JsonFactory();
        // Create a DeserializationConfig instance with default settings
        deserializationConfig = new DeserializationConfig(null, null, null, null, null, null, null);
    }

    @Test
    public void testIsEnabled_ReturnsTrue_WhenFeatureIsEnabled() throws Exception {
        // Arrange
        JsonParser.Feature feature = JsonParser.Feature.ALLOW_COMMENTS;
        // Use reflection to set _parserFeaturesToChange to enable the feature
        setFieldValue(deserializationConfig, "_parserFeaturesToChange", feature.getMask());
        // Use reflection to set _parserFeatures to enable the feature
        setFieldValue(deserializationConfig, "_parserFeatures", feature.getMask());
        // Act
        boolean result = deserializationConfig.isEnabled(feature, jsonFactory);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsEnabled_ReturnsFalse_WhenFeatureIsNotEnabled() throws Exception {
        // Arrange
        JsonParser.Feature feature = JsonParser.Feature.ALLOW_COMMENTS;
        // Use reflection to set _parserFeaturesToChange to enable the feature
        setFieldValue(deserializationConfig, "_parserFeaturesToChange", feature.getMask());
        // Use reflection to set _parserFeatures to disable the feature
        setFieldValue(deserializationConfig, "_parserFeatures", 0);
        // Act
        boolean result = deserializationConfig.isEnabled(feature, jsonFactory);
        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsEnabled_ReturnsFactoryEnabled_WhenFeatureIsNotInParserFeatures() throws Exception {
        // Arrange
        JsonParser.Feature feature = JsonParser.Feature.ALLOW_COMMENTS;
        // Use reflection to set _parserFeaturesToChange to 0
        setFieldValue(deserializationConfig, "_parserFeaturesToChange", 0);
        // Act
        boolean result = deserializationConfig.isEnabled(feature, jsonFactory);
        // Assert
        // Factory should return false by default
        assertFalse(result);
    }

    private void setFieldValue(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
