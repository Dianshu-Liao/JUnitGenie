package org.apache.commons.collections4.bloomfilter;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class Shape_getProbability_16_0_Test {

    // Factory method to create an instance of Shape for testing
    private Shape createShape(int numberOfHashFunctions, int numberOfBits) {
        // Using reflection to access the private constructor for testing purposes
        try {
            java.lang.reflect.Constructor<Shape> constructor = Shape.class.getDeclaredConstructor(int.class, int.class);
            constructor.setAccessible(true);
            return constructor.newInstance(numberOfHashFunctions, numberOfBits);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Shape instance", e);
        }
    }

    @Test
    void testGetProbabilityWithValidInput() {
        Shape shape = createShape(3, 1000);
        double probability = shape.getProbability(10);
        assertTrue(probability >= 0 && probability <= 1, "Probability should be between 0 and 1");
    }

    @Test
    void testGetProbabilityWithZeroItems() {
        Shape shape = createShape(3, 1000);
        double probability = shape.getProbability(0);
        assertEquals(0.0, probability, "Probability should be 0 when there are 0 items");
    }

    @Test
    void testGetProbabilityWithNegativeItems() {
        Shape shape = createShape(3, 1000);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            shape.getProbability(-1);
        });
        assertEquals("Number of items must be greater than or equal to 0: -1", thrown.getMessage());
    }

    @Test
    void testGetProbabilityWithLargeNumberOfItems() {
        Shape shape = createShape(3, 1000);
        // Test with a large number of items
        double probability = shape.getProbability(10000);
        assertTrue(probability >= 0 && probability <= 1, "Probability should be between 0 and 1");
    }
}
