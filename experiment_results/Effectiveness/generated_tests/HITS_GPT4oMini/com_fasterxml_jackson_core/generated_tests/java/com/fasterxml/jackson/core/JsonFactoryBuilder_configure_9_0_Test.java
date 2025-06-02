package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.json.JsonWriteFeature;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.json.JsonReadFeature;

public class JsonFactoryBuilder_configure_9_0_Test {

    private JsonFactoryBuilder jsonFactoryBuilder;

    @BeforeEach
    public void setUp() {
        jsonFactoryBuilder = new JsonFactoryBuilder();
    }

    @Test
    public void testConfigureEnableFeature() {
        JsonWriteFeature feature = JsonWriteFeature.WRITE_NUMBERS_AS_STRINGS;
        JsonFactoryBuilder result = jsonFactoryBuilder.configure(feature, true);
        assertNotNull(result);
        JsonFactory factory = new JsonFactory(result);
        assertTrue(factory.getGeneratorFeatures() > 0);
    }

    @Test
    public void testConfigureDisableFeature() {
        JsonWriteFeature feature = JsonWriteFeature.WRITE_NUMBERS_AS_STRINGS;
        jsonFactoryBuilder.configure(feature, true);
        JsonFactoryBuilder result = jsonFactoryBuilder.configure(feature, false);
        assertNotNull(result);
        JsonFactory factory = new JsonFactory(result);
        assertEquals(0, factory.getGeneratorFeatures());
    }

    @Test
    public void testConfigureNullFeature() {
        JsonFactory factoryBefore = new JsonFactory(jsonFactoryBuilder);
        JsonWriteFeature feature = null;
        JsonFactoryBuilder result = jsonFactoryBuilder.configure(feature, true);
        assertNotNull(result);
        JsonFactory factoryAfter = new JsonFactory(result);
        // Check if the generator features remain unchanged
        assertEquals(factoryBefore.getGeneratorFeatures(), factoryAfter.getGeneratorFeatures());
    }

    @Test
    public void testConfigureWithDifferentStates() {
        JsonWriteFeature feature = JsonWriteFeature.WRITE_NUMBERS_AS_STRINGS;
        JsonFactoryBuilder enabledResult = jsonFactoryBuilder.configure(feature, true);
        assertNotNull(enabledResult);
        JsonFactory factoryEnabled = new JsonFactory(enabledResult);
        assertTrue(factoryEnabled.getGeneratorFeatures() > 0);
        JsonFactoryBuilder disabledResult = jsonFactoryBuilder.configure(feature, false);
        assertNotNull(disabledResult);
        JsonFactory factoryDisabled = new JsonFactory(disabledResult);
        assertEquals(0, factoryDisabled.getGeneratorFeatures());
    }
}
