package org.apache.commons.collections4.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Iterator;
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

public class Flat3Map_values_19_0_Test {

    private Flat3Map<String, Integer> flat3Map;

    private AbstractHashedMap<String, Integer> mockDelegateMap;

    @BeforeEach
    public void setUp() {
        flat3Map = new Flat3Map<>();
        mockDelegateMap = mock(AbstractHashedMap.class);
    }

    @Test
    public void testValues_WithDelegateMap() {
        // Arrange
        when(mockDelegateMap.values()).thenReturn(new HashMap<String, Integer>() {

            {
                put("key1", 1);
                put("key2", 2);
            }
        }.values());
        // Set the delegateMap using reflection
        setPrivateField(flat3Map, "delegateMap", mockDelegateMap);
        // Act
        Collection<Integer> values = flat3Map.values();
        // Assert
        assertNotNull(values);
        assertEquals(2, values.size());
        assertTrue(values.contains(1));
        assertTrue(values.contains(2));
    }

    @Test
    public void testValues_WithoutDelegateMap() {
        // Act
        Collection<Integer> values = flat3Map.values();
        // Assert
        assertNotNull(values);
        assertTrue(values.isEmpty());
    }

    private void setPrivateField(Object target, String fieldName, Object value) {
        try {
            // Fixed the buggy line by replacing 'var' with 'java.lang.reflect.Field'
            java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }
}
