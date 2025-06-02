package org.apache.commons.collections4.bidimap;

import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap.DataElement;
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

class TreeBidiMap_doEquals_13_0_Test {

    private TreeBidiMap<String, String> treeBidiMap;

    @BeforeEach
    void setUp() {
        treeBidiMap = new TreeBidiMap<>();
    }

    @Test
    void testDoEquals_SameInstance() throws Exception {
        Method doEqualsMethod = TreeBidiMap.class.getDeclaredMethod("doEquals", Object.class, DataElement.class);
        doEqualsMethod.setAccessible(true);
        boolean result = (boolean) doEqualsMethod.invoke(treeBidiMap, treeBidiMap, DataElement.KEY);
        assertTrue(result);
    }

    @Test
    void testDoEquals_NonMapObject() throws Exception {
        Method doEqualsMethod = TreeBidiMap.class.getDeclaredMethod("doEquals", Object.class, DataElement.class);
        doEqualsMethod.setAccessible(true);
        boolean result = (boolean) doEqualsMethod.invoke(treeBidiMap, new Object(), DataElement.KEY);
        assertFalse(result);
    }

    @Test
    void testDoEquals_DifferentSize() throws Exception {
        Method doEqualsMethod = TreeBidiMap.class.getDeclaredMethod("doEquals", Object.class, DataElement.class);
        doEqualsMethod.setAccessible(true);
        Map<String, String> otherMap = new HashMap<>();
        otherMap.put("key1", "value1");
        boolean result = (boolean) doEqualsMethod.invoke(treeBidiMap, otherMap, DataElement.KEY);
        assertFalse(result);
    }

    @Test
    void testDoEquals_DifferentValues() throws Exception {
        Method doEqualsMethod = TreeBidiMap.class.getDeclaredMethod("doEquals", Object.class, DataElement.class);
        doEqualsMethod.setAccessible(true);
        treeBidiMap.put("key1", "value1");
        Map<String, String> otherMap = new HashMap<>();
        otherMap.put("key1", "value2");
        boolean result = (boolean) doEqualsMethod.invoke(treeBidiMap, otherMap, DataElement.KEY);
        assertFalse(result);
    }

    @Test
    void testDoEquals_ValidEqualMap() throws Exception {
        Method doEqualsMethod = TreeBidiMap.class.getDeclaredMethod("doEquals", Object.class, DataElement.class);
        doEqualsMethod.setAccessible(true);
        treeBidiMap.put("key1", "value1");
        Map<String, String> otherMap = new HashMap<>();
        otherMap.put("key1", "value1");
        boolean result = (boolean) doEqualsMethod.invoke(treeBidiMap, otherMap, DataElement.KEY);
        assertTrue(result);
    }

    @Test
    void testDoEquals_ClassCastException() throws Exception {
        Method doEqualsMethod = TreeBidiMap.class.getDeclaredMethod("doEquals", Object.class, DataElement.class);
        doEqualsMethod.setAccessible(true);
        Map<Object, Object> otherMap = mock(Map.class);
        when(otherMap.size()).thenReturn(1);
        when(otherMap.get(any())).thenThrow(new ClassCastException());
        boolean result = (boolean) doEqualsMethod.invoke(treeBidiMap, otherMap, DataElement.KEY);
        assertFalse(result);
    }

    @Test
    void testDoEquals_NullPointerException() throws Exception {
        Method doEqualsMethod = TreeBidiMap.class.getDeclaredMethod("doEquals", Object.class, DataElement.class);
        doEqualsMethod.setAccessible(true);
        Map<Object, Object> otherMap = mock(Map.class);
        when(otherMap.size()).thenReturn(1);
        when(otherMap.get(any())).thenThrow(new NullPointerException());
        boolean result = (boolean) doEqualsMethod.invoke(treeBidiMap, otherMap, DataElement.KEY);
        assertFalse(result);
    }
}
