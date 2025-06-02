package org.apache.commons.collections4.bidimap;

import org.apache.commons.collections4.bidimap.TreeBidiMap;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.collections4.bidimap.TreeBidiMap.DataElement.KEY;
import static org.apache.commons.collections4.bidimap.TreeBidiMap.DataElement.VALUE;
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

public class TreeBidiMap_containsValue_11_0_Test {

    private TreeBidiMap<String, Integer> treeBidiMap;

    @BeforeEach
    public void setUp() {
        treeBidiMap = new TreeBidiMap<>();
        // Populate the map with some test data
        treeBidiMap.put("One", 1);
        treeBidiMap.put("Two", 2);
        treeBidiMap.put("Three", 3);
    }

    @Test
    public void testContainsValue_ExistingValue() {
        assertTrue(treeBidiMap.containsValue(1));
    }

    @Test
    public void testContainsValue_NonExistingValue() {
        assertFalse(treeBidiMap.containsValue(4));
    }

    @Test
    public void testContainsValue_NullValue() {
        assertThrows(NullPointerException.class, () -> {
            treeBidiMap.containsValue(null);
        });
    }

    @Test
    public void testContainsValue_EmptyMap() {
        TreeBidiMap<String, Integer> emptyMap = new TreeBidiMap<>();
        assertFalse(emptyMap.containsValue(1));
    }

    @Test
    public void testContainsValue_NegativeValue() {
        assertFalse(treeBidiMap.containsValue(-1));
    }

    @Test
    public void testContainsValue_DifferentType() {
        assertFalse(treeBidiMap.containsValue("One"));
    }

    // Reflection test for private methods
    @Test
    public void testCheckValue_Reflection() throws Exception {
        Method checkValueMethod = TreeBidiMap.class.getDeclaredMethod("checkValue", Object.class);
        checkValueMethod.setAccessible(true);
        // This should not throw an exception
        checkValueMethod.invoke(null, 1);
        // This should throw a NullPointerException
        assertThrows(NullPointerException.class, () -> {
            checkValueMethod.invoke(null, null);
        });
    }

    @Test
    public void testLookupValue_Reflection() throws Exception {
        Method lookupValueMethod = TreeBidiMap.class.getDeclaredMethod("lookupValue", Object.class);
        lookupValueMethod.setAccessible(true);
        // Test with existing value
        assertNotNull(lookupValueMethod.invoke(treeBidiMap, 1));
        // Test with non-existing value
        assertNull(lookupValueMethod.invoke(treeBidiMap, 4));
    }
}
