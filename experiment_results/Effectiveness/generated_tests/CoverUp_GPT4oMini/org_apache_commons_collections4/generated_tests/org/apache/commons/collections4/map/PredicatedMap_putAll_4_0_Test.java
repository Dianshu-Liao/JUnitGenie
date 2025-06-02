package org.apache.commons.collections4.map;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.map.PredicatedMap;
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

class PredicatedMap_putAll_4_0_Test {

    private PredicatedMap<String, Integer> predicatedMap;

    private Map<String, Integer> sourceMap;

    @BeforeEach
    void setUp() {
        // Key must be non-empty
        Predicate<String> keyPredicate = key -> key != null && key.length() > 0;
        // Value must be positive
        Predicate<Integer> valuePredicate = value -> value != null && value > 0;
        predicatedMap = new PredicatedMap<>(new HashMap<>(), keyPredicate, valuePredicate);
        sourceMap = new HashMap<>();
    }

    @Test
    void testPutAll_ValidEntries() {
        sourceMap.put("one", 1);
        sourceMap.put("two", 2);
        predicatedMap.putAll(sourceMap);
        assertEquals(2, predicatedMap.size());
    }

    @Test
    void testPutAll_EmptyMap() {
        predicatedMap.putAll(new HashMap<>());
        assertEquals(0, predicatedMap.size());
    }

    @Test
    void testPutAll_InvalidKey() {
        // Invalid key (empty)
        sourceMap.put("", 1);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            predicatedMap.putAll(sourceMap);
        });
        assertEquals("Cannot add key - Predicate rejected it", exception.getMessage());
    }

    @Test
    void testPutAll_InvalidValue() {
        // Invalid value (negative)
        sourceMap.put("three", -1);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            predicatedMap.putAll(sourceMap);
        });
        assertEquals("Cannot add value - Predicate rejected it", exception.getMessage());
    }

    @Test
    void testPutAll_MixedValidAndInvalidEntries() {
        sourceMap.put("validKey", 1);
        // Invalid key
        sourceMap.put("", 2);
        // Invalid value
        sourceMap.put("anotherKey", -1);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            predicatedMap.putAll(sourceMap);
        });
        assertEquals("Cannot add key - Predicate rejected it", exception.getMessage());
        // No valid entries added
        assertEquals(0, predicatedMap.size());
    }
}
