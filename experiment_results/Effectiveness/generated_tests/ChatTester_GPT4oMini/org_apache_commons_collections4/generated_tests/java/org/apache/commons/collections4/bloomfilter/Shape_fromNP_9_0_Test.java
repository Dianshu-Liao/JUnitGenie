package org.apache.commons.collections4.bloomfilter;

import org.junit.jupiter.api.function.Executable;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class // Reflection to invoke private methods if needed in future tests.
Shape_fromNP_9_0_Test {

    @Test
    public void testFromNP_ValidInputs() {
        int numberOfItems = 1000;
        double probability = 0.01;
        Shape shape = Shape.fromNP(numberOfItems, probability);
        assertNotNull(shape);
        assertEquals(Shape.class, shape.getClass());
    }

    @Test
    public void testFromNP_ProbabilityTooLow() {
        int numberOfItems = 1000;
        double probability = 0.0;
        Executable executable = () -> Shape.fromNP(numberOfItems, probability);
        assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    public void testFromNP_ProbabilityTooHigh() {
        int numberOfItems = 1000;
        double probability = 1.1;
        Executable executable = () -> Shape.fromNP(numberOfItems, probability);
        assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    public void testFromNP_ExceedsIntegerMaxValue() {
        int numberOfItems = Integer.MAX_VALUE;
        double probability = 0.01;
        Executable executable = () -> Shape.fromNP(numberOfItems, probability);
        assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    public void testFromNP_NegativeNumberOfItems() {
        int numberOfItems = -100;
        double probability = 0.01;
        Executable executable = () -> Shape.fromNP(numberOfItems, probability);
        assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    public void testFromNP_ZeroNumberOfItems() {
        int numberOfItems = 0;
        double probability = 0.01;
        Executable executable = () -> Shape.fromNP(numberOfItems, probability);
        assertThrows(IllegalArgumentException.class, executable);
    }

    // Additional test for boundary condition
    @Test
    public void testFromNP_MaxIntegerBits() {
        // Just below Integer.MAX_VALUE
        int numberOfItems = 2147483647;
        double probability = 0.01;
        Shape shape = Shape.fromNP(numberOfItems, probability);
        assertNotNull(shape);
        assertTrue(shape.getNumberOfBits() <= Integer.MAX_VALUE);
    }
}
