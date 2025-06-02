package org.apache.commons.collections4.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.PredicatedBag;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.list.PredicatedList;
import org.apache.commons.collections4.multiset.HashMultiSet;
import org.apache.commons.collections4.multiset.PredicatedMultiSet;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.set.PredicatedSet;

class PredicatedCollection_PredicatedCollection_6_0_Test {

    private List<Integer> collection;

    private org.apache.commons.collections4.Predicate<Integer> predicate;

    @BeforeEach
    void setUp() {
        collection = new ArrayList<>();
        // Example predicate: only positive integers
        predicate = new org.apache.commons.collections4.Predicate<Integer>() {

            @Override
            public boolean evaluate(Integer integer) {
                return integer > 0;
            }
        };
    }

    @Test
    void testConstructorWithValidCollectionAndPredicate() {
        collection.add(1);
        collection.add(2);
        collection.add(3);
        PredicatedCollection<Integer> predicatedCollection = new PredicatedCollection<>(collection, predicate);
        assertNotNull(predicatedCollection);
    }

    @Test
    void testConstructorWithEmptyCollection() {
        Collection<Integer> emptyCollection = new ArrayList<>();
        PredicatedCollection<Integer> predicatedCollection = new PredicatedCollection<>(emptyCollection, predicate);
        assertNotNull(predicatedCollection);
    }

    @Test
    void testConstructorWithNullPredicate() {
        assertThrows(NullPointerException.class, () -> {
            new PredicatedCollection<>(collection, null);
        });
    }

    @Test
    void testConstructorWithInvalidItems() {
        collection.add(-1);
        assertThrows(IllegalArgumentException.class, () -> {
            new PredicatedCollection<>(collection, predicate);
        });
    }

    @Test
    void testConstructorWithMixedValidAndInvalidItems() {
        collection.add(1);
        collection.add(-2);
        assertThrows(IllegalArgumentException.class, () -> {
            new PredicatedCollection<>(collection, predicate);
        });
    }

    @Test
    void testPrivateValidateMethod() throws Exception {
        PredicatedCollection<Integer> predicatedCollection = new PredicatedCollection<>(collection, predicate);
        Method method = PredicatedCollection.class.getDeclaredMethod("validate", Object.class);
        method.setAccessible(true);
        // Test valid item
        assertDoesNotThrow(() -> method.invoke(predicatedCollection, 1));
        // Test invalid item
        assertThrows(IllegalArgumentException.class, () -> method.invoke(predicatedCollection, -1));
    }
}
