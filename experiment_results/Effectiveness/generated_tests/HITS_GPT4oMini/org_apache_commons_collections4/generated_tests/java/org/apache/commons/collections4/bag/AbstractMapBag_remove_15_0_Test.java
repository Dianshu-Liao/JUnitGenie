package org.apache.commons.collections4.bag;

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
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.set.UnmodifiableSet;

class AbstractMapBag_remove_15_0_Test extends AbstractMapBag {

    private Map<Object, MutableInteger> map;

    @BeforeEach
    void setUp() {
        map = new HashMap<>();
        map.put("item1", new MutableInteger(2));
        map.put("item2", new MutableInteger(3));
        initializeBag(map);
    }

    @Test
    void testRemoveExistingItem() {
        boolean result = remove("item1");
        assertTrue(result);
        assertEquals(3, getMapSize());
        assertNull(map.get("item1"));
    }

    @Test
    void testRemoveNonExistingItem() {
        boolean result = remove("item3");
        assertFalse(result);
        assertEquals(5, getMapSize());
    }

    @Test
    void testRemoveAllOccurrences() {
        boolean result = remove("item2");
        assertTrue(result);
        assertEquals(2, getMapSize());
        assertNull(map.get("item2"));
    }

    @Test
    void testRemoveNullItem() {
        boolean result = remove(null);
        assertFalse(result);
        assertEquals(5, getMapSize());
    }

    // Getter method to calculate the total size of the bag
    protected int getMapSize() {
        return map.values().stream().mapToInt(mut -> mut.value).sum();
    }

    // Method to initialize the bag
    protected void initializeBag(Map<Object, MutableInteger> map) {
        this.map = map;
        // The modCount is managed internally, so we do not set it here.
    }
}
