package org.apache.commons.collections4.map;

import org.apache.commons.collections4.Predicate;
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

class PredicatedMap_checkSetValue_1_0_Test {

    private PredicatedMap<String, Integer> predicatedMap;

    private Predicate<? super Integer> valuePredicate;

    @BeforeEach
    void setUp() {
        // Mock the value predicate to allow certain values
        valuePredicate = mock(Predicate.class);
        when(valuePredicate.test(5)).thenReturn(true);
        when(valuePredicate.test(10)).thenReturn(false);
        // Create a new PredicatedMap with a dummy map and the mocked predicates
        predicatedMap = new PredicatedMap<>(new HashMap<>(), null, valuePredicate);
    }

    @Test
    void testCheckSetValue_ValidValue() {
        // Test with a valid value that should pass the predicate
        Integer value = 5;
        assertEquals(value, invokeCheckSetValue(value));
    }

    @Test
    void testCheckSetValue_InvalidValue() {
        // Test with an invalid value that should fail the predicate
        Integer value = 10;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeCheckSetValue(value);
        });
        assertEquals("Cannot set value - Predicate rejected it", exception.getMessage());
    }

    private Integer invokeCheckSetValue(Integer value) {
        try {
            // Use reflection to access the private method
            java.lang.reflect.Method method = PredicatedMap.class.getDeclaredMethod("checkSetValue", Object.class);
            method.setAccessible(true);
            return (Integer) method.invoke(predicatedMap, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
