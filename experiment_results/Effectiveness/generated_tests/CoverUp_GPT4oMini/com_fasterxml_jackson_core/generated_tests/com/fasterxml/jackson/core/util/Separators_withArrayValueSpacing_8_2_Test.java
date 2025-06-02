package com.fasterxml.jackson.core.util;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;

public class Separators_withArrayValueSpacing_8_2_Test {

    private Separators separators;

    private Separators.Spacing spacing1;

    private Separators.Spacing spacing2;

    @BeforeEach
    public void setUp() throws Exception {
        // Initialize Spacing objects for testing
        spacing1 = createSpacing();
        spacing2 = createSpacing();
        // Initialize Separators with some default values
        separators = new Separators(":", 'a', spacing1, 'b', spacing1, "empty", 'c', spacing1, "arrayEmpty");
    }

    @Test
    public void testWithArrayValueSpacing_SameSpacing_ReturnsSameInstance() {
        Separators result = separators.withArrayValueSpacing(spacing1);
        assertSame(separators, result, "Expected the same instance to be returned.");
    }

    @Test
    public void testWithArrayValueSpacing_DifferentSpacing_ReturnsNewInstance() {
        Separators result = separators.withArrayValueSpacing(spacing2);
        assertNotSame(separators, result, "Expected a new instance to be returned.");
        assertEquals(separators.getArrayValueSpacing(), spacing1, "Original spacing should remain unchanged.");
        assertEquals(result.getArrayValueSpacing(), spacing2, "New instance should have the new spacing.");
    }

    @Test
    public void testWithArrayValueSpacing_NullSpacing_ReturnsNewInstance() {
        Separators result = separators.withArrayValueSpacing(null);
        assertNotSame(separators, result, "Expected a new instance to be returned when spacing is null.");
        assertNull(result.getArrayValueSpacing(), "New instance should have null spacing.");
    }

    @Test
    public void testWithArrayValueSpacing_IdenticalNewInstance() {
        Separators newSeparators = new Separators(":", 'a', spacing1, 'b', spacing1, "empty", 'c', spacing1, "arrayEmpty");
        Separators result = newSeparators.withArrayValueSpacing(spacing1);
        assertSame(newSeparators, result, "Expected the same instance to be returned for identical input.");
    }

    private Separators.Spacing createSpacing() throws Exception {
        Constructor<Separators.Spacing> constructor = Separators.Spacing.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        return constructor.newInstance();
    }
}

class Separators {

    private static final long serialVersionUID = 1;

    public final static String DEFAULT_ROOT_VALUE_SEPARATOR = " ";

    public final static String DEFAULT_OBJECT_EMPTY_SEPARATOR = " ";

    public final static String DEFAULT_ARRAY_EMPTY_SEPARATOR = " ";

    private final char objectFieldValueSeparator;

    private final Spacing objectFieldValueSpacing;

    private final char objectEntrySeparator;

    private final Spacing objectEntrySpacing;

    private final String objectEmptySeparator;

    private final char arrayValueSeparator;

    private final Spacing arrayValueSpacing;

    private final String arrayEmptySeparator;

    private final String rootSeparator;

    public Separators(String rootSeparator, char objectFieldValueSeparator, Spacing objectFieldValueSpacing, char objectEntrySeparator, Spacing objectEntrySpacing, String objectEmptySeparator, char arrayValueSeparator, Spacing arrayValueSpacing, String arrayEmptySeparator) {
        this.rootSeparator = rootSeparator;
        this.objectFieldValueSeparator = objectFieldValueSeparator;
        this.objectFieldValueSpacing = objectFieldValueSpacing;
        this.objectEntrySeparator = objectEntrySeparator;
        this.objectEntrySpacing = objectEntrySpacing;
        this.objectEmptySeparator = objectEmptySeparator;
        this.arrayValueSeparator = arrayValueSeparator;
        this.arrayValueSpacing = arrayValueSpacing;
        this.arrayEmptySeparator = arrayEmptySeparator;
    }

    public Separators withArrayValueSpacing(Spacing spacing) {
        return (arrayValueSpacing == spacing) ? this : new Separators(rootSeparator, objectFieldValueSeparator, objectFieldValueSpacing, objectEntrySeparator, objectEntrySpacing, objectEmptySeparator, arrayValueSeparator, spacing, arrayEmptySeparator);
    }

    public Spacing getArrayValueSpacing() {
        return arrayValueSpacing;
    }

    static class Spacing {
        // Assuming some properties and methods for Spacing class
    }
}
