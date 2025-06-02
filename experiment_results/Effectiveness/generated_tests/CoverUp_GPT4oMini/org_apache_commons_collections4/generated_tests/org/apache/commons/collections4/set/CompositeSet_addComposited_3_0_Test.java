package org.apache.commons.collections4.set;

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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.list.UnmodifiableList;

public class CompositeSet_addComposited_3_0_Test {

    private CompositeSet<String> compositeSet;

    @BeforeEach
    public void setUp() {
        compositeSet = new CompositeSet<>();
    }

    @Test
    public void testAddComposited_Null() {
        compositeSet.addComposited((Set<String>[]) null);
        assertTrue(compositeSet.getSets().isEmpty(), "Expected no sets to be added when null is passed.");
    }

    @Test
    public void testAddComposited_EmptyArray() {
        compositeSet.addComposited(new HashSet<>(), new HashSet<>());
        assertTrue(compositeSet.getSets().isEmpty(), "Expected no sets to be added when empty sets are passed.");
    }

    @Test
    public void testAddComposited_SingleSet() {
        Set<String> set1 = new HashSet<>();
        set1.add("A");
        compositeSet.addComposited(set1);
        List<Set<String>> sets = compositeSet.getSets();
        assertEquals(1, sets.size(), "Expected one set to be added.");
        assertTrue(sets.get(0).contains("A"), "Expected set to contain 'A'.");
    }

    @Test
    public void testAddComposited_MultipleSets() {
        Set<String> set1 = new HashSet<>();
        set1.add("A");
        Set<String> set2 = new HashSet<>();
        set2.add("B");
        compositeSet.addComposited(set1, set2);
        List<Set<String>> sets = compositeSet.getSets();
        assertEquals(2, sets.size(), "Expected two sets to be added.");
        assertTrue(sets.get(0).contains("A"), "Expected first set to contain 'A'.");
        assertTrue(sets.get(1).contains("B"), "Expected second set to contain 'B'.");
    }

    @Test
    public void testAddComposited_NullSetInArray() {
        Set<String> set1 = new HashSet<>();
        set1.add("A");
        compositeSet.addComposited(set1, null);
        List<Set<String>> sets = compositeSet.getSets();
        assertEquals(1, sets.size(), "Expected one set to be added when null is in the array.");
        assertTrue(sets.get(0).contains("A"), "Expected set to contain 'A'.");
    }
}
