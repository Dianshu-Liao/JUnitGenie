package org.apache.commons.collections4.bag;

import org.apache.commons.collections4.bag.AbstractMapBag;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.set.UnmodifiableSet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AbstractMapBag_remove_15_2_Test {

    private AbstractMapBag<String> bag;

    @BeforeEach
    void setUp() {
        bag = new AbstractMapBag<String>() {

            // Provide a concrete implementation for the abstract class
            @Override
            protected Map<String, MutableInteger> getMap() {
                return new HashMap<>();
            }
        };
        bag.add("apple", 3);
        bag.add("banana", 2);
    }

    @Test
    void testRemoveExistingElement() {
        assertTrue(bag.remove("apple"));
        assertEquals(2, bag.size());
        // apple should be removed
        assertFalse(bag.remove("apple"));
    }

    @Test
    void testRemoveNonExistingElement() {
        // orange does not exist
        assertFalse(bag.remove("orange"));
        // size should remain unchanged
        assertEquals(5, bag.size());
    }

    @Test
    void testRemoveMultipleOccurrences() {
        assertTrue(bag.remove("banana"));
        // size should decrease by 2, as banana had a count of 2
        assertEquals(3, bag.size());
    }

    @Test
    void testRemoveNullElement() {
        // null should not be removed
        assertFalse(bag.remove(null));
        // size should remain unchanged
        assertEquals(5, bag.size());
    }
}
