package org.apache.commons.collections4.collection;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashSet;
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

class PredicatedCollection_PredicatedCollection_6_0_Test {

    private static class TestPredicate implements Predicate<Integer> {

        @Override
        public boolean evaluate(Integer object) {
            return object != null && object > 0;
        }
    }

    @Test
    void testPredicatedCollectionWithValidElements() {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3));
        Predicate<Integer> predicate = new TestPredicate();
        PredicatedCollection<Integer> predicatedCollection = new PredicatedCollection<>(collection, predicate);
        assertEquals(3, predicatedCollection.size());
    }

    @Test
    void testPredicatedCollectionWithInvalidElement() {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(-1, 2, 3));
        Predicate<Integer> predicate = new TestPredicate();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new PredicatedCollection<>(collection, predicate);
        });
        assertEquals("Cannot add Object '-1' - Predicate 'org.apache.commons.collections4.collection.PredicatedCollectionTest$TestPredicate@...", exception.getMessage().substring(0, 70));
    }

    @Test
    void testPredicatedCollectionWithNullPredicate() {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3));
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            new PredicatedCollection<>(collection, null);
        });
        assertEquals("predicate", exception.getMessage());
    }

    @Test
    void testValidateMethodWithValidElement() throws Exception {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3));
        Predicate<Integer> predicate = new TestPredicate();
        PredicatedCollection<Integer> predicatedCollection = new PredicatedCollection<>(collection, predicate);
        Method validateMethod = PredicatedCollection.class.getDeclaredMethod("validate", Object.class);
        validateMethod.setAccessible(true);
        assertDoesNotThrow(() -> validateMethod.invoke(predicatedCollection, 1));
    }

    @Test
    void testValidateMethodWithInvalidElement() throws Exception {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3));
        Predicate<Integer> predicate = new TestPredicate();
        PredicatedCollection<Integer> predicatedCollection = new PredicatedCollection<>(collection, predicate);
        Method validateMethod = PredicatedCollection.class.getDeclaredMethod("validate", Object.class);
        validateMethod.setAccessible(true);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validateMethod.invoke(predicatedCollection, -1);
        });
        assertEquals("Cannot add Object '-1' - Predicate 'org.apache.commons.collections4.collection.PredicatedCollectionTest$TestPredicate@...", exception.getMessage().substring(0, 70));
    }
}
