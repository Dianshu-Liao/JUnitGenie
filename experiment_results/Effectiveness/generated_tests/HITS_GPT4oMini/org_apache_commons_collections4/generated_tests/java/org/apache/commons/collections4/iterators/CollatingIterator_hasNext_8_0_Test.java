package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
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
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.list.UnmodifiableList;

public class CollatingIterator_hasNext_8_0_Test {

    private CollatingIterator<Integer> collatingIterator;

    @BeforeEach
    public void setUp() {
        collatingIterator = new CollatingIterator<>();
    }

    @Test
    public void testHasNext_WithEmptyIterators_ShouldReturnFalse() {
        collatingIterator = new CollatingIterator<>(null, Collections.emptyList());
        assertFalse(collatingIterator.hasNext(), "Expected hasNext() to return false with empty iterators");
    }

    @Test
    public void testHasNext_WithSingleEmptyIterator_ShouldReturnFalse() {
        collatingIterator = new CollatingIterator<>(null, Collections.singletonList(Collections.emptyIterator()));
        assertFalse(collatingIterator.hasNext(), "Expected hasNext() to return false with a single empty iterator");
    }

    @Test
    public void testHasNext_WithSingleIteratorHavingNext_ShouldReturnTrue() {
        collatingIterator = new CollatingIterator<>(null, Collections.singletonList(Arrays.asList(1).iterator()));
        assertTrue(collatingIterator.hasNext(), "Expected hasNext() to return true when an iterator has a next element");
    }

    @Test
    public void testHasNext_WithMultipleIterators_AllEmpty_ShouldReturnFalse() {
        collatingIterator = new CollatingIterator<>(null, Arrays.asList(Collections.emptyIterator(), Collections.emptyIterator()));
        assertFalse(collatingIterator.hasNext(), "Expected hasNext() to return false with multiple empty iterators");
    }

    @Test
    public void testHasNext_WithMultipleIterators_OneHasNext_ShouldReturnTrue() {
        collatingIterator = new CollatingIterator<>(null, Arrays.asList(Collections.emptyIterator(), Arrays.asList(2).iterator()));
        assertTrue(collatingIterator.hasNext(), "Expected hasNext() to return true when at least one iterator has a next element");
    }

    @Test
    public void testHasNext_WithMultipleIterators_AllHaveNext_ShouldReturnTrue() {
        collatingIterator = new CollatingIterator<>(null, Arrays.asList(Arrays.asList(1).iterator(), Arrays.asList(2).iterator()));
        assertTrue(collatingIterator.hasNext(), "Expected hasNext() to return true when all iterators have next elements");
    }

    @Test
    public void testHasNext_AfterNextCall_ShouldReturnTrue() {
        collatingIterator = new CollatingIterator<>(null, Arrays.asList(Arrays.asList(1).iterator(), Arrays.asList(2).iterator()));
        // Initialize the state
        collatingIterator.hasNext();
    }
}
