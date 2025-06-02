package org.apache.commons.collections4.map;

import java.util.HashMap;
import java.util.Map;
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
import java.util.AbstractList;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntry;
import org.apache.commons.collections4.list.UnmodifiableList;

public class // Reflection test for private method if needed
// @Test
// public void testPrivateMethod() throws Exception {
// Method method = ListOrderedMap.class.getDeclaredMethod("privateMethodName", parameterTypes);
// method.setAccessible(true);
// Object result = method.invoke(listOrderedMap, parameters);
// assertEquals(expectedValue, result);
// }
ListOrderedMap_put_15_0_Test {

    private ListOrderedMap<String, Integer> listOrderedMap;

    @BeforeEach
    public void setUp() {
        listOrderedMap = new ListOrderedMap<>(new HashMap<>());
    }

    @Test
    public void testPut_NewKey() {
        // Test adding a new key
        Integer result = listOrderedMap.put("key1", 1);
        // since it's a new key, previous value should be null
        assertNull(result);
        // check if value is set correctly
        assertEquals(1, listOrderedMap.get("key1"));
    }

    @Test
    public void testPut_ExistingKey() {
        // Test updating an existing key
        listOrderedMap.put("key1", 1);
        Integer result = listOrderedMap.put("key1", 2);
        // previous value should be returned
        assertEquals(1, result);
        // check if value is updated
        assertEquals(2, listOrderedMap.get("key1"));
    }

    @Test
    public void testPut_MultipleKeys() {
        // Test adding multiple keys
        listOrderedMap.put("key1", 1);
        listOrderedMap.put("key2", 2);
        listOrderedMap.put("key3", 3);
        assertEquals(1, listOrderedMap.get("key1"));
        assertEquals(2, listOrderedMap.get("key2"));
        assertEquals(3, listOrderedMap.get("key3"));
    }

    @Test
    public void testPut_SameKeyMultipleTimes() {
        // Test adding the same key multiple times
        listOrderedMap.put("key1", 1);
        listOrderedMap.put("key1", 2);
        listOrderedMap.put("key1", 3);
        // last value should be retrieved
        assertEquals(3, listOrderedMap.get("key1"));
    }

    @Test
    public void testPut_EmptyMap() {
        // Test adding a key to an empty map
        Integer result = listOrderedMap.put("key1", 10);
        // no previous value
        assertNull(result);
        // value should be set
        assertEquals(10, listOrderedMap.get("key1"));
    }

    @Test
    public void testPut_NullKey() {
        // Test adding a null key
        Integer result = listOrderedMap.put(null, 5);
        // no previous value
        assertNull(result);
        // value should be set
        assertEquals(5, listOrderedMap.get(null));
    }

    @Test
    public void testPut_NullValue() {
        // Test adding a key with a null value
        listOrderedMap.put("key1", 5);
        Integer result = listOrderedMap.put("key1", null);
        // previous value should be returned
        assertEquals(5, result);
        // value should be null now
        assertNull(listOrderedMap.get("key1"));
    }
}
