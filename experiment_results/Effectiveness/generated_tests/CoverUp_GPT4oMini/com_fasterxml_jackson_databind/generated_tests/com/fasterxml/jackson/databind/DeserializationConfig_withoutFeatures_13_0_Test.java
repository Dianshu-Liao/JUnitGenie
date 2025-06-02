package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.lang.reflect.InvocationTargetException;
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

class DeserializationConfig_withoutFeatures_13_0_Test {

    private DeserializationConfig createConfigWithFeatures(int features) {
        try {
            Field field = DeserializationConfig.class.getDeclaredField("_deserFeatures");
            field.setAccessible(true);
            return (DeserializationConfig) DeserializationConfig.class.getConstructor(DeserializationConfig.class, long.class, int.class, int.class, int.class, int.class, int.class).newInstance(new DeserializationConfig(null, null, null, null, null, null, null), 0L, features, 0, 0, 0, 0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testWithoutFeaturesRemovesFeatures() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Given
        DeserializationConfig config = createConfigWithFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES.getMask());
        // When
        DeserializationConfig newConfig = config.withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // Then
        assertNotSame(config, newConfig);
        assertEquals(0, newConfig.getDeserializationFeatures());
    }

    @Test
    void testWithoutFeaturesNoChange() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Given
        DeserializationConfig config = createConfigWithFeatures(0);
        // When
        DeserializationConfig newConfig = config.withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // Then
        assertSame(config, newConfig);
    }

    @Test
    void testWithoutMultipleFeatures() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Given
        int initialFeatures = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES.getMask() | DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT.getMask();
        DeserializationConfig config = createConfigWithFeatures(initialFeatures);
        // When
        DeserializationConfig newConfig = config.withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        // Then
        assertNotSame(config, newConfig);
        assertEquals(0, newConfig.getDeserializationFeatures());
    }

    @Test
    void testWithoutFeaturesRetainsOtherFeatures() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Given
        int initialFeatures = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES.getMask() | DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT.getMask();
        DeserializationConfig config = createConfigWithFeatures(initialFeatures);
        // When
        DeserializationConfig newConfig = config.withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // Then
        assertNotSame(config, newConfig);
        assertEquals(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT.getMask(), newConfig.getDeserializationFeatures());
    }
}
