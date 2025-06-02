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

class AbstractMapBag_getCount_10_3_Test extends AbstractMapBag {

    private Map<Object, MutableInteger> map;

    @BeforeEach
    void setUp() {
        map = new HashMap<>();
        // Mock the map with some values for testing
        map.put("item1", new MutableInteger(3));
        map.put("item2", new MutableInteger(5));
        map.put("item3", new MutableInteger(0));
    }

    @Override
    protected Map<Object, MutableInteger> getMap() {
        return map;
    }

    @Test
    void testGetCount_ItemExists() {
        assertEquals(3, getCount("item1"), "Count for item1 should be 3");
        assertEquals(5, getCount("item2"), "Count for item2 should be 5");
    }

    @Test
    void testGetCount_ItemNotExists() {
        assertEquals(0, getCount("item4"), "Count for non-existing item should be 0");
    }

    @Test
    void testGetCount_ItemWithZeroCount() {
        assertEquals(0, getCount("item3"), "Count for item3 should be 0");
    }

    @Test
    void testGetCount_NullInput() {
        assertEquals(0, getCount(null), "Count for null input should be 0");
    }

    @Test
    void testGetCount_EmptyMap() {
        map.clear();
        assertEquals(0, getCount("item1"), "Count for item1 in an empty map should be 0");
    }
}
