package com.fasterxml.jackson.core.util;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class Separators_withObjectEmptySeparator_6_0_Test {

    private Separators separators;

    @BeforeEach
    public void setUp() {
        separators = createSeparators("root", '|', new Spacing(), ',', new Spacing(), "empty", ';', new Spacing(), "arrayEmpty");
    }

    @Test
    public void testWithObjectEmptySeparator_SameSeparator() {
        Separators result = separators.withObjectEmptySeparator("empty");
        assertSame(separators, result, "Expected the same instance to be returned when the separator is the same.");
    }

    @Test
    public void testWithObjectEmptySeparator_DifferentSeparator() {
        Separators result = separators.withObjectEmptySeparator("newEmpty");
        assertNotSame(separators, result, "Expected a new instance to be returned when the separator is different.");
        assertEquals("newEmpty", result.getObjectEmptySeparator(), "Expected the new separator to be set correctly.");
    }

    private Separators createSeparators(String rootSeparator, char objectFieldValueSeparator, Spacing objectFieldValueSpacing, char objectEntrySeparator, Spacing objectEntrySpacing, String objectEmptySeparator, char arrayValueSeparator, Spacing arrayValueSpacing, String arrayEmptySeparator) {
        try {
            Constructor<Separators> constructor = Separators.class.getDeclaredConstructor(String.class, char.class, Spacing.class, char.class, Spacing.class, String.class, char.class, Spacing.class, String.class);
            constructor.setAccessible(true);
            return constructor.newInstance(rootSeparator, objectFieldValueSeparator, objectFieldValueSpacing, objectEntrySeparator, objectEntrySpacing, objectEmptySeparator, arrayValueSeparator, arrayValueSpacing, arrayEmptySeparator);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException("Failed to create Separators instance", e);
        }
    }
}

class Spacing {
    // Assuming Spacing has a default constructor and necessary methods if required.
}
