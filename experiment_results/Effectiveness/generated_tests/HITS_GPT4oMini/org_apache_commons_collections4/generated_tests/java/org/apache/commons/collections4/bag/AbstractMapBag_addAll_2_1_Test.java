package org.apache.commons.collections4.bag;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.set.UnmodifiableSet;

class AbstractMapBag_addAll_2_1_Test {

    private AbstractMapBag<String> bag;

    private class TestBag extends AbstractMapBag<String> {

        public TestBag() {
            super(new HashMap<>());
        }

        @Override
        public boolean add(String object, int occurrences) {
            if (occurrences <= 0 || object == null) {
                return false;
            }
            MutableInteger currentCount = getMap().get(object);
            if (currentCount != null) {
                occurrences += currentCount.value;
            }
            getMap().put(object, new MutableInteger(occurrences));
            return true;
        }

        @Override
        public int size() {
            return getMap().values().stream().mapToInt(mutableInteger -> mutableInteger.value).sum();
        }

        protected Map<String, MutableInteger> getMap() {
            return super.getMap();
        }
    }

    private static class MutableInteger {

        int value;

        MutableInteger(int value) {
            this.value = value;
        }
    }

    @BeforeEach
    void setUp() {
        bag = new TestBag();
    }

    @Test
    void testAddAllWithEmptyCollection() {
        Collection<String> collection = new ArrayList<>();
        boolean result = bag.addAll(collection);
        assertFalse(result, "Adding an empty collection should return false.");
        assertEquals(0, bag.size(), "Bag size should remain 0.");
    }

    @Test
    void testAddAllWithSingleElement() {
        Collection<String> collection = new ArrayList<>();
        collection.add("element1");
        boolean result = bag.addAll(collection);
        assertTrue(result, "Adding a collection with a single element should return true.");
        assertEquals(1, bag.size(), "Bag size should be 1 after adding one element.");
    }

    @Test
    void testAddAllWithMultipleElements() {
        Collection<String> collection = new ArrayList<>();
        collection.add("element1");
        collection.add("element2");
        boolean result = bag.addAll(collection);
        assertTrue(result, "Adding a collection with multiple elements should return true.");
        assertEquals(2, bag.size(), "Bag size should be 2 after adding two elements.");
    }

    @Test
    void testAddAllWithDuplicateElements() {
        Collection<String> collection = new ArrayList<>();
        collection.add("element1");
        collection.add("element1");
        boolean result = bag.addAll(collection);
        assertTrue(result, "Adding a collection with duplicate elements should return true.");
        assertEquals(2, bag.size(), "Bag size should be 2 after adding two occurrences of the same element.");
    }
}
