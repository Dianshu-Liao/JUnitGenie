package org.apache.commons.collections4.bag;
import org.apache.commons.collections4.bag.AbstractMapBag;
import org.apache.commons.collections4.bag.AbstractMapBag.MutableInteger;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;

public class bag_AbstractMapBag_add_Object_int_cfg_path_2_Test {

    private class TestBag extends AbstractMapBag<Object> {
        // Implementing the abstract methods is necessary for instantiation
        @Override
        public int getCount(Object object) {
            return super.getCount(object); // Use the superclass method to get the count
        }

        @Override
        public Set<Object> uniqueSet() {
            return new HashSet<>(super.uniqueSet()); // Return a new HashSet based on the unique set
        }
    }

    @Test(timeout = 4000)
    public void testAddWithPositiveCopies() {
        TestBag bag = new TestBag();
        Object obj = new Object();
        int nCopies = 5; // Valid input greater than 0

        boolean result = bag.add(obj, nCopies);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testAddWithZeroCopies() {
        TestBag bag = new TestBag();
        Object obj = new Object();
        int nCopies = 0; // Invalid input

        boolean result = bag.add(obj, nCopies);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testAddWithNegativeCopies() {
        TestBag bag = new TestBag();
        Object obj = new Object();
        int nCopies = -3; // Invalid input

        boolean result = bag.add(obj, nCopies);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testAddExistingObject() {
        TestBag bag = new TestBag();
        Object obj = new Object();
        int nCopies = 5; // Valid input

        // First add
        bag.add(obj, nCopies);
        // Add again
        boolean result = bag.add(obj, nCopies);
        assertTrue(result);
    }

}