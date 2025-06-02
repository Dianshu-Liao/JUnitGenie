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

public class CompositeSet_remove_14_0_Test {

    private CompositeSet<Integer> compositeSet;

    private Set<Integer> set1;

    private Set<Integer> set2;

    @BeforeEach
    public void setUp() {
        set1 = new HashSet<>();
        set2 = new HashSet<>();
        compositeSet = new CompositeSet<>(set1, set2);
    }

    @Test
    public void testRemoveFromFirstSet() {
        set1.add(1);
        set1.add(2);
        boolean result = compositeSet.remove(1);
        assertTrue(result);
        assertFalse(set1.contains(1));
    }

    @Test
    public void testRemoveFromSecondSet() {
        set2.add(3);
        set2.add(4);
        boolean result = compositeSet.remove(4);
        assertTrue(result);
        assertFalse(set2.contains(4));
    }

    @Test
    public void testRemoveNonExistentElement() {
        set1.add(1);
        set1.add(2);
        boolean result = compositeSet.remove(3);
        assertFalse(result);
    }

    @Test
    public void testRemoveFromEmptySets() {
        boolean result = compositeSet.remove(1);
        assertFalse(result);
    }

    @Test
    public void testRemoveNullElement() {
        set1.add(null);
        boolean result = compositeSet.remove(null);
        assertTrue(result);
        assertFalse(set1.contains(null));
    }
}
