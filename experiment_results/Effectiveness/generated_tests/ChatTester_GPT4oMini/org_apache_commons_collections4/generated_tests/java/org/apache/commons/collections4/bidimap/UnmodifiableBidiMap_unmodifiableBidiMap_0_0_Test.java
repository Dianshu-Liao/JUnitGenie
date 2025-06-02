package org.apache.commons.collections4.bidimap;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.Unmodifiable;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections4.map.UnmodifiableEntrySet;
import org.apache.commons.collections4.set.UnmodifiableSet;

@ExtendWith(MockitoExtension.class)
public class UnmodifiableBidiMap_unmodifiableBidiMap_0_0_Test {

    @Test
    public void testUnmodifiableBidiMap_WithUnmodifiableMap() {
        // Arrange
        BidiMap<String, Integer> unmodifiableMap = Mockito.mock(BidiMap.class);
        Mockito.when(unmodifiableMap instanceof Unmodifiable).thenReturn(true);
        // Act
        BidiMap<String, Integer> result = UnmodifiableBidiMap.unmodifiableBidiMap(unmodifiableMap);
        // Assert
        assertNotNull(result);
        assertSame(unmodifiableMap, result);
    }

    @Test
    public void testUnmodifiableBidiMap_WithModifiableMap() throws Exception {
        // Arrange
        BidiMap<String, Integer> modifiableMap = Mockito.mock(BidiMap.class);
        // Use reflection to access the private constructor of UnmodifiableBidiMap
        Constructor<UnmodifiableBidiMap> constructor = UnmodifiableBidiMap.class.getDeclaredConstructor(BidiMap.class);
        constructor.setAccessible(true);
        BidiMap<String, Integer> expectedUnmodifiableMap = constructor.newInstance(modifiableMap);
        // Act
        BidiMap<String, Integer> result = UnmodifiableBidiMap.unmodifiableBidiMap(modifiableMap);
        // Assert
        assertNotNull(result);
        assertNotSame(modifiableMap, result);
        assertTrue(result instanceof UnmodifiableBidiMap);
        assertEquals(expectedUnmodifiableMap, result);
        // Additional checks can be performed to verify the behavior of the result
    }
}
