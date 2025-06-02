// Test method
package org.apache.commons.collections4.bidimap;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections4.keyvalue.UnmodifiableMapEntry;
import static org.apache.commons.collections4.bidimap.TreeBidiMap.DataElement.KEY;
import static org.apache.commons.collections4.bidimap.TreeBidiMap.DataElement.VALUE;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TreeBidiMap_doEquals_13_1_Test {

    private TreeBidiMap<String, String> treeBidiMap;

    @BeforeEach
    void setUp() {
        treeBidiMap = new TreeBidiMap<>();
    }

    @Test
    void testDoEquals_SameInstance() throws Exception {
        // Test case where obj is the same instance
        boolean result = invokeDoEquals(treeBidiMap, treeBidiMap, null);
        assertTrue(result);
    }

    @Test
    void testDoEquals_NonMapObject() throws Exception {
        // Test case where obj is not a Map
        boolean result = invokeDoEquals(treeBidiMap, new Object(), null);
        assertFalse(result);
    }

    @Test
    void testDoEquals_DifferentSize() throws Exception {
        // Test case where the other Map has a different size
        Map<String, String> otherMap = new HashMap<>();
        otherMap.put("key1", "value1");
        boolean result = invokeDoEquals(treeBidiMap, otherMap, null);
        assertFalse(result);
    }

    @Test
    void testDoEquals_ValuesNotEqual() throws Exception {
        // Test case where the values in the maps are not equal
        treeBidiMap.put("key1", "value1");
        Map<String, String> otherMap = new HashMap<>();
        otherMap.put("key1", "value2");
        boolean result = invokeDoEquals(treeBidiMap, otherMap, null);
        assertFalse(result);
    }

    @Test
    void testDoEquals_EqualMaps() throws Exception {
        // Test case where the maps are equal
        treeBidiMap.put("key1", "value1");
        Map<String, String> otherMap = new HashMap<>();
        otherMap.put("key1", "value1");
        boolean result = invokeDoEquals(treeBidiMap, otherMap, null);
        assertTrue(result);
    }

    @Test
    void testDoEquals_ClassCastException() throws Exception {
        // Test case where a ClassCastException occurs
        treeBidiMap.put("key1", "value1");
        Map<Object, Object> otherMap = new HashMap<>();
        otherMap.put(new Object(), new Object());
        boolean result = invokeDoEquals(treeBidiMap, otherMap, null);
        assertFalse(result);
    }

    @Test
    void testDoEquals_NullPointerException() throws Exception {
        // Test case where a NullPointerException occurs
        treeBidiMap.put("key1", null);
        Map<String, String> otherMap = new HashMap<>();
        otherMap.put("key1", "value1");
        boolean result = invokeDoEquals(treeBidiMap, otherMap, null);
        assertFalse(result);
    }

    private boolean invokeDoEquals(TreeBidiMap<String, String> treeBidiMap, Object obj, Object dataElement) throws Exception {
        // Fixed line: changed 'var' to 'Method' to explicitly declare the type
        java.lang.reflect.Method method = TreeBidiMap.class.getDeclaredMethod("doEquals", Object.class, Object.class);
        method.setAccessible(true);
        return (boolean) method.invoke(treeBidiMap, obj, dataElement);
    }
}
