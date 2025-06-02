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

class MultiValueMap_totalSize_17_0_Test {

    private MultiValueMap multiValueMap;

    @BeforeEach
    void setUp() {
        multiValueMap = new MultiValueMap();
    }

    @Test
    void testTotalSizeWithEmptyMap() {
        // Arrange
        Map<Object, Collection<Object>> mockMap = Mockito.mock(Map.class);
        when(mockMap.values()).thenReturn(Collections.emptySet());
        setDecorated(mockMap);
        // Act
        int result = multiValueMap.totalSize();
        // Assert
        assertEquals(0, result);
    }

    @Test
    void testTotalSizeWithSingleValueCollection() {
        // Arrange
        Collection<Object> values = Arrays.asList("value1");
        Map<Object, Collection<Object>> mockMap = Mockito.mock(Map.class);
        when(mockMap.values()).thenReturn(Collections.singletonList(values));
        setDecorated(mockMap);
        // Act
        int result = multiValueMap.totalSize();
        // Assert
        assertEquals(1, result);
    }

    @Test
    void testTotalSizeWithMultipleCollections() {
        // Arrange
        Collection<Object> values1 = Arrays.asList("value1", "value2");
        Collection<Object> values2 = Arrays.asList("value3");
        Map<Object, Collection<Object>> mockMap = Mockito.mock(Map.class);
        when(mockMap.values()).thenReturn(Arrays.asList(values1, values2));
        setDecorated(mockMap);
        // Act
        int result = multiValueMap.totalSize();
        // Assert
        assertEquals(3, result);
    }

    @Test
    void testTotalSizeWithEmptyCollections() {
        // Arrange
        Collection<Object> values1 = Collections.emptyList();
        Collection<Object> values2 = Collections.emptyList();
        Map<Object, Collection<Object>> mockMap = Mockito.mock(Map.class);
        when(mockMap.values()).thenReturn(Arrays.asList(values1, values2));
        setDecorated(mockMap);
        // Act
        int result = multiValueMap.totalSize();
        // Assert
        assertEquals(0, result);
    }

    @Test
    void testTotalSizeWithMixedCollections() {
        // Arrange
        Collection<Object> values1 = Arrays.asList("value1", "value2", "value3");
        Collection<Object> values2 = Collections.emptyList();
        Collection<Object> values3 = Arrays.asList("value4");
        Map<Object, Collection<Object>> mockMap = Mockito.mock(Map.class);
        when(mockMap.values()).thenReturn(Arrays.asList(values1, values2, values3));
        setDecorated(mockMap);
        // Act
        int result = multiValueMap.totalSize();
        // Assert
        assertEquals(4, result);
    }

    private void setDecorated(Map<Object, Collection<Object>> mockMap) {
        try {
            java.lang.reflect.Field decoratedField = MultiValueMap.class.getDeclaredField("decorated");
            decoratedField.setAccessible(true);
            decoratedField.set(multiValueMap, mockMap);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
