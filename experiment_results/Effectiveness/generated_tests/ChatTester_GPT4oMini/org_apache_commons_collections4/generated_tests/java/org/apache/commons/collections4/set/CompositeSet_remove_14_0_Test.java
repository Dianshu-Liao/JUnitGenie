package org.apache.commons.collections4.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.list.UnmodifiableList;

public class CompositeSet_remove_14_0_Test {

    private CompositeSet<String> compositeSet;

    private Set<String> set1;

    private Set<String> set2;

    @BeforeEach
    public void setUp() {
        set1 = new HashSet<>();
        set2 = new HashSet<>();
        compositeSet = new CompositeSet<>(set1, set2);
    }

    @Test
    public void testRemoveFromSet1() {
        set1.add("test");
        assertTrue(compositeSet.remove("test"));
        assertFalse(set1.contains("test"));
    }

    @Test
    public void testRemoveFromSet2() {
        set2.add("test");
        assertTrue(compositeSet.remove("test"));
        assertFalse(set2.contains("test"));
    }

    @Test
    public void testRemoveNonExistentElement() {
        assertFalse(compositeSet.remove("nonExistent"));
    }

    @Test
    public void testRemoveFromEmptySets() {
        assertFalse(compositeSet.remove("test"));
    }

    @Test
    public void testRemoveNull() {
        set1.add(null);
        assertTrue(compositeSet.remove(null));
        assertFalse(set1.contains(null));
    }

    @Test
    public void testRemoveFromMultipleSets() {
        set1.add("duplicate");
        set2.add("duplicate");
        assertTrue(compositeSet.remove("duplicate"));
        assertFalse(set1.contains("duplicate"));
        // Should still be in set2
        assertTrue(set2.contains("duplicate"));
    }

    @Test
    public void testRemoveAfterAddingDifferentElement() {
        set1.add("test1");
        set2.add("test2");
        assertTrue(compositeSet.remove("test1"));
        assertFalse(compositeSet.remove("test2"));
        assertTrue(set1.contains("test1"));
        assertFalse(set2.contains("test2"));
    }
}
