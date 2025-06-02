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

public class JsonFactoryBuilder_configure_9_4_Test {

    private JsonFactoryBuilder jsonFactoryBuilder;

    @BeforeEach
    public void setUp() {
        jsonFactoryBuilder = new JsonFactoryBuilder();
    }

    @Test
    public void testConfigureEnable() {
        JsonWriteFeature feature = JsonWriteFeature.WRITE_NUMBERS_AS_STRINGS;
        JsonFactoryBuilder result = jsonFactoryBuilder.configure(feature, true);
        assertNotNull(result);
    }

    @Test
    public void testConfigureDisable() {
        JsonWriteFeature feature = JsonWriteFeature.WRITE_NUMBERS_AS_STRINGS;
        JsonFactoryBuilder result = jsonFactoryBuilder.configure(feature, false);
        assertNotNull(result);
    }

    @Test
    public void testConfigureWithNullFeature() {
        JsonFactoryBuilder result = jsonFactoryBuilder.configure((JsonWriteFeature) null, true);
        assertNotNull(result);
    }

    @Test
    public void testConfigureWithFalseState() {
        JsonWriteFeature feature = JsonWriteFeature.WRITE_NUMBERS_AS_STRINGS;
        JsonFactoryBuilder result = jsonFactoryBuilder.configure(feature, false);
        assertNotNull(result);
    }

    @Test
    public void testConfigureWithTrueState() {
        JsonWriteFeature feature = JsonWriteFeature.WRITE_NUMBERS_AS_STRINGS;
        JsonFactoryBuilder result = jsonFactoryBuilder.configure(feature, true);
        assertNotNull(result);
    }
}
