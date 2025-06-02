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

    private AbstractMapBag mapBag;

    private Map<Object, MutableInteger> mockMap;

    @BeforeEach
    void setUp() {
        mockMap = mock(Map.class);
        mapBag = new AbstractMapBag(mockMap) {
        };
    }

    @Test
    void testRemove_ObjectNotInMap() {
        // Arrange
        Object object = new Object();
        int nCopies = 1;
        when(mockMap.get(object)).thenReturn(null);
        // Act
        boolean result = mapBag.remove(object, nCopies);
        // Assert
        assertFalse(result);
        verify(mockMap).get(object);
    }

    @Test
    void testRemove_NCopiesLessThanOrEqualToZero() {
        // Arrange
        Object object = new Object();
        int nCopies = 0;
        MutableInteger mutableInteger = new MutableInteger(5);
        when(mockMap.get(object)).thenReturn(mutableInteger);
        // Act
        boolean result = mapBag.remove(object, nCopies);
        // Assert
        assertFalse(result);
        verify(mockMap).get(object);
    }

    @Test
    void testRemove_NCopiesLessThanAvailable() {
        // Arrange
        Object object = new Object();
        int nCopies = 2;
        MutableInteger mutableInteger = new MutableInteger(5);
        when(mockMap.get(object)).thenReturn(mutableInteger);
        // Act
        boolean result = mapBag.remove(object, nCopies);
        // Assert
        assertTrue(result);
        assertEquals(3, mutableInteger.value);
        verify(mockMap).get(object);
        // Ensure remove not called
        verify(mockMap, never()).remove(object);
    }

    @Test
    void testRemove_NCopiesEqualToAvailable() {
        // Arrange
        Object object = new Object();
        int nCopies = 5;
        MutableInteger mutableInteger = new MutableInteger(5);
        when(mockMap.get(object)).thenReturn(mutableInteger);
        // Act
        boolean result = mapBag.remove(object, nCopies);
        // Assert
        assertTrue(result);
        assertEquals(0, mutableInteger.value);
        verify(mockMap).get(object);
        verify(mockMap).remove(object);
    }

    @Test
    void testRemove_NCopiesGreaterThanAvailable() {
        // Arrange
        Object object = new Object();
        int nCopies = 10;
        MutableInteger mutableInteger = new MutableInteger(5);
        when(mockMap.get(object)).thenReturn(mutableInteger);
        // Act
        boolean result = mapBag.remove(object, nCopies);
        // Assert
        assertTrue(result);
        assertEquals(0, mutableInteger.value);
        verify(mockMap).get(object);
        verify(mockMap).remove(object);
    }

    // Additional helper class for testing
    static class MutableInteger {

        int value;

        MutableInteger(int value) {
            this.value = value;
        }
    }
}
