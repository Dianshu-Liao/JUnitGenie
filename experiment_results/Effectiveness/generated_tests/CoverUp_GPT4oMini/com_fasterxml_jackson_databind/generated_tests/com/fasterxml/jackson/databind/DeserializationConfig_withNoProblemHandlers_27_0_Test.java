package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.util.LinkedNode;
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
import com.fasterxml.jackson.databind.introspect.*;
import com.fasterxml.jackson.databind.jsontype.*;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.RootNameLookup;

class DeserializationConfig_withNoProblemHandlers_27_0_Test {

    private DeserializationConfig configWithHandlers;

    private DeserializationConfig configWithoutHandlers;

    @BeforeEach
    void setUp() {
        BaseSettings baseSettings = Mockito.mock(BaseSettings.class);
        JsonNodeFactory nodeFactory = new JsonNodeFactory(false);
        LinkedNode<DeserializationProblemHandler> problemHandlers = new LinkedNode<>(new DeserializationProblemHandler() {
        }, null);
        // Create a config with problem handlers
        configWithHandlers = new DeserializationConfig(baseSettings, null, null, null, null, null, null);
        // Create a config without problem handlers
        configWithoutHandlers = new DeserializationConfig(baseSettings, null, null, null, null, null, null);
    }

    @Test
    void testWithNoProblemHandlers_withHandlers() {
        DeserializationConfig result = configWithHandlers.withNoProblemHandlers();
        // Assert that a new instance is created
        assertNotSame(configWithHandlers, result);
        // Assert that the new instance has no problem handlers
        assertSame(null, result.getProblemHandlers());
    }

    @Test
    void testWithNoProblemHandlers_withoutHandlers() {
        DeserializationConfig result = configWithoutHandlers.withNoProblemHandlers();
        // Assert that the same instance is returned
        assertSame(configWithoutHandlers, result);
    }
}
