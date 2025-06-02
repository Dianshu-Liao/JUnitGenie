package com.fasterxml.jackson.core.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Objects;

public class Separators_withObjectEmptySeparator_6_1_Test {

    @Test
    public void testWithObjectEmptySeparator_SameSeparator() {
        // Arrange
        Separators separators = new Separators();
        String separator = Separators.DEFAULT_OBJECT_EMPTY_SEPARATOR;
        // Act
        Separators result = separators.withObjectEmptySeparator(separator);
        // Assert
        assertSame(separators, result, "Expected the same instance when separator is the same.");
    }

    @Test
    public void testWithObjectEmptySeparator_DifferentSeparator() {
        // Arrange
        Separators separators = new Separators();
        String newSeparator = "newSeparator";
        // Act
        Separators result = separators.withObjectEmptySeparator(newSeparator);
        // Assert
        assertNotSame(separators, result, "Expected a new instance when separator is different.");
        assertEquals(newSeparator, result.getObjectEmptySeparator(), "Expected the new separator to be set.");
    }

    @Test
    public void testWithObjectEmptySeparator_NullSeparator() {
        // Arrange
        Separators separators = new Separators();
        String nullSeparator = null;
        // Act
        Separators result = separators.withObjectEmptySeparator(nullSeparator);
        // Assert
        assertNotSame(separators, result, "Expected a new instance when separator is null.");
        assertEquals(nullSeparator, result.getObjectEmptySeparator(), "Expected the new separator to be set to null.");
    }

    @Test
    public void testWithObjectEmptySeparator_EmptyStringSeparator() {
        // Arrange
        Separators separators = new Separators();
        String emptySeparator = "";
        // Act
        Separators result = separators.withObjectEmptySeparator(emptySeparator);
        // Assert
        assertNotSame(separators, result, "Expected a new instance when separator is an empty string.");
        assertEquals(emptySeparator, result.getObjectEmptySeparator(), "Expected the new separator to be set to an empty string.");
    }
}
