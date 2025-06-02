package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ZippingIterator;
import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class iterators_ZippingIterator__init__Iterator_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testZippingIteratorWithNonNullIterators() {
        Iterator<Integer> iterator1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Integer> iterator2 = Arrays.asList(4, 5, 6).iterator();
        Iterator<Integer> iterator3 = Arrays.asList(7, 8, 9).iterator();

        ZippingIterator<Integer> zippingIterator = new ZippingIterator<>(iterator1, iterator2, iterator3);
        
        assertTrue(zippingIterator.hasNext());
        assertEquals(Integer.valueOf(1), zippingIterator.next());
        assertEquals(Integer.valueOf(4), zippingIterator.next());
        assertEquals(Integer.valueOf(7), zippingIterator.next());
    }

    @Test(timeout = 4000)
    public void testZippingIteratorWithNullIterator() {
        try {
            ZippingIterator<Integer> zippingIterator = new ZippingIterator<>((Iterator<Integer>) null);
            fail("Expected NullPointerException for null iterator");
        } catch (NullPointerException e) {
            assertEquals("iterator", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testZippingIteratorWithEmptyIterators() {
        Iterator<Integer> iterator1 = Arrays.<Integer>asList().iterator();
        Iterator<Integer> iterator2 = Arrays.<Integer>asList().iterator();

        ZippingIterator<Integer> zippingIterator = new ZippingIterator<>(iterator1, iterator2);
        
        assertFalse(zippingIterator.hasNext());
    }

    @Test(timeout = 4000)
    public void testZippingIteratorWithExhaustedIterators() {
        Iterator<Integer> iterator1 = Arrays.asList(1).iterator();
        Iterator<Integer> iterator2 = Arrays.asList(2).iterator();
        Iterator<Integer> iterator3 = Arrays.asList(3).iterator();

        ZippingIterator<Integer> zippingIterator = new ZippingIterator<>(iterator1, iterator2, iterator3);
        
        assertTrue(zippingIterator.hasNext());
        assertEquals(Integer.valueOf(1), zippingIterator.next());
        assertTrue(zippingIterator.hasNext());
        assertEquals(Integer.valueOf(2), zippingIterator.next());
        assertTrue(zippingIterator.hasNext());
        assertEquals(Integer.valueOf(3), zippingIterator.next());
        assertFalse(zippingIterator.hasNext());
    }


}