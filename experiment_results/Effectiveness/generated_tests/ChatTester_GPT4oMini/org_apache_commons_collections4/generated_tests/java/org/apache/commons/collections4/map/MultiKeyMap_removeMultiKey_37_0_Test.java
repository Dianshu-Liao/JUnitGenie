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

public class MultiKeyMap_removeMultiKey_37_0_Test {

    private MultiKeyMap multiKeyMap;

    private AbstractHashedMap<MultiKey<Object>, String> mockedMap;

    @BeforeEach
    public void setUp() {
        mockedMap = mock(AbstractHashedMap.class);
        multiKeyMap = new MultiKeyMap(mockedMap);
    }

    @Test
    public void testRemoveMultiKey_ExistingKey() throws Exception {
        // Setup
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object key4 = "key4";
        Object key5 = "key5";
        String expectedValue = "value";
        // Mocking hash and decorated methods
        when(multiKeyMap.hash(key1, key2, key3, key4, key5)).thenReturn(1);
        when(multiKeyMap.decoratedHashIndex(1)).thenReturn(0);
        AbstractHashedMap.HashEntry<MultiKey<Object>, String> entry = mock(AbstractHashedMap.HashEntry.class);
        when(entry.hashCode).thenReturn(1);
        when(entry.getValue()).thenReturn(expectedValue);
        when(entry.next).thenReturn(null);
        when(mockedMap.data[0]).thenReturn(entry);
        // Execute
        String actualValue = invokeRemoveMultiKey(key1, key2, key3, key4, key5);
        // Verify
        assertEquals(expectedValue, actualValue);
        verify(mockedMap).removeMapping(entry, 0, null);
    }

    @Test
    public void testRemoveMultiKey_NonExistingKey() throws Exception {
        // Setup
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object key4 = "key4";
        Object key5 = "key5";
        // Mocking hash and decorated methods
        when(multiKeyMap.hash(key1, key2, key3, key4, key5)).thenReturn(1);
        when(multiKeyMap.decoratedHashIndex(1)).thenReturn(0);
        AbstractHashedMap.HashEntry<MultiKey<Object>, String> entry = mock(AbstractHashedMap.HashEntry.class);
        when(entry.hashCode).thenReturn(2);
        when(entry.next).thenReturn(null);
        when(mockedMap.data[0]).thenReturn(entry);
        // Execute
        String actualValue = invokeRemoveMultiKey(key1, key2, key3, key4, key5);
        // Verify
        assertNull(actualValue);
        verify(mockedMap, never()).removeMapping(any(), anyInt(), any());
    }

    @Test
    public void testRemoveMultiKey_ChainOfEntries() throws Exception {
        // Setup
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object key4 = "key4";
        Object key5 = "key5";
        String expectedValue = "value";
        // Mocking hash and decorated methods
        when(multiKeyMap.hash(key1, key2, key3, key4, key5)).thenReturn(1);
        when(multiKeyMap.decoratedHashIndex(1)).thenReturn(0);
        AbstractHashedMap.HashEntry<MultiKey<Object>, String> entry1 = mock(AbstractHashedMap.HashEntry.class);
        AbstractHashedMap.HashEntry<MultiKey<Object>, String> entry2 = mock(AbstractHashedMap.HashEntry.class);
        when(entry1.hashCode).thenReturn(2);
        when(entry1.next).thenReturn(entry2);
        when(entry2.hashCode).thenReturn(1);
        when(entry2.getValue()).thenReturn(expectedValue);
        when(entry2.next).thenReturn(null);
        when(mockedMap.data[0]).thenReturn(entry1);
        // Execute
        String actualValue = invokeRemoveMultiKey(key1, key2, key3, key4, key5);
        // Verify
        assertEquals(expectedValue, actualValue);
        verify(mockedMap).removeMapping(entry2, 0, entry1);
    }

    private String invokeRemoveMultiKey(Object key1, Object key2, Object key3, Object key4, Object key5) throws Exception {
        Method method = MultiKeyMap.class.getDeclaredMethod("removeMultiKey", Object.class, Object.class, Object.class, Object.class, Object.class);
        method.setAccessible(true);
        return (String) method.invoke(multiKeyMap, key1, key2, key3, key4, key5);
    }
}
