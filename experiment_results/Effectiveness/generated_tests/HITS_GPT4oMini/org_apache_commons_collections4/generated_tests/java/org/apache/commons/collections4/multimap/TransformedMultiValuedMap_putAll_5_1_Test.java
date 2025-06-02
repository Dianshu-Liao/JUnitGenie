package org.apache.commons.collections4.multimap;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.Transformer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.FluentIterable;

class TransformedMultiValuedMap_putAll_5_1_Test {

    private TransformedMultiValuedMap<String, String> transformedMultiValuedMap;

    private MultiValuedMap<String, String> mockMap;

    private Transformer<String, String> keyTransformer;

    private Transformer<String, String> valueTransformer;

    @BeforeEach
    void setUp() {
        keyTransformer = (Transformer<String, String>) key -> key + "_transformed";
        valueTransformer = (Transformer<String, String>) value -> value + "_transformed";
        mockMap = mock(MultiValuedMap.class);
        transformedMultiValuedMap = new TransformedMultiValuedMap<>(mockMap, keyTransformer, valueTransformer);
    }

    @Test
    void testPutAll_NullMap_ThrowsException() {
        // Arrange
        MultiValuedMap<String, String> nullMap = null;
        // Act & Assert
        Exception exception = assertThrows(NullPointerException.class, () -> {
            transformedMultiValuedMap.putAll(nullMap);
        });
        assertEquals("map", exception.getMessage());
    }

    @Test
    void testPutAll_EmptyMap_NoChange() {
        // Arrange
        when(mockMap.entries()).thenReturn(new ArrayList<Map.Entry<String, String>>());
        // Act
        boolean result = transformedMultiValuedMap.putAll(mockMap);
        // Assert
        assertFalse(result);
        verify(mockMap, times(1)).entries();
    }
}
