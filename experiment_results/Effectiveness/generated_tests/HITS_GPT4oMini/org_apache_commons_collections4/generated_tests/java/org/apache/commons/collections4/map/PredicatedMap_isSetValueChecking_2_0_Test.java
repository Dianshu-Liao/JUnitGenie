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

public class PredicatedMap_isSetValueChecking_2_0_Test {

    private PredicatedMap<String, Integer> predicatedMapWithValuePredicate;

    private PredicatedMap<String, Integer> predicatedMapWithoutValuePredicate;

    @BeforeEach
    public void setUp() {
        // Create a predicate for values
        Predicate<Integer> valuePredicate = value -> value > 0;
        // Create a predicate map with a value predicate
        predicatedMapWithValuePredicate = new PredicatedMap<>(new HashMap<>(), key -> true, valuePredicate);
        // Create a predicate map without a value predicate
        predicatedMapWithoutValuePredicate = new PredicatedMap<>(new HashMap<>(), key -> true, null);
    }

    @Test
    public void testIsSetValueChecking_WithValuePredicate() {
        // Test that isSetValueChecking returns true when valuePredicate is not null
        assertTrue(predicatedMapWithValuePredicate.isSetValueChecking(), "Expected isSetValueChecking to return true when valuePredicate is set.");
    }

    @Test
    public void testIsSetValueChecking_WithoutValuePredicate() {
        // Test that isSetValueChecking returns false when valuePredicate is null
        assertFalse(predicatedMapWithoutValuePredicate.isSetValueChecking(), "Expected isSetValueChecking to return false when valuePredicate is null.");
    }
}
