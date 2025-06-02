package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.util.LinkedNode;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.cfg.*;
import com.fasterxml.jackson.databind.introspect.*;
import com.fasterxml.jackson.databind.jsontype.*;
import com.fasterxml.jackson.databind.type.LogicalType;

public class DeserializationConfig_with_4_2_Test {

    private DeserializationConfig config;

    private SubtypeResolver defaultResolver;

    private SubtypeResolver newResolver;

    @BeforeEach
    public void setUp() {
        // Initialize default SubtypeResolver and DeserializationConfig
        defaultResolver = new SubtypeResolver() {

            @Override
            public void registerSubtypes(Class<?>... subtypes) {
                // Implementation for testing purposes
            }

            @Override
            public void registerSubtypes(Collection<Class<?>> subtypes) {
                // Implementation for testing purposes
            }

            @Override
            public void registerSubtypes(NamedType... namedTypes) {
                // Empty implementation for testing purposes
            }
        };
        // Mocking BaseSettings with necessary parameters
        BaseSettings baseSettings = mock(BaseSettings.class);
        config = new DeserializationConfig(baseSettings, defaultResolver, null, null, null, null, null);
        newResolver = new SubtypeResolver() {

            @Override
            public void registerSubtypes(Class<?>... subtypes) {
                // Implementation for testing purposes
            }

            @Override
            public void registerSubtypes(Collection<Class<?>> subtypes) {
                // Implementation for testing purposes
            }

            @Override
            public void registerSubtypes(NamedType... namedTypes) {
                // Empty implementation for testing purposes
            }
        };
    }

    @Test
    public void testWithSameResolver() {
        // Test that calling with() with the same resolver returns the same instance
        DeserializationConfig result = config.with(defaultResolver);
        assertSame(config, result, "Expected the same instance when the same SubtypeResolver is used.");
    }

    @Test
    public void testWithDifferentResolver() {
        // Test that calling with() with a different resolver returns a new instance
        DeserializationConfig result = config.with(newResolver);
        assertNotSame(config, result, "Expected a new instance when a different SubtypeResolver is used.");
    }
}
