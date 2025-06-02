package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.json.JsonWriteFeature;

public class JsonFactoryBuilder_rootValueSeparator_12_0_Test {

    private JsonFactoryBuilder jsonFactoryBuilder;

    @BeforeEach
    public void setUp() {
        jsonFactoryBuilder = new JsonFactoryBuilder();
    }

    @Test
    public void testRootValueSeparator() throws Exception {
        // Arrange
        SerializedString expectedSeparator = new SerializedString(";");
        // Act
        jsonFactoryBuilder.rootValueSeparator(expectedSeparator);
        // Use reflection to access the private field
        Method getRootValueSeparatorMethod = JsonFactoryBuilder.class.getDeclaredMethod("getRootValueSeparator");
        getRootValueSeparatorMethod.setAccessible(true);
        SerializedString actualSeparator = (SerializedString) getRootValueSeparatorMethod.invoke(jsonFactoryBuilder);
        // Assert
        assertEquals(expectedSeparator.getValue(), actualSeparator.getValue());
    }
}
