package org.apache.commons.collections4.map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.MultiValueMap;
import java.lang.reflect.Method;
import java.util.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.TransformIterator;

public class MultiValueMap_totalSize_17_1_Test {

    private MultiValueMap<String, List<String>> multiValueMap;

    @BeforeEach
    public void setUp() {
        multiValueMap = new MultiValueMap<>(new HashMap<>(), ArrayList::new);
    }

    @Test
    public void testTotalSize_EmptyMap() {
        assertEquals(0, multiValueMap.totalSize());
    }

    @Test
    public void testTotalSize_SingleEmptyCollection() {
        multiValueMap.put("key1", new ArrayList<>());
        assertEquals(0, multiValueMap.totalSize());
    }

    @Test
    public void testTotalSize_SingleNonEmptyCollection() {
        multiValueMap.put("key1", Arrays.asList("value1", "value2"));
        assertEquals(2, multiValueMap.totalSize());
    }

    @Test
    public void testTotalSize_MultipleCollections() {
        multiValueMap.put("key1", Arrays.asList("value1", "value2"));
        multiValueMap.put("key2", Arrays.asList("value3"));
        // empty collection
        multiValueMap.put("key3", new ArrayList<>());
        assertEquals(3, multiValueMap.totalSize());
    }

    @Test
    public void testTotalSize_NestedCollections() {
        multiValueMap.put("key1", Arrays.asList("value1", "value2"));
        multiValueMap.put("key2", Arrays.asList("value3", "value4", "value5"));
        multiValueMap.put("key3", Arrays.asList("value6"));
        assertEquals(6, multiValueMap.totalSize());
    }

    private void invokePrivateMethod(String methodName) throws Exception {
        Method method = MultiValueMap.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(multiValueMap);
    }
}
