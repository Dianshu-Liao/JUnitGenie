package org.apache.commons.collections4.bloomfilter;

import org.apache.commons.collections4.bloomfilter.Shape;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class Shape_fromNP_9_0_Test {

    @Test
    void testFromNP_ValidInput() {
        Shape shape = Shape.fromNP(10, 0.5);
        assertNotNull(shape);
        assertEquals(10, shape.getNumberOfBits());
        assertTrue(shape.getNumberOfHashFunctions() > 0);
    }

    @Test
    void testFromNP_ZeroItems() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Shape.fromNP(0, 0.5);
        });
        assertEquals("Number of items must be greater than 0: 0", thrown.getMessage());
    }

    @Test
    void testFromNP_NegativeItems() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Shape.fromNP(-1, 0.5);
        });
        assertEquals("Number of items must be greater than 0: -1", thrown.getMessage());
    }

    @Test
    void testFromNP_ProbabilityZero() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Shape.fromNP(10, 0.0);
        });
        assertEquals("Probability must be greater than 0 and less than 1: 0.0", thrown.getMessage());
    }

    @Test
    void testFromNP_ProbabilityOne() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Shape.fromNP(10, 1.0);
        });
        assertEquals("Probability must be greater than 0 and less than 1: 1.0", thrown.getMessage());
    }

    @Test
    void testFromNP_TooManyBits() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Shape.fromNP(Integer.MAX_VALUE, 0.5);
        });
        assertTrue(thrown.getMessage().contains("Resulting filter has more than"));
    }

    @Test
    void testFromNP_ValidInputWithHighProbability() {
        Shape shape = Shape.fromNP(100, 0.99);
        assertNotNull(shape);
        assertEquals(100, shape.getNumberOfBits());
        assertTrue(shape.getNumberOfHashFunctions() > 0);
    }

    // Reflection test for private methods if needed
    @Test
    void testPrivateMethod() throws Exception {
        Method method = Shape.class.getDeclaredMethod("checkCalculatedProbability", double.class);
        method.setAccessible(true);
        // should not throw exception
        method.invoke(null, 0.5);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            // should throw exception
            method.invoke(null, 1.0);
        });
        assertEquals("Calculated probability is greater than or equal to 1: 1.0", thrown.getMessage());
    }
}
