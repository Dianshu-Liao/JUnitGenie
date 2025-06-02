package com.fasterxml.jackson.core;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class JsonFactoryBuilder_rootValueSeparator_16_0_Test {

    private JsonFactoryBuilder jsonFactoryBuilder;

    @BeforeEach
    public void setUp() {
        jsonFactoryBuilder = new JsonFactoryBuilder();
    }

    @Test
    public void testRootValueSeparator_WhenRootValueSeparatorIsNull() {
        // Arrange
        // No need to set _rootValueSeparator, it should be null by default.
        // Act
        SerializableString result = jsonFactoryBuilder.rootValueSeparator();
        // Assert
        assertNull(result, "The root value separator should be null");
    }

    @Test
    public void testRootValueSeparator_WhenRootValueSeparatorIsSet() throws Exception {
        // Arrange
        SerializableString expectedSeparator = new SerializedString(",");
        jsonFactoryBuilder.rootValueSeparator(expectedSeparator);
        // Act
        SerializableString result = jsonFactoryBuilder.rootValueSeparator();
        // Assert
        assertEquals(expectedSeparator, result, "The root value separator should match the expected value");
    }
}
