package org.apache.commons.collections4.bag;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.AbstractMapBag;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class bag_AbstractMapBag_containsAll_Bag_cfg_path_2_Test {

    private class TestBag extends AbstractMapBag<Object> {
        private final Map<Object, Integer> map = new HashMap<>();

        public TestBag() {
            super();
        }

        @Override
        public int getCount(Object object) {
            return map.getOrDefault(object, 0);
        }

        @Override
        public boolean add(Object object) {
            map.put(object, map.getOrDefault(object, 0) + 1);
            return true;
        }

        @Override
        public Set<Object> uniqueSet() {
            return new HashSet<>(map.keySet());
        }

        // Implement other abstract methods as needed...
    }

    @Test(timeout = 4000)
    public void testContainsAll() {
        TestBag bag1 = new TestBag();
        TestBag bag2 = new TestBag();

        // Setup bag1 with some elements
        bag1.add("apple");
        bag1.add("banana");
        bag1.add("banana"); // banana count is now 2

        // Setup bag2 with elements that bag1 should contain
        bag2.add("apple");
        bag2.add("banana");

        // Test that bag1 contains all elements of bag2
        assertTrue(bag1.containsAll(bag2));
    }

    @Test(timeout = 4000)
    public void testContainsAllWithInsufficientCount() {
        TestBag bag1 = new TestBag();
        TestBag bag2 = new TestBag();

        // Setup bag1 with some elements
        bag1.add("apple");
        bag1.add("banana");

        // Setup bag2 with elements that bag1 should contain
        bag2.add("apple");
        bag2.add("banana");
        bag2.add("banana"); // bag2 has 2 bananas

        // Test that bag1 does not contain all elements of bag2
        assertFalse(bag1.containsAll(bag2));
    }

    @Test(timeout = 4000)
    public void testContainsAllWithEmptyBag() {
        TestBag bag1 = new TestBag();
        TestBag bag2 = new TestBag();

        // Setup bag1 with some elements
        bag1.add("apple");
        bag1.add("banana");

        // Test that bag1 contains all elements of an empty bag
        assertTrue(bag1.containsAll(bag2));
    }

}