package org.apache.commons.collections4.bidimap;

import org.apache.commons.collections4.bidimap.TreeBidiMap;
import java.lang.reflect.Method;
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
import java.util.Map;
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
        // Adding some initial values to the map
        treeBidiMap.put("One", 1);
        treeBidiMap.put("Two", 2);
        treeBidiMap.put("Three", 3);
    }

    @Test
    void testDoRemoveValue_ExistingValue() throws Exception {
        // Invoke the private method doRemoveValue with an existing value
        String removedKey = invokeDoRemoveValue(treeBidiMap, 2);
        assertEquals("Two", removedKey);
        // Verify the value is removed
        assertNull(treeBidiMap.getKey(2));
    }

    @Test
    void testDoRemoveValue_NonExistingValue() throws Exception {
        // Invoke the private method doRemoveValue with a non-existing value
        String removedKey = invokeDoRemoveValue(treeBidiMap, 4);
        assertNull(removedKey);
    }

    @Test
    void testDoRemoveValue_NullValue() throws Exception {
        // Invoke the private method doRemoveValue with null
        String removedKey = invokeDoRemoveValue(treeBidiMap, null);
        assertNull(removedKey);
    }

    private String invokeDoRemoveValue(TreeBidiMap<String, Integer> map, Object value) throws Exception {
        // Use reflection to invoke the private method
        Method method = TreeBidiMap.class.getDeclaredMethod("doRemoveValue", Object.class);
        method.setAccessible(true);
        return (String) method.invoke(map, value);
    }
}
