package org.apache.commons.collections4.bidimap;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableOrderedMapIterator;
import org.apache.commons.collections4.map.UnmodifiableEntrySet;
import org.apache.commons.collections4.set.UnmodifiableSet;
import org.apache.commons.collections4.OrderedMapIterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UnmodifiableOrderedBidiMap_unmodifiableOrderedBidiMap_0_0_Test {

    private OrderedBidiMap<String, Integer> mockMap;

    @BeforeEach
    public void setUp() {
        mockMap = mock(OrderedBidiMap.class);
    }

    @Test
    public void testUnmodifiableOrderedBidiMap_WithUnmodifiableMap() {
        // Arrange
        UnmodifiableOrderedBidiMap<String, Integer> unmodifiableMap = mock(UnmodifiableOrderedBidiMap.class);
        when(mockMap instanceof Unmodifiable).thenReturn(true);
        // Act
        OrderedBidiMap<String, Integer> result = UnmodifiableOrderedBidiMap.unmodifiableOrderedBidiMap(mockMap);
        // Assert
        assertSame(unmodifiableMap, result);
    }

    @Test
    public void testUnmodifiableOrderedBidiMap_WithRegularMap() {
        // Arrange
        when(mockMap instanceof Unmodifiable).thenReturn(false);
        UnmodifiableOrderedBidiMap<String, Integer> unmodifiableOrderedBidiMap = invokePrivateConstructor(UnmodifiableOrderedBidiMap.class, mockMap);
        // Act
        OrderedBidiMap<String, Integer> result = UnmodifiableOrderedBidiMap.unmodifiableOrderedBidiMap(mockMap);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof UnmodifiableOrderedBidiMap);
    }

    private <T> T invokePrivateConstructor(Class<T> clazz, Object... args) {
        try {
            // Fixed buggy line from 'var' to 'java.lang.reflect.Constructor'
            java.lang.reflect.Constructor<T> constructor = clazz.getDeclaredConstructor(OrderedBidiMap.class);
            constructor.setAccessible(true);
            return constructor.newInstance(args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
