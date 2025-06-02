package com.fasterxml.jackson.core;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;

public class StreamReadConstraints_hasMaxDocumentLength_6_0_Test {

    private StreamReadConstraints constraints;

    @BeforeEach
    public void setUp() {
        // Initialize with different _maxDocLen values for testing
        constraints = new StreamReadConstraints(1000, 5000L, 1000, 20000000, 50000, -1L);
    }

    @Test
    public void testHasMaxDocumentLength_WhenMaxDocLenIsPositive() {
        // Arrange: Set _maxDocLen to a positive value using reflection
        setPrivateField(constraints, "_maxDocLen", 5000L);
        // Act
        boolean result = constraints.hasMaxDocumentLength();
        // Assert
        assertTrue(result, "Expected hasMaxDocumentLength to return true when _maxDocLen is positive.");
    }

    @Test
    public void testHasMaxDocumentLength_WhenMaxDocLenIsZero() {
        // Arrange: Set _maxDocLen to zero using reflection
        setPrivateField(constraints, "_maxDocLen", 0L);
        // Act
        boolean result = constraints.hasMaxDocumentLength();
        // Assert
        assertFalse(result, "Expected hasMaxDocumentLength to return false when _maxDocLen is zero.");
    }

    @Test
    public void testHasMaxDocumentLength_WhenMaxDocLenIsNegative() {
        // Arrange: Set _maxDocLen to a negative value using reflection
        setPrivateField(constraints, "_maxDocLen", -1000L);
        // Act
        boolean result = constraints.hasMaxDocumentLength();
        // Assert
        assertFalse(result, "Expected hasMaxDocumentLength to return false when _maxDocLen is negative.");
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }
}
