package org.apache.commons.collections4.map;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.collection.CompositeCollection;
import org.apache.commons.collections4.set.CompositeSet;

@ExtendWith(MockitoExtension.class)
public class CompositeMap_put_10_2_Test {

    private CompositeMap<String, String> compositeMap;

    @BeforeEach
    public void setUp() {
        compositeMap = new CompositeMap<>();
    }

    @Test
    public void testPutThrowsUnsupportedOperationExceptionWhenMutatorIsNull() {
        // Arrange
        // Mutator is not set, so it should be null by default
        // Act & Assert
        assertThrows(UnsupportedOperationException.class, () -> {
            compositeMap.put("key", "value");
        }, "No mutator specified");
    }

    @Test
    public void testPutWorksWhenMutatorIsSet() {
        // Arrange
        Map<String, String> mockMap1 = new HashMap<>();
        Map<String, String> mockMap2 = new HashMap<>();
        org.apache.commons.collections4.map.CompositeMap.MapMutator<String, String> mockMutator = mock(org.apache.commons.collections4.map.CompositeMap.MapMutator.class);
        // Set the mutator for the compositeMap
        compositeMap.setMutator(mockMutator);
        // Create a new CompositeMap with the mock maps and mutator
        compositeMap = new CompositeMap<>(mockMap1, mockMap2, mockMutator);
        // Act
        compositeMap.put("key", "value");
        // Assert
        // Verify that the mutator's put method is called with the expected parameters
        verify(mockMutator).put(compositeMap, new Map[] { mockMap1, mockMap2 }, "key", "value");
    }
}
