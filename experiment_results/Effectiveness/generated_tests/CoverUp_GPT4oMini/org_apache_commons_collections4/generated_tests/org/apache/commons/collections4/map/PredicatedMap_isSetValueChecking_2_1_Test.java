package org.apache.commons.collections4.map;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections4.Predicate;
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

class PredicatedMap_isSetValueChecking_2_1_Test {

    private PredicatedMap<String, String> predicatedMapWithPredicate;

    private PredicatedMap<String, String> predicatedMapWithoutPredicate;

    @BeforeEach
    void setUp() {
        // Predicate that always returns true
        Predicate<String> alwaysTruePredicate = new Predicate<String>() {

            @Override
            public boolean evaluate(String object) {
                return true;
            }
        };
        // Initialize PredicatedMap with a valuePredicate
        predicatedMapWithPredicate = PredicatedMap.predicatedMap(new HashMap<>(), null, alwaysTruePredicate);
        // Initialize PredicatedMap without a valuePredicate
        predicatedMapWithoutPredicate = PredicatedMap.predicatedMap(new HashMap<>(), null, null);
    }

    @Test
    void testIsSetValueChecking_WhenValuePredicateIsNotNull() throws Exception {
        // Use reflection to invoke the private method
        boolean result = invokeIsSetValueChecking(predicatedMapWithPredicate);
        assertTrue(result, "Expected isSetValueChecking() to return true when valuePredicate is not null");
    }

    @Test
    void testIsSetValueChecking_WhenValuePredicateIsNull() throws Exception {
        // Use reflection to invoke the private method
        boolean result = invokeIsSetValueChecking(predicatedMapWithoutPredicate);
        assertFalse(result, "Expected isSetValueChecking() to return false when valuePredicate is null");
    }

    private boolean invokeIsSetValueChecking(PredicatedMap<String, String> predicatedMap) throws Exception {
        java.lang.reflect.Method method = PredicatedMap.class.getDeclaredMethod("isSetValueChecking");
        method.setAccessible(true);
        return (boolean) method.invoke(predicatedMap);
    }
}
