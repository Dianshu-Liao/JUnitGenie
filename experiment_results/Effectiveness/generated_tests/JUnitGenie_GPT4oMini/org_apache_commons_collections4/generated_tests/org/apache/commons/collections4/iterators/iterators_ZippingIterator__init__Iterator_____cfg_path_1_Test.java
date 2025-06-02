package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ZippingIterator;
import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class iterators_ZippingIterator__init__Iterator_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testZippingIterator_WithValidIterators() {
        Iterator<Integer> iterator1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<String> iterator2 = Arrays.asList("A", "B", "C").iterator();
        Iterator<Double> iterator3 = Arrays.asList(1.0, 2.0, 3.0).iterator(); // Changed Object to Double

        ZippingIterator<Object> zippingIterator = new ZippingIterator<>(iterator1, iterator2, iterator3);

        assertTrue(zippingIterator.hasNext());
        assertEquals(1, zippingIterator.next());
        assertEquals("A", zippingIterator.next());
        assertEquals(1.0, zippingIterator.next());
        assertTrue(zippingIterator.hasNext());
        assertEquals(2, zippingIterator.next());
        assertEquals("B", zippingIterator.next());
        assertEquals(2.0, zippingIterator.next());
        assertTrue(zippingIterator.hasNext());
        assertEquals(3, zippingIterator.next());
        assertEquals("C", zippingIterator.next());
        assertEquals(3.0, zippingIterator.next());
        assertFalse(zippingIterator.hasNext());
    }

    @Test(timeout = 4000)
    public void testZippingIterator_WithNullIterator() {
        try {
            ZippingIterator<Object> zippingIterator = new ZippingIterator<>(null, null); // Added a second null for varargs
            fail("Expected NullPointerException for null iterator");
        } catch (NullPointerException e) {
            assertEquals("iterator", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testZippingIterator_WithExhaustedIterators() {
        Iterator<Object> emptyIterator = Arrays.asList().iterator(); // Changed Integer to Object

        Iterator<String> iterator = Arrays.asList("A", "B", "C").iterator();

        ZippingIterator<Object> zippingIterator = new ZippingIterator<>(emptyIterator, iterator);

        assertFalse(zippingIterator.hasNext()); // Corrected the assertion to check for empty iterator
    }


}