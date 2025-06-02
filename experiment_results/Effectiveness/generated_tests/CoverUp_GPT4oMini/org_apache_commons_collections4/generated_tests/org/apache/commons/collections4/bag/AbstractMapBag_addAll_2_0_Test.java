package org.apache.commons.collections4.bag;

import org.apache.commons.collections4.Bag;
import org.apache.commons.lang3.mutable.MutableInt;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.set.UnmodifiableSet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AbstractMapBag_addAll_2_0_Test {

    private AbstractMapBag<String> bag;

    @BeforeEach
    void setUp() {
        bag = new TestMapBag();
    }

    @Test
    void testAddAllWithEmptyCollection() {
        Collection<String> collection = Arrays.asList();
        boolean result = bag.addAll(collection);
        assertFalse(result, "addAll should return false when adding an empty collection");
        assertEquals(0, bag.size(), "Bag size should remain 0 after adding an empty collection");
    }

    @Test
    void testAddAllWithNonEmptyCollection() {
        Collection<String> collection = Arrays.asList("A", "B", "C");
        boolean result = bag.addAll(collection);
        assertTrue(result, "addAll should return true when adding new elements");
        assertEquals(3, bag.size(), "Bag size should be 3 after adding 3 new elements");
    }

    @Test
    void testAddAllWithDuplicates() {
        bag.add("A");
        bag.add("B");
        Collection<String> collection = Arrays.asList("B", "C", "D");
        boolean result = bag.addAll(collection);
        assertTrue(result, "addAll should return true when adding elements including existing ones");
        assertEquals(4, bag.size(), "Bag size should be 4 after adding new and existing elements");
    }

    @Test
    void testAddAllWithNullElement() {
        Collection<String> collection = Arrays.asList("A", null, "C");
        assertThrows(NullPointerException.class, () -> bag.addAll(collection), "addAll should throw NullPointerException when adding a collection with null elements");
    }

    private static class TestMapBag extends AbstractMapBag<String> {

        private final Map<String, MutableInt> map;

        public TestMapBag() {
            this.map = new HashMap<>();
        }

        @Override
        public boolean add(String object) {
            return add(object, 1);
        }

        @Override
        public boolean add(String object, int occurrences) {
            if (object == null) {
                throw new NullPointerException("Element cannot be null");
            }
            MutableInt count = map.get(object);
            if (count == null) {
                map.put(object, new MutableInt(occurrences));
                return true;
            } else {
                count.add(occurrences);
                return false;
            }
        }

        @Override
        public int size() {
            return map.values().stream().mapToInt(MutableInt::intValue).sum();
        }
    }
}
