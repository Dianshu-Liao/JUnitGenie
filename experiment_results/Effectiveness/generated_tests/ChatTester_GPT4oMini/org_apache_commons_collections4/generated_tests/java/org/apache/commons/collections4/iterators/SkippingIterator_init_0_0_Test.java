package org.apache.commons.collections4.iterators;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class SkippingIterator_init_0_0_Test {

    private SkippingIterator<Integer> skippingIterator;

    private Iterator<Integer> iterator;

    @BeforeEach
    void setUp() {
        // Initialize the iterator with a sample collection
        iterator = new Iterator<Integer>() {

            private int currentIndex = 0;

            private final Integer[] elements = { 1, 2, 3, 4, 5 };

            @Override
            public boolean hasNext() {
                return currentIndex < elements.length;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return elements[currentIndex++];
            }
        };
    }

    @Test
    void testInit_SkipsToOffset() throws Exception {
        // Create SkippingIterator with an offset of 3
        skippingIterator = new SkippingIterator<>(iterator, 3);
        // Use reflection to access the private init method
        Method initMethod = SkippingIterator.class.getDeclaredMethod("init");
        initMethod.setAccessible(true);
        // Invoke the init method
        initMethod.invoke(skippingIterator);
        // Verify that the position has advanced correctly
        assertTrue(skippingIterator.hasNext());
        // Should be at the 4th element after skipping
        assertEquals(4, skippingIterator.next());
    }

    @Test
    void testInit_AtOffset() throws Exception {
        // Create SkippingIterator with an offset of 5
        skippingIterator = new SkippingIterator<>(iterator, 5);
        // Use reflection to access the private init method
        Method initMethod = SkippingIterator.class.getDeclaredMethod("init");
        initMethod.setAccessible(true);
        // Invoke the init method
        initMethod.invoke(skippingIterator);
        // Verify that there are no more elements left
        assertFalse(skippingIterator.hasNext());
    }

    @Test
    void testInit_OffsetGreaterThanSize() throws Exception {
        // Create SkippingIterator with an offset greater than the number of elements
        skippingIterator = new SkippingIterator<>(iterator, 10);
        // Use reflection to access the private init method
        Method initMethod = SkippingIterator.class.getDeclaredMethod("init");
        initMethod.setAccessible(true);
        // Invoke the init method
        initMethod.invoke(skippingIterator);
        // Verify that there are no more elements left
        assertFalse(skippingIterator.hasNext());
    }
}
