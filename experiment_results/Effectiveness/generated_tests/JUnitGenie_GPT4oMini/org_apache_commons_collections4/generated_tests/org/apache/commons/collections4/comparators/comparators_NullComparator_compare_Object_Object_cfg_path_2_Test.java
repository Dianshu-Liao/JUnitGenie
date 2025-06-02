package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.NullComparator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class comparators_NullComparator_compare_Object_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCompareWithNullsAreHighTrue() {
        NullComparator comparator = new NullComparator(true);
        Comparable o1 = new ComparableObject(1);
        Comparable o2 = new ComparableObject(2);
        
        // Testing with two different non-null objects
        int result = comparator.compare(o1, o2);
        assertEquals(-1, result); // Assuming o1 < o2
    }

    @Test(timeout = 4000)
    public void testCompareWithNullsAreHighFalse() {
        NullComparator comparator = new NullComparator(false);
        Comparable o1 = new ComparableObject(1);
        Comparable o2 = new ComparableObject(2);
        
        // Testing with two different non-null objects
        int result = comparator.compare(o1, o2);
        assertEquals(-1, result); // Assuming o1 < o2
    }

    @Test(timeout = 4000)
    public void testCompareWithNullO1() {
        NullComparator comparator = new NullComparator(true);
        Object o1 = null;
        Comparable o2 = new ComparableObject(1);
        
        // Testing with o1 as null
        int result = comparator.compare(o1, o2);
        assertEquals(1, result); // nullsAreHigh is true, so null should be considered high
    }

    @Test(timeout = 4000)
    public void testCompareWithNullO2() {
        NullComparator comparator = new NullComparator(false);
        Comparable o1 = new ComparableObject(1);
        Object o2 = null;
        
        // Testing with o2 as null
        int result = comparator.compare(o1, o2);
        assertEquals(-1, result); // nullsAreHigh is false, so null should be considered low
    }

    @Test(timeout = 4000)
    public void testCompareWithBothNulls() {
        NullComparator comparator = new NullComparator(true);
        Object o1 = null;
        Object o2 = null;
        
        // Testing with both objects as null
        int result = comparator.compare(o1, o2);
        assertEquals(0, result); // Both are null, should return 0
    }

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