package com.fasterxml.jackson.databind;

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

public class DeserializationConfig_without_20_0_Test {

    private DeserializationConfig deserializationConfig;

    private FormatFeature mockFeature;

    @BeforeEach
    public void setUp() {
        // Mock dependencies and create an instance of DeserializationConfig
        BaseSettings baseSettings = Mockito.mock(BaseSettings.class);
        SubtypeResolver subtypeResolver = Mockito.mock(SubtypeResolver.class);
        SimpleMixInResolver mixins = Mockito.mock(SimpleMixInResolver.class);
        RootNameLookup rootNames = Mockito.mock(RootNameLookup.class);
        ConfigOverrides configOverrides = Mockito.mock(ConfigOverrides.class);
        CoercionConfigs coercionConfigs = Mockito.mock(CoercionConfigs.class);
        DatatypeFeatures datatypeFeatures = Mockito.mock(DatatypeFeatures.class);
        deserializationConfig = new DeserializationConfig(baseSettings, subtypeResolver, mixins, rootNames, configOverrides, coercionConfigs, datatypeFeatures);
        // Initialize mock feature
        mockFeature = Mockito.mock(FormatFeature.class);
        // Example mask
        Mockito.when(mockFeature.getMask()).thenReturn(0b0001);
    }

    @Test
    public void testWithoutJsonReadFeature() {
        // Given a JsonReadFeature type
        FormatFeature jsonReadFeature = Mockito.mock(JsonReadFeature.class);
        Mockito.when(jsonReadFeature.getMask()).thenReturn(0b0001);
        // When invoking without method
        DeserializationConfig result = deserializationConfig.without(jsonReadFeature);
        // Verify that _withoutJsonReadFeatures was called (you would need to implement this)
        // This requires capturing the call or checking the state of the result
        // For now, we will just assert the result is not null
        assertNotNull(result);
    }

    @Test
    public void testWithoutFormatFeatureChangesState() {
        // Given a FormatFeature that changes the state
        Mockito.when(mockFeature.getMask()).thenReturn(0b0001);
        // When invoking without method
        DeserializationConfig result = deserializationConfig.without(mockFeature);
        // Verify that a new instance is returned (not the same as original)
        assertNotSame(deserializationConfig, result);
    }

    @Test
    public void testWithoutFormatFeatureNoChange() {
        // Given a FormatFeature that does not change the state
        Mockito.when(mockFeature.getMask()).thenReturn(0b0000);
        // When invoking without method
        DeserializationConfig result = deserializationConfig.without(mockFeature);
        // Verify that the same instance is returned
        assertSame(deserializationConfig, result);
    }

    @Test
    public void testWithoutFormatFeatureWithMultipleMasks() {
        // Given a FormatFeature that changes the state
        Mockito.when(mockFeature.getMask()).thenReturn(0b0010);
        // Set initial state for format read features
        // This assumes you have a way to set _formatReadFeatures, which may require reflection
        // Example initial state
        setFormatReadFeatures(deserializationConfig, 0b0110);
        // When invoking without method
        DeserializationConfig result = deserializationConfig.without(mockFeature);
        // Verify that a new instance is returned (not the same as original)
        assertNotSame(deserializationConfig, result);
        // Verify the new format read features state
        // Again, this would require reflection to access private fields
        int newFormatReadFeatures = getFormatReadFeatures(result);
        // Expecting the mask to be removed
        assertEquals(0b0100, newFormatReadFeatures);
    }

    private void setFormatReadFeatures(DeserializationConfig config, int features) {
        try {
            java.lang.reflect.Field field = DeserializationConfig.class.getDeclaredField("_formatReadFeatures");
            field.setAccessible(true);
            field.setInt(config, features);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getFormatReadFeatures(DeserializationConfig config) {
        try {
            java.lang.reflect.Field field = DeserializationConfig.class.getDeclaredField("_formatReadFeatures");
            field.setAccessible(true);
            return field.getInt(config);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
