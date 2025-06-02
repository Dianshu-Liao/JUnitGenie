package org.apache.commons.collections4.set;

import org.apache.commons.collections4.set.ListOrderedSet;
import java.lang.reflect.Method;
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
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.list.UnmodifiableList;

class ListOrderedSet_retainAll_16_1_Test {

    private ListOrderedSet<String> listOrderedSet;

    @BeforeEach
    void setUp() {
        listOrderedSet = new ListOrderedSet<>();
        listOrderedSet.add("A");
        listOrderedSet.add("B");
        listOrderedSet.add("C");
    }

    @Test
    void testRetainAll_EmptyCollection() {
        Collection<String> emptyCollection = new ArrayList<>();
        boolean result = listOrderedSet.retainAll(emptyCollection);
        assertFalse(result);
        assertEquals(3, listOrderedSet.size());
    }

    @Test
    void testRetainAll_NonEmptyCollection() {
        Collection<String> collection = new HashSet<>();
        collection.add("B");
        collection.add("C");
        boolean result = listOrderedSet.retainAll(collection);
        assertTrue(result);
        assertEquals(2, listOrderedSet.size());
        assertTrue(listOrderedSet.contains("B"));
        assertTrue(listOrderedSet.contains("C"));
        assertFalse(listOrderedSet.contains("A"));
    }

    @Test
    void testRetainAll_NoChange() {
        Collection<String> collection = new HashSet<>();
        collection.add("A");
        collection.add("B");
        boolean result = listOrderedSet.retainAll(collection);
        assertFalse(result);
        assertEquals(3, listOrderedSet.size());
    }

    @Test
    void testRetainAll_AllElementsRemoved() {
        Collection<String> collection = new HashSet<>();
        collection.add("D");
        boolean result = listOrderedSet.retainAll(collection);
        assertTrue(result);
        assertEquals(0, listOrderedSet.size());
    }

    @Test
    void testRetainAll_ContainsOnlyRemovedElements() {
        Collection<String> collection = new HashSet<>();
        collection.add("A");
        collection.add("B");
        collection.add("C");
        boolean result = listOrderedSet.retainAll(collection);
        assertFalse(result);
        assertEquals(3, listOrderedSet.size());
    }

    @Test
    void testRetainAll_EmptySetAfterRetain() {
        Collection<String> collection = new HashSet<>();
        collection.add("D");
        listOrderedSet.retainAll(collection);
        assertTrue(listOrderedSet.isEmpty());
    }

    @Test
    void testRetainAll_ReflectiveInvocation() throws Exception {
        Collection<String> collection = new HashSet<>();
        collection.add("B");
        collection.add("D");
        Method retainAllMethod = ListOrderedSet.class.getDeclaredMethod("retainAll", Collection.class);
        retainAllMethod.setAccessible(true);
        boolean result = (boolean) retainAllMethod.invoke(listOrderedSet, collection);
        assertTrue(result);
        assertEquals(1, listOrderedSet.size());
        assertTrue(listOrderedSet.contains("B"));
        assertFalse(listOrderedSet.contains("A"));
        assertFalse(listOrderedSet.contains("C"));
    }
}
