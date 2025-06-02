package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.iterators.BoundedIterator;
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

class BoundedIterator_init_2_0_Test {

    private BoundedIterator<Integer> boundedIterator;

    @BeforeEach
    void setUp() {
        // Setup a sample iterator for testing
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        boundedIterator = new BoundedIterator<>(list.iterator(), 2, 5);
    }

    @Test
    void testInitWithOffsetLessThanIteratorSize() throws Exception {
        // Use reflection to invoke the private init method
        Method initMethod = BoundedIterator.class.getDeclaredMethod("init");
        initMethod.setAccessible(true);
        // Call init method
        initMethod.invoke(boundedIterator);
        // Verify that the position is set correctly after init
        assertEquals(2, getPos(boundedIterator));
    }

    @Test
    void testInitWithOffsetGreaterThanIteratorSize() throws Exception {
        // Create a new BoundedIterator with an offset greater than the iterator size
        List<Integer> list = Arrays.asList(1, 2);
        boundedIterator = new BoundedIterator<>(list.iterator(), 5, 5);
        // Use reflection to invoke the private init method
        Method initMethod = BoundedIterator.class.getDeclaredMethod("init");
        initMethod.setAccessible(true);
        // Call init method
        initMethod.invoke(boundedIterator);
        // Verify that the position is still 0 because offset is greater than size
        assertEquals(0, getPos(boundedIterator));
    }

    @Test
    void testInitWithEmptyIterator() throws Exception {
        // Create a new BoundedIterator with an empty iterator
        List<Integer> list = Arrays.asList();
        boundedIterator = new BoundedIterator<>(list.iterator(), 0, 5);
        // Use reflection to invoke the private init method
        Method initMethod = BoundedIterator.class.getDeclaredMethod("init");
        initMethod.setAccessible(true);
        // Call init method
        initMethod.invoke(boundedIterator);
        // Verify that the position is still 0
        assertEquals(0, getPos(boundedIterator));
    }

    private long getPos(BoundedIterator<?> boundedIterator) throws Exception {
        // Use reflection to access the private pos field
        java.lang.reflect.Field posField = BoundedIterator.class.getDeclaredField("pos");
        posField.setAccessible(true);
        return posField.getLong(boundedIterator);
    }
}
