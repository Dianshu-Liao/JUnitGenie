package org.apache.commons.collections4.collection;

import org.apache.commons.collections4.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.PredicatedBag;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.list.PredicatedList;
import org.apache.commons.collections4.multiset.HashMultiSet;
import org.apache.commons.collections4.multiset.PredicatedMultiSet;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.set.PredicatedSet;

public class PredicatedCollection_PredicatedCollection_6_0_Test {

    @Test
    public void testConstructorWithValidCollectionAndPredicate() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        Predicate<Integer> predicate = (Integer i) -> i > 0;
        PredicatedCollection<Integer> predicatedCollection = new PredicatedCollection<>(collection, predicate);
        assertNotNull(predicatedCollection);
    }

    @Test
    public void testConstructorWithEmptyCollection() {
        Collection<Integer> collection = new ArrayList<>();
        Predicate<Integer> predicate = (Integer i) -> i > 0;
        PredicatedCollection<Integer> predicatedCollection = new PredicatedCollection<>(collection, predicate);
        assertNotNull(predicatedCollection);
    }

    @Test
    public void testConstructorWithNullPredicate() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        Predicate<Integer> predicate = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new PredicatedCollection<>(collection, predicate);
        });
        assertEquals("predicate", exception.getMessage());
    }

    @Test
    public void testConstructorWithInvalidElement() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(-1);
        Predicate<Integer> predicate = (Integer i) -> i > 0;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new PredicatedCollection<>(collection, predicate);
        });
        assertEquals("Cannot add Object '-1' - Predicate 'org.apache.commons.collections4.functors.Predicate$1@1b6d3586' rejected it", exception.getMessage());
    }

    @Test
    public void testConstructorWithValidElements() {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        Predicate<Integer> predicate = (Integer i) -> i > 0;
        PredicatedCollection<Integer> predicatedCollection = new PredicatedCollection<>(collection, predicate);
        assertEquals(2, predicatedCollection.size());
    }

    @Test
    public void testConstructorWithMixedElements() {
        Collection<Integer> collection = new HashSet<>();
        collection.add(1);
        collection.add(-1);
        Predicate<Integer> predicate = (Integer i) -> i > 0;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new PredicatedCollection<>(collection, predicate);
        });
        assertEquals("Cannot add Object '-1' - Predicate 'org.apache.commons.collections4.functors.Predicate$1@1b6d3586' rejected it", exception.getMessage());
    }
}
