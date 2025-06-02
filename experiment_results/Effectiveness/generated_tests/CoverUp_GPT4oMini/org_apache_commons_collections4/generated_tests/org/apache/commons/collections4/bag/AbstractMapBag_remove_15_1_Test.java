package org.apache.commons.collections4.bag;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.AbstractMapBag;
import org.apache.commons.collections4.set.UnmodifiableSet;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AbstractMapBag_remove_15_1_Test {

    private static class MutableInteger {

        int value;

        MutableInteger(int value) {
            this.value = value;
        }
    }

    private class TestMapBag extends AbstractMapBag<String> {

        protected TestMapBag() {
            super(new HashMap<>());
        }
    }

    private TestMapBag bag;

    private Map<String, MutableInteger> map;

    @BeforeEach
    void setUp() {
        map = new HashMap<>();
        bag = new TestMapBag();
        setField(bag, "map", map);
        setField(bag, "size", 0);
        setField(bag, "modCount", 0);
    }

    private void setField(Object target, String fieldName, Object value) {
        try {
            Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Object getField(Object target, String fieldName) {
        try {
            Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(target);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testRemoveNonExistentElement() {
        assertFalse(bag.remove("nonExistent"));
    }

    @Test
    void testRemoveExistentElement() {
        MutableInteger count = new MutableInteger(3);
        map.put("item", count);
        setField(bag, "size", 3);
        assertTrue(bag.remove("item"));
        assertFalse(map.containsKey("item"));
        assertEquals(0, getField(bag, "size"));
    }

    @Test
    void testRemoveUpdatesModCount() {
        MutableInteger count = new MutableInteger(2);
        map.put("item", count);
        setField(bag, "size", 2);
        int initialModCount = (int) getField(bag, "modCount");
        bag.remove("item");
        int updatedModCount = (int) getField(bag, "modCount");
        assertEquals(initialModCount + 1, updatedModCount);
    }
}
