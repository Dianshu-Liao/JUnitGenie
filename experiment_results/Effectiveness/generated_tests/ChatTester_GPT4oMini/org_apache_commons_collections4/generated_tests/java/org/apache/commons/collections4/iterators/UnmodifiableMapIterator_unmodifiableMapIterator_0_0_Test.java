package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.collections4.MapIterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.collections4.Unmodifiable;

// Mocking dependencies
interface UnmodifiableMapIterator_unmodifiableMapIterator_0_0_Test<K, V> extends Iterator<Map.Entry<K, V>> {
}

interface UnmodifiableInterface {
}

class UnmodifiableMapIteratorTest {

    private MapIterator<String, String> mockIterator;

    @BeforeEach
    public void setUp() {
        mockIterator = mock(MapIterator.class);
    }

    @Test
    public void testUnmodifiableMapIteratorWithNonUnmodifiable() {
        // Act
        MapIterator<String, String> result = UnmodifiableMapIterator.unmodifiableMapIterator(mockIterator);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof UnmodifiableMapIterator);
    }

    @Test
    public void testUnmodifiableMapIteratorWithUnmodifiable() {
        // Arrange
        MapIterator<String, String> unmodifiableMockIterator = mock(MapIterator.class, withSettings().extraInterfaces(UnmodifiableInterface.class));
        // Act
        MapIterator<String, String> result = UnmodifiableMapIterator.unmodifiableMapIterator(unmodifiableMockIterator);
        // Assert
        assertNotNull(result);
        assertSame(unmodifiableMockIterator, result);
    }

    @Test
    public void testUnmodifiableMapIteratorWithNullIterator() {
        // Act & Assert
        Exception exception = assertThrows(NullPointerException.class, () -> {
            UnmodifiableMapIterator.unmodifiableMapIterator(null);
        });
        assertEquals("iterator", exception.getMessage());
    }

    @Test
    public void testUnmodifiableMapIteratorWithEmptyIterator() {
        // Arrange
        MapIterator<String, String> emptyMockIterator = mock(MapIterator.class);
        when(emptyMockIterator.hasNext()).thenReturn(false);
        // Act
        MapIterator<String, String> result = UnmodifiableMapIterator.unmodifiableMapIterator(emptyMockIterator);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof UnmodifiableMapIterator);
        assertFalse(result.hasNext());
    }
}
