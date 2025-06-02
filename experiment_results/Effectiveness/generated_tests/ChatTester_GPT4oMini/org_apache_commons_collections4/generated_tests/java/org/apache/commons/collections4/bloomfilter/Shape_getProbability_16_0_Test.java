package org.apache.commons.collections4.bloomfilter;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Constructor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class Shape_getProbability_16_0_Test {

    private Shape shape;

    @BeforeEach
    public void setUp() {
        // Using reflection to access the private constructor
        shape = createShapeInstance(5, 100);
    }

    private Shape createShapeInstance(int param1, int param2) {
        try {
            Constructor<Shape> constructor = Shape.class.getDeclaredConstructor(int.class, int.class);
            constructor.setAccessible(true);
            return constructor.newInstance(param1, param2);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Shape instance", e);
        }
    }

    @Test
    public void testGetProbability_NegativeNumberOfItems() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            shape.getProbability(-1);
        });
        assertEquals("Number of items must be greater than or equal to 0: -1", exception.getMessage());
    }

    @Test
    public void testGetProbability_ZeroItems() {
        double result = shape.getProbability(0);
        assertEquals(0, result, 0.0001);
    }

    @Test
    public void testGetProbability_PositiveItems() {
        // Example with a positive number of items
        double result = shape.getProbability(10);
        assertNotNull(result);
        assertTrue(result > 0);
    }

    @Test
    public void testGetProbability_AnotherPositiveItems() {
        // Another test with a different positive number of items
        double result = shape.getProbability(50);
        assertNotNull(result);
        assertTrue(result > 0);
    }

    @Test
    public void testGetProbability_HighNumberOfItems() {
        // Testing with a high number of items
        double result = shape.getProbability(1000);
        assertNotNull(result);
        assertTrue(result > 0);
    }
}
