package org.apache.commons.collections4.bidimap;

import java.util.HashMap;
import java.util.Map;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TreeBidiMap_previousKey_49_0_Test {

    private TreeBidiMap<String, Integer> treeBidiMap;

    @BeforeEach
    void setUp() {
        treeBidiMap = new TreeBidiMap<>();
        treeBidiMap.put("a", 1);
        treeBidiMap.put("b", 2);
        treeBidiMap.put("c", 3);
    }

    @Test
    void testPreviousKey_ReturnsPreviousKey() throws Exception {
        // Assuming "b" is the current key, the previous key should be "a"
        assertEquals("a", invokePreviousKey("b"));
    }

    @Test
    void testPreviousKey_ReturnsNull_WhenNoPreviousKey() throws Exception {
        // "a" has no previous key
        assertNull(invokePreviousKey("a"));
    }

    @Test
    void testPreviousKey_ReturnsNull_WhenKeyNotPresent() throws Exception {
        // Key "d" is not present in the map
        assertNull(invokePreviousKey("d"));
    }

    @Test
    void testPreviousKey_ThrowsException_WhenKeyIsNull() {
        assertThrows(IllegalArgumentException.class, () -> invokePreviousKey(null));
    }

    private String invokePreviousKey(String key) throws Exception {
        // Using reflection to access the private method
        java.lang.reflect.Method method = TreeBidiMap.class.getDeclaredMethod("previousKey", Object.class);
        method.setAccessible(true);
        return (String) method.invoke(treeBidiMap, key);
    }
}
