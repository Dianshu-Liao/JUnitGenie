package org.apache.commons.collections4.map;

import java.lang.reflect.Method;
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
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.AbstractHashedMap.HashEntry;

public class MultiKeyMap_get_13_1_Test {

    private MultiKeyMap multiKeyMap;

    private AbstractHashedMap<MultiKey<Object>, Object> mockMap;

    @BeforeEach
    public void setUp() {
        mockMap = Mockito.mock(AbstractHashedMap.class);
        multiKeyMap = new MultiKeyMap(mockMap);
    }

    @Test
    public void testGetReturnsValueWhenEntryExists() throws Exception {
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object key4 = "key4";
        Object key5 = "key5";
        int hashCode = multiKeyMap.hash(key1, key2, key3, key4, key5);
        MultiKey<Object> multiKey = new MultiKey<>(key1, key2, key3, key4, key5);
        AbstractHashedMap.HashEntry<MultiKey<Object>, Object> mockEntry = Mockito.mock(AbstractHashedMap.HashEntry.class);
        Mockito.when(mockEntry.hashCode).thenReturn(hashCode);
        Mockito.when(mockEntry.getValue()).thenReturn("value");
        Mockito.when(mockMap.get(hashCode)).thenReturn(mockEntry);
        // No further entries
        Mockito.when(mockEntry.next).thenReturn(null);
        Object result = invokeGetMethod(key1, key2, key3, key4, key5);
        assertEquals("value", result);
    }

    @Test
    public void testGetReturnsNullWhenEntryDoesNotExist() throws Exception {
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object key4 = "key4";
        Object key5 = "key5";
        int hashCode = multiKeyMap.hash(key1, key2, key3, key4, key5);
        Mockito.when(mockMap.get(hashCode)).thenReturn(null);
        Object result = invokeGetMethod(key1, key2, key3, key4, key5);
        assertNull(result);
    }

    @Test
    public void testGetReturnsNullWhenKeysDoNotMatch() throws Exception {
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object key4 = "key4";
        Object key5 = "key5";
        int hashCode = multiKeyMap.hash(key1, key2, key3, key4, key5);
        MultiKey<Object> multiKey = new MultiKey<>(key1, key2, key3, key4, key5);
        AbstractHashedMap.HashEntry<MultiKey<Object>, Object> mockEntry = Mockito.mock(AbstractHashedMap.HashEntry.class);
        Mockito.when(mockEntry.hashCode).thenReturn(hashCode);
        Mockito.when(mockEntry.getValue()).thenReturn("value");
        Mockito.when(mockMap.get(hashCode)).thenReturn(mockEntry);
        // No further entries
        Mockito.when(mockEntry.next).thenReturn(null);
        // Simulating a mismatch in keys
        Mockito.when(multiKeyMap.isEqualKey(mockEntry, "wrongKey1", "wrongKey2", "wrongKey3", "wrongKey4", "wrongKey5")).thenReturn(false);
        Object result = invokeGetMethod(key1, key2, key3, key4, key5);
        assertNull(result);
    }

    private Object invokeGetMethod(Object key1, Object key2, Object key3, Object key4, Object key5) throws Exception {
        Method method = MultiKeyMap.class.getDeclaredMethod("get", Object.class, Object.class, Object.class, Object.class, Object.class);
        method.setAccessible(true);
        return method.invoke(multiKeyMap, key1, key2, key3, key4, key5);
    }
}
