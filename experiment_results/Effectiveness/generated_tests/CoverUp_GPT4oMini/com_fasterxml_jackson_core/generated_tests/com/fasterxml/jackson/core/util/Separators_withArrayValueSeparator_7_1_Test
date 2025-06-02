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

    private Separators separators;

    @BeforeEach
    public void setUp() {
        // Initialize with some values
        separators = new Separators('a', 'b', 'c');
    }

    @Test
    public void testWithArrayValueSeparator_SameValue() {
        Separators result = separators.withArrayValueSeparator('c');
        assertSame(separators, result, "Expected the same instance when using the same array value separator.");
    }

    @Test
    public void testWithArrayValueSeparator_DifferentValue() {
        Separators result = separators.withArrayValueSeparator('d');
        assertNotSame(separators, result, "Expected a new instance when using a different array value separator.");
        assertEquals('d', result.getArrayValueSeparator(), "The array value separator should be updated.");
    }

    @Test
    public void testWithArrayValueSeparator_NullValue() {
        // This test assumes that '0' is not a valid char for arrayValueSeparator
        Separators result = separators.withArrayValueSeparator('\0');
        assertNotSame(separators, result, "Expected a new instance when using a null character as array value separator.");
        assertEquals('\0', result.getArrayValueSeparator(), "The array value separator should be updated to null character.");
    }

    @Test
    public void testWithArrayValueSeparator_EmptyValue() {
        // This test assumes that ' ' (space) is a valid char for arrayValueSeparator
        Separators result = separators.withArrayValueSeparator(' ');
        assertNotSame(separators, result, "Expected a new instance when using a space as array value separator.");
        assertEquals(' ', result.getArrayValueSeparator(), "The array value separator should be updated to space.");
    }
}
