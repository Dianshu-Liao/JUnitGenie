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

class MultiValueMap_put_11_0_Test {

    private MultiValueMap<String, String> multiValueMap;

    @BeforeEach
    void setUp() {
        multiValueMap = new MultiValueMap<>(new HashMap<>(), new Factory<Collection<String>>() {

            @Override
            public Collection<String> create() {
                return new ArrayList<>();
            }
        });
    }

    @Test
    void testPut_NewKey() throws Exception {
        String key = "key1";
        String value = "value1";
        Object result = invokePutMethod(key, value);
        assertEquals(value, result);
        assertTrue(multiValueMap.getCollection(key).contains(value));
    }

    @Test
    void testPut_ExistingKey() throws Exception {
        String key = "key1";
        String value1 = "value1";
        String value2 = "value2";
        invokePutMethod(key, value1);
        Object result = invokePutMethod(key, value2);
        assertEquals(value2, result);
        Collection<String> collection = multiValueMap.getCollection(key);
        assertTrue(collection.contains(value1));
        assertTrue(collection.contains(value2));
        assertEquals(2, collection.size());
    }

    @Test
    void testPut_NullValue() throws Exception {
        String key = "key1";
        Object result = invokePutMethod(key, null);
        assertNull(result);
        assertNull(multiValueMap.getCollection(key));
    }

    @Test
    void testPut_NullKey() throws Exception {
        Object result = invokePutMethod(null, "value1");
        assertNull(result);
        assertNull(multiValueMap.getCollection(null));
    }

    private Object invokePutMethod(Object key, Object value) throws Exception {
        Method method = MultiValueMap.class.getDeclaredMethod("put", Object.class, Object.class);
        method.setAccessible(true);
        return method.invoke(multiValueMap, key, value);
    }
}
