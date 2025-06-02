package org.apache.commons.collections4.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.TransformIterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class MultiValueMap_put_11_0_Test {

    private MultiValueMap<String, String> multiValueMap;

    @BeforeEach
    void setUp() {
        multiValueMap = new MultiValueMap<>(new HashMap<>(), ArrayList::new);
    }

    @Test
    void testPutNewKey() throws Exception {
        // Test putting a new key-value pair
        Object result = invokePutMethod(multiValueMap, "key1", "value1");
        assertEquals("value1", result);
        // Verify the internal state of the map
        Collection<String> values = multiValueMap.getCollection("key1");
        assertNotNull(values);
        assertTrue(values.contains("value1"));
    }

    @Test
    void testPutExistingKey() throws Exception {
        // Prepare the map with an existing key
        invokePutMethod(multiValueMap, "key1", "value1");
        // Test putting an additional value for the existing key
        Object result = invokePutMethod(multiValueMap, "key1", "value2");
        assertEquals("value2", result);
        // Verify the internal state of the map
        Collection<String> values = multiValueMap.getCollection("key1");
        assertNotNull(values);
        assertTrue(values.contains("value1"));
        assertTrue(values.contains("value2"));
    }

    @Test
    void testPutNullValue() throws Exception {
        // Test putting a null value
        Object result = invokePutMethod(multiValueMap, "key2", null);
        assertNull(result);
        // Verify that the key does not exist
        Collection<String> values = multiValueMap.getCollection("key2");
        assertNull(values);
    }

    @Test
    void testPutNullKey() throws Exception {
        // Test putting a value with a null key
        Object result = invokePutMethod(multiValueMap, null, "value3");
        assertNull(result);
        // Verify that the key does not exist
        Collection<String> values = multiValueMap.getCollection(null);
        assertNull(values);
    }

    private Object invokePutMethod(MultiValueMap<String, String> map, String key, Object value) throws Exception {
        // Buggy Line fixed: Replaced 'var' with 'java.lang.reflect.Method'
        java.lang.reflect.Method method = MultiValueMap.class.getDeclaredMethod("put", Object.class, Object.class);
        method.setAccessible(true);
        return method.invoke(map, key, value);
    }
}
