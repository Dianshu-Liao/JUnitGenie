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

class AbstractMapBag_remove_16_0_Test {

    private AbstractMapBag<Object> bag;

    private Map<Object, MutableInteger> mockMap;

    @BeforeEach
    void setUp() {
        mockMap = new HashMap<>();
        bag = new AbstractMapBag<Object>() {

            @Override
            public int size() {
                return mockMap.values().stream().mapToInt(mutableInteger -> mutableInteger.value).sum();
            }
        };
        // Using reflection to set the private map field for testing
        try {
            java.lang.reflect.Field field = AbstractMapBag.class.getDeclaredField("map");
            field.setAccessible(true);
            field.set(bag, mockMap);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set the map field for testing: " + e.getMessage());
        }
    }

    @Test
    void testRemove_ObjectNotInMap_ReturnsFalse() {
        Object objectToRemove = new Object();
        int copiesToRemove = 1;
        boolean result = bag.remove(objectToRemove, copiesToRemove);
        assertFalse(result, "Expected remove to return false when object is not in the map.");
    }

    @Test
    void testRemove_NegativeCopies_ReturnsFalse() {
        Object objectToRemove = new Object();
        mockMap.put(objectToRemove, new MutableInteger(5));
        int negativeCopies = -1;
        boolean result = bag.remove(objectToRemove, negativeCopies);
        assertFalse(result, "Expected remove to return false when number of copies is negative.");
    }

    @Test
    void testRemove_ZeroCopies_ReturnsFalse() {
        Object objectToRemove = new Object();
        mockMap.put(objectToRemove, new MutableInteger(5));
        int zeroCopies = 0;
        boolean result = bag.remove(objectToRemove, zeroCopies);
        assertFalse(result, "Expected remove to return false when number of copies is zero.");
    }

    @Test
    void testRemove_ValidCopies_RemovesCorrectly() {
        Object objectToRemove = new Object();
        MutableInteger mutableInteger = new MutableInteger(5);
        mockMap.put(objectToRemove, mutableInteger);
        int copiesToRemove = 3;
        boolean result = bag.remove(objectToRemove, copiesToRemove);
        assertTrue(result, "Expected remove to return true when removing valid copies.");
        assertEquals(2, mutableInteger.value, "Expected mutable integer value to be decremented correctly.");
        assertEquals(2, bag.size(), "Expected bag size to be decremented correctly.");
    }

    @Test
    void testRemove_MoreCopiesThanAvailable_RemovesAll() {
        Object objectToRemove = new Object();
        MutableInteger mutableInteger = new MutableInteger(5);
        mockMap.put(objectToRemove, mutableInteger);
        int copiesToRemove = 10;
        boolean result = bag.remove(objectToRemove, copiesToRemove);
        assertTrue(result, "Expected remove to return true when removing more copies than available.");
        assertFalse(mockMap.containsKey(objectToRemove), "Expected object to be removed from the map.");
        assertEquals(0, bag.size(), "Expected bag size to be zero after removing all copies.");
    }
}

class MutableInteger {

    int value;

    MutableInteger(int value) {
        this.value = value;
    }
}
