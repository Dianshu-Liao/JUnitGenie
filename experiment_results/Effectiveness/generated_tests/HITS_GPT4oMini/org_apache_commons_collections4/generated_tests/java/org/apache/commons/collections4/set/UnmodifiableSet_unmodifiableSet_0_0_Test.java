package org.apache.commons.collections4.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;

public class UnmodifiableSet_unmodifiableSet_0_0_Test {

    @Test
    public void testUnmodifiableSetWithModifiableSet() {
        Set<String> modifiableSet = new HashSet<>();
        modifiableSet.add("A");
        modifiableSet.add("B");
        modifiableSet.add("C");
        Set<String> unmodifiableSet = UnmodifiableSet.unmodifiableSet(modifiableSet);
        assertEquals(3, unmodifiableSet.size());
        assertTrue(unmodifiableSet.contains("A"));
        assertTrue(unmodifiableSet.contains("B"));
        assertTrue(unmodifiableSet.contains("C"));
        assertThrows(UnsupportedOperationException.class, () -> unmodifiableSet.add("D"));
    }

    @Test
    public void testUnmodifiableSetWithUnmodifiableSet() {
        Set<String> originalSet = new HashSet<>();
        originalSet.add("X");
        originalSet.add("Y");
        Set<String> unmodifiableOriginalSet = Collections.unmodifiableSet(originalSet);
        Set<String> returnedSet = UnmodifiableSet.unmodifiableSet(unmodifiableOriginalSet);
        assertSame(unmodifiableOriginalSet, returnedSet);
        assertEquals(2, returnedSet.size());
        assertTrue(returnedSet.contains("X"));
        assertTrue(returnedSet.contains("Y"));
        assertThrows(UnsupportedOperationException.class, () -> returnedSet.add("Z"));
    }

    @Test
    public void testUnmodifiableSetWithEmptySet() {
        Set<String> emptySet = new HashSet<>();
        Set<String> unmodifiableSet = UnmodifiableSet.unmodifiableSet(emptySet);
        assertEquals(0, unmodifiableSet.size());
        assertFalse(unmodifiableSet.contains("A"));
        assertThrows(UnsupportedOperationException.class, () -> unmodifiableSet.add("A"));
    }

    @Test
    public void testUnmodifiableSetWithNullSet() {
        assertThrows(NullPointerException.class, () -> UnmodifiableSet.unmodifiableSet(null));
    }
}
