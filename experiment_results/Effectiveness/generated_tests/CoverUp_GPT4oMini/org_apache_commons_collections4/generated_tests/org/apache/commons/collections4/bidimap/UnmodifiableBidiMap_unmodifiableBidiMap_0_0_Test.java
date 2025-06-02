package org.apache.commons.collections4.bidimap;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.Unmodifiable;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections4.map.UnmodifiableEntrySet;
import org.apache.commons.collections4.set.UnmodifiableSet;

public class UnmodifiableBidiMap_unmodifiableBidiMap_0_0_Test {

    private BidiMap<String, Integer> mockBidiMap;

    @BeforeEach
    public void setUp() {
        mockBidiMap = mock(BidiMap.class);
    }

    @Test
    public void testUnmodifiableBidiMap_WithUnmodifiableMap() {
        when(mockBidiMap instanceof Unmodifiable).thenReturn(true);
        BidiMap<String, Integer> result = UnmodifiableBidiMap.unmodifiableBidiMap(mockBidiMap);
        assertSame(mockBidiMap, result);
    }

    @Test
    public void testUnmodifiableBidiMap_WithModifiableMap() {
        when(mockBidiMap instanceof Unmodifiable).thenReturn(false);
        BidiMap<String, Integer> result = UnmodifiableBidiMap.unmodifiableBidiMap(mockBidiMap);
        assertNotNull(result);
        assertNotSame(mockBidiMap, result);
    }

    @Test
    public void testUnmodifiableBidiMap_WithNullMap() {
        assertThrows(NullPointerException.class, () -> {
            UnmodifiableBidiMap.unmodifiableBidiMap(null);
        });
    }
}
