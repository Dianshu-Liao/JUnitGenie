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
public class Separators_withObjectEmptySeparator_6_2_Test {

    private Separators separators;

    @BeforeEach
    public void setUp() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        separators = createSeparators("root", ':', new Spacing(), ';', new Spacing(), "empty", ',', new Spacing(), "arrayEmpty");
    }

    @Test
    public void testWithObjectEmptySeparator_SameValue() {
        String sameSeparator = "empty";
        Separators result = separators.withObjectEmptySeparator(sameSeparator);
        assertSame(separators, result);
    }

    @Test
    public void testWithObjectEmptySeparator_DifferentValue() {
        String newSeparator = "newEmpty";
        Separators result = separators.withObjectEmptySeparator(newSeparator);
        assertNotSame(separators, result);
        assertSame(newSeparator, result.getObjectEmptySeparator());
    }

    @Test
    public void testWithObjectEmptySeparator_NullValue() {
        String nullSeparator = null;
        Separators result = separators.withObjectEmptySeparator(nullSeparator);
        assertNotSame(separators, result);
        assertSame(nullSeparator, result.getObjectEmptySeparator());
    }

    private Separators createSeparators(String rootSeparator, char objectFieldValueSeparator, Spacing objectFieldValueSpacing, char objectEntrySeparator, Spacing objectEntrySpacing, String objectEmptySeparator, char arrayValueSeparator, Spacing arrayValueSpacing, String arrayEmptySeparator) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<Separators> constructor = Separators.class.getDeclaredConstructor(String.class, char.class, Spacing.class, char.class, Spacing.class, String.class, char.class, Spacing.class, String.class);
        constructor.setAccessible(true);
        return constructor.newInstance(rootSeparator, objectFieldValueSeparator, objectFieldValueSpacing, objectEntrySeparator, objectEntrySpacing, objectEmptySeparator, arrayValueSeparator, arrayValueSpacing, arrayEmptySeparator);
    }
}

class Spacing {
    // Assuming Spacing is a simple class with no fields or methods for this test.
}
