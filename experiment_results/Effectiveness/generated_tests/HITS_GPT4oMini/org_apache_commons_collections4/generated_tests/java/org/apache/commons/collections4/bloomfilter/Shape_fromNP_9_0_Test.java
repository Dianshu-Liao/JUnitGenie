package org.apache.commons.collections4.bloomfilter;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class Shape_fromNP_9_0_Test {

    @Test
    public void testFromNP_ValidInput() {
        Shape shape = Shape.fromNP(10, 0.5);
        assertNotNull(shape);
        assertEquals(10, shape.getNumberOfBits());
        assertTrue(shape.getNumberOfHashFunctions() > 0);
    }

    @Test
    public void testFromNP_ZeroItems() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Shape.fromNP(0, 0.5);
        });
        assertEquals("Number of items must be greater than 0: 0", exception.getMessage());
    }

    @Test
    public void testFromNP_NegativeItems() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Shape.fromNP(-1, 0.5);
        });
        assertEquals("Number of items must be greater than 0: -1", exception.getMessage());
    }

    @Test
    public void testFromNP_ProbabilityZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Shape.fromNP(10, 0.0);
        });
        assertEquals("Probability must be greater than 0 and less than 1: 0.0", exception.getMessage());
    }

    @Test
    public void testFromNP_ProbabilityOne() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Shape.fromNP(10, 1.0);
        });
        assertEquals("Calculated probability is greater than or equal to 1: 1.0", exception.getMessage());
    }

    @Test
    public void testFromNP_ProbabilityGreaterThanOne() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Shape.fromNP(10, 1.5);
        });
        assertEquals("Probability must be greater than 0 and less than 1: 1.5", exception.getMessage());
    }

    @Test
    public void testFromNP_TooManyBits() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Shape.fromNP(Integer.MAX_VALUE, 0.5);
        });
        assertTrue(exception.getMessage().contains("Resulting filter has more than"));
    }

    @Test
    public void testFromNP_OneItem() {
        Shape shape = Shape.fromNP(1, 0.5);
        assertNotNull(shape);
        assertEquals(1, shape.getNumberOfBits());
        assertEquals(1, shape.getNumberOfHashFunctions());
    }

    @Test
    public void testFromNP_LargeNumberOfItems() {
        Shape shape = Shape.fromNP(1000000, 0.01);
        assertNotNull(shape);
        assertTrue(shape.getNumberOfBits() > 0);
        assertTrue(shape.getNumberOfHashFunctions() > 0);
    }
}
