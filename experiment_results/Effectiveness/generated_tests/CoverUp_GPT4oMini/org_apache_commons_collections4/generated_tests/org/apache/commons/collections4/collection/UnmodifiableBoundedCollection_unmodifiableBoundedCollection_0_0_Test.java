package org.apache.commons.collections4.collection;

import org.apache.commons.collections4.BoundedCollection;
import org.apache.commons.collections4.Unmodifiable;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;

class UnmodifiableBoundedCollection_unmodifiableBoundedCollection_0_0_Test {

    private BoundedCollection<String> boundedCollectionMock;

    private BoundedCollection<String> unmodifiableBoundedCollectionMock;

    @BeforeEach
    void setUp() {
        boundedCollectionMock = mock(BoundedCollection.class);
        unmodifiableBoundedCollectionMock = mock(BoundedCollection.class, withSettings().extraInterfaces(Unmodifiable.class));
    }

    @Test
    void testUnmodifiableBoundedCollection_WithUnmodifiableCollection() {
        // Arrange
        when(unmodifiableBoundedCollectionMock instanceof Unmodifiable).thenReturn(true);
        // Act
        BoundedCollection<String> result = UnmodifiableBoundedCollection.unmodifiableBoundedCollection(unmodifiableBoundedCollectionMock);
        // Assert
        assertSame(unmodifiableBoundedCollectionMock, result);
        verify(unmodifiableBoundedCollectionMock, never()).add(any());
    }

    @Test
    void testUnmodifiableBoundedCollection_WithModifiableCollection() {
        // Arrange
        when(boundedCollectionMock instanceof Unmodifiable).thenReturn(false);
        // Act
        BoundedCollection<String> result = UnmodifiableBoundedCollection.unmodifiableBoundedCollection(boundedCollectionMock);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof UnmodifiableBoundedCollection);
        verify(boundedCollectionMock, never()).add(any());
    }

    @Test
    void testUnmodifiableBoundedCollection_WithNullCollection() {
        // Arrange
        BoundedCollection<String> nullCollection = null;
        // Act & Assert
        Exception exception = assertThrows(NullPointerException.class, () -> {
            UnmodifiableBoundedCollection.unmodifiableBoundedCollection(nullCollection);
        });
        assertEquals("collection", exception.getMessage());
    }

    @Test
    void testUnmodifiableBoundedCollection_WithNonBoundedCollection() {
        // Arrange
        List<String> nonBoundedCollection = new ArrayList<>();
        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UnmodifiableBoundedCollection.unmodifiableBoundedCollection(nonBoundedCollection);
        });
        assertEquals("Collection is not a bounded collection.", exception.getMessage());
    }
}
