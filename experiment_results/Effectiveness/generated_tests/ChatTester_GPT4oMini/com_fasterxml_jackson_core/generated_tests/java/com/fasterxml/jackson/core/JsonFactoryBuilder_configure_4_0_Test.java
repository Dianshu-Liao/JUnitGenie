package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.json.JsonReadFeature;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.json.JsonWriteFeature;

public class JsonFactoryBuilder_configure_4_0_Test {

    private JsonFactoryBuilder jsonFactoryBuilder;

    @BeforeEach
    public void setUp() {
        jsonFactoryBuilder = new JsonFactoryBuilder();
    }

    @Test
    public void testConfigureEnable() {
        // Arrange
        JsonReadFeature feature = mock(JsonReadFeature.class);
        boolean state = true;
        // Act
        JsonFactoryBuilder result = jsonFactoryBuilder.configure(feature, state);
        // Assert
        assertSame(result, jsonFactoryBuilder.enable(feature));
    }

    @Test
    public void testConfigureDisable() {
        // Arrange
        JsonReadFeature feature = mock(JsonReadFeature.class);
        boolean state = false;
        // Act
        JsonFactoryBuilder result = jsonFactoryBuilder.configure(feature, state);
        // Assert
        assertSame(result, jsonFactoryBuilder.disable(feature));
    }
}
