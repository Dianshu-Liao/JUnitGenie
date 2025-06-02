package org.apache.commons.collections4.map;

import java.lang.reflect.Method;
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

class ListOrderedMap_put_15_0_Test {

    private ListOrderedMap<String, String> listOrderedMap;

    @BeforeEach
    void setUp() {
        listOrderedMap = new ListOrderedMap<>(new HashMap<>());
    }

    @Test
    void testPutNewKey() {
        String key = "key1";
        String value = "value1";
        String result = listOrderedMap.put(key, value);
        // no previous value for the key
        assertNull(result);
        // should return the new value
        assertEquals(value, listOrderedMap.put(key, value));
    }

    @Test
    void testPutExistingKey() {
        String key = "key2";
        String value1 = "value1";
        String value2 = "value2";
        listOrderedMap.put(key, value1);
        String result = listOrderedMap.put(key, value2);
        // should return the previous value
        assertEquals(value1, result);
        // should return the new value
        assertEquals(value2, listOrderedMap.put(key, value2));
    }

    @Test
    void testPutMultipleKeys() {
        String key1 = "key3";
        String value1 = "value1";
        String key2 = "key4";
        String value2 = "value2";
        listOrderedMap.put(key1, value1);
        listOrderedMap.put(key2, value2);
        // should return null on first put
        assertEquals(value1, listOrderedMap.put(key1, value1));
        // should return null on first put
        assertEquals(value2, listOrderedMap.put(key2, value2));
    }

    @Test
    void testPutNullKey() {
        String value = "value";
        Exception exception = assertThrows(NullPointerException.class, () -> {
            listOrderedMap.put(null, value);
        });
        assertEquals("key cannot be null", exception.getMessage());
    }

    @Test
    void testPutNullValue() {
        String key = "key5";
        String result = listOrderedMap.put(key, null);
        // no previous value for the key
        assertNull(result);
        // should return the new value
        assertNull(listOrderedMap.put(key, null));
    }
}
