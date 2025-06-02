package com.fasterxml.jackson.databind;

import java.lang.reflect.Method;
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

// Mocked DeserializationFeature for testing purposes
enum DeserializationFeature {

    // Add more features as needed
    FEATURE_ONE(1),
    // Add more features as needed
    FEATURE_TWO(2);

    private final int mask;

    DeserializationFeature(int mask) {
        this.mask = mask;
    }

    public int getMask() {
        return mask;
    }
}

public class DeserializationConfig_isEnabled_31_2_Test {

    private DeserializationConfig deserializationConfig;

    @BeforeEach
    public void setUp() {
        // Initialize with default parameters
        deserializationConfig = new DeserializationConfig(null, null, null, null, null, null, null);
    }

    @Test
    public void testIsEnabledFeatureEnabled() throws Exception {
        // Set the deserialization features to enable FEATURE_ONE
        setDeserializationFeatures(DeserializationFeature.FEATURE_ONE.getMask());
        // Invoke the isEnabled method for FEATURE_ONE
        Method isEnabledMethod = DeserializationConfig.class.getDeclaredMethod("isEnabled", DeserializationFeature.class);
        isEnabledMethod.setAccessible(true);
        boolean result = (boolean) isEnabledMethod.invoke(deserializationConfig, DeserializationFeature.FEATURE_ONE);
        assertTrue(result, "Feature FEATURE_ONE should be enabled.");
    }

    @Test
    public void testIsEnabledFeatureDisabled() throws Exception {
        // Set the deserialization features to disable all features
        setDeserializationFeatures(0);
        // Invoke the isEnabled method for FEATURE_ONE
        Method isEnabledMethod = DeserializationConfig.class.getDeclaredMethod("isEnabled", DeserializationFeature.class);
        isEnabledMethod.setAccessible(true);
        boolean result = (boolean) isEnabledMethod.invoke(deserializationConfig, DeserializationFeature.FEATURE_ONE);
        assertFalse(result, "Feature FEATURE_ONE should be disabled.");
    }

    @Test
    public void testIsEnabledMultipleFeatures() throws Exception {
        // Enable both FEATURE_ONE and FEATURE_TWO
        setDeserializationFeatures(DeserializationFeature.FEATURE_ONE.getMask() | DeserializationFeature.FEATURE_TWO.getMask());
        // Check if both features are enabled
        Method isEnabledMethod = DeserializationConfig.class.getDeclaredMethod("isEnabled", DeserializationFeature.class);
        isEnabledMethod.setAccessible(true);
        boolean resultFeatureOne = (boolean) isEnabledMethod.invoke(deserializationConfig, DeserializationFeature.FEATURE_ONE);
        boolean resultFeatureTwo = (boolean) isEnabledMethod.invoke(deserializationConfig, DeserializationFeature.FEATURE_TWO);
        assertTrue(resultFeatureOne, "Feature FEATURE_ONE should be enabled.");
        assertTrue(resultFeatureTwo, "Feature FEATURE_TWO should be enabled.");
    }

    private void setDeserializationFeatures(int features) throws Exception {
        // Use reflection to set the _deserFeatures field
        Field field = DeserializationConfig.class.getDeclaredField("_deserFeatures");
        field.setAccessible(true);
        field.setInt(deserializationConfig, features);
    }
}
