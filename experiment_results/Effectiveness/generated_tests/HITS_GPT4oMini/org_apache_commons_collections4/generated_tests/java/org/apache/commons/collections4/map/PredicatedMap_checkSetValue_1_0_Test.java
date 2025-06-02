package org.apache.commons.collections4.map;

import org.apache.commons.collections4.Predicate;
import java.util.HashMap;
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
import java.util.Map;

public class PredicatedMap_checkSetValue_1_0_Test {

    private PredicatedMap<String, String> predicatedMap;

    private Predicate<String> valuePredicate;

    private Predicate<String> keyPredicate;

    @BeforeEach
    public void setUp() {
        valuePredicate = mock(Predicate.class);
        // Create a mock for key predicate
        keyPredicate = mock(Predicate.class);
        // Pass both predicates
        predicatedMap = new PredicatedMap<>(new HashMap<String, String>(), keyPredicate, valuePredicate);
    }

    @Test
    public void testCheckSetValue_ValidValue() {
        String validValue = "validValue";
        // Arrange
        when(valuePredicate.test(validValue)).thenReturn(true);
        // Act
        String result = predicatedMap.checkSetValue(validValue);
        // Assert
        assertEquals(validValue, result);
    }

    @Test
    public void testCheckSetValue_InvalidValue() {
        String invalidValue = "invalidValue";
        // Arrange
        when(valuePredicate.test(invalidValue)).thenReturn(false);
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            predicatedMap.checkSetValue(invalidValue);
        });
    }
}
