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
import org.apache.commons.collections4.Predicate;

class PredicatedMap_putAll_4_0_Test {

    private PredicatedMap<String, Integer> predicatedMap;

    private Map<String, Integer> testMap;

    @BeforeEach
    void setUp() {
        // Define key and value predicates
        // Non-null and non-empty keys
        Predicate<String> keyPredicate = key -> key != null && key.length() > 0;
        // Non-null and positive values
        Predicate<Integer> valuePredicate = value -> value != null && value > 0;
        // Initialize PredicatedMap with empty test map and predicates
        predicatedMap = new PredicatedMap<>(new HashMap<>(), keyPredicate, valuePredicate);
        testMap = new HashMap<>();
    }

    @Test
    void testPutAll_ValidEntries() {
        testMap.put("key1", 1);
        testMap.put("key2", 2);
        predicatedMap.putAll(testMap);
        assertEquals(2, predicatedMap.size());
        assertTrue(predicatedMap.containsKey("key1"));
        assertTrue(predicatedMap.containsKey("key2"));
        assertEquals(1, predicatedMap.get("key1"));
        assertEquals(2, predicatedMap.get("key2"));
    }

    @Test
    void testPutAll_NullKey_ShouldThrowException() {
        // Null key
        testMap.put(null, 1);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            predicatedMap.putAll(testMap);
        });
        assertEquals("Cannot add key - Predicate rejected it", exception.getMessage());
    }

    @Test
    void testPutAll_EmptyKey_ShouldThrowException() {
        // Empty key
        testMap.put("", 1);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            predicatedMap.putAll(testMap);
        });
        assertEquals("Cannot add key - Predicate rejected it", exception.getMessage());
    }

    @Test
    void testPutAll_NullValue_ShouldThrowException() {
        // Null value
        testMap.put("key1", null);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            predicatedMap.putAll(testMap);
        });
        assertEquals("Cannot add value - Predicate rejected it", exception.getMessage());
    }

    @Test
    void testPutAll_NegativeValue_ShouldThrowException() {
        // Negative value
        testMap.put("key1", -1);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            predicatedMap.putAll(testMap);
        });
        assertEquals("Cannot add value - Predicate rejected it", exception.getMessage());
    }

    @Test
    void testPutAll_MixedEntries_ShouldThrowException() {
        testMap.put("key1", 1);
        // Invalid entry
        testMap.put(null, 2);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            predicatedMap.putAll(testMap);
        });
        assertEquals("Cannot add key - Predicate rejected it", exception.getMessage());
    }
}
