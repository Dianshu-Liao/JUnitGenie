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

class AbstractMapBag_remove_15_1_Test {

    private AbstractMapBag bag;

    private Map<Object, AbstractMapBag.MutableInteger> mockMap;

    @BeforeEach
    void setUp() {
        mockMap = new HashMap<>();
        bag = new AbstractMapBag() {

            {
                setMap(mockMap);
            }

            @Override
            public int size() {
                return mockMap.values().stream().mapToInt(mut -> mut.value).sum();
            }

            protected void setMap(Map<Object, MutableInteger> map) {
                // Use reflection to set the private 'map' variable
                try {
                    java.lang.reflect.Field field = AbstractMapBag.class.getDeclaredField("map");
                    field.setAccessible(true);
                    field.set(this, map);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    @Test
    void testRemove_ObjectPresent() {
        Object objectToRemove = "testObject";
        AbstractMapBag.MutableInteger mutableInteger = new AbstractMapBag.MutableInteger(3);
        mockMap.put(objectToRemove, mutableInteger);
        boolean result = bag.remove(objectToRemove);
        assertTrue(result);
        assertFalse(mockMap.containsKey(objectToRemove));
        assertEquals(0, bag.size());
    }

    @Test
    void testRemove_ObjectNotPresent() {
        Object objectToRemove = "nonExistentObject";
        boolean result = bag.remove(objectToRemove);
        assertFalse(result);
        assertEquals(0, bag.size());
    }

    @Test
    void testRemove_NullObject() {
        Object objectToRemove = null;
        AbstractMapBag.MutableInteger mutableInteger = new AbstractMapBag.MutableInteger(1);
        mockMap.put(objectToRemove, mutableInteger);
        boolean result = bag.remove(objectToRemove);
        assertTrue(result);
        assertFalse(mockMap.containsKey(objectToRemove));
        assertEquals(0, bag.size());
    }
}
