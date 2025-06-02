package org.apache.commons.collections4.bidimap;

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

class TreeBidiMap_doRemoveValue_20_0_Test {

    private TreeBidiMap<String, Integer> treeBidiMap;

    @BeforeEach
    void setUp() {
        treeBidiMap = new TreeBidiMap<>();
        // Add test data to the map
        treeBidiMap.put("One", 1);
        treeBidiMap.put("Two", 2);
        treeBidiMap.put("Three", 3);
    }

    @Test
    void testDoRemoveValue_ValueExists() throws Exception {
        // Invoke the private method
        Method method = TreeBidiMap.class.getDeclaredMethod("doRemoveValue", Object.class);
        method.setAccessible(true);
        // Test removing an existing value
        Object result = method.invoke(treeBidiMap, 2);
        assertEquals("Two", result);
    }

    @Test
    void testDoRemoveValue_ValueDoesNotExist() throws Exception {
        // Invoke the private method
        Method method = TreeBidiMap.class.getDeclaredMethod("doRemoveValue", Object.class);
        method.setAccessible(true);
        // Test removing a non-existing value
        Object result = method.invoke(treeBidiMap, 4);
        assertNull(result);
    }

    @Test
    void testDoRemoveValue_NullValue() throws Exception {
        // Invoke the private method
        Method method = TreeBidiMap.class.getDeclaredMethod("doRemoveValue", Object.class);
        method.setAccessible(true);
        // Test removing a null value
        Object result = method.invoke(treeBidiMap, null);
        assertNull(result);
    }
}
