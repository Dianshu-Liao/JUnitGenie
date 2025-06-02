package org.apache.commons.collections4.map;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

class SingletonMap_get_7_1_Test {

    private SingletonMap<String, String> singletonMap;

    @BeforeEach
    void setUp() {
        singletonMap = new SingletonMap<>("testKey", "testValue");
    }

    @Test
    void testGetReturnsValueForEqualKey() throws Exception {
        // Use reflection to access the private method isEqualKey
        Method method = SingletonMap.class.getDeclaredMethod("isEqualKey", Object.class);
        method.setAccessible(true);
        // Invoke isEqualKey with the correct key
        boolean isEqual = (boolean) method.invoke(singletonMap, "testKey");
        assertTrue(isEqual);
        // Now test the get method
        String result = singletonMap.get("testKey");
        assertEquals("testValue", result);
    }

    @Test
    void testGetReturnsNullForDifferentKey() {
        String result = singletonMap.get("differentKey");
        assertNull(result);
    }

    @Test
    void testGetReturnsNullForNullKey() {
        String result = singletonMap.get(null);
        assertNull(result);
    }
}
