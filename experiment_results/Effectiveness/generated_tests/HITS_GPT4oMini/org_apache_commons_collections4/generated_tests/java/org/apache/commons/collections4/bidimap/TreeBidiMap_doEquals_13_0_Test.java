package org.apache.commons.collections4.bidimap;

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

public class TreeBidiMap_doEquals_13_0_Test {

    private static class TestableTreeBidiMap extends TreeBidiMap<String, String> {

        public boolean testDoEquals(Object obj, DataElement dataElement) {
            try {
                java.lang.reflect.Method method = TreeBidiMap.class.getDeclaredMethod("doEquals", Object.class, DataElement.class);
                method.setAccessible(true);
                return (Boolean) method.invoke(this, obj, dataElement);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private TestableTreeBidiMap treeBidiMap;

    @BeforeEach
    public void setUp() {
        treeBidiMap = new TestableTreeBidiMap();
    }

    @Test
    public void testDoEquals_SameInstance() {
        assertTrue(treeBidiMap.testDoEquals(treeBidiMap, TreeBidiMap.DataElement.KEY), "Should return true for the same instance");
    }

    @Test
    public void testDoEquals_NullObject() {
        assertFalse(treeBidiMap.testDoEquals(null, TreeBidiMap.DataElement.KEY), "Should return false for null object");
    }

    @Test
    public void testDoEquals_DifferentType() {
        assertFalse(treeBidiMap.testDoEquals("Not a Map", TreeBidiMap.DataElement.KEY), "Should return false for non-Map object");
    }

    @Test
    public void testDoEquals_DifferentSize() {
        Map<String, String> otherMap = new HashMap<>();
        otherMap.put("key1", "value1");
        assertFalse(treeBidiMap.testDoEquals(otherMap, TreeBidiMap.DataElement.KEY), "Should return false for maps of different sizes");
    }

    @Test
    public void testDoEquals_EqualMaps() {
        treeBidiMap.put("key1", "value1");
        Map<String, String> otherMap = new HashMap<>();
        otherMap.put("key1", "value1");
        assertTrue(treeBidiMap.testDoEquals(otherMap, TreeBidiMap.DataElement.KEY), "Should return true for equal maps");
    }
}
