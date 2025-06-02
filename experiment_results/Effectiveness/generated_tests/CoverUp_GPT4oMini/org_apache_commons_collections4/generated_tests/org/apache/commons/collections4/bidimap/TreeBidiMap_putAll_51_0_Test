package org.apache.commons.collections4.bidimap;

import org.apache.commons.collections4.bidimap.TreeBidiMap;
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

class // Reflection test to access private method if needed
// This part is optional and can be included if you want to test private methods
// private void invokePrivateMethod(String methodName, Object... args) throws Exception {
// Method method = TreeBidiMap.class.getDeclaredMethod(methodName, /* parameter types */);
// method.setAccessible(true);
// method.invoke(treeBidiMap, args);
// }
TreeBidiMap_putAll_51_0_Test {

    private TreeBidiMap<String, Integer> treeBidiMap;

    @BeforeEach
    void setUp() {
        treeBidiMap = new TreeBidiMap<>();
    }

    @Test
    void testPutAllWithEmptyMap() {
        Map<String, Integer> emptyMap = new HashMap<>();
        treeBidiMap.putAll(emptyMap);
        assertEquals(0, treeBidiMap.size());
    }

    @Test
    void testPutAllWithNonEmptyMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        treeBidiMap.putAll(map);
        assertEquals(2, treeBidiMap.size());
        assertEquals(1, treeBidiMap.get("One"));
        assertEquals(2, treeBidiMap.get("Two"));
    }

    @Test
    void testPutAllWithDuplicateKeys() {
        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        // Duplicate key, should update the value
        map.put("One", 2);
        treeBidiMap.putAll(map);
        assertEquals(1, treeBidiMap.size());
        assertEquals(2, treeBidiMap.get("One"));
    }

    @Test
    void testPutAllWithNullValues() {
        Map<String, Integer> map = new HashMap<>();
        map.put("One", null);
        treeBidiMap.putAll(map);
        assertEquals(1, treeBidiMap.size());
        assertNull(treeBidiMap.get("One"));
    }

    @Test
    void testPutAllWithNullKeys() {
        Map<String, Integer> map = new HashMap<>();
        map.put(null, 1);
        treeBidiMap.putAll(map);
        assertEquals(1, treeBidiMap.size());
        assertEquals(1, treeBidiMap.get(null));
    }

    @Test
    void testPutAllWithConcurrentModification() {
        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        // Simulate concurrent modification
        assertThrows(ConcurrentModificationException.class, () -> {
            treeBidiMap.putAll(map);
            // Modify while iterating
            treeBidiMap.put("Three", 3);
        });
    }
}
