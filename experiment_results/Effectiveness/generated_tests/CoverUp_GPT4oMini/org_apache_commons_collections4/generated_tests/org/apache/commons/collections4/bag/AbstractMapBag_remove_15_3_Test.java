package org.apache.commons.collections4.bag;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections4.bag.AbstractMapBag;
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

class AbstractMapBag_remove_15_3_Test {

    static class MutableInteger {

        int value;

        MutableInteger(int value) {
            this.value = value;
        }
    }

    private AbstractMapBag<String> bag;

    private Map<String, MutableInteger> mockMap;

    @BeforeEach
    void setUp() {
        mockMap = new HashMap<>();
        bag = Mockito.mock(AbstractMapBag.class, Mockito.withSettings().useConstructor(mockMap).defaultAnswer(Mockito.CALLS_REAL_METHODS));
    }

    @Test
    void testRemoveNonExistentElement() {
        // Arrange
        String element = "nonExistent";
        when(mockMap.get(element)).thenReturn(null);
        // Act
        boolean result = bag.remove(element);
        // Assert
        assertFalse(result);
        verify(mockMap).get(element);
        verify(mockMap, never()).remove(any());
        assertEquals(0, invokePrivateSize(bag));
    }

    @Test
    void testRemoveExistentElement() {
        // Arrange
        String element = "existent";
        MutableInteger mutableInteger = new MutableInteger(3);
        mockMap.put(element, mutableInteger);
        when(mockMap.get(element)).thenReturn(mutableInteger);
        // Act
        boolean result = bag.remove(element);
        // Assert
        assertTrue(result);
        verify(mockMap).get(element);
        verify(mockMap).remove(element);
        assertEquals(0, invokePrivateSize(bag));
    }

    @Test
    void testRemoveUpdatesModCount() {
        // Arrange
        String element = "element";
        MutableInteger mutableInteger = new MutableInteger(2);
        mockMap.put(element, mutableInteger);
        when(mockMap.get(element)).thenReturn(mutableInteger);
        // Act
        bag.remove(element);
        // Assert
        assertEquals(1, invokePrivateModCount(bag));
    }

    private int invokePrivateSize(AbstractMapBag<?> bag) {
        try {
            java.lang.reflect.Field sizeField = AbstractMapBag.class.getDeclaredField("size");
            sizeField.setAccessible(true);
            return (int) sizeField.get(bag);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int invokePrivateModCount(AbstractMapBag<?> bag) {
        try {
            java.lang.reflect.Field modCountField = AbstractMapBag.class.getDeclaredField("modCount");
            modCountField.setAccessible(true);
            return (int) modCountField.get(bag);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
