package com.fasterxml.jackson.core.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Objects;

public class Separators_withObjectEmptySeparator_6_0_Test {

    @Test
    public void testWithObjectEmptySeparator_ChangesSeparator() {
        Separators original = new Separators(Separators.DEFAULT_ROOT_VALUE_SEPARATOR, ' ', null, ' ', null, Separators.DEFAULT_OBJECT_EMPTY_SEPARATOR, ' ', null, Separators.DEFAULT_ARRAY_EMPTY_SEPARATOR);
        String newSeparator = "newSeparator";
        Separators updated = original.withObjectEmptySeparator(newSeparator);
        assertNotSame(original, updated);
        assertEquals(newSeparator, updated.getObjectEmptySeparator());
    }

    @Test
    public void testWithObjectEmptySeparator_SameSeparator() {
        String sameSeparator = Separators.DEFAULT_OBJECT_EMPTY_SEPARATOR;
        Separators original = new Separators(Separators.DEFAULT_ROOT_VALUE_SEPARATOR, ' ', null, ' ', null, sameSeparator, ' ', null, Separators.DEFAULT_ARRAY_EMPTY_SEPARATOR);
        Separators updated = original.withObjectEmptySeparator(sameSeparator);
        assertSame(original, updated);
    }

    @Test
    public void testWithObjectEmptySeparator_NullSeparator() {
        Separators original = new Separators(Separators.DEFAULT_ROOT_VALUE_SEPARATOR, ' ', null, ' ', null, Separators.DEFAULT_OBJECT_EMPTY_SEPARATOR, ' ', null, Separators.DEFAULT_ARRAY_EMPTY_SEPARATOR);
        Separators updated = original.withObjectEmptySeparator(null);
        assertNotSame(original, updated);
        assertNull(updated.getObjectEmptySeparator());
    }

    @Test
    public void testWithObjectEmptySeparator_EmptyStringSeparator() {
        Separators original = new Separators(Separators.DEFAULT_ROOT_VALUE_SEPARATOR, ' ', null, ' ', null, Separators.DEFAULT_OBJECT_EMPTY_SEPARATOR, ' ', null, Separators.DEFAULT_ARRAY_EMPTY_SEPARATOR);
        String emptySeparator = "";
        Separators updated = original.withObjectEmptySeparator(emptySeparator);
        assertNotSame(original, updated);
        assertEquals(emptySeparator, updated.getObjectEmptySeparator());
    }

    @Test
    public void testWithObjectEmptySeparator_ChangeFromDefault() {
        Separators original = new Separators(Separators.DEFAULT_ROOT_VALUE_SEPARATOR, ' ', null, ' ', null, Separators.DEFAULT_OBJECT_EMPTY_SEPARATOR, ' ', null, Separators.DEFAULT_ARRAY_EMPTY_SEPARATOR);
        String newSeparator = "changedSeparator";
        Separators updated = original.withObjectEmptySeparator(newSeparator);
        assertNotSame(original, updated);
        assertEquals(newSeparator, updated.getObjectEmptySeparator());
    }
}
