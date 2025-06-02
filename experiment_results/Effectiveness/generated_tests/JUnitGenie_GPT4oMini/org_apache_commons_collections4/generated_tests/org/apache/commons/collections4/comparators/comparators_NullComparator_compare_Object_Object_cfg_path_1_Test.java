package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.NullComparator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class comparators_NullComparator_compare_Object_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCompareWithNullsAreHighTrue() {
        NullComparator comparator = new NullComparator(true);
        Comparable o1 = new ComparableObject(1);
        Comparable o2 = new ComparableObject(2);
        
        // Test when both objects are not null and different
        assertEquals(-1, comparator.compare(o1, o2));
    }

    @Test(timeout = 4000)
    public void testCompareWithNullsAreHighFalse() {
        NullComparator comparator = new NullComparator(false);
        Comparable o1 = new ComparableObject(2);
        Comparable o2 = new ComparableObject(1);
        
        // Test when both objects are not null and different
        assertEquals(1, comparator.compare(o1, o2));
    }

    @Test(timeout = 4000)
    public void testCompareWithFirstObjectNull() {
        NullComparator comparator = new NullComparator(true);
        Comparable o1 = null;
        Comparable o2 = new ComparableObject(1);
        
        // Test when first object is null
        assertEquals(1, comparator.compare(o1, o2));
    }

    @Test(timeout = 4000)
    public void testCompareWithSecondObjectNull() {
        NullComparator comparator = new NullComparator(false);
        Comparable o1 = new ComparableObject(1);
        Comparable o2 = null;
        
        // Test when second object is null
        assertEquals(-1, comparator.compare(o1, o2));
    }

    @Test(timeout = 4000)
    public void testCompareWithBothObjectsNull() {
        NullComparator comparator = new NullComparator(true);
        Comparable o1 = null;
        Comparable o2 = null;
        
        // Test when both objects are null
        assertEquals(0, comparator.compare(o1, o2));
    }

    @Test(timeout = 4000)
    public void testCompareWithSameObjects() {
        NullComparator comparator = new NullComparator(true);
        Comparable o1 = new ComparableObject(1);
        Comparable o2 = o1;
        
        // Test when both objects are the same
        assertEquals(0, comparator.compare(o1, o2));
    }

    // A simple Comparable class for testing
    private static class ComparableObject implements Comparable<ComparableObject> {
        private final int value;

        public ComparableObject(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(ComparableObject other) {
            return Integer.compare(this.value, other.value);
        }
    }

}