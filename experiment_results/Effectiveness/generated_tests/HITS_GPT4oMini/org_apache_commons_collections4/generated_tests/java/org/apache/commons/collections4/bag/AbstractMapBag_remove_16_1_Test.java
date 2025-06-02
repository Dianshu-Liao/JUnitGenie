package org.apache.commons.collections4.bag;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.set.UnmodifiableSet;
import java.lang.reflect.Field;
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
import org.apache.commons.collections4.CollectionUtils;

class AbstractMapBag_remove_16_1_Test {

    private AbstractMapBag<String> bag;

    private Map<String, MutableInteger> mockMap;

    static class MutableInteger {

        int value;

        MutableInteger(int value) {
            this.value = value;
        }
    }

    @BeforeEach
    void setUp() throws Exception {
        mockMap = new HashMap<>();
        bag = new AbstractMapBag<String>() {

            {
                try {
                    Field mapField = AbstractMapBag.class.getDeclaredField("map");
                    mapField.setAccessible(true);
                    mapField.set(this, mockMap);
                    Field sizeField = AbstractMapBag.class.getDeclaredField("size");
                    sizeField.setAccessible(true);
                    sizeField.set(this, 0);
                    Field modCountField = AbstractMapBag.class.getDeclaredField("modCount");
                    modCountField.setAccessible(true);
                    modCountField.set(this, 0);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    @Test
    void testRemove_NonExistentElement() {
        assertFalse(bag.remove("nonexistent", 1));
    }

    @Test
    void testRemove_ZeroCopies() {
        MutableInteger existingCount = new MutableInteger(3);
        mockMap.put("element", existingCount);
        assertFalse(bag.remove("element", 0));
        assertEquals(3, existingCount.value);
    }

    @Test
    void testRemove_LessThanCurrentCopies() {
        MutableInteger existingCount = new MutableInteger(5);
        mockMap.put("element", existingCount);
        bag.remove("element", 2);
        assertEquals(3, existingCount.value);
    }

    @Test
    void testRemove_ExactCopies() {
        MutableInteger existingCount = new MutableInteger(4);
        mockMap.put("element", existingCount);
        bag.remove("element", 4);
        assertFalse(mockMap.containsKey("element"));
    }

    @Test
    void testRemove_MoreThanCurrentCopies() {
        MutableInteger existingCount = new MutableInteger(2);
        mockMap.put("element", existingCount);
        bag.remove("element", 5);
        assertFalse(mockMap.containsKey("element"));
    }

    @Test
    void testRemove_ConcurrentModification() {
        MutableInteger existingCount = new MutableInteger(1);
        mockMap.put("element", existingCount);
        bag.remove("element", 1);
        assertFalse(mockMap.containsKey("element"));
    }
}
