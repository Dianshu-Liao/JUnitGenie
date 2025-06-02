package org.apache.commons.collections4.map;

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
import org.apache.commons.collections4.functors.ConstantTransformer;
import org.apache.commons.collections4.functors.FactoryTransformer;

class DefaultedMap_get_3_0_Test {

    private DefaultedMap<String, String> defaultedMap;

    @Mock
    private Transformer<String, String> transformer;

    private Map<String, String> map;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        map = new HashMap<>();
        defaultedMap = new DefaultedMap<>(transformer);
    }

    @Test
    void testGetReturnsValueFromMap() {
        String key = "key1";
        String expectedValue = "value1";
        map.put(key, expectedValue);
        // Use reflection to set the map field
        setMapField(defaultedMap, map);
        String result = defaultedMap.get(key);
        assertEquals(expectedValue, result);
    }

    @Test
    void testGetReturnsDefaultValueFromTransformer() {
        String key = "key2";
        String defaultValue = "defaultValue";
        when(transformer.apply(key)).thenReturn(defaultValue);
        // Use reflection to set the map field
        setMapField(defaultedMap, map);
        String result = defaultedMap.get(key);
        assertEquals(defaultValue, result);
        verify(transformer).apply(key);
    }

    @Test
    void testGetReturnsNullWhenKeyNotFoundAndTransformerReturnsNull() {
        String key = "key3";
        when(transformer.apply(key)).thenReturn(null);
        // Use reflection to set the map field
        setMapField(defaultedMap, map);
        String result = defaultedMap.get(key);
        assertNull(result);
        verify(transformer).apply(key);
    }

    @Test
    void testGetReturnsValueWhenKeyIsNull() {
        String key = null;
        String defaultValue = "defaultForNullKey";
        when(transformer.apply(key)).thenReturn(defaultValue);
        // Use reflection to set the map field
        setMapField(defaultedMap, map);
        String result = defaultedMap.get(key);
        assertEquals(defaultValue, result);
        verify(transformer).apply(key);
    }

    private void setMapField(DefaultedMap<String, String> defaultedMap, Map<String, String> map) {
        try {
            java.lang.reflect.Field field = DefaultedMap.class.getDeclaredField("map");
            field.setAccessible(true);
            field.set(defaultedMap, map);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set the map field: " + e.getMessage());
        }
    }
}
