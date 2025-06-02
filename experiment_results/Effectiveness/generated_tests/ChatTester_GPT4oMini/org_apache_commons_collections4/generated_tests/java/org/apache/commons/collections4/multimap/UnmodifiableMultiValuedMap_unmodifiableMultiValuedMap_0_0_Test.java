package org.apache.commons.collections4.multimap;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections4.map.UnmodifiableMap;
import org.apache.commons.collections4.multiset.UnmodifiableMultiSet;
import org.apache.commons.collections4.set.UnmodifiableSet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UnmodifiableMultiValuedMap_unmodifiableMultiValuedMap_0_0_Test {

    @Test
    public void testUnmodifiableMultiValuedMap_WithUnmodifiableInstance() {
        // Arrange
        MultiValuedMap<String, String> unmodifiableMap = Mockito.mock(MultiValuedMap.class);
        // Act
        UnmodifiableMultiValuedMap<String, String> result = UnmodifiableMultiValuedMap.unmodifiableMultiValuedMap(unmodifiableMap);
        // Assert
        assertNotNull(result);
        assertSame(unmodifiableMap, result);
    }

    @Test
    public void testUnmodifiableMultiValuedMap_WithRegularInstance() {
        // Arrange
        MultiValuedMap<String, String> regularMap = Mockito.mock(MultiValuedMap.class);
        // Act
        UnmodifiableMultiValuedMap<String, String> result = UnmodifiableMultiValuedMap.unmodifiableMultiValuedMap(regularMap);
        // Assert
        assertNotNull(result);
        // Additional assertions can be performed if the constructor behavior is known
    }

    @Test
    public void testUnmodifiableMultiValuedMap_NullInput() {
        // Arrange
        MultiValuedMap<String, String> nullMap = null;
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            UnmodifiableMultiValuedMap.unmodifiableMultiValuedMap(nullMap);
        });
    }
}
