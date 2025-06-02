package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Comparator;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.list.UnmodifiableList;

public class CollatingIterator_CollatingIterator_16_1_Test {

    private CollatingIterator<Integer> collatingIterator;

    @BeforeEach
    public void setUp() {
        collatingIterator = new CollatingIterator<>(Comparator.naturalOrder());
    }

    private int getLastReturned() throws Exception {
        Field lastReturnedField = CollatingIterator.class.getDeclaredField("lastReturned");
        lastReturnedField.setAccessible(true);
        return lastReturnedField.getInt(collatingIterator);
    }

    @Test
    public void testLastReturnedInitialization() throws Exception {
        assertEquals(-1, getLastReturned(), "lastReturned should be initialized to -1");
    }

    @Test
    public void testLastReturnedAfterNoElements() throws Exception {
        assertEquals(-1, getLastReturned(), "lastReturned should still be -1 after no elements returned");
    }

    @Test
    public void testLastReturnedAfterAddingIterators() throws Exception {
        Iterator<Integer> iterator1 = Arrays.asList(1, 3, 5).iterator();
        Iterator<Integer> iterator2 = Arrays.asList(2, 4, 6).iterator();
        collatingIterator = new CollatingIterator<>(Comparator.naturalOrder(), Arrays.asList(iterator1, iterator2));
        assertEquals(-1, getLastReturned(), "lastReturned should still be -1 before any elements are returned");
    }
}
