package org.apache.commons.collections4.map;

import org.apache.commons.collections4.functors.ConstantTransformer;
import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.FactoryTransformer;

public class DefaultedMap_get_3_0_Test {

    private DefaultedMap<String, String> defaultedMap;

    private static final String DEFAULT_VALUE = "default";

    @BeforeEach
    public void setUp() {
        // Create a new DefaultedMap with a ConstantTransformer for default values
        defaultedMap = new DefaultedMap<>(ConstantTransformer.constantTransformer(DEFAULT_VALUE));
    }

    @Test
    public void testGetReturnsValueForExistingKey() {
        // Arrange
        defaultedMap.put("key1", "value1");
        // Act
        String result = defaultedMap.get("key1");
        // Assert
        assertEquals("value1", result);
    }

    @Test
    public void testGetReturnsDefaultForNonExistingKey() {
        // Act
        String result = defaultedMap.get("nonExistingKey");
        // Assert
        assertEquals(DEFAULT_VALUE, result);
    }

    @Test
    public void testGetReturnsNullForNullKeyAndDefaultIsNull() {
        // Arrange
        defaultedMap = new DefaultedMap<>(ConstantTransformer.constantTransformer(null));
        // Act
        String result = defaultedMap.get(null);
        // Assert
        assertNull(result);
    }

    @Test
    public void testGetReturnsDefaultForKeyThatIsPresentButValueIsNull() {
        // Arrange
        defaultedMap.put("key2", null);
        // Act
        String result = defaultedMap.get("key2");
        // Assert
        assertNull(result);
    }

    @Test
    public void testGetReturnsDefaultForKeyThatIsPresentButValueIsDefault() {
        // Arrange
        defaultedMap.put("key3", DEFAULT_VALUE);
        // Act
        String result = defaultedMap.get("key3");
        // Assert
        assertEquals(DEFAULT_VALUE, result);
    }
}
