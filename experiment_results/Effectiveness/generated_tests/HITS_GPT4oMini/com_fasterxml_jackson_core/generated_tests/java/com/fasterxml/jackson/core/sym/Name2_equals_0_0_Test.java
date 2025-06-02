package com.fasterxml.jackson.core.sym;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class Name2_equals_0_0_Test {

    private Name2 name2;

    @BeforeEach
    public void setUp() {
        // Initialize the Name2 object with sample values
        name2 = new Name2("TestName", 123, 1, 2);
    }

    @Test
    public void testEquals_withMatchingQuad() {
        // Test the equals method with a matching integer value
        assertTrue(name2.equals(1), "Expected equals(1) to return true");
    }

    @Test
    public void testEquals_withNonMatchingQuad() {
        // Test the equals method with a non-matching integer value
        assertFalse(name2.equals(3), "Expected equals(3) to return false");
    }

    @Test
    public void testEquals_withZero() {
        // Test the equals method with zero
        assertFalse(name2.equals(0), "Expected equals(0) to return false");
    }

    @Test
    public void testEquals_withNegativeValue() {
        // Test the equals method with a negative integer value
        assertFalse(name2.equals(-1), "Expected equals(-1) to return false");
    }

    @Test
    public void testEquals_withLargeValue() {
        // Test the equals method with a large integer value
        assertFalse(name2.equals(1000), "Expected equals(1000) to return false");
    }
}
