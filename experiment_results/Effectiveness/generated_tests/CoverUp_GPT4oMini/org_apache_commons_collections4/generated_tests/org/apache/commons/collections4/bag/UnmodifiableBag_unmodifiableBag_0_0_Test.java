package org.apache.commons.collections4.bag;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.bag.HashBag;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import org.apache.commons.collections4.set.UnmodifiableSet;

public class UnmodifiableBag_unmodifiableBag_0_0_Test {

    @Test
    public void testUnmodifiableBag_WithUnmodifiableBag() {
        // Arrange
        Bag<String> originalBag = mock(Bag.class);
        when(originalBag instanceof Unmodifiable).thenReturn(true);
        // Act
        Bag<String> result = UnmodifiableBag.unmodifiableBag(originalBag);
        // Assert
        assertSame(originalBag, result);
    }

    @Test
    public void testUnmodifiableBag_WithRegularBag() {
        // Arrange
        Bag<String> originalBag = new HashBag<>();
        originalBag.add("item1", 2);
        originalBag.add("item2", 1);
        // Act
        Bag<String> result = UnmodifiableBag.unmodifiableBag(originalBag);
        // Assert
        assertNotSame(originalBag, result);
        assertThrows(UnsupportedOperationException.class, () -> result.add("item3"));
        assertThrows(UnsupportedOperationException.class, () -> result.clear());
    }

    @Test
    public void testUnmodifiableBag_WithNullBag() {
        // Arrange
        Bag<String> originalBag = null;
        // Act & Assert
        assertThrows(NullPointerException.class, () -> UnmodifiableBag.unmodifiableBag(originalBag));
    }
}
