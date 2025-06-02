package org.apache.commons.collections4.map;

import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.map.MultiValueMap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.TransformIterator;

class MultiValueMap_containsValue_5_0_Test {

    private MultiValueMap<String, String> multiValueMap;

    @BeforeEach
    void setUp() {
        multiValueMap = new MultiValueMap<>(new HashMap<>(), ArrayList::new);
    }

    @Test
    void testContainsValue_withExistingKeyAndValue() throws Exception {
        // Setup
        multiValueMap.put("key1", "value1");
        multiValueMap.put("key1", "value2");
        // Test
        assertTrue(multiValueMap.containsValue("key1", "value1"));
        assertTrue(multiValueMap.containsValue("key1", "value2"));
    }

    @Test
    void testContainsValue_withExistingKeyAndNonExistingValue() throws Exception {
        // Setup
        multiValueMap.put("key1", "value1");
        // Test
        assertFalse(multiValueMap.containsValue("key1", "value2"));
    }

    @Test
    void testContainsValue_withNonExistingKey() throws Exception {
        // Test
        assertFalse(multiValueMap.containsValue("key2", "value1"));
    }

    @Test
    void testContainsValue_withNullKey() throws Exception {
        // Setup
        multiValueMap.put(null, "value1");
        // Test
        assertTrue(multiValueMap.containsValue(null, "value1"));
        assertFalse(multiValueMap.containsValue(null, "value2"));
    }

    @Test
    void testContainsValue_withNullValue() throws Exception {
        // Setup
        multiValueMap.put("key1", null);
        // Test
        assertTrue(multiValueMap.containsValue("key1", null));
        assertFalse(multiValueMap.containsValue("key1", "value1"));
    }

    @Test
    void testContainsValue_withNullKeyAndNullValue() throws Exception {
        // Setup
        multiValueMap.put(null, null);
        // Test
        assertTrue(multiValueMap.containsValue(null, null));
    }

    @Test
    void testContainsValue_withEmptyMap() throws Exception {
        // Test
        assertFalse(multiValueMap.containsValue("key1", "value1"));
    }

    // Reflection to test private method
    private Object invokePrivateMethod(String methodName, Object... args) throws Exception {
        Method method = MultiValueMap.class.getDeclaredMethod(methodName, Object.class, Object.class);
        method.setAccessible(true);
        return method.invoke(multiValueMap, args);
    }
}
