package org.apache.commons.collections4.iterators;

import java.lang.reflect.Method;
import java.util.Arrays;
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

class BoundedIterator_hasNext_1_0_Test {

    private BoundedIterator<String> boundedIterator;

    private Iterator<String> mockIterator;

    @BeforeEach
    void setUp() {
        // Setting up a mock iterator with some elements
        List<String> elements = Arrays.asList("one", "two", "three");
        mockIterator = elements.iterator();
    }

    @Test
    void testHasNextWithinBounds() throws Exception {
        boundedIterator = new BoundedIterator<>(mockIterator, 0, 3);
        assertTrue(boundedIterator.hasNext(), "Expected hasNext to return true within bounds");
    }

    @Test
    void testHasNextExceedsMax() throws Exception {
        boundedIterator = new BoundedIterator<>(mockIterator, 0, 2);
        // Move position to exceed max
        invokePrivateMethod("advancePosition", 3);
        assertFalse(boundedIterator.hasNext(), "Expected hasNext to return false when position exceeds max");
    }

    @Test
    void testHasNextBelowOffset() throws Exception {
        boundedIterator = new BoundedIterator<>(mockIterator, 2, 3);
        // Move position below offset
        invokePrivateMethod("advancePosition", 1);
        assertFalse(boundedIterator.hasNext(), "Expected hasNext to return false when position is below offset");
    }

    @Test
    void testHasNextAtOffset() throws Exception {
        boundedIterator = new BoundedIterator<>(mockIterator, 1, 3);
        // Move position to offset
        invokePrivateMethod("advancePosition", 1);
        assertTrue(boundedIterator.hasNext(), "Expected hasNext to return true when position is at offset");
    }

    @Test
    void testHasNextAfterLastElement() throws Exception {
        boundedIterator = new BoundedIterator<>(mockIterator, 0, 3);
        // Move to after last element
        invokePrivateMethod("advancePosition", 3);
        assertFalse(boundedIterator.hasNext(), "Expected hasNext to return false after the last element");
    }

    @Test
    void testHasNextWhenIteratorIsEmpty() throws Exception {
        List<String> emptyList = Arrays.asList();
        mockIterator = emptyList.iterator();
        boundedIterator = new BoundedIterator<>(mockIterator, 0, 3);
        assertFalse(boundedIterator.hasNext(), "Expected hasNext to return false when iterator is empty");
    }

    private void invokePrivateMethod(String methodName, long position) throws Exception {
        Method method = BoundedIterator.class.getDeclaredMethod(methodName, long.class);
        method.setAccessible(true);
        method.invoke(boundedIterator, position);
    }
}
