package org.apache.commons.collections4.bag;

import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Method;
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
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.set.UnmodifiableSet;

class AbstractMapBag_remove_15_0_Test {

    private AbstractMapBag bag;

    private Map<String, MutableInteger> mockMap;

    @BeforeEach
    void setUp() {
        mockMap = new HashMap<>();
        bag = new AbstractMapBag(mockMap) {
        };
    }

    @Test
    void testRemoveObjectNotInMap() throws Exception {
        // Given
        Object object = "test";
        // When
        boolean result = invokeRemove(bag, object);
        // Then
        assertFalse(result);
        assertEquals(0, getFieldValue(bag, "size"));
        assertEquals(0, getFieldValue(bag, "modCount"));
    }

    @Test
    void testRemoveObjectInMap() throws Exception {
        // Given
        String object = "test";
        MutableInteger mutableInteger = new MutableInteger(3);
        mockMap.put(object, mutableInteger);
        setFieldValue(bag, "size", 3);
        // When
        boolean result = invokeRemove(bag, object);
        // Then
        assertTrue(result);
        assertEquals(0, getFieldValue(bag, "size"));
        assertEquals(1, getFieldValue(bag, "modCount"));
        assertFalse(mockMap.containsKey(object));
    }

    @Test
    void testRemoveObjectInMapMultipleTimes() throws Exception {
        // Given
        String object = "test";
        MutableInteger mutableInteger = new MutableInteger(2);
        mockMap.put(object, mutableInteger);
        setFieldValue(bag, "size", 2);
        // When
        // First removal
        invokeRemove(bag, object);
        // Second removal
        boolean result = invokeRemove(bag, object);
        // Then
        assertTrue(result);
        assertEquals(0, getFieldValue(bag, "size"));
        assertEquals(2, getFieldValue(bag, "modCount"));
        assertFalse(mockMap.containsKey(object));
    }

    // Reflection methods to access private methods and fields
    private boolean invokeRemove(AbstractMapBag bag, Object object) throws Exception {
        Method method = AbstractMapBag.class.getDeclaredMethod("remove", Object.class);
        method.setAccessible(true);
        return (boolean) method.invoke(bag, object);
    }

    private int getFieldValue(AbstractMapBag bag, String fieldName) throws Exception {
        Field field = AbstractMapBag.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return (int) field.get(bag);
    }

    private void setFieldValue(AbstractMapBag bag, String fieldName, int value) throws Exception {
        Field field = AbstractMapBag.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(bag, value);
    }
}

class MutableInteger {

    int value;

    MutableInteger(int value) {
        this.value = value;
    }
}
