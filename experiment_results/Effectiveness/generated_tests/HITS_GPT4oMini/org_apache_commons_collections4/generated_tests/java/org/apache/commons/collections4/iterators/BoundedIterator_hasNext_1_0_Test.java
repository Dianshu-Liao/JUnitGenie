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
import java.util.NoSuchElementException;
import java.util.Objects;

public class BoundedIterator_hasNext_1_0_Test {

    private BoundedIterator<Integer> boundedIterator;

    @BeforeEach
    public void setUp() {
        // This will be set up in each test case as needed
    }

    @Test
    public void testHasNext_WhenIteratorIsEmpty_ShouldReturnFalse() {
        boundedIterator = new BoundedIterator<>(Collections.emptyIterator(), 0, 5);
        assertFalse(boundedIterator.hasNext());
    }

    @Test
    public void testHasNext_WhenIteratorHasElementsWithinBounds_ShouldReturnTrue() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        boundedIterator = new BoundedIterator<>(list.iterator(), 0, 5);
        assertTrue(boundedIterator.hasNext());
    }

    @Test
    public void testHasNext_WhenIteratorHasElementsExceedingMax_ShouldReturnFalse() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        boundedIterator = new BoundedIterator<>(list.iterator(), 1, 5);
        assertFalse(boundedIterator.hasNext());
    }

    @Test
    public void testHasNext_WhenOffsetIsGreaterThanMax_ShouldReturnFalse() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        boundedIterator = new BoundedIterator<>(list.iterator(), 3, 2);
        assertFalse(boundedIterator.hasNext());
    }

    @Test
    public void testHasNext_WhenOffsetIsZeroAndMaxIsZero_ShouldReturnFalse() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        boundedIterator = new BoundedIterator<>(list.iterator(), 0, 0);
        assertFalse(boundedIterator.hasNext());
    }

    @Test
    public void testHasNext_WhenIteratorIsNull_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BoundedIterator<>(null, 0, 5);
        });
    }

    @Test
    public void testHasNext_WhenOffsetIsNegative_ShouldThrowException() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        assertThrows(IllegalArgumentException.class, () -> {
            new BoundedIterator<>(list.iterator(), -1, 5);
        });
    }

    @Test
    public void testHasNext_WhenMaxIsNegative_ShouldThrowException() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        assertThrows(IllegalArgumentException.class, () -> {
            new BoundedIterator<>(list.iterator(), 0, -1);
        });
    }
}
