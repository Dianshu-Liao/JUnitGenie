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

public class MultiKeyMap_removeMultiKey_36_2_Test {

    private MultiKeyMap multiKeyMap;

    private AbstractHashedMap<MultiKey<?>, String> mockMap;

    @BeforeEach
    public void setUp() {
        mockMap = mock(AbstractHashedMap.class);
        multiKeyMap = new MultiKeyMap(mockMap);
    }

    @Test
    public void testRemoveMultiKey_ExistingKey_ReturnsValue() throws Exception {
        // Setup
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object key4 = "key4";
        String expectedValue = "value";
        // Mock the behavior of the internal map
        int hashCode = multiKeyMap.hash(key1, key2, key3, key4);
        int index = multiKeyMap.decoratedHashIndex(hashCode);
        AbstractHashedMap.HashEntry<MultiKey<?>, String> mockEntry = mock(AbstractHashedMap.HashEntry.class);
        when(mockEntry.hashCode).thenReturn(hashCode);
        when(mockEntry.getValue()).thenReturn(expectedValue);
        when(mockEntry.next).thenReturn(null);
        when(mockMap.data[index]).thenReturn(mockEntry);
        // Invoke the method
        String result = invokeRemoveMultiKey(key1, key2, key3, key4);
        // Verify
        assertEquals(expectedValue, result);
        verify(mockMap).removeMapping(mockEntry, index, null);
    }

    @Test
    public void testRemoveMultiKey_NonExistingKey_ReturnsNull() throws Exception {
        // Setup
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object key4 = "key4";
        // Mock the behavior of the internal map
        int hashCode = multiKeyMap.hash(key1, key2, key3, key4);
        int index = multiKeyMap.decoratedHashIndex(hashCode);
        when(mockMap.data[index]).thenReturn(null);
        // Invoke the method
        String result = invokeRemoveMultiKey(key1, key2, key3, key4);
        // Verify
        assertNull(result);
    }

    @Test
    public void testRemoveMultiKey_MultipleEntries_ReturnsCorrectValue() throws Exception {
        // Setup
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object key4 = "key4";
        String expectedValue = "value";
        int hashCode = multiKeyMap.hash(key1, key2, key3, key4);
        int index = multiKeyMap.decoratedHashIndex(hashCode);
        AbstractHashedMap.HashEntry<MultiKey<?>, String> mockEntry1 = mock(AbstractHashedMap.HashEntry.class);
        AbstractHashedMap.HashEntry<MultiKey<?>, String> mockEntry2 = mock(AbstractHashedMap.HashEntry.class);
        when(mockEntry1.hashCode).thenReturn(hashCode);
        when(mockEntry1.getValue()).thenReturn(expectedValue);
        when(mockEntry1.next).thenReturn(mockEntry2);
        // Different hash code
        when(mockEntry2.hashCode).thenReturn(-1);
        when(mockEntry2.next).thenReturn(null);
        when(mockMap.data[index]).thenReturn(mockEntry1);
        // Invoke the method
        String result = invokeRemoveMultiKey(key1, key2, key3, key4);
        // Verify
        assertEquals(expectedValue, result);
        verify(mockMap).removeMapping(mockEntry1, index, null);
    }

    private String invokeRemoveMultiKey(Object key1, Object key2, Object key3, Object key4) throws Exception {
        Method method = MultiKeyMap.class.getDeclaredMethod("removeMultiKey", Object.class, Object.class, Object.class, Object.class);
        method.setAccessible(true);
        return (String) method.invoke(multiKeyMap, key1, key2, key3, key4);
    }
}
