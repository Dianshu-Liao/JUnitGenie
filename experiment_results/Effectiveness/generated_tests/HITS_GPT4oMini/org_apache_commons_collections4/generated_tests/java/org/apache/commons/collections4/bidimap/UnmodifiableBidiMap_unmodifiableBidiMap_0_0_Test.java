package org.apache.commons.collections4.bidimap;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.set.UnmodifiableSet;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections4.map.UnmodifiableEntrySet;

public class UnmodifiableBidiMap_unmodifiableBidiMap_0_0_Test {

    @Test
    public void testUnmodifiableBidiMap_WithModifiableMap() {
        BidiMap<String, Integer> modifiableMap = new DualHashBidiMap<>();
        modifiableMap.put("One", 1);
        modifiableMap.put("Two", 2);
        BidiMap<String, Integer> unmodifiableMap = UnmodifiableBidiMap.unmodifiableBidiMap(modifiableMap);
        assertNotNull(unmodifiableMap);
        assertSame(modifiableMap, unmodifiableMap);
    }

    @Test
    public void testUnmodifiableBidiMap_WithUnmodifiableMap() {
        BidiMap<String, Integer> modifiableMap = new DualHashBidiMap<>();
        modifiableMap.put("One", 1);
        modifiableMap.put("Two", 2);
        BidiMap<String, Integer> unmodifiableMap = UnmodifiableBidiMap.unmodifiableBidiMap(modifiableMap);
        BidiMap<String, Integer> result = UnmodifiableBidiMap.unmodifiableBidiMap(unmodifiableMap);
        assertNotNull(result);
        assertSame(unmodifiableMap, result);
    }

    @Test
    public void testUnmodifiableBidiMap_WithNullMap() {
        assertThrows(NullPointerException.class, () -> {
            UnmodifiableBidiMap.unmodifiableBidiMap(null);
        });
    }
}
