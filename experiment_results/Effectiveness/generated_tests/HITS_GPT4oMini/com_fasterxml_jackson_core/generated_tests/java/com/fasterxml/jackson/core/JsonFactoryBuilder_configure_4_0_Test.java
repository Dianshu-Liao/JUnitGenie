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
        // Given
        JsonReadFeature feature = JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS;
        // When
        JsonFactoryBuilder result = jsonFactoryBuilder.configure(feature, true);
        // Then
        assertNotNull(result);
        // Further assertions to check if the feature is enabled can be added here
    }

    @Test
    public void testConfigureDisable() {
        // Given
        JsonReadFeature feature = JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS;
        // When
        JsonFactoryBuilder result = jsonFactoryBuilder.configure(feature, false);
        // Then
        assertNotNull(result);
        // Further assertions to check if the feature is disabled can be added here
    }

    @Test
    public void testConfigureMultipleFeatures() {
        // Given
        JsonReadFeature feature1 = JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS;
        // Use a valid feature
        JsonReadFeature feature2 = JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER;
        // When
        JsonFactoryBuilder result1 = jsonFactoryBuilder.configure(feature1, true);
        JsonFactoryBuilder result2 = jsonFactoryBuilder.configure(feature2, true);
        // Then
        assertNotNull(result1);
        assertNotNull(result2);
        // Further assertions to verify the state of both features can be added here
    }

    @Test
    public void testConfigureWithNullFeature() {
        // Given
        JsonReadFeature feature = null;
        // When
        JsonFactoryBuilder result = jsonFactoryBuilder.configure(feature, true);
        // Then
        assertNotNull(result);
        // Check that the result is still valid even with a null feature
    }

    @Test
    public void testConfigureWithInvalidFeature() {
        // Given
        // Assuming this feature does not exist
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            jsonFactoryBuilder.configure(JsonReadFeature.valueOf("INVALID_FEATURE"), true);
        });
        // Then
        String expectedMessage = "Feature not recognized";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
