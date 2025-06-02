package com.fasterxml.jackson.core.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Objects;

public class Separators_withArrayValueSeparator_7_1_Test {

    @Test
    public void testWithArrayValueSeparator_ChangesSeparator() {
        // Arrange
        Separators original = new Separators('a', 'b', 'c');
        char newSeparator = 'd';
        // Act
        Separators updated = original.withArrayValueSeparator(newSeparator);
        // Assert
        assertNotSame(original, updated);
        // Assuming toString() reflects the separator
        assertTrue(updated.toString().contains(String.valueOf(newSeparator)));
    }

    @Test
    public void testWithArrayValueSeparator_SameSeparator() {
        // Arrange
        char separator = 'e';
        Separators original = new Separators('a', 'b', separator);
        // Act
        Separators updated = original.withArrayValueSeparator(separator);
        // Assert
        assertSame(original, updated);
    }

    @Test
    public void testWithArrayValueSeparator_ChangingFromDefault() {
        // Arrange
        char defaultSeparator = ' ';
        char newSeparator = ',';
        Separators original = new Separators(defaultSeparator, 'b', newSeparator);
        // Act
        Separators updated = original.withArrayValueSeparator(newSeparator);
        // Assert
        assertNotSame(original, updated);
        // Assuming toString() reflects the separator
        assertTrue(updated.toString().contains(String.valueOf(newSeparator)));
    }

    @Test
    public void testWithArrayValueSeparator_ChangingToDefault() {
        // Arrange
        char newSeparator = '!';
        Separators original = new Separators('a', 'b', newSeparator);
        // Act
        Separators updated = original.withArrayValueSeparator(' ');
        // Assert
        assertNotSame(original, updated);
        // Assuming toString() reflects the separator
        assertTrue(updated.toString().contains(" "));
    }

    @Test
    public void testWithArrayValueSeparator_MultipleChanges() {
        // Arrange
        Separators original = new Separators('a', 'b', 'c');
        char firstChange = 'x';
        char secondChange = 'y';
        // Act
        Separators firstUpdated = original.withArrayValueSeparator(firstChange);
        Separators secondUpdated = firstUpdated.withArrayValueSeparator(secondChange);
        // Assert
        assertNotSame(original, firstUpdated);
        assertNotSame(firstUpdated, secondUpdated);
        // Assuming toString() reflects the separator
        assertTrue(secondUpdated.toString().contains(String.valueOf(secondChange)));
    }
}
