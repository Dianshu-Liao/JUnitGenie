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

class UnmodifiableBag_unmodifiableBag_0_0_Test {

    @Test
    void testUnmodifiableBagWithUnmodifiableBag() {
        // Arrange
        Bag<String> originalBag = new HashBag<>();
        originalBag.add("item", 1);
        Bag<String> unmodifiableBag = UnmodifiableBag.unmodifiableBag(originalBag);
        // Act
        Bag<String> result = UnmodifiableBag.unmodifiableBag(unmodifiableBag);
        // Assert
        assertSame(unmodifiableBag, result);
    }

    @Test
    void testUnmodifiableBagWithModifiableBag() {
        // Arrange
        Bag<String> modifiableBag = new HashBag<>();
        modifiableBag.add("item1", 2);
        modifiableBag.add("item2", 3);
        // Act
        Bag<String> result = UnmodifiableBag.unmodifiableBag(modifiableBag);
        // Assert
        assertNotSame(modifiableBag, result);
        assertEquals(2, result.getCount("item1"));
        assertEquals(3, result.getCount("item2"));
        assertThrows(UnsupportedOperationException.class, () -> result.add("item3", 1));
    }

    @Test
    void testUnmodifiableBagWithNullBag() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> UnmodifiableBag.unmodifiableBag(null));
    }
}
