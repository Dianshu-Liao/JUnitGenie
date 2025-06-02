package org.apache.commons.collections4.map;

import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.TransformIterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MultiValueMap_MultiValueMap_20_0_Test {

    private MultiValueMap<String, String> multiValueMap;

    @BeforeEach
    void setUp() {
        multiValueMap = new MultiValueMap<>();
    }

    @Test
    void testMultiValueMapConstructor() {
        assertNotNull(multiValueMap);
    }

    @Test
    void testPutAndGet() {
        multiValueMap.put("key1", "value1");
        assertEquals(1, multiValueMap.size("key1"));
        assertTrue(multiValueMap.getCollection("key1").contains("value1"));
    }

    @Test
    void testPutAll() {
        Map<String, Collection<String>> map = new HashMap<>();
        map.put("key2", new ArrayList<>(Arrays.asList("value2a", "value2b")));
        multiValueMap.putAll(map);
        assertEquals(2, multiValueMap.size("key2"));
        assertTrue(multiValueMap.getCollection("key2").contains("value2a"));
        assertTrue(multiValueMap.getCollection("key2").contains("value2b"));
    }

    @Test
    void testContainsValue() {
        multiValueMap.put("key3", "value3");
        assertTrue(multiValueMap.containsValue("value3"));
        assertFalse(multiValueMap.containsValue("value4"));
    }

    @Test
    void testRemoveMapping() {
        multiValueMap.put("key4", "value4");
        assertTrue(multiValueMap.removeMapping("key4", "value4"));
        assertFalse(multiValueMap.getCollection("key4").contains("value4"));
    }

    @Test
    void testTotalSize() {
        multiValueMap.put("key5", "value5");
        multiValueMap.put("key5", "value6");
        assertEquals(2, multiValueMap.totalSize());
    }

    @Test
    void testClear() {
        multiValueMap.put("key6", "value7");
        multiValueMap.clear();
        assertEquals(0, multiValueMap.totalSize());
    }

    @Test
    void testValues() {
        multiValueMap.put("key7", "value8");
        assertNotNull(multiValueMap.values());
        assertTrue(multiValueMap.values().contains("value8"));
    }
}
