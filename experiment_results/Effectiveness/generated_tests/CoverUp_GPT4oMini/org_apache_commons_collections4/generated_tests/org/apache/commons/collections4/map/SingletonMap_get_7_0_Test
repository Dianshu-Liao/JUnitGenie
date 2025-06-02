package org.apache.commons.collections4.map;

import java.lang.reflect.Method;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.BoundedMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.SingletonIterator;
import org.apache.commons.collections4.keyvalue.TiedMapEntry;

@ExtendWith(MockitoExtension.class)
class SingletonMap_get_7_0_Test {

    private SingletonMap<String, String> singletonMap;

    @BeforeEach
    void setUp() {
        singletonMap = new SingletonMap<>("key", "value");
    }

    @Test
    void testGetWithMatchingKey() {
        String result = singletonMap.get("key");
        assertEquals("value", result);
    }

    @Test
    void testGetWithNonMatchingKey() {
        String result = singletonMap.get("nonexistentKey");
        assertNull(result);
    }

    @Test
    void testGetWithNullKey() {
        String result = singletonMap.get(null);
        assertNull(result);
    }

    @Test
    void testGetWithNullKeyInSingleton() {
        SingletonMap<String, String> nullKeyMap = new SingletonMap<>(null, "value");
        String result = nullKeyMap.get(null);
        assertEquals("value", result);
    }

    @Test
    void testGetWithEmptySingleton() {
        SingletonMap<String, String> emptyMap = new SingletonMap<>();
        String result = emptyMap.get("key");
        assertNull(result);
    }

    @Test
    void testIsEqualKey() throws Exception {
        Method method = SingletonMap.class.getDeclaredMethod("isEqualKey", Object.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(singletonMap, "key");
        assertEquals(true, result);
        result = (boolean) method.invoke(singletonMap, "nonexistentKey");
        assertEquals(false, result);
    }
}
