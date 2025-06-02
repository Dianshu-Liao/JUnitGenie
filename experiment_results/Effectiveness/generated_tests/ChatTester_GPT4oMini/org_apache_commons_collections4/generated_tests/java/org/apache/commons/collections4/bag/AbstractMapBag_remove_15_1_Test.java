package org.apache.commons.collections4.bag;

import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.set.UnmodifiableSet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AbstractMapBag_remove_15_1_Test {

    private AbstractMapBag<String> bag;

    // Mocking MutableInteger class
    static class MutableInteger {

        int value;

        MutableInteger(int value) {
            this.value = value;
        }
    }

    // Concrete implementation of AbstractMapBag for testing
    static class ConcreteMapBag extends AbstractMapBag<String> {

        ConcreteMapBag(Map<String, MutableInteger> map) {
            super(map);
        }
    }

    @BeforeEach
    void setUp() {
        Map<String, MutableInteger> map = new HashMap<>();
        map.put("apple", new MutableInteger(2));
        map.put("banana", new MutableInteger(3));
        // Fixed the bug by using the correct type for the map
        bag = new ConcreteMapBag((Map<String, AbstractMapBag.MutableInteger>) (Map<?, ?>) map);
    }

    @Test
    void testRemoveObject() throws Exception {
        // Test removing an existing element
        // Should return true
        assertTrue(bag.remove("apple"));
        // Check that removing again returns false
        assertFalse(bag.remove("apple"));
        // Check the size after removing an element
        Field sizeField = AbstractMapBag.class.getDeclaredField("size");
        sizeField.setAccessible(true);
        int size = (int) sizeField.get(bag);
        // 5 (initial size) - 2 (apple count) = 3
        assertEquals(3, size);
        // Test removing a non-existing element
        // Should return false
        assertFalse(bag.remove("orange"));
        // Test removing another existing element
        // Should return true
        assertTrue(bag.remove("banana"));
        // Check the size after removing another element
        size = (int) sizeField.get(bag);
        assertEquals(0, size);
        // Check modCount after removals
        Field modCountField = AbstractMapBag.class.getDeclaredField("modCount");
        modCountField.setAccessible(true);
        int initialModCount = (int) modCountField.get(bag);
        // No effect, banana already removed
        bag.remove("banana");
        int updatedModCount = (int) modCountField.get(bag);
        // Should increment modCount
        assertEquals(initialModCount + 1, updatedModCount);
    }
}
