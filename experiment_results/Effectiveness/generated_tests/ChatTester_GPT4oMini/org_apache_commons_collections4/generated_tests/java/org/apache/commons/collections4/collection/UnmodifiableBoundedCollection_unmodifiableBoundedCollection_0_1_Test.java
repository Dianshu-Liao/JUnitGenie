package org.apache.commons.collections4.collection;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.BoundedCollection;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import java.util.ArrayList;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UnmodifiableBoundedCollection_unmodifiableBoundedCollection_0_1_Test {

    @Test
    public void testUnmodifiableBoundedCollection_WithUnmodifiableInstance() {
        // Arrange
        BoundedCollection<String> mockCollection = Mockito.mock(BoundedCollection.class);
        Mockito.when(mockCollection instanceof Unmodifiable).thenReturn(true);
        // Act
        BoundedCollection<String> result = UnmodifiableBoundedCollection.unmodifiableBoundedCollection(mockCollection);
        // Assert
        assertSame(mockCollection, result);
    }

    @Test
    public void testUnmodifiableBoundedCollection_WithRegularInstance() {
        // Arrange
        BoundedCollection<String> mockCollection = Mockito.mock(BoundedCollection.class);
        // Act
        BoundedCollection<String> result = UnmodifiableBoundedCollection.unmodifiableBoundedCollection(mockCollection);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof UnmodifiableBoundedCollection);
    }

    @Test
    public void testUnmodifiableBoundedCollection_WithNullCollection() {
        // Arrange
        BoundedCollection<String> nullCollection = null;
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            UnmodifiableBoundedCollection.unmodifiableBoundedCollection(nullCollection);
        });
        assertEquals("Collection is not a bounded collection.", exception.getMessage());
    }

    @Test
    public void testUnmodifiableBoundedCollection_WithNonBoundedCollection() {
        // Arrange
        Collection<String> nonBoundedCollection = new ArrayList<>();
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            UnmodifiableBoundedCollection.unmodifiableBoundedCollection(nonBoundedCollection);
        });
        assertEquals("Collection is not a bounded collection.", exception.getMessage());
    }
}
