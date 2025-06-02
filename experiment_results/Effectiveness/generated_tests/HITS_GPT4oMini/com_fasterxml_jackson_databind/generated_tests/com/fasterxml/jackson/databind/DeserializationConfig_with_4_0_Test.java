package com.fasterxml.jackson.databind;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.LinkedNode;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.cfg.*;
import com.fasterxml.jackson.databind.introspect.*;
import com.fasterxml.jackson.databind.jsontype.*;

@ExtendWith(MockitoExtension.class)
public class DeserializationConfig_with_4_0_Test {

    private DeserializationConfig config;

    private SubtypeResolver resolver1;

    private SubtypeResolver resolver2;

    @BeforeEach
    public void setUp() {
        // Create mock SubtypeResolver instances
        resolver1 = mock(SubtypeResolver.class);
        resolver2 = mock(SubtypeResolver.class);
        config = new DeserializationConfig(null, resolver1, null, null, null, null, null);
    }

    @Test
    public void testWithSameSubtypeResolver() {
        // When the same SubtypeResolver is provided
        DeserializationConfig result = config.with(resolver1);
        assertSame(config, result, "Expected the same instance to be returned");
    }

    @Test
    public void testWithDifferentSubtypeResolver() {
        // When a different SubtypeResolver is provided
        DeserializationConfig result = config.with(resolver2);
        assertNotSame(config, result, "Expected a new instance to be returned");
    }
}
