package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

class BoundedIterator_hasNext_1_0_Test {

    private BoundedIterator<Integer> boundedIterator;

    @BeforeEach
    void setUp() {
        // Setup a sample iterator
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        boundedIterator = new BoundedIterator<>(iterator, 0, 3);
    }

    @Test
    void testHasNext_WhenWithinBounds_ReturnsTrue() {
        assertTrue(boundedIterator.hasNext());
    }

    @Test
    void testHasNext_WhenExceedsMax_ReturnsFalse() throws Exception {
        // Use reflection to set the position to exceed the max
        setPrivateField(boundedIterator, "pos", 4);
        assertFalse(boundedIterator.hasNext());
    }

    @Test
    void testHasNext_WhenAtMax_ReturnsFalse() throws Exception {
        // Use reflection to set the position to exactly max
        setPrivateField(boundedIterator, "pos", 3);
        assertFalse(boundedIterator.hasNext());
    }

    @Test
    void testHasNext_WhenIteratorIsExhausted_ReturnsFalse() {
        // Exhaust the iterator
        // 1
        boundedIterator.next();
        // 2
        boundedIterator.next();
        // 3
        boundedIterator.next();
        assertFalse(boundedIterator.hasNext());
    }

    @Test
    void testHasNext_WhenIteratorHasNext_ReturnsTrue() {
        // 1
        boundedIterator.next();
        // Should return true for next element
        assertTrue(boundedIterator.hasNext());
    }

    @Test
    void testHasNext_WhenOffsetIsNegative_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BoundedIterator<>(Arrays.asList(1, 2, 3).iterator(), -1, 3);
        });
    }

    @Test
    void testHasNext_WhenMaxIsNegative_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BoundedIterator<>(Arrays.asList(1, 2, 3).iterator(), 0, -1);
        });
    }

    private void setPrivateField(BoundedIterator<?> obj, String fieldName, long value) throws Exception {
        java.lang.reflect.Field field = BoundedIterator.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.setLong(obj, value);
    }
}
