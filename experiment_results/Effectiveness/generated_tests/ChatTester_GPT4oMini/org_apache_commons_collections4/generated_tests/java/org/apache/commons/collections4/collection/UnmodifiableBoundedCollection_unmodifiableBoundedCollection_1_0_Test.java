package org.apache.commons.collections4.collection;

import java.util.ArrayList;
import java.util.Collection;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.BoundedCollection;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;

public class UnmodifiableBoundedCollection_unmodifiableBoundedCollection_1_0_Test {

    private BoundedCollection<String> boundedCollectionMock;

    private AbstractCollectionDecorator<String> abstractCollectionDecoratorMock;

    private SynchronizedCollection<String> synchronizedCollectionMock;

    @BeforeEach
    public void setUp() {
        boundedCollectionMock = mock(BoundedCollection.class);
        abstractCollectionDecoratorMock = mock(AbstractCollectionDecorator.class);
        synchronizedCollectionMock = mock(SynchronizedCollection.class);
    }

    @Test
    public void testUnmodifiableBoundedCollection_ValidBoundedCollection() {
        // Given
        when(boundedCollectionMock instanceof BoundedCollection).thenReturn(true);
        // When
        BoundedCollection<String> result = UnmodifiableBoundedCollection.unmodifiableBoundedCollection(boundedCollectionMock);
        // Then
        assertNotNull(result);
        assertEquals(boundedCollectionMock, result);
    }

    @Test
    public void testUnmodifiableBoundedCollection_ValidAbstractCollectionDecorator() {
        // Given
        when(abstractCollectionDecoratorMock.decorated()).thenReturn(boundedCollectionMock);
        when(abstractCollectionDecoratorMock instanceof AbstractCollectionDecorator).thenReturn(true);
        // When
        BoundedCollection<String> result = UnmodifiableBoundedCollection.unmodifiableBoundedCollection(abstractCollectionDecoratorMock);
        // Then
        assertNotNull(result);
        assertEquals(boundedCollectionMock, result);
    }

    @Test
    public void testUnmodifiableBoundedCollection_ValidSynchronizedCollection() {
        // Given
        when(synchronizedCollectionMock.decorated()).thenReturn(boundedCollectionMock);
        when(synchronizedCollectionMock instanceof SynchronizedCollection).thenReturn(true);
        // When
        BoundedCollection<String> result = UnmodifiableBoundedCollection.unmodifiableBoundedCollection(synchronizedCollectionMock);
        // Then
        assertNotNull(result);
        assertEquals(boundedCollectionMock, result);
    }

    @Test
    public void testUnmodifiableBoundedCollection_InvalidCollection() {
        // Given
        Collection<String> nonBoundedCollection = new ArrayList<>();
        // When & Then
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            UnmodifiableBoundedCollection.unmodifiableBoundedCollection(nonBoundedCollection);
        });
        assertEquals("Collection is not a bounded collection.", thrown.getMessage());
    }

    @Test
    public void testUnmodifiableBoundedCollection_NullCollection() {
        // When & Then
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> {
            UnmodifiableBoundedCollection.unmodifiableBoundedCollection(null);
        });
        assertEquals("collection", thrown.getMessage());
    }

    @Test
    public void testUnmodifiableBoundedCollection_ExceedsLoopLimit() {
        // Given
        when(abstractCollectionDecoratorMock.decorated()).thenReturn(abstractCollectionDecoratorMock);
        when(abstractCollectionDecoratorMock instanceof AbstractCollectionDecorator).thenReturn(true);
        // When & Then
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            UnmodifiableBoundedCollection.unmodifiableBoundedCollection(abstractCollectionDecoratorMock);
        });
        assertEquals("Collection is not a bounded collection.", thrown.getMessage());
    }
}
