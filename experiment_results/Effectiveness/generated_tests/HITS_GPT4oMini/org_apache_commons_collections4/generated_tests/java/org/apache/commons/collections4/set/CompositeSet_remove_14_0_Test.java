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

public class CompositeSet_remove_14_0_Test {

    private CompositeSet<String> compositeSet;

    @BeforeEach
    public void setUp() {
        compositeSet = new CompositeSet<>();
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        set1.add("A");
        set1.add("B");
        set2.add("C");
        compositeSet.getSets().add(set1);
        compositeSet.getSets().add(set2);
    }

    @Test
    public void testRemove_ExistingElementFromFirstSet() {
        assertTrue(compositeSet.remove("A"), "Should return true when removing an existing element from the first set");
        assertFalse(compositeSet.getSets().get(0).contains("A"), "Element A should be removed from the first set");
    }

    @Test
    public void testRemove_ExistingElementFromSecondSet() {
        assertTrue(compositeSet.remove("C"), "Should return true when removing an existing element from the second set");
        assertFalse(compositeSet.getSets().get(1).contains("C"), "Element C should be removed from the second set");
    }

    @Test
    public void testRemove_NonExistingElement() {
        assertFalse(compositeSet.remove("D"), "Should return false when trying to remove a non-existing element");
    }

    @Test
    public void testRemove_ElementAlreadyRemoved() {
        // Remove B first
        compositeSet.remove("B");
        assertFalse(compositeSet.remove("B"), "Should return false when trying to remove an already removed element");
    }

    @Test
    public void testRemove_EmptyCompositeSet() {
        CompositeSet<String> emptyCompositeSet = new CompositeSet<>();
        assertFalse(emptyCompositeSet.remove("A"), "Should return false when trying to remove from an empty CompositeSet");
    }
}
