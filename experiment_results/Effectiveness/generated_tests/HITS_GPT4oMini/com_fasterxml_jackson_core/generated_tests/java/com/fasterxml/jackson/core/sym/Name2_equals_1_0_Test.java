package com.fasterxml.jackson.core.sym;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class Name2_equals_1_0_Test {

    private Name2 name2;

    @BeforeEach
    public void setUp() {
        // Initialize the Name2 object with appropriate values
        name2 = new Name2("TestName", 12345, 10, 20);
    }

    @Test
    public void testEquals_WithMatchingValues_ShouldReturnTrue() {
        // Arrange
        int quad1 = 10;
        int quad2 = 20;
        // Act
        boolean result = name2.equals(quad1, quad2);
        // Assert
        assertTrue(result, "Expected equals to return true for matching values.");
    }

    @Test
    public void testEquals_WithNonMatchingFirstValue_ShouldReturnFalse() {
        // Arrange
        // Different from 10
        int quad1 = 15;
        int quad2 = 20;
        // Act
        boolean result = name2.equals(quad1, quad2);
        // Assert
        assertFalse(result, "Expected equals to return false for non-matching first value.");
    }

    @Test
    public void testEquals_WithNonMatchingSecondValue_ShouldReturnFalse() {
        // Arrange
        int quad1 = 10;
        // Different from 20
        int quad2 = 25;
        // Act
        boolean result = name2.equals(quad1, quad2);
        // Assert
        assertFalse(result, "Expected equals to return false for non-matching second value.");
    }

    @Test
    public void testEquals_WithBothNonMatchingValues_ShouldReturnFalse() {
        // Arrange
        // Different from 10
        int quad1 = 15;
        // Different from 20
        int quad2 = 25;
        // Act
        boolean result = name2.equals(quad1, quad2);
        // Assert
        assertFalse(result, "Expected equals to return false for both non-matching values.");
    }
}
