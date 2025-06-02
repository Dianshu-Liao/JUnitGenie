package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import org.apache.commons.collections4.list.UnmodifiableList;

public class CollatingIterator_remove_11_0_Test {

    private CollatingIterator<Integer> collatingIterator;

    private Iterator<Integer> iterator1;

    private Iterator<Integer> iterator2;

    @BeforeEach
    public void setUp() {
        iterator1 = Arrays.asList(1, 3, 5).iterator();
        iterator2 = Arrays.asList(2, 4, 6).iterator();
        collatingIterator = new CollatingIterator<>(null, Arrays.asList(iterator1, iterator2));
    }

    @Test
    public void testRemove_NoElementReturned_ThrowsIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> collatingIterator.remove());
    }

    @Test
    public void testRemove_ValidElementReturned_RemovesElementFromIterator() {
        // Move to the first element
        collatingIterator.getIterators().get(0).next();
        // Now remove it
        collatingIterator.remove();
        List<Integer> expectedValues = Arrays.asList(3, 5);
        assertTrue(iterator1.hasNext());
        assertEquals(expectedValues, Arrays.asList(iterator1.next(), iterator1.next()));
    }

    @Test
    public void testRemove_ValidElementReturnedFromSecondIterator_RemovesElementFromSecondIterator() {
        // Move to the first element of the second iterator
        collatingIterator.getIterators().get(1).next();
        // Now remove it
        collatingIterator.remove();
        List<Integer> expectedValues = Arrays.asList(4, 6);
        assertTrue(iterator2.hasNext());
        assertEquals(expectedValues, Arrays.asList(iterator2.next(), iterator2.next()));
    }

    @Test
    public void testRemove_CallsRemoveMultipleTimes_ThrowsIllegalStateException() {
        // Move to the first element
        collatingIterator.getIterators().get(0).next();
        // Remove it
        collatingIterator.remove();
        assertThrows(IllegalStateException.class, () -> collatingIterator.remove());
    }

    @Test
    public void testRemove_NoElementReturnedFromIterator_ThrowsIllegalStateException() {
        // Move to the first element
        collatingIterator.getIterators().get(0).next();
        // Remove it
        collatingIterator.remove();
        assertThrows(IllegalStateException.class, () -> {
            // Attempt to set again
            collatingIterator.getIterators().get(0).next();
            // This should throw
            collatingIterator.remove();
        });
    }

    @Test
    public void testRemove_EmptyIterator_ThrowsNoSuchElementException() {
        // Move to the first element
        collatingIterator.getIterators().get(0).next();
        // Remove it
        collatingIterator.remove();
        assertThrows(NoSuchElementException.class, () -> {
            // Attempt to set again
            collatingIterator.getIterators().get(0).next();
            // This should throw
            collatingIterator.remove();
        });
    }
}
