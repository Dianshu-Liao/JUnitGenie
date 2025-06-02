package org.apache.commons.collections4.set;

import org.apache.commons.collections4.set.UnmodifiableSet;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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

class UnmodifiableSet_unmodifiableSet_0_0_Test {

    @Test
    void testUnmodifiableSetWithUnmodifiableSet() {
        Set<String> originalSet = Collections.unmodifiableSet(new HashSet<>());
        Set<String> resultSet = UnmodifiableSet.unmodifiableSet(originalSet);
        assertSame(originalSet, resultSet, "The returned set should be the same instance as the input unmodifiable set.");
    }

    @Test
    void testUnmodifiableSetWithModifiableSet() {
        Set<String> originalSet = new HashSet<>();
        originalSet.add("Element1");
        Set<String> resultSet = UnmodifiableSet.unmodifiableSet(originalSet);
        assertNotSame(originalSet, resultSet, "The returned set should not be the same instance as the input modifiable set.");
        assertEquals(originalSet, resultSet, "The contents of the returned set should be the same as the original set.");
    }

    @Test
    void testUnmodifiableSetWithNull() {
        assertThrows(NullPointerException.class, () -> {
            UnmodifiableSet.unmodifiableSet(null);
        }, "Expected NullPointerException for null input.");
    }

    @Test
    void testUnmodifiableSetPrivateConstructor() throws Exception {
        Constructor<UnmodifiableSet> constructor = UnmodifiableSet.class.getDeclaredConstructor(Set.class);
        constructor.setAccessible(true);
        Set<String> originalSet = new HashSet<>();
        UnmodifiableSet unmodifiableSet = constructor.newInstance(originalSet);
        assertNotNull(unmodifiableSet, "The private constructor should create an instance of UnmodifiableSet.");
    }
}
