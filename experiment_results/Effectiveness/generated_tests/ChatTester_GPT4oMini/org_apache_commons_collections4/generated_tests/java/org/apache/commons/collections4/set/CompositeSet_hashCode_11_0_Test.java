package org.apache.commons.collections4.set;

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
        assertEquals(0, compositeSet.hashCode());
    }

    @Test
    public void testHashCodeSingleElement() {
        // Test hashCode for a CompositeSet with one element
        Set<String> set = new HashSet<>();
        set.add("test");
        compositeSet = new CompositeSet<>(set);
        assertEquals("test".hashCode(), compositeSet.hashCode());
    }

    @Test
    public void testHashCodeMultipleElements() {
        // Test hashCode for a CompositeSet with multiple elements
        Set<String> set1 = new HashSet<>();
        set1.add("test1");
        Set<String> set2 = new HashSet<>();
        set2.add("test2");
        compositeSet = new CompositeSet<>(set1, set2);
        int expectedHashCode = "test1".hashCode() + "test2".hashCode();
        assertEquals(expectedHashCode, compositeSet.hashCode());
    }

    @Test
    public void testHashCodeWithNullElement() {
        // Test hashCode for a CompositeSet with a null element
        Set<String> set = new HashSet<>();
        set.add(null);
        compositeSet = new CompositeSet<>(set);
        assertEquals(0, compositeSet.hashCode());
    }

    @Test
    public void testHashCodeDifferentSets() {
        // Test hashCode for different sets
        Set<String> set1 = new HashSet<>();
        set1.add("test1");
        Set<String> set2 = new HashSet<>();
        set2.add("test2");
        CompositeSet<String> compositeSet1 = new CompositeSet<>(set1);
        CompositeSet<String> compositeSet2 = new CompositeSet<>(set2);
        assertNotEquals(compositeSet1.hashCode(), compositeSet2.hashCode());
    }
}
