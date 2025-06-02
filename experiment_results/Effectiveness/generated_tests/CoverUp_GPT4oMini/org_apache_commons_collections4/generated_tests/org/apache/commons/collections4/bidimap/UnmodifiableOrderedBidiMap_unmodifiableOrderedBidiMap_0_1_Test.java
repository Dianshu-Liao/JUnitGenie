package org.apache.commons.collections4.bidimap;

import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.bidimap.UnmodifiableOrderedBidiMap;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableOrderedMapIterator;
import org.apache.commons.collections4.map.UnmodifiableEntrySet;
import org.apache.commons.collections4.set.UnmodifiableSet;

class UnmodifiableOrderedBidiMap_unmodifiableOrderedBidiMap_0_1_Test {

    private OrderedBidiMap<String, Integer> mockOrderedBidiMap;

    @BeforeEach
    void setUp() {
        mockOrderedBidiMap = mock(OrderedBidiMap.class);
    }

    @Test
    void testUnmodifiableOrderedBidiMap_whenMapIsUnmodifiable() {
        // Arrange
        when(mockOrderedBidiMap instanceof Unmodifiable).thenReturn(true);
        // Act
        OrderedBidiMap<String, Integer> result = UnmodifiableOrderedBidiMap.unmodifiableOrderedBidiMap(mockOrderedBidiMap);
        // Assert
        assertEquals(mockOrderedBidiMap, result);
    }

    @Test
    void testUnmodifiableOrderedBidiMap_whenMapIsModifiable() {
        // Arrange
        when(mockOrderedBidiMap instanceof Unmodifiable).thenReturn(false);
        // Act
        OrderedBidiMap<String, Integer> result = UnmodifiableOrderedBidiMap.unmodifiableOrderedBidiMap(mockOrderedBidiMap);
        // Assert
        assertNotNull(result);
        assertNotEquals(mockOrderedBidiMap, result);
    }
}
