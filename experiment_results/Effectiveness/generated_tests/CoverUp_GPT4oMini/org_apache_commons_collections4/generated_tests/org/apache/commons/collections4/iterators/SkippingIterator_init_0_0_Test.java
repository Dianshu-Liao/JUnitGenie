package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.iterators.SkippingIterator;
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

class SkippingIterator_init_0_0_Test {

    private SkippingIterator<Integer> skippingIterator;

    @BeforeEach
    void setUp() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Iterator<Integer> iterator = list.iterator();
        // offset set to 3
        skippingIterator = new SkippingIterator<>(iterator, 3);
    }

    @Test
    void testInitWithOffsetLessThanIteratorSize() throws Exception {
        // Invoke the private init method using reflection
        Method initMethod = SkippingIterator.class.getDeclaredMethod("init");
        initMethod.setAccessible(true);
        initMethod.invoke(skippingIterator);
        // After initialization, the first three elements should be skipped
        assertTrue(skippingIterator.hasNext());
        assertEquals(4, skippingIterator.next());
        assertEquals(5, skippingIterator.next());
        assertFalse(skippingIterator.hasNext());
    }

    @Test
    void testInitWithOffsetEqualToIteratorSize() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Iterator<Integer> iterator = list.iterator();
        // offset set to 3
        skippingIterator = new SkippingIterator<>(iterator, 3);
        Method initMethod = SkippingIterator.class.getDeclaredMethod("init");
        initMethod.setAccessible(true);
        initMethod.invoke(skippingIterator);
        // No elements should be available after skipping all
        assertFalse(skippingIterator.hasNext());
    }

    @Test
    void testInitWithOffsetGreaterThanIteratorSize() throws Exception {
        List<Integer> list = Arrays.asList(1, 2);
        Iterator<Integer> iterator = list.iterator();
        // offset set to 5
        skippingIterator = new SkippingIterator<>(iterator, 5);
        Method initMethod = SkippingIterator.class.getDeclaredMethod("init");
        initMethod.setAccessible(true);
        initMethod.invoke(skippingIterator);
        // No elements should be available after trying to skip more than available
        assertFalse(skippingIterator.hasNext());
    }

    @Test
    void testInitWithOffsetNegative() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new SkippingIterator<>(Arrays.asList(1, 2, 3).iterator(), -1);
        });
        assertEquals("Offset parameter must not be negative.", thrown.getMessage());
    }
}
