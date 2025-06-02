package org.apache.commons.collections4.multimap;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.multimap.UnmodifiableMultiValuedMap;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections4.map.UnmodifiableMap;
import org.apache.commons.collections4.multiset.UnmodifiableMultiSet;
import org.apache.commons.collections4.set.UnmodifiableSet;

class UnmodifiableMultiValuedMap_unmodifiableMultiValuedMap_0_0_Test {

    @Test
    void testUnmodifiableMultiValuedMap_WithUnmodifiableMap() {
        // Arrange
        MultiValuedMap<String, String> mockMap = mock(MultiValuedMap.class);
        when(mockMap instanceof Unmodifiable).thenReturn(true);
        // Act
        UnmodifiableMultiValuedMap<String, String> result = UnmodifiableMultiValuedMap.unmodifiableMultiValuedMap(mockMap);
        // Assert
        assertSame(mockMap, result);
    }

    @Test
    void testUnmodifiableMultiValuedMap_WithModifiableMap() {
        // Arrange
        MultiValuedMap<String, String> mockMap = mock(MultiValuedMap.class);
        when(mockMap instanceof Unmodifiable).thenReturn(false);
        // Act
        UnmodifiableMultiValuedMap<String, String> result = UnmodifiableMultiValuedMap.unmodifiableMultiValuedMap(mockMap);
        // Assert
        assertNotNull(result);
    }

    @Test
    void testUnmodifiableMultiValuedMap_NullMap() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            UnmodifiableMultiValuedMap.unmodifiableMultiValuedMap(null);
        });
    }
}
