package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.Unmodifiable;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

public class UnmodifiableMapIterator_unmodifiableMapIterator_0_0_Test {

    @Test
    public void testUnmodifiableMapIterator_NullIterator_ThrowsException() {
        // Arrange
        MapIterator<Object, Object> nullIterator = null;
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            UnmodifiableMapIterator.unmodifiableMapIterator(nullIterator);
        });
    }

    @Test
    public void testUnmodifiableMapIterator_ValidIterator_ReturnsUnmodifiableIterator() {
        // Arrange
        MapIterator<String, Integer> mockIterator = mock(MapIterator.class);
        // Act
        MapIterator<String, Integer> result = UnmodifiableMapIterator.unmodifiableMapIterator(mockIterator);
        // Assert
        // Verify that the result is an instance of UnmodifiableMapIterator
        assertTrue(result instanceof UnmodifiableMapIterator);
    }

    @Test
    public void testUnmodifiableMapIterator_AlreadyUnmodifiableIterator_ReturnsSameInstance() {
        // Arrange
        MapIterator<String, Integer> mockUnmodifiableIterator = mock(MapIterator.class, Mockito.withSettings().extraInterfaces(Unmodifiable.class));
        // Act
        MapIterator<String, Integer> result = UnmodifiableMapIterator.unmodifiableMapIterator(mockUnmodifiableIterator);
        // Assert
        // Verify that the result is the same instance as the input
        assertSame(result, mockUnmodifiableIterator);
    }
}
