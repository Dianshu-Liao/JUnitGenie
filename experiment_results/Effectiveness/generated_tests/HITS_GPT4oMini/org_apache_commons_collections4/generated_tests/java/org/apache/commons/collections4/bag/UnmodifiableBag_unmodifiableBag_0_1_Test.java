package org.apache.commons.collections4.bag;

import org.apache.commons.collections4.Bag;
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
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import org.apache.commons.collections4.set.UnmodifiableSet;

public class UnmodifiableBag_unmodifiableBag_0_1_Test {

    @Test
    void testUnmodifiableBagReturnsUnmodifiableInstance() {
        Bag<String> bag = new HashBag<>();
        bag.add("item1", 2);
        Bag<String> unmodifiableBag = UnmodifiableBag.unmodifiableBag(bag);
        assertTrue(unmodifiableBag instanceof UnmodifiableBag);
        assertEquals(2, unmodifiableBag.getCount("item1"));
    }

    @Test
    void testUnmodifiableBagThrowsExceptionOnModification() {
        Bag<String> bag = new HashBag<>();
        bag.add("item1", 2);
        Bag<String> unmodifiableBag = UnmodifiableBag.unmodifiableBag(bag);
        assertThrows(UnsupportedOperationException.class, () -> {
            unmodifiableBag.add("item2");
        });
        assertThrows(UnsupportedOperationException.class, () -> {
            unmodifiableBag.remove("item1");
        });
    }

    @Test
    void testUnmodifiableBagReturnsSameInstanceForAlreadyUnmodifiable() {
        Bag<String> bag = UnmodifiableBag.unmodifiableBag(new HashBag<>());
        Bag<String> unmodifiableBag = UnmodifiableBag.unmodifiableBag(bag);
        assertSame(bag, unmodifiableBag);
    }

    @Test
    void testUnmodifiableBagWithNullThrowsException() {
        assertThrows(NullPointerException.class, () -> {
            UnmodifiableBag.unmodifiableBag(null);
        });
    }
}
