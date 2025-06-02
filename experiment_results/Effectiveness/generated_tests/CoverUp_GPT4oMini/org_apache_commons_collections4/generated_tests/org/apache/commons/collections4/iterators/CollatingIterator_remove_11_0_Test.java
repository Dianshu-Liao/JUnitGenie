package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.iterators.CollatingIterator;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.collections4.list.UnmodifiableList;

class CollatingIterator_remove_11_0_Test {

    private CollatingIterator<Integer> collatingIterator;

    private Iterator<Integer> iterator1;

    private Iterator<Integer> iterator2;

    @BeforeEach
    void setUp() {
        iterator1 = Arrays.asList(1, 2, 3).iterator();
        iterator2 = Arrays.asList(4, 5, 6).iterator();
        collatingIterator = new CollatingIterator<>(Integer::compareTo, Arrays.asList(iterator1, iterator2));
    }

    @Test
    void testRemove_NoValueReturned_ThrowsIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> collatingIterator.remove());
    }

    @Test
    void testRemove_ValidCondition_RemovesElement() throws Exception {
        invokeSet(0);
        invokeSet(1);
        collatingIterator.remove();
        assertEquals(1, collatingIterator.getIterators().get(0).next());
        assertTrue(iterator2.hasNext());
    }

    @Test
    void testRemove_ValidCondition_RemovesFromSecondIterator() throws Exception {
        invokeSet(1);
        collatingIterator.remove();
        assertEquals(5, collatingIterator.getIterators().get(1).next());
    }

    @Test
    void testRemove_AfterMultipleCalls_ThrowsIllegalStateException() throws Exception {
        invokeSet(0);
        collatingIterator.remove();
        assertThrows(IllegalStateException.class, () -> collatingIterator.remove());
    }

    private void invokeSet(int index) throws Exception {
        Method setMethod = CollatingIterator.class.getDeclaredMethod("set", int.class);
        setMethod.setAccessible(true);
        setMethod.invoke(collatingIterator, index);
    }
}
