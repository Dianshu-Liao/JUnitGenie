package org.apache.commons.collections4.map;

import java.util.*;
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
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.TransformIterator;

public class MultiValueMap_containsValue_4_0_Test {

    private MultiValueMap multiValueMap;

    @BeforeEach
    public void setUp() {
        multiValueMap = new MultiValueMap();
    }

    @Test
    public void testContainsValue_WhenValueExists_ReturnsTrue() {
        // Setup the internal state of MultiValueMap
        Map<String, Collection<String>> map = new HashMap<>();
        map.put("key1", new ArrayList<>(Arrays.asList("value1", "value2")));
        map.put("key2", new ArrayList<>(Collections.singletonList("value3")));
        setInternalMap(multiValueMap, map);
        // Act
        boolean result = multiValueMap.containsValue("value2");
        // Assert
        assertTrue(result);
    }

    @Test
    public void testContainsValue_WhenValueDoesNotExist_ReturnsFalse() {
        // Setup the internal state of MultiValueMap
        Map<String, Collection<String>> map = new HashMap<>();
        map.put("key1", new ArrayList<>(Arrays.asList("value1", "value2")));
        map.put("key2", new ArrayList<>(Collections.singletonList("value3")));
        setInternalMap(multiValueMap, map);
        // Act
        boolean result = multiValueMap.containsValue("value4");
        // Assert
        assertFalse(result);
    }

    @Test
    public void testContainsValue_WhenEmpty_ReturnsFalse() {
        // Setup the internal state of MultiValueMap
        Map<String, Collection<String>> map = new HashMap<>();
        setInternalMap(multiValueMap, map);
        // Act
        boolean result = multiValueMap.containsValue("value1");
        // Assert
        assertFalse(result);
    }

    @Test
    public void testContainsValue_WhenNullValue_ReturnsFalse() {
        // Setup the internal state of MultiValueMap
        Map<String, Collection<String>> map = new HashMap<>();
        map.put("key1", new ArrayList<>(Arrays.asList("value1", "value2")));
        setInternalMap(multiValueMap, map);
        // Act
        boolean result = multiValueMap.containsValue(null);
        // Assert
        assertFalse(result);
    }

    private void setInternalMap(MultiValueMap multiValueMap, Map<String, Collection<String>> map) {
        try {
            // Use reflection to set the internal map in MultiValueMap
            java.lang.reflect.Field field = MultiValueMap.class.getDeclaredField("map");
            field.setAccessible(true);
            field.set(multiValueMap, map);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
