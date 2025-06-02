package com.fasterxml.jackson.databind;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.util.LinkedNode;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.cfg.*;
import com.fasterxml.jackson.databind.introspect.*;
import com.fasterxml.jackson.databind.jsontype.*;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.RootNameLookup;

@ExtendWith(MockitoExtension.class)
public class DeserializationConfig_with_4_1_Test {

    private DeserializationConfig deserializationConfig;

    private SubtypeResolver subtypeResolver;

    @BeforeEach
    public void setUp() {
        BaseSettings baseSettings = mock(BaseSettings.class);
        subtypeResolver = mock(SubtypeResolver.class);
        deserializationConfig = new DeserializationConfig(baseSettings, subtypeResolver, null, null, null, null, null);
    }

    @Test
    public void testWithSameSubtypeResolver() {
        DeserializationConfig result = deserializationConfig.with(subtypeResolver);
        assertSame(deserializationConfig, result, "Expected the same instance to be returned");
    }

    @Test
    public void testWithDifferentSubtypeResolver() {
        // New instance
        SubtypeResolver newSubtypeResolver = mock(SubtypeResolver.class);
        DeserializationConfig result = deserializationConfig.with(newSubtypeResolver);
        assertNotSame(deserializationConfig, result, "Expected a new instance to be returned");
        // Use reflection to access private constructor
        try {
            Constructor<DeserializationConfig> constructor = DeserializationConfig.class.getDeclaredConstructor(DeserializationConfig.class, SubtypeResolver.class);
            constructor.setAccessible(true);
            DeserializationConfig newConfig = constructor.newInstance(deserializationConfig, newSubtypeResolver);
            assertNotNull(newConfig);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            fail("Reflection to create new DeserializationConfig instance failed: " + e.getMessage());
        }
    }
}
