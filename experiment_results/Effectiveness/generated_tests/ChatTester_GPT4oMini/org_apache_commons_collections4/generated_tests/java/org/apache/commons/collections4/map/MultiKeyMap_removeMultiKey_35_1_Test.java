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

public class MultiKeyMap_removeMultiKey_35_1_Test {

    private MultiKeyMap multiKeyMap;

    private AbstractHashedMap<MultiKey<Object>, Object> mockedMap;

    @BeforeEach
    public void setUp() {
        mockedMap = mock(AbstractHashedMap.class);
        multiKeyMap = new MultiKeyMap(mockedMap);
    }

    @Test
    public void testRemoveMultiKey_ExistingKey() throws Exception {
        // Prepare the mock behavior
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        int hashCode = multiKeyMap.hash(key1, key2, key3);
        int index = multiKeyMap.decoratedHashIndex(hashCode);
        // Mock the entry in the map
        AbstractHashedMap.HashEntry<MultiKey<Object>, Object> entry = mock(AbstractHashedMap.HashEntry.class);
        when(entry.hashCode).thenReturn(hashCode);
        when(entry.getValue()).thenReturn("value");
        // Mock the data array
        when(mockedMap.data[index]).thenReturn(entry);
        when(entry.next).thenReturn(null);
        // Invoke the method
        Method method = MultiKeyMap.class.getDeclaredMethod("removeMultiKey", Object.class, Object.class, Object.class);
        method.setAccessible(true);
        Object result = method.invoke(multiKeyMap, key1, key2, key3);
        // Verify results
        assertEquals("value", result);
        verify(mockedMap).removeMapping(entry, index, null);
    }

    @Test
    public void testRemoveMultiKey_NonExistingKey() throws Exception {
        // Prepare the mock behavior
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        int hashCode = multiKeyMap.hash(key1, key2, key3);
        int index = multiKeyMap.decoratedHashIndex(hashCode);
        // Mock the data array
        when(mockedMap.data[index]).thenReturn(null);
        // Invoke the method
        Method method = MultiKeyMap.class.getDeclaredMethod("removeMultiKey", Object.class, Object.class, Object.class);
        method.setAccessible(true);
        Object result = method.invoke(multiKeyMap, key1, key2, key3);
        // Verify results
        assertNull(result);
    }

    @Test
    public void testRemoveMultiKey_KeyNotMatching() throws Exception {
        // Prepare the mock behavior
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object differentKey1 = "differentKey1";
        int hashCode = multiKeyMap.hash(key1, key2, key3);
        int index = multiKeyMap.decoratedHashIndex(hashCode);
        // Mock the entry in the map
        AbstractHashedMap.HashEntry<MultiKey<Object>, Object> entry = mock(AbstractHashedMap.HashEntry.class);
        when(entry.hashCode).thenReturn(hashCode);
        when(entry.getValue()).thenReturn("value");
        when(entry.next).thenReturn(null);
        // Mock the data array
        when(mockedMap.data[index]).thenReturn(entry);
        // Invoke the method with a different key
        Method method = MultiKeyMap.class.getDeclaredMethod("removeMultiKey", Object.class, Object.class, Object.class);
        method.setAccessible(true);
        Object result = method.invoke(multiKeyMap, differentKey1, key2, key3);
        // Verify results
        assertNull(result);
    }
}
