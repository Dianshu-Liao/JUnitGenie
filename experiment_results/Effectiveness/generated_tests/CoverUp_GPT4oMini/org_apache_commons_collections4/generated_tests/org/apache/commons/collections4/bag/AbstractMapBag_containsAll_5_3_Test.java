package org.apache.commons.collections4.bag;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.AbstractMapBag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.AbstractMapBag.MutableInteger;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.set.UnmodifiableSet;

class AbstractMapBag_containsAll_5_3_Test {

    private class TestMapBag extends AbstractMapBag<Object> {

        public TestMapBag(Map<Object, MutableInteger> map) {
            super(map);
        }

        @Override
        public int getCount(final Object object) {
            final MutableInteger count = getMap().get(object);
            return count != null ? count.value : 0;
        }

        @Override
        public boolean add(Object item, int count) {
            try {
                Field mapField = AbstractMapBag.class.getDeclaredField("map");
                mapField.setAccessible(true);
                Map<Object, MutableInteger> map = (Map<Object, MutableInteger>) mapField.get(this);
                map.put(item, new MutableInteger(count));
                // Return true to match the Bag interface
                return true;
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        public Set<Object> uniqueSet() {
            return getMap().keySet();
        }
    }

    private TestMapBag testMapBag;

    @BeforeEach
    public void setUp() {
        Map<Object, MutableInteger> map = new HashMap<>();
        testMapBag = new TestMapBag(map);
    }

    @Test
    public void testContainsAll_withAllCountsMet() {
        Bag<Object> otherBag = new HashBag<>();
        otherBag.add("item1", 2);
        otherBag.add("item2", 3);
        testMapBag.add("item1", 2);
        testMapBag.add("item2", 3);
        assertTrue(testMapBag.containsAll(otherBag));
    }

    @Test
    public void testContainsAll_withInsufficientCount() {
        Bag<Object> otherBag = new HashBag<>();
        otherBag.add("item1", 2);
        otherBag.add("item2", 4);
        testMapBag.add("item1", 2);
        testMapBag.add("item2", 3);
        assertFalse(testMapBag.containsAll(otherBag));
    }

    @Test
    public void testContainsAll_withMissingItem() {
        Bag<Object> otherBag = new HashBag<>();
        otherBag.add("item1", 1);
        // This item is not in the testMapBag
        otherBag.add("item3", 1);
        testMapBag.add("item1", 2);
        assertFalse(testMapBag.containsAll(otherBag));
    }

    @Test
    public void testContainsAll_withEmptyBag() {
        // Empty bag
        Bag<Object> otherBag = new HashBag<>();
        // Should return true
        assertTrue(testMapBag.containsAll(otherBag));
    }
}
