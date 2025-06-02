package com.fasterxml.jackson.core.sym;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class Name2_equals_2_0_Test {

    private Name2 name2Instance;

    @BeforeEach
    public void setUp() {
        // Initializing the Name2 instance with arbitrary values.
        name2Instance = new Name2("TestName", 123, 1, 2);
    }

    @Test
    public void testEquals_SameValues_ReturnsTrue() {
        // Test case where all three values are the same
        assertTrue(name2Instance.equals(1, 2, 3));
    }

    @Test
    public void testEquals_DifferentQuad1_ReturnsFalse() {
        // Test case where quad1 is different
        assertFalse(name2Instance.equals(2, 2, 3));
    }

    @Test
    public void testEquals_DifferentQuad2_ReturnsFalse() {
        // Test case where quad2 is different
        assertFalse(name2Instance.equals(1, 3, 3));
    }

    @Test
    public void testEquals_DifferentQ3_ReturnsFalse() {
        // Test case where q3 is different
        assertFalse(name2Instance.equals(1, 2, 4));
    }

    @Test
    public void testEquals_AllDifferent_ReturnsFalse() {
        // Test case where all values are different
        assertFalse(name2Instance.equals(2, 3, 4));
    }
}
