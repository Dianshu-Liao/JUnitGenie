package org.apache.commons.collections4.bloomfilter;

import java.lang.reflect.Constructor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class Shape_getProbability_16_0_Test {

    private Shape shape;

    @BeforeEach
    void setUp() throws Exception {
        // Use reflection to access the private constructor
        Constructor<Shape> constructor = Shape.class.getDeclaredConstructor(int.class, int.class);
        constructor.setAccessible(true);
        shape = constructor.newInstance(3, 100);
    }

    @Test
    void testGetProbabilityWithNegativeItems() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            shape.getProbability(-1);
        });
        assertEquals("Number of items must be greater than or equal to 0: -1", thrown.getMessage());
    }

    @Test
    void testGetProbabilityWithZeroItems() {
        double probability = shape.getProbability(0);
        assertEquals(0, probability);
    }

    @Test
    void testGetProbabilityWithPositiveItems() {
        double probability = shape.getProbability(10);
        // The probability should be greater than 0 for valid inputs
        assertTrue(probability > 0);
    }

    @Test
    void testGetProbabilityWithLargeNumberOfItems() {
        double probability = shape.getProbability(1000);
        // The probability should still be valid for large inputs
        assertTrue(probability > 0);
    }

    @Test
    void testGetProbabilityWithNumberOfHashFunctionsAndBits() {
        // Test with specific values to validate the formula
        double expectedProbability = Math.pow(-Math.expm1(-1.0 * shape.getNumberOfHashFunctions() * 5 / shape.getNumberOfBits()), shape.getNumberOfHashFunctions());
        double actualProbability = shape.getProbability(5);
        // Allow for some precision error
        assertEquals(expectedProbability, actualProbability, 0.0001);
    }
}
