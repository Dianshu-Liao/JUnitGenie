package org.apache.commons.collections4.multimap;

import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Iterator;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.FluentIterable;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.Transformer;

public class TransformedMultiValuedMap_putAll_4_0_Test {

    private TransformedMultiValuedMap<String, String> transformedMultiValuedMap;

    @BeforeEach
    public void setUp() {
        // Mocking a MultiValuedMap for the constructor
        MultiValuedMap<String, String> mockMap = mock(MultiValuedMap.class);
        transformedMultiValuedMap = new TransformedMultiValuedMap<>(mockMap, key -> key, value -> value);
    }

    @Test
    public void testPutAll_NullMap_ShouldThrowException() {
        // Arrange
        Map<String, String> nullMap = null;
        // Act & Assert
        Exception exception = assertThrows(NullPointerException.class, () -> {
            transformedMultiValuedMap.putAll(nullMap);
        });
        assertEquals("map", exception.getMessage());
    }

    @Test
    public void testPutAll_EmptyMap_ShouldNotChange() {
        // Arrange
        Map<String, String> emptyMap = new HashMap<>();
        // Act
        boolean changed = transformedMultiValuedMap.putAll(emptyMap);
        // Assert
        assertFalse(changed);
    }

    @Test
    public void testPutAll_NonEmptyMap_ShouldChange() {
        // Arrange
        Map<String, String> nonEmptyMap = new HashMap<>();
        nonEmptyMap.put("key1", "value1");
        nonEmptyMap.put("key2", "value2");
        // Mocking the put method to return true for the test
        when(transformedMultiValuedMap.put("key1", "value1")).thenReturn(true);
        when(transformedMultiValuedMap.put("key2", "value2")).thenReturn(true);
        // Act
        boolean changed = transformedMultiValuedMap.putAll(nonEmptyMap);
        // Assert
        assertTrue(changed);
    }

    @Test
    public void testPutAll_SomePutCallsReturnFalse_ShouldChange() {
        // Arrange
        Map<String, String> mixedMap = new HashMap<>();
        mixedMap.put("key1", "value1");
        mixedMap.put("key2", "value2");
        // Mocking the put method to return false for one of the calls
        when(transformedMultiValuedMap.put("key1", "value1")).thenReturn(true);
        when(transformedMultiValuedMap.put("key2", "value2")).thenReturn(false);
        // Act
        boolean changed = transformedMultiValuedMap.putAll(mixedMap);
        // Assert
        assertTrue(changed);
    }
}
