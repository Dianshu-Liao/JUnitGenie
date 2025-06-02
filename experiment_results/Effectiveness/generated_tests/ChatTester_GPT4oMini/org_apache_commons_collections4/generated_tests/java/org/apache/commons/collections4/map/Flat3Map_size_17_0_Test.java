package org.apache.commons.collections4.map;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class Flat3Map_size_17_0_Test {

    private Flat3Map<String, String> flat3Map;

    private AbstractHashedMap<String, String> mockDelegateMap;

    @BeforeEach
    public void setUp() {
        flat3Map = new Flat3Map<>();
        mockDelegateMap = mock(AbstractHashedMap.class);
    }

    @Test
    public void testSizeWhenDelegateMapIsNull() {
        // Given
        // flat3Map.size is initialized to 0 by default
        // When
        int size = flat3Map.size();
        // Then
        assertEquals(0, size);
    }

    @Test
    public void testSizeWhenDelegateMapIsNotNull() throws Exception {
        // Set the delegateMap using reflection
        java.lang.reflect.Field delegateMapField = Flat3Map.class.getDeclaredField("delegateMap");
        delegateMapField.setAccessible(true);
        delegateMapField.set(flat3Map, mockDelegateMap);
        when(mockDelegateMap.size()).thenReturn(5);
        // When
        int size = flat3Map.size();
        // Then
        assertEquals(5, size);
    }

    @Test
    public void testSizeWhenDelegateMapIsNotNullAndReturnsZero() throws Exception {
        // Set the delegateMap using reflection
        java.lang.reflect.Field delegateMapField = Flat3Map.class.getDeclaredField("delegateMap");
        delegateMapField.setAccessible(true);
        delegateMapField.set(flat3Map, mockDelegateMap);
        when(mockDelegateMap.size()).thenReturn(0);
        // When
        int size = flat3Map.size();
        // Then
        assertEquals(0, size);
    }
}
