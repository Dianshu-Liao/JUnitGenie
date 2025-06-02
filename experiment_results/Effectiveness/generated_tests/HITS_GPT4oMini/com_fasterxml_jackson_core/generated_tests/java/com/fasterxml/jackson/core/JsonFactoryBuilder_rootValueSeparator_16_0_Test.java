package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.SerializedString;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.json.JsonWriteFeature;

public class JsonFactoryBuilder_rootValueSeparator_16_0_Test {

    private JsonFactoryBuilder jsonFactoryBuilder;

    @BeforeEach
    public void setUp() {
        jsonFactoryBuilder = new JsonFactoryBuilder();
    }

    @Test
    public void testRootValueSeparator_WhenNotSet_ShouldReturnNull() {
        // Arrange
        // No root value separator set
        // Act
        SerializableString result = jsonFactoryBuilder.rootValueSeparator();
        // Assert
        assertNull(result, "Expected root value separator to be null when not set.");
    }

    @Test
    public void testRootValueSeparator_WhenSet_ShouldReturnCorrectValue() {
        // Arrange
        SerializableString expectedSeparator = new SerializedString(", ");
        jsonFactoryBuilder._rootValueSeparator = expectedSeparator;
        // Act
        SerializableString result = jsonFactoryBuilder.rootValueSeparator();
        // Assert
        assertEquals(expectedSeparator, result, "Expected root value separator to match the set value.");
    }
}
