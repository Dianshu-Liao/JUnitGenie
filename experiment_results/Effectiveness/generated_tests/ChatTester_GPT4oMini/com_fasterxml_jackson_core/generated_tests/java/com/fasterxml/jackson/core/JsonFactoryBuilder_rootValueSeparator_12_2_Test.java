package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.SerializableString;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.json.JsonWriteFeature;

public class JsonFactoryBuilder_rootValueSeparator_12_2_Test {

    private JsonFactoryBuilder jsonFactoryBuilder;

    @BeforeEach
    public void setUp() {
        jsonFactoryBuilder = new JsonFactoryBuilder();
    }

    @Test
    public void testRootValueSeparator() {
        // Arrange
        SerializableString mockSerializableString = Mockito.mock(SerializableString.class);
        // Act
        JsonFactoryBuilder result = jsonFactoryBuilder.rootValueSeparator(mockSerializableString);
        // Assert
        assertNotNull(result);
        assertSame(result, jsonFactoryBuilder);
        // Use reflection to access the private field _rootValueSeparator
        try {
            java.lang.reflect.Field field = JsonFactoryBuilder.class.getDeclaredField("_rootValueSeparator");
            field.setAccessible(true);
            SerializableString actualValue = (SerializableString) field.get(jsonFactoryBuilder);
            assertSame(mockSerializableString, actualValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }
}
