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

public class MultiKeyMap_removeMultiKey_36_0_Test {

    private MultiKeyMap multiKeyMap;

    private AbstractHashedMap<MultiKey<? extends Object>, Object> mockedMap;

    @BeforeEach
    public void setUp() {
        mockedMap = mock(AbstractHashedMap.class);
        multiKeyMap = new MultiKeyMap(mockedMap);
    }

    @Test
    public void testRemoveMultiKey_ExistingKey_ReturnsValue() throws Exception {
        // Arrange
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object key4 = "key4";
        Object expectedValue = "value";
        // Mocking the behavior of the underlying map
        int hashCode = multiKeyMap.hash(key1, key2, key3, key4);
        int index = multiKeyMap.decoratedHashIndex(hashCode);
        AbstractHashedMap.HashEntry<MultiKey<? extends Object>, Object> entry = mock(AbstractHashedMap.HashEntry.class);
        when(entry.hashCode).thenReturn(hashCode);
        when(entry.getValue()).thenReturn(expectedValue);
        when(mockedMap.data[index]).thenReturn(entry);
        when(entry.next).thenReturn(null);
        // Mocking the removeMapping method
        doNothing().when(mockedMap).removeMapping(entry, index, null);
        // Act
        Object result = invokeRemoveMultiKey(key1, key2, key3, key4);
        // Assert
        assertEquals(expectedValue, result);
        verify(mockedMap).removeMapping(entry, index, null);
    }

    @Test
    public void testRemoveMultiKey_NonExistingKey_ReturnsNull() throws Exception {
        // Arrange
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object key4 = "key4";
        // Mocking the behavior of the underlying map
        int hashCode = multiKeyMap.hash(key1, key2, key3, key4);
        int index = multiKeyMap.decoratedHashIndex(hashCode);
        AbstractHashedMap.HashEntry<MultiKey<? extends Object>, Object> entry = mock(AbstractHashedMap.HashEntry.class);
        // Different hash code
        when(entry.hashCode).thenReturn(hashCode + 1);
        when(mockedMap.data[index]).thenReturn(entry);
        when(entry.next).thenReturn(null);
        // Act
        Object result = invokeRemoveMultiKey(key1, key2, key3, key4);
        // Assert
        assertNull(result);
        verify(mockedMap, never()).removeMapping(any(), anyInt(), any());
    }

    @Test
    public void testRemoveMultiKey_ChainOfEntries_ReturnsValue() throws Exception {
        // Arrange
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object key4 = "key4";
        Object expectedValue = "value";
        // Mocking the behavior of the underlying map
        int hashCode = multiKeyMap.hash(key1, key2, key3, key4);
        int index = multiKeyMap.decoratedHashIndex(hashCode);
        AbstractHashedMap.HashEntry<MultiKey<? extends Object>, Object> firstEntry = mock(AbstractHashedMap.HashEntry.class);
        AbstractHashedMap.HashEntry<MultiKey<? extends Object>, Object> secondEntry = mock(AbstractHashedMap.HashEntry.class);
        when(firstEntry.hashCode).thenReturn(hashCode);
        when(firstEntry.getValue()).thenReturn(expectedValue);
        when(firstEntry.next).thenReturn(secondEntry);
        // Different hash code
        when(secondEntry.hashCode).thenReturn(hashCode + 1);
        when(secondEntry.next).thenReturn(null);
        when(mockedMap.data[index]).thenReturn(firstEntry);
        // Mocking the removeMapping method
        doNothing().when(mockedMap).removeMapping(firstEntry, index, null);
        // Act
        Object result = invokeRemoveMultiKey(key1, key2, key3, key4);
        // Assert
        assertEquals(expectedValue, result);
        verify(mockedMap).removeMapping(firstEntry, index, null);
    }

    private Object invokeRemoveMultiKey(Object key1, Object key2, Object key3, Object key4) throws Exception {
        Method method = MultiKeyMap.class.getDeclaredMethod("removeMultiKey", Object.class, Object.class, Object.class, Object.class);
        method.setAccessible(true);
        return method.invoke(multiKeyMap, key1, key2, key3, key4);
    }
}
