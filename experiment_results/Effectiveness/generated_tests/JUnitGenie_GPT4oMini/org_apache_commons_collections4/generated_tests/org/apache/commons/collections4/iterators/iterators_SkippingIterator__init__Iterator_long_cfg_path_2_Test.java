package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.SkippingIterator;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class iterators_SkippingIterator__init__Iterator_long_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSkippingIteratorWithValidOffset() {
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3, 4, 5).iterator();
        long offset = 2;

        SkippingIterator<Integer> skippingIterator = new SkippingIterator<>(iterator, offset);
        
        // Verify the internal state using a public method or reflection if necessary
        assertEquals(2, getOffset(skippingIterator));
        assertEquals(0, getPosition(skippingIterator));
    }

    private long getOffset(SkippingIterator<Integer> skippingIterator) {
        // Use reflection to access the private field if necessary
        try {
            java.lang.reflect.Field field = SkippingIterator.class.getDeclaredField("offset");
            field.setAccessible(true);
            return (long) field.get(skippingIterator);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getPosition(SkippingIterator<Integer> skippingIterator) {
        // Use reflection to access the private field if necessary
        try {
            java.lang.reflect.Field field = SkippingIterator.class.getDeclaredField("pos");
            field.setAccessible(true);
            return (int) field.get(skippingIterator);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(timeout = 4000)
    public void testSkippingIteratorWithNegativeOffset() {
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3, 4, 5).iterator();
        long offset = -1;

        try {
            new SkippingIterator<>(iterator, offset);
            fail("Expected IllegalArgumentException for negative offset");
        } catch (IllegalArgumentException e) {
            assertEquals("Offset parameter must not be negative.", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSkippingIteratorWithNullIterator() {
        long offset = 1;

        try {
            new SkippingIterator<>(null, offset);
            fail("Expected NullPointerException for null iterator");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }


}