package com.fasterxml.jackson.core;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.util.ArrayList;
import com.fasterxml.jackson.core.io.NumberInput;

public class JsonPointer_matches_6_0_Test {

    @Test
    public void testMatches_WithNullNextSegment_ReturnsTrue() throws Exception {
        // Arrange
        JsonPointer pointer = new JsonPointer(null, 0, null, null);
        // Act
        boolean result = pointer.matches();
        // Assert
        assertTrue(result);
    }

    @Test
    public void testMatches_WithNonNullNextSegment_ReturnsFalse() throws Exception {
        // Arrange
        JsonPointer nextSegment = new JsonPointer();
        JsonPointer pointer = new JsonPointer(null, 0, null, nextSegment);
        // Act
        boolean result = pointer.matches();
        // Assert
        assertFalse(result);
    }

    @Test
    public void testMatches_WithNextSegmentAsNullInDifferentConstructor_ReturnsTrue() throws Exception {
        // Arrange
        JsonPointer pointer = new JsonPointer(new JsonPointer(), null);
        // Act
        boolean result = pointer.matches();
        // Assert
        assertTrue(result);
    }

    @Test
    public void testMatches_WithNextSegmentAsNonNullInDifferentConstructor_ReturnsFalse() throws Exception {
        // Arrange
        JsonPointer nextSegment = new JsonPointer();
        JsonPointer pointer = new JsonPointer(new JsonPointer(), nextSegment);
        // Act
        boolean result = pointer.matches();
        // Assert
        assertFalse(result);
    }

    @Test
    public void testMatches_WithNextSegmentAsEmpty_ReturnsTrue() throws Exception {
        // Arrange
        JsonPointer emptyPointer = JsonPointer.empty();
        JsonPointer pointer = new JsonPointer(emptyPointer, null);
        // Act
        boolean result = pointer.matches();
        // Assert
        assertTrue(result);
    }

    @Test
    public void testMatches_WithNextSegmentAsNonEmpty_ReturnsFalse() throws Exception {
        // Arrange
        JsonPointer nextSegment = new JsonPointer("some/path", 0, "property", null);
        JsonPointer pointer = new JsonPointer(nextSegment, null);
        // Act
        boolean result = pointer.matches();
        // Assert
        assertFalse(result);
    }
}
