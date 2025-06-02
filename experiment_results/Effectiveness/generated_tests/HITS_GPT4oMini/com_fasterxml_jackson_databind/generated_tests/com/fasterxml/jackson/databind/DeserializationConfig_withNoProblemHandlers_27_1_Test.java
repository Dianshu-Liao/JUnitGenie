package com.fasterxml.jackson.databind;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

public class DeserializationConfig_withNoProblemHandlers_27_1_Test {

    private DeserializationConfig configWithHandlers;

    private DeserializationConfig configWithoutHandlers;

    @BeforeEach
    public void setUp() {
        // Create mock objects for required parameters
        BaseSettings baseSettings = mock(BaseSettings.class);
        SubtypeResolver subtypeResolver = mock(SubtypeResolver.class);
        SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
        RootNameLookup rootNames = mock(RootNameLookup.class);
        ConfigOverrides configOverrides = mock(ConfigOverrides.class);
        CoercionConfigs coercionConfigs = mock(CoercionConfigs.class);
        DatatypeFeatures datatypeFeatures = mock(DatatypeFeatures.class);
        // Initializing a DeserializationConfig instance with problem handlers
        configWithHandlers = new DeserializationConfig(baseSettings, subtypeResolver, mixins, rootNames, configOverrides, coercionConfigs, datatypeFeatures);
        // Simulating no problem handlers
        configWithoutHandlers = configWithHandlers.withNoProblemHandlers();
    }

    @Test
    public void testWithNoProblemHandlers_WhenProblemHandlersNotNull_ReturnsNewInstance() {
        DeserializationConfig result = configWithHandlers.withNoProblemHandlers();
        assertNotNull(result);
        // Ensure it's a new instance
        assertNotSame(configWithHandlers, result);
    }

    @Test
    public void testWithNoProblemHandlers_WhenProblemHandlersNull_ReturnsSameInstance() {
        DeserializationConfig result = configWithoutHandlers.withNoProblemHandlers();
        assertNotNull(result);
        // Ensure it's the same instance
        assertSame(configWithoutHandlers, result);
    }
}
