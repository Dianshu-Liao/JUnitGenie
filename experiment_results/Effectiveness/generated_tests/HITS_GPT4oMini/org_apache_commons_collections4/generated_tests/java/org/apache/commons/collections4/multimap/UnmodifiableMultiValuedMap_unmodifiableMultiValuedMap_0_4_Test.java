package org.apache.commons.collections4.multimap;

import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.collections4.MultiValuedMap;
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
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections4.map.UnmodifiableMap;
import org.apache.commons.collections4.multiset.UnmodifiableMultiSet;
import org.apache.commons.collections4.set.UnmodifiableSet;

public class UnmodifiableMultiValuedMap_unmodifiableMultiValuedMap_0_4_Test {

    @Test
    public void testUnmodifiableMultiValuedMap_WithModifiableMap() {
        // Arrange
        MultiValuedMap<String, String> modifiableMap = new ArrayListValuedHashMap<>();
        modifiableMap.put("key1", "value1");
        modifiableMap.put("key1", "value2");
        // Act
        UnmodifiableMultiValuedMap<String, String> unmodifiableMap = UnmodifiableMultiValuedMap.unmodifiableMultiValuedMap(modifiableMap);
        // Assert
        assertNotNull(unmodifiableMap);
        assertEquals(2, unmodifiableMap.get("key1").size());
        assertTrue(unmodifiableMap.get("key1").contains("value1"));
        assertTrue(unmodifiableMap.get("key1").contains("value2"));
    }

    @Test
    public void testUnmodifiableMultiValuedMap_WithUnmodifiableMap() {
        // Arrange
        MultiValuedMap<String, String> modifiableMap = new ArrayListValuedHashMap<>();
        modifiableMap.put("key1", "value1");
        UnmodifiableMultiValuedMap<String, String> unmodifiableMap = UnmodifiableMultiValuedMap.unmodifiableMultiValuedMap(modifiableMap);
        // Act
        UnmodifiableMultiValuedMap<String, String> result = UnmodifiableMultiValuedMap.unmodifiableMultiValuedMap(unmodifiableMap);
        // Assert
        assertSame(unmodifiableMap, result);
    }

    @Test
    public void testUnmodifiableMultiValuedMap_NullMap() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            UnmodifiableMultiValuedMap.unmodifiableMultiValuedMap(null);
        });
    }
}
