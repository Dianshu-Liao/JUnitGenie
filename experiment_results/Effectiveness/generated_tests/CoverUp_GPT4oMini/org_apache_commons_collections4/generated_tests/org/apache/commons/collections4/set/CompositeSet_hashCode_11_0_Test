package org.apache.commons.collections4.set;

import org.apache.commons.collections4.set.CompositeSet;
import java.util.HashSet;
import java.util.Set;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.list.UnmodifiableList;

public class CompositeSet_hashCode_11_0_Test {

    private CompositeSet<String> compositeSet;

    @BeforeEach
    public void setUp() {
        compositeSet = new CompositeSet<>();
    }

    @Test
    public void testHashCodeEmptySet() {
        // Test hashCode for an empty CompositeSet
        int expectedHashCode = 0;
        assertEquals(expectedHashCode, compositeSet.hashCode());
    }

    @Test
    public void testHashCodeWithNullElement() {
        // Test hashCode with a set containing a null element
        Set<String> setWithNull = new HashSet<>();
        setWithNull.add(null);
        compositeSet = new CompositeSet<>(setWithNull);
        // null.hashCode() is treated as 0
        int expectedHashCode = 0;
        assertEquals(expectedHashCode, compositeSet.hashCode());
    }

    @Test
    public void testHashCodeWithElements() {
        // Test hashCode with a set containing elements
        Set<String> setWithElements = new HashSet<>();
        setWithElements.add("A");
        setWithElements.add("B");
        compositeSet = new CompositeSet<>(setWithElements);
        int expectedHashCode = "A".hashCode() + "B".hashCode();
        assertEquals(expectedHashCode, compositeSet.hashCode());
    }

    @Test
    public void testHashCodeWithMultipleSets() {
        // Test hashCode with multiple sets
        Set<String> set1 = new HashSet<>();
        set1.add("A");
        Set<String> set2 = new HashSet<>();
        set2.add("B");
        compositeSet = new CompositeSet<>(set1, set2);
        int expectedHashCode = "A".hashCode() + "B".hashCode();
        assertEquals(expectedHashCode, compositeSet.hashCode());
    }

    @Test
    public void testHashCodeWithDuplicateElements() {
        // Test hashCode with duplicate elements
        Set<String> setWithDuplicates = new HashSet<>();
        setWithDuplicates.add("A");
        // Duplicate
        setWithDuplicates.add("A");
        compositeSet = new CompositeSet<>(setWithDuplicates);
        int expectedHashCode = "A".hashCode();
        assertEquals(expectedHashCode, compositeSet.hashCode());
    }
}
